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