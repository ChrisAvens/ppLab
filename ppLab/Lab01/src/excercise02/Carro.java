package excercise02;
public class Carro {
    private String registration;
    private int actualSpeed = 0;
    private final int maxSpeed = 200;
    private boolean connected;
    private Condutor driver;

    public Carro(String registration, Condutor driver) {
        this.registration = registration;
        this.driver = driver;
        this.connected = false;
    }

    public void Connect() {
        connected = true;
        System.out.println("Car " + registration + " connected: VRUUUUMmmmmmmmmm");
    }

    public void Disconnect() {
        connected = false;
        System.out.println("Car " + registration + " Disconnected: MMMmmmmm");
    }

    public void accelerate() {
        if (!connected) {
            System.out.println("the car " + registration + " is disconnected! It can't accelerate!.");
            return;
        }
        int increase = 10 + (int)(driver.getDexterty() * 0.10);
        actualSpeed += increase;
        if (actualSpeed > maxSpeed) {
            actualSpeed = maxSpeed;
        }
        System.out.println("Car " + registration + " accelerating. Current speed: " + actualSpeed + " km/h");
    }

    public void brake(int brakeIntensity) {
        if (!connected) {
            System.out.println("The car " + registration + " is disconnected! It can't brake!.");
            return;
        }
        actualSpeed -= brakeIntensity;
        if (actualSpeed < 0) {
            actualSpeed = 0;
        }
        System.out.println("Car " + registration + " braking. Current speed: " + actualSpeed + " km/h");
    }

    //Getters

    public int getActualSpeed() {
        return actualSpeed;
    }

    public Condutor getDriver() {
        return driver;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getRegistration() {
        return registration;
    }

}
