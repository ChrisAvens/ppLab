cmake_minimum_required(VERSION 3.10)
project(lab02)

set(CMAKE_CXX_STANDARD 20)

# Add this line to include the project root directory in the search path
include_directories(${CMAKE_SOURCE_DIR})

add_executable(lab02.Ex02
        Lab02/Ex02/TestEx02.cpp)

add_executable(lab02.Ex01
        Lab02/Ex01/TestEx01.cpp)

        