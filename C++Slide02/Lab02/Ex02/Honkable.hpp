// File: Lab02/Ex02/Honkable.hpp
#ifndef HONKABLE_HPP
#define HONKABLE_HPP

class Honkable {
public:
    virtual void honk() = 0;
    virtual ~Honkable() = default;
};

#endif // HONKABLE_HPP