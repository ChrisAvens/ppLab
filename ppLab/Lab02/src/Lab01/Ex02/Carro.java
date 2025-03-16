package Lab01.Ex02;

public class Carro {
    private final String registration;
    private int actualSpeed;
    private final int maxSpeed = 200;
    private boolean connected;
    private final Condutor driver;

    public Carro(String registration, Condutor driver) {
        this.registration = registration;
        this.driver = driver;
        this.connected = false;
        this.actualSpeed = 0;
    }

    public void connect() {
        connected = true;
        System.out.println("Car " + registration + " connected.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Car " + registration + " disconnected.");
    }

    public void accelerate() {
        if (!connected) {
            System.out.println("Car disconnected! Cannot accelerate.");
            return;
        }
        actualSpeed += 10;
        if (actualSpeed > maxSpeed) {}
            actualSpeed = maxSpeed;
        System.out.println("Actual speed: " + actualSpeed + " km/h");
    }

    public void brake(int intensity) {
        if (!connected) {
            System.out.println("Car disconnected! Cannot brake.");
            return;
        }
        actualSpeed -= intensity;
        if (actualSpeed < 0)
            actualSpeed = 0;
        System.out.println("Actual speed: " + actualSpeed + " km/h");
    }

    public void honk() {
        System.out.println("Car honk.");
    }
}
