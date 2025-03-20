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