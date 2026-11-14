
# Lab 7: Grad-CAM - Explainable AI

import torch
import torch.nn.functional as F
import torchvision.models as models
import torchvision.transforms as transforms
from PIL import Image
import matplotlib.pyplot as plt

# Load a pretrained ResNet18 model
model = models.resnet18(weights=models.ResNet18_Weights.DEFAULT)
model.eval()

# Select the final convolutional layer
target_layer = model.layer4[-1]

# Variables to store activations and gradients
activations = None
gradients = None

def forward_hook(module, input, output):
    global activations
    activations = output

def backward_hook(module, grad_input, grad_output):
    global gradients
    gradients = grad_output[0]

# Register hooks
target_layer.register_forward_hook(forward_hook)
target_layer.register_full_backward_hook(backward_hook)

# Load and preprocess an image
image = Image.open("Lab7/GradCAM/input.jpg").convert("RGB")

transform = transforms.Compose([
    transforms.Resize((224, 224)),
    transforms.ToTensor(),
    transforms.Normalize(
        mean=[0.485, 0.456, 0.406],
        std=[0.229, 0.224, 0.225]
    )
])

input_tensor = transform(image).unsqueeze(0)

# Forward pass
output = model(input_tensor)
predicted_class = output.argmax(dim=1).item()

# Backward pass
model.zero_grad()
score = output[0, predicted_class]
score.backward()

# Calculate Grad-CAM
weights = gradients.mean(dim=(2, 3), keepdim=True)
cam = (weights * activations).sum(dim=1, keepdim=True)
cam = F.relu(cam)

# Normalize heatmap
cam = F.interpolate(
    cam,
    size=(224, 224),
    mode="bilinear",
    align_corners=False
)

cam = cam.squeeze().detach()
cam = cam / (cam.max() + 1e-8)

# Display original image and heatmap
plt.figure(figsize=(10, 5))

plt.subplot(1, 2, 1)
plt.imshow(image.resize((224, 224)))
plt.title("Original Image")
plt.axis("off")

plt.subplot(1, 2, 2)
plt.imshow(image.resize((224, 224)))
plt.imshow(cam.numpy(), cmap="jet", alpha=0.5)
plt.title("Grad-CAM Heatmap")
plt.axis("off")

plt.tight_layout()
plt.savefig("Lab7/GradCAM/GradCAM_Output.png")
plt.show()

print("Predicted Class Index:", predicted_class)
print("Grad-CAM visualization generated successfully!")
