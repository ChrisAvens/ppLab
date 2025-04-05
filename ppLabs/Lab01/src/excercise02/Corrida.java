package excercise02;

import java.util.Random;

public class Corrida {
    public static void main(String[] args) {
        // Define number of turns
        final int totalTurns = 10;

        // Creating drivers
        Condutor condutor1 = new Condutor("Chris", 30, 8);
        Condutor condutor2 = new Condutor("Ema", 28, 7);

        // Creating cars
        Carro carro1 = new Carro("ABC-1234", condutor1);
        Carro carro2 = new Carro("XYZ-5678", condutor2);

        // Connecting cars
        carro1.Connect();
        carro2.Connect();

        // Initializing random number generator
        Random random = new Random();

        // Simulating a run
        for (int turn = 1; turn <= totalTurns; turn++) {
            System.out.println("\n-- Turno " + turn + " --");

            // Each car tries to accelerate
            carro1.accelerate();
            carro2.accelerate();

            // Determining if any car needs to brake (30% chance)
            if (random.nextInt(100) < 30) { // 30% chance
                int brakeIntensity = random.nextInt(16) + 5; // 5 to 20 km/h
                System.out.println("Car " + carro1.getRegistration() + " found an obstacle!");
                carro1.brake(brakeIntensity);
            }

            if (random.nextInt(100) < 30) { // 30% de chance
                int brakeIntensity = random.nextInt(16) + 5; // 5 a 20 km/h
                System.out.println("Car " + carro2.getRegistration() + " found an obstacle!");
                carro2.brake(brakeIntensity);
            }

            // Displaying speeds after each turn
            System.out.println("Speed after turn " + turn + ":");
            System.out.println("Car " + carro1.getRegistration() + " - " + carro1.getActualSpeed() + " km/h");
            System.out.println("Car " + carro2.getRegistration() + " - " + carro2.getActualSpeed() + " km/h");
        }

        // Disconnecting cars
        carro1.Disconnect();
        carro2.Disconnect();

        // Displaying the final speed of each car
        System.out.println("\nFinal speed of car 1 (" + carro1.getDriver().getName() + "): " + carro1.getActualSpeed() + " km/h");
        System.out.println("Velocidade final do Carro 2 (" + carro2.getDriver().getName() + "): " + carro2.getActualSpeed() + " km/h");

        // Determinando o vencedor
        if (carro1.getActualSpeed() > carro2.getActualSpeed()) {
            System.out.println("\nWinner: Car 1 (" + carro1.getDriver().getName() + ")");
        } else if (carro1.getActualSpeed() < carro2.getActualSpeed()) {
            System.out.println("\nWinner: Car 2 (" + carro2.getDriver().getName() + ")");
        } else {
            System.out.println("\nIt´s a tie!");
        }
    }
}