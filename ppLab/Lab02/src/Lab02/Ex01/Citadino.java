package Lab02.Ex01;

import Lab01.Ex02.Carro;
import Lab01.Ex02.Condutor;

public class Citadino extends Carro {

    public Citadino(String registration, Condutor driver) {
        super(registration, driver);
    }

    public void ConnectManualAC(){
        System.out.println("Manual AC connected");
    }

    @Override
    public void honk() {
        System.out.println("City car honk: PIIIP PIIIIP");
    }
}
