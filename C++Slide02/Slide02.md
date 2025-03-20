# C++ Programming Laboratory 02: Object-Oriented Programming

## **Objectives**
- **Part 1: Inheritance and Polymorphism**
- **Part 2: Interfaces and Abstract Classes**

---

## **Prerequisites**
- Basic knowledge of C++ programming.
- Understanding of **classes**, **objects**, **inheritance**, and **polymorphism**.
- Familiarity with the **Visual Studio Code** or any preferred C++ IDE.

---

## **Environment Setup**
1. **Installation of IDE**:
    - Ensure that you have access to C++ development environment (e.g., Visual Studio, CLion) 
    - If not on your computer, check vdi.ual.pt.

2. **Project Configuration**:
    - Open your IDE.
    - Create a new C++ project.
    - Organize the project with the following directories:
        - `Lab01.Ex02`
        - `Lab02.Ex01`

---

## **Provided Code**

You will receive the code for the `Lab01.Ex02` directory, which includes the classes `Car` and `Driver`. This code will serve as the foundation for activities in the `Lab02.Ex01` directory.

### **1. Class `Car` in `Lab01.Ex02`**
```cpp
// File: Lab01/Ex02/Car.hpp
#ifndef CAR_HPP
#define CAR_HPP

#include <string>
#include <iostream>
#include "Driver.h"

class Car {
protected:
    std::string licensePlate;
    int currentSpeed;
    const int maxSpeed = 200;
    bool isOn;
    Driver driver;

public:
    Car(const std::string& licensePlate, const Driver& driver)
        : licensePlate(licensePlate), driver(driver), isOn(false), currentSpeed(0) {}

    void turnOn() {
        isOn = true;
        std::cout << "Car " << licensePlate << " is now ON." << std::endl;
    }

    void turnOff() {
        isOn = false;
        std::cout << "Car " << licensePlate << " is now OFF." << std::endl;
    }

    void accelerate() {
        if (!isOn) {
            std::cout << "The car is off! Cannot accelerate." << std::endl;
            return;
        }
        currentSpeed += 10;
        if (currentSpeed > maxSpeed)
            currentSpeed = maxSpeed;
        std::cout << "Current speed: " << currentSpeed << " km/h" << std::endl;
    }

    void brake(int intensity) {
        if (!isOn) {
            std::cout << "The car is off! Cannot brake." << std::endl;
            return;
        }
        currentSpeed -= intensity;
        if (currentSpeed < 0)
            currentSpeed = 0;
        std::cout << "Current speed: " << currentSpeed << " km/h" << std::endl;
    }

    virtual void honk() {
        std::cout << "Standard car horn." << std::endl;
    }
};

#endif // CAR_HPP
```

### **2. Class `Driver` in `Lab01.Ex02`**
```cpp
// File: Lab01/Ex02/Driver.hpp
#ifndef DRIVER_HPP
#define DRIVER_HPP

#include <string>
#include <iostream>

class Driver {
private:
    std::string name;
    int age;
    int skill;

public:
    Driver(const std::string& name, int age, int skill)
        : name(name), age(age), skill(skill) {}

    // Getters and Setters

    std::string getName() const { return name; }

    void setName(const std::string& name) { this->name = name; }

    int getAge() const { return age; }

    void setAge(int age) { this->age = age; }

    int getSkill() const { return skill; }

    void setSkill(int skill) { this->skill = skill; }

    void printInfo() const {
        std::cout << "Driver{name='" << name << "', age=" << age << ", skill=" << skill << "}" << std::endl;
    }
};

#endif // DRIVER_HPP
```

---

## **Activities in Directory `Lab02.Ex01`**

The following tasks should be completed in the `Lab02.Ex01` directory. 
Use your IDE to create the necessary classes and implement the requirements as described.

### **1. Creating Subclasses `CityCar` and `Van`**

#### **a. Class `CityCar`**
- **Inheritance**: Inherit from the `Car` class.
- **Specific Methods**:
    - Implement the method `turnOnAC()` that prints "AC turned on!".
- **Method Overriding**:
    - Override the `honk()` method to display "CityCar Horn: Piii Piii!".

```cpp
// File: Lab02/Ex01/CityCar.hpp
#ifndef CITYCAR_HPP
#define CITYCAR_HPP

#include "../../Lab01/Ex02/Car.hpp"

class CityCar : public Car {
public:
    CityCar(const std::string& licensePlate, const Driver& driver)
        : Car(licensePlate, driver) {}

    void turnOnAC() {
        std::cout << "AC turned on!" << std::endl;
    }

    void honk() override {
        std::cout << "CityCar Horn: Piii Piii!" << std::endl;
    }
};

#endif // CITYCAR_HPP
```

