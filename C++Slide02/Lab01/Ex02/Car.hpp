// File: Lab01/Ex02/Car.hpp
#ifndef CAR_HPP
#define CAR_HPP

#include <string>
#include <iostream>
#include "Driver.hpp"

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