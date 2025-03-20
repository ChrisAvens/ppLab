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