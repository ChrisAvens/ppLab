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