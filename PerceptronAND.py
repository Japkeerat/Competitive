import numpy as np
from sklearn.model_selection import train_test_split

x = np.array([(0,0,0),(0,0,1),(0,1,0),(0,1,1),(1,0,0),(1,0,1),(1,1,0),(1,1,1)])
y = np.array([0,0,0,0,0,0,0,1])

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 2/8, random_state = 42)

weights = np.random.rand(3)

epochs = 10
error = 0.1
learning_rate = 0.01


def sgm(num):
    value = 1 / (1 + np.exp(0 - num))
    return value


for i in range(epochs):
    for j in range(len(x_train)):
        z = np.multiply(x_train[j], weights)
        q = np.sum(z)
        q = sgm(q)
        if np.absolute(q - y_train[j]) > error:
            n = y_train[j] - q
            n *= learning_rate
            dw = x_train[j] * n
            if np.all(np.equal(dw, np.zeros(3))):
                j += 1
            weights = np.add(weights, dw)
            j -= 1

y_predict = np.zeros(len(y_test), dtype = int)

for j in range(len(x_test)):
    z = np.multiply(x_train[j], weights)
    q = np.sum(z)
    q = sgm(q)
    y_predict[j] = q
    
from sklearn.metrics import accuracy_score
accuracy = accuracy_score(y_test, y_predict)

print("Accuracy of Perceptron model is {} %".format(accuracy * 100))
