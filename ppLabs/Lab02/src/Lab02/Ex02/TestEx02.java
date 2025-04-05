package Lab02.Ex02;

import Lab01.Ex02.Condutor;

public class TestEx02 {
    public static void main(String[] args) {

        Condutor driver = new Condutor("Chris", 20, 10);
        CarroReal car = new CarroReal("123-ADC", driver);

        car.connect();
        car.accelerate();
        car.honk();
        car.brake(10);
        car.disconnect();

    }
}
