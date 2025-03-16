package Lab02.Ex02;
import Lab01.Ex02.Carro;
import Lab01.Ex02.Condutor;


public abstract class CarroAbstrato extends Carro {

    public CarroAbstrato(String registration, Condutor driver) {
        super(registration, driver);
    }

    public abstract void honk();
}
