// File: Lab02/Ex02/AbstractCar.hpp
#ifndef ABSTRACTCAR_HPP
#define ABSTRACTCAR_HPP

#include "../../Lab01/Ex02/Car.hpp"
#include "Honkable.hpp" 

class AbstractCar : public Car, public Honkable {
public:
    AbstractCar(const std::string& licensePlate, const Driver& driver)
        : Car(licensePlate, driver) {}

    virtual void honk() = 0; // Pure virtual function
};

#endif // ABSTRACTCAR_HPP