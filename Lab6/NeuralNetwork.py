
# Lab 6: Neural Network using PyTorch

import torch
import torch.nn as nn
import torch.optim as optim

# Sample dataset: XOR problem
X = torch.tensor([
    [0.0, 0.0],
    [0.0, 1.0],
    [1.0, 0.0],
    [1.0, 1.0]
])

Y = torch.tensor([
    [0.0],
    [1.0],
    [1.0],
    [0.0]
])

# Define Neural Network
class NeuralNetwork(nn.Module):
    def __init__(self):
        super().__init__()
        self.hidden = nn.Linear(2, 8)
        self.output = nn.Linear(8, 1)
        self.relu = nn.ReLU()
        self.sigmoid = nn.Sigmoid()

    def forward(self, x):
        x = self.relu(self.hidden(x))
        x = self.sigmoid(self.output(x))
        return x

# Create model
model = NeuralNetwork()

# Loss function and optimizer
criterion = nn.BCELoss()
optimizer = optim.Adam(model.parameters(), lr=0.05)

# Train the network
epochs = 3000

for epoch in range(epochs):
    predictions = model(X)
    loss = criterion(predictions, Y)

    optimizer.zero_grad()
    loss.backward()
    optimizer.step()

    if (epoch + 1) % 500 == 0:
        print(f"Epoch [{epoch + 1}/{epochs}], Loss: {loss.item():.4f}")

# Test the model
print("\nNeural Network Predictions:")

with torch.no_grad():
    predictions = model(X)

    for i in range(len(X)):
        predicted_class = 1 if predictions[i].item() >= 0.5 else 0
        print(
            f"Input: {X[i].tolist()} "
            f"Predicted: {predicted_class} "
            f"Actual: {int(Y[i].item())}"
        )

print("\nTraining completed!")