#### **b. Class `Van`**
- **Inheritance**: Inherit from the `Car` class.
- **Specific Methods**:
    - Implement the method `turnOffPassengerAirbag()` that prints "Passenger Airbag turned off!".
- **Method Overriding**:
    - Override the `honk()` method to display "Van Horn: Bip Bip".

```cpp
// File: Lab02/Ex01/Van.hpp
#ifndef VAN_HPP
#define VAN_HPP

#include "../../Lab01/Ex02/Car.hpp"

class Van : public Car {
public:
    Van(const std::string& licensePlate, const Driver& driver)
        : Car(licensePlate, driver) {}

    void turnOffPassengerAirbag() {
        std::cout << "Passenger Airbag turned off!" << std::endl;
    }

    void honk() override {
        std::cout << "Van Horn: Bip Bip" << std::endl;
    }
};

#endif // VAN_HPP
```

---

### **2. Test Class `TestEx01`**
Create a class `TestEx01` within the `Lab02.Ex01` directory that performs the following actions:

- **Object Creation**:
    - Instantiate objects of `CityCar` and `Van` with different license plates.
    - Create a list of `Car` pointers that contain instances of both subclasses.

- **Interactions with Objects**:
    - Iterate over the list of cars and for each car:
        - Call the methods `turnOn()`, `accelerate()`, `honk()`, and `turnOff()`.
        - Use `dynamic_cast` to check the type of the car and call specific methods:
            - If it's an instance of `CityCar`, call `turnOnAC()`.
            - If it's an instance of `Van`, call `turnOffPassengerAirbag()`.

```cpp
// File: Lab02/Ex01/TestEx01.cpp
#include <iostream>
#include <vector>
#include "CityCar.hpp"
#include "Van.hpp"

int main() {
    // Creating Driver instances
    Driver driver1("Alice", 30, 8);
    Driver driver2("Bob", 35, 7);
    Driver driver3("Charlie", 28, 9);
    Driver driver4("Diana", 32, 6);

    // Creating Car instances
    CityCar car1("AAA-1111", driver1);
    Van van1("BBB-2222", driver2);
    CityCar car2("CCC-3333", driver3);
    Van van2("DDD-4444", driver4);

    // Creating a list of Car pointers
    std::vector<Car*> cars = { &car1, &van1, &car2, &van2 };

    // Interacting with each car
    for (auto car : cars) {
        car->turnOn();
        car->accelerate();
        car->honk();
        
        // Check if car is CityCar
        if (CityCar* cityCar = dynamic_cast<CityCar*>(car)) {
            std::cout << "---- Using the element of the list as CityCar ----" << std::endl;
            cityCar->turnOnAC();
        }
        // Check if car is Van
        else if (Van* van = dynamic_cast<Van*>(car)) {
            std::cout << "---- Using the element of the list as Van ----" << std::endl;
            van->turnOffPassengerAirbag();
        }

        car->turnOff();
        std::cout << "---------------------------------------" << std::endl;
    }

    return 0;
}
```

---

### **3. Running the Program**

For this moment, we have CMakeList.txt as follows:
```
cmake_minimum_required(VERSION 3.30)
project(lab02)

set(CMAKE_CXX_STANDARD 20)

add_executable(lab02.Ex01
        Lab02/Ex01/Test01.cpp)
```

After implementation, run the `TestEx01` class to observe the behavior of different types of cars and verify the functioning of inheritance and polymorphism.

**Example Output:**
```
Car AAA-1111 is now ON. 
Current speed: 10 km/h 
CityCar Horn: Piii Piii! 
---- Using the element of the list as CityCar ---- 
AC turned on! Car AAA-1111 is now OFF.
Car BBB-2222 is now ON. 

Current speed: 10 km/h 
Van Horn: Bip Bip 
---- Using the element of the list as Van ---- 
Passenger Airbag turned off! 
Car BBB-2222 is now OFF.

Car CCC-3333 is now ON. 
Current speed: 10 km/h 
CityCar Horn: Piii Piii! 
---- Using the element of the list as CityCar ---- 
AC turned on! 
Car CCC-3333 is now OFF.

Car DDD-4444 is now ON. 
Current speed: 10 km/h 
Van Horn: Bip Bip 
---- Using the element of the list as Van ---- 
Passenger Airbag turned off! 
Car DDD-4444 is now OFF.

Process finished with exit code 0

```

---

## **Final Considerations**

This laboratory aims to strengthen your understanding of fundamental Object-Oriented Programming concepts in C++. By implementing inheritance and polymorphism, you will be prepared to develop more complex and robust applications.

