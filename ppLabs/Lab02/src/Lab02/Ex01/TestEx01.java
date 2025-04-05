package Lab02.Ex01;

import Lab01.Ex02.Carro;
import Lab01.Ex02.Condutor;

import java.util.List;
import java.util.ArrayList;


public class TestEx01 {
    public static void main(String[] args) {

        //Driver instance
        Condutor driver = new Condutor("Chris", 20, 10);

        //Citadino and Van instances
        Citadino cityCar1 = new Citadino("IOU-948", driver);
        Van van1 = new Van("LMK-084", driver);
        Citadino cityCar2 = new Citadino("FYS-742", driver);
        Van van2 = new Van("PLS-123", driver);

        List<Carro> cars = new ArrayList<>();
        cars.add(van1);
        cars.add(van2);
        cars.add(cityCar1);
        cars.add(cityCar2);

        for (Carro car : cars) {
            car.connect();
            car.accelerate();
            car.honk();

            if (car instanceof Citadino) {
                System.out.println("Element of the list is Citadino, connecting manual AC");
                ((Citadino) car).ConnectManualAC();
            } else if (car instanceof Van) {
                System.out.println("Element of the list is Van, disconnecting passenger Airbag");
                ((Van) car).disconnectPassengerAirbag();
            }

            car.disconnect();
            System.out.println("-----------------------------------------------------");
        }
    }
}
