
import torch
import torch.nn as nn
import torchvision.models as models
import torchvision.transforms as transforms
from PIL import Image
import matplotlib.pyplot as plt

# Load pretrained ResNet18
weights = models.ResNet18_Weights.DEFAULT
model = models.resnet18(weights=weights)
model.eval()

# Image preprocessing
preprocess = weights.transforms()

image_path = "Lab7/GradCAM/input.jpg"
image = Image.open(image_path).convert("RGB")
input_image = preprocess(image).unsqueeze(0)
input_image.requires_grad = True

# Get original prediction
output = model(input_image)
original_class = output.argmax(dim=1).item()
categories = weights.meta["categories"]

# Calculate loss
criterion = nn.CrossEntropyLoss()
target = torch.tensor([original_class])

loss = criterion(output, target)

# Calculate gradients
model.zero_grad()
loss.backward()

# FGSM attack
epsilon = 0.05
perturbed_image = input_image + epsilon * input_image.grad.sign()

# Clip normalized image to valid range
mean = torch.tensor([0.485, 0.456, 0.406]).view(1, 3, 1, 1)
std = torch.tensor([0.229, 0.224, 0.225]).view(1, 3, 1, 1)

lower = (0 - mean) / std
upper = (1 - mean) / std

perturbed_image = torch.max(
    torch.min(perturbed_image, upper), lower
).detach()

# Adversarial prediction
with torch.no_grad():
    adversarial_output = model(perturbed_image)
    adversarial_class = adversarial_output.argmax(dim=1).item()

print("Original Prediction:", categories[original_class])
print("Adversarial Prediction:", categories[adversarial_class])

# Convert tensors back to displayable images
def denormalize(tensor):
    return (tensor * std + mean).squeeze(0).permute(1, 2, 0).numpy()

original_display = denormalize(input_image.detach())
adversarial_display = denormalize(perturbed_image)

# Display and save results
plt.figure(figsize=(10, 5))

plt.subplot(1, 2, 1)
plt.imshow(original_display)
plt.title("Original Image")
plt.axis("off")

plt.subplot(1, 2, 2)
plt.imshow(adversarial_display)
plt.title("FGSM Adversarial Image")
plt.axis("off")

plt.tight_layout()
plt.savefig("Lab7/FGSM/FGSM_Output.png")
plt.show()

print("FGSM output saved successfully!")