If you have any questions or need additional assistance, please feel free to seek help.

* When a function is **not declared as `virtual`**, the compiler determines which function to call **at compile time** based on the **type of the pointer or reference**, not the actual object it points to. This is known as **static binding**.
* When a function is declared as `**virtual**` in the base class, the compiler sets up a **virtual table (vtable)** for the class. This allows the program to determine **at runtime** which function to call based on the **actual object's type**, enabling **polymorphic behavior** through **dynamic binding**.
* A **vtable** is a mechanism used by C++ compilers to support **dynamic (runtime) polymorphism**. When a class contains **virtual functions**, the compiler creates a vtable for that class. Each object of the class contains a **vptr** (virtual pointer) that points to the class's vtable.
* In scenarios involving **multiple inheritance**, a class might contain multiple vtables to handle each base class's virtual functions separately. Each vtable caters to a specific inheritance path, ensuring that function calls are correctly resolved based on the object's actual type and the inheritance hierarchy.
* While vtables enable powerful features like polymorphism, they introduce a slight **runtime overhead** due to indirect function calls through the vtable. In performance-critical applications:
**Minimize the use of virtual functions** where possible.

## **Understanding Object Allocation in C++ vs. Java**
### **a. C++ Object Allocation**
In C++, objects can be allocated in two primary ways:
1. **Stack Allocation (Automatic Storage):**
2. **Heap Allocation (Dynamic Storage):**

- **Examples:**
```cpp
  Driver driver1("Alice", 30, 8); // Allocated on the stack
  Driver* driverPtr = new Driver("Alice", 30, 8); // Allocated on the heap
    ...
  delete driverPtr;

```  
### **Java Object Allocation**
In Java, **all objects** are allocated on the **heap**, and memory management is handled automatically by the **Garbage Collector (GC)**.
- **Syntax:**
```java 
  Driver driver1 = new Driver("Alice", 30, 8); // Always on the heap
```
---

## **Part 2: Interfaces and Abstract Classes**

### **Objective**
In the second part of the laboratory, students will deepen their understanding of **interfaces** and **abstract classes** in C++. Using the provided code from Part 1, you will extend the functionalities of existing classes by implementing interfaces and creating more flexible and reusable class hierarchies.

### **Prerequisites**
- Complete the activities from **Part 1**.
- Understanding of **abstract classes** and **pure virtual functions** in C++.
- Familiarity with your chosen C++ IDE.

### **Environment Setup**
Ensure that the C++ project from the laboratory is open in your IDE and that the directories `Lab01.Ex02` and `Lab02.Ex01` are properly organized as described in Part 1.


## **Activities in Directory `Lab02.Ex02`**

The following tasks should be completed in the `Lab02.Ex02` directory. Use your IDE to create the necessary classes and implement the requirements as described.
---
### **1. Defining the `Honkable` Interface**

- **Objective**: Create an interface that defines the honking behavior, allowing different implementations in distinct subclasses.

- **Steps**:
    1. **Create the `Honkable` Interface**:
        - In the `Lab02.Ex02` directory, create an interface named `Honkable`.
        - Define the method `virtual void honk() = 0;` within the interface.

    2. **Implement the Interface in Subclasses**:
        - Subclasses representing specific types of cars should implement the `Honkable` interface and provide the implementation for the `honk()` method according to the desired behavior.

```cpp
// File: Lab02/Ex02/Honkable.hpp
#ifndef HONKABLE_HPP
#define HONKABLE_HPP

class Honkable {
public:
    virtual void honk() = 0;
    virtual ~Honkable() = default;
};

#endif // HONKABLE_HPP
```

---
### **2. Transforming the `Car` Class into an Abstract Class**

- **Objective**: Modify the existing `Car` class in the `Lab01.Ex02` directory to make it abstract, allowing the creation of subclasses with specific behaviors.

- **Steps**:
    1. **Create a New Abstract Class `AbstractCar`**:
        - In the `Lab02.Ex02` directory, create a new class named `AbstractCar` that inherits from `Lab01.Ex02::Car`.
        - Mark the `AbstractCar` class as `abstract` by declaring at least one pure virtual function.

    2. **Add a Pure Virtual Method `honk()`**:
        - Within `AbstractCar`, declare the method `virtual void honk() = 0;` without implementation.

```cpp
// File: Lab02/Ex02/AbstractCar.hpp
#ifndef ABSTRACTCAR_HPP
#define ABSTRACTCAR_HPP

#include "../../Lab01/Ex02/Car.hpp"

class AbstractCar : public Car, , public Honkable {
public:
    AbstractCar(const std::string& licensePlate, const Driver& driver)
        : Car(licensePlate, driver) {}

    virtual void honk() = 0; // Pure virtual function
};

#endif // ABSTRACTCAR_HPP
```

