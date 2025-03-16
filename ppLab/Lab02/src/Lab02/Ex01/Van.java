package Lab02.Ex01;

import Lab01.Ex02.Carro;
import Lab01.Ex02.Condutor;

public class Van extends Carro {

    public Van(String registration, Condutor driver) {
        super(registration, driver);
    }

    public void disconnectPassengerAirbag(){
        System.out.println("Disconnecting passenger airbag");
    }

    @Override
    public void honk() {
        System.out.println("Van honk: BEEEP BEEEP");
    }
}
