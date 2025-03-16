package Lab02.Ex02;


import Lab01.Ex02.Condutor;

public class CarroReal extends CarroAbstrato implements Buzina{

    public CarroReal(String registration, Condutor driver) {
        super(registration, driver);
    }

    @Override
    public void honk() {
        System.out.println("Honk of Realcar: Toooooooot!");
    }
}