---



### **3. Implementing the Concrete Class `RealCar`**

- **Objective**: Create a concrete class that represents a specific type of car, implementing the behaviors defined by the `Honkable` interface.

- **Steps**:
    1. **Create the `RealCar` Class**:
        - In the `Lab02.Ex02` directory, create a new class named `RealCar` that inherits from `AbstractCar` and implements the `Honkable` interface.

    2. **Implement the `honk()` Method**:
        - Within `RealCar`, provide a concrete implementation for the `honk()` method, for example:
          ```cpp
          void honk() override {
              std::cout << "RealCar Horn: Toooooooot!" << std::endl;
          }
          ```

    3. **Add Constructor**:
        - Implement a constructor that calls the superclass `AbstractCar` constructor, receiving necessary parameters (e.g., `licensePlate` and `driver`).

```cpp
// File: Lab02/Ex02/RealCar.hpp
#ifndef REALCAR_HPP
#define REALCAR_HPP

#include "AbstractCar.hpp"
#include "Honkable.hpp"

class RealCar : public AbstractCar {
public:
    RealCar(const std::string& licensePlate, const Driver& driver)
        : AbstractCar(licensePlate, driver) {}

    void honk() override {
        std::cout << "RealCar Horn: Toooooooot!" << std::endl;
    }
};

#endif // REALCAR_HPP
```

---

### **4. Test Class `TestEx02`**

- **Objective**: Implement a test class to verify the functioning of the abstract classes and interfaces created.

- **Steps**:
    1. **Create the `TestEx02` Class**:
        - In the `Lab02.Ex02` directory, create a new class named `TestEx02` containing the `main` method.

    2. **Implement the `main` Method**:
        - In the `main` method, perform the following actions:
            1. **Instantiate a `Driver` Object**:
                - Name: "Bob"
                - Age: 35
                - Skill: 7
            2. **Create a `RealCar` Object**:
                - License Plate: "DDD-4444"
                - Driver: The object created earlier.
            3. **Interactions with the `RealCar` Object**:
                - Call the methods `turnOn()`, `accelerate()`, `honk()`, `brake(15)`, and `turnOff()`.
            4. **Run the Program**:
                - Execute the `main` method and verify if the outputs are as expected.

```cpp
// File: Lab02/Ex02/TestEx02.cpp
#include <iostream>
#include "RealCar.hpp"

int main() {
    // Creating a Driver instance
    Driver driver("Bob", 35, 7);

    // Creating a RealCar instance
    RealCar realCar("DDD-4444", driver);

    // Interacting with RealCar
    realCar.turnOn();
    realCar.accelerate();
    realCar.honk();
    realCar.brake(15);
    realCar.turnOff();

    return 0;
}
```

---

### **5. Running and Testing the Program**
For this moment, we have CMakeList.txt as follows:
```
cmake_minimum_required(VERSION 3.30)
project(lab02)

set(CMAKE_CXX_STANDARD 20)

add_executable(lab02.Ex01
        Lab02/Ex01/Test01.cpp)
add_executable(lab02.Ex02
        Lab02/Ex02/Test02.cpp)
        
```        
- **Objective**: Verify that the implementations are correct and that the defined behaviors are functioning as expected.

- **Steps**:
    1. **Run the `TestEx02` Class**:
        - In your IDE, open the `TestEx02` class.
        - Right-click on the editor and select **Run 'TestEx02.main()'**.

    2. **Check the Console Output**:
        - Confirm that the printed messages correspond to the actions performed, for example:
          ```
          Car DDD-4444 is now ON.
          Current speed: 10 km/h
          RealCar Horn: Toooooooot!
          Current speed: 0 km/h
          Car DDD-4444 is now OFF.
          ```

---

## **Final Considerations**

This second part of the laboratory aims to consolidate your understanding of **abstract classes** and **interfaces** in C++, demonstrating how these tools can be used to create more flexible and well-structured class hierarchies. By implementing these solutions, you will be prepared to develop more complex and robust applications, leveraging the benefits of Object-Oriented Programming.

**Tips:**
- **Code Reuse**: Utilize the methods already implemented in the `Car` class to avoid redundancy.
- **Method Overriding**: Use the `override` keyword when implementing methods from interfaces or overriding superclass methods.
- **Code Organization**: Keep your code organized and well-commented to facilitate readability and maintenance.
- **Frequent Testing**: Test your classes frequently to ensure each component functions correctly before proceeding.

If you have any questions or need additional assistance, do not hesitate to seek help from your instructor or classmates.

---

**Happy Coding! 🚗🔧**