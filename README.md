# ☕ Object-Oriented Java Projects

This repository contains two academic Java mini-projects developed by **Hassan Mroueh** as part of the Object-Oriented Programming course.  
Each project demonstrates core OOP principles such as encapsulation, method overloading, and array manipulation.

---

## 📁 Project Structure

```bash
Object-Oriented-Java-Projects/
├── Matrix.java            # Matrix class with overloaded operations (+, -, *, transpose)
├── TestMatrix.java        # Driver class to test Matrix operations
├── MyArrayList.java       # Custom implementation of a dynamic array (similar to Java's ArrayList)
└── README.md
````

---

## 📘 Project 1: Matrix Operations

A `Matrix` class that supports:

* Construction from 1D or 2D arrays
* Matrix addition, subtraction, multiplication (by scalar or matrix)
* Transposition
* Display methods for formatted printing of operations
* Tracks the number of Matrix instances

### 🔎 Sample Features

* `add(Matrix other)`
* `multiply(double scalar)`
* `transpose()`
* `displayOp(Matrix other, char op, Matrix result)`

Tested using `TestMatrix.java`.

---

## 📗 Project 2: Custom ArrayList Implementation

`MyArrayList.java` is a custom implementation of a generic dynamic array that includes:

* `add`, `remove`, `clear`, `set`, `get`, `contains`
* Index lookup methods: `indexOf`, `lastIndexOf`
* Dynamic resizing logic
* Capacity starts at 16 by default

This project reinforces understanding of Java arrays, object handling, and list operations without using the `java.util` collections.

---

## 👨‍🎓 Author

* **Hassan Mroueh**
  *Developed at University of Balamand for educational purposes.*

---

## 🔖 License

This project is shared for academic reference and learning only.



