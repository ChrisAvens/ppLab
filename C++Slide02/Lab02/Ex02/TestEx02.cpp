// File: Lab02/Ex02/TestEx02.cpp
#include <iostream>
#include "RealCar.hpp"
#include "../../Lab01/Ex02/Driver.hpp" 


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