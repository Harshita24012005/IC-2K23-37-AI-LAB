
# Lab 6: Linear Regression using PyTorch

import torch
import torch.nn as nn
import matplotlib.pyplot as plt

# Sample training data
X = torch.tensor([[1.0], [2.0], [3.0], [4.0], [5.0]])
Y = torch.tensor([[3.0], [5.0], [7.0], [9.0], [11.0]])

# Define Linear Regression model
model = nn.Linear(1, 1)

# Loss function and optimizer
criterion = nn.MSELoss()
optimizer = torch.optim.SGD(model.parameters(), lr=0.01)

# Training the model
epochs = 1000

for epoch in range(epochs):
    # Forward pass
    predictions = model(X)
    loss = criterion(predictions, Y)

    # Backward pass
    optimizer.zero_grad()
    loss.backward()
    optimizer.step()

    if (epoch + 1) % 100 == 0:
        print(f"Epoch [{epoch + 1}/{epochs}], Loss: {loss.item():.4f}")

# Display learned parameters
print("\nTraining completed!")
print("Learned Weight:", model.weight.item())
print("Learned Bias:", model.bias.item())

# Make a prediction
test_input = torch.tensor([[6.0]])

with torch.no_grad():
    prediction = model(test_input)

print("Prediction for X = 6:", prediction.item())

# Plot results
with torch.no_grad():
    predicted_values = model(X)

plt.scatter(X.numpy(), Y.numpy(), label="Actual Data")
plt.plot(X.numpy(), predicted_values.numpy(), label="Regression Line")
plt.xlabel("X")
plt.ylabel("Y")
plt.title("Linear Regression using PyTorch")
plt.legend()
plt.savefig("Lab6/LinearRegression.png")
plt.show()
