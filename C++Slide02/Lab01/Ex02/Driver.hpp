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