package excercise02;
public class Condutor {
    private String name;
    private int age;
    private int dexterty;

    // Constructor:
    public Condutor(String name, int age, int dexterty) {
        this.name = name;
        this.age = age;
        this.dexterty = dexterty;
    }

    //Public Getters and Setters:

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getDexterty() {
        return dexterty;
    }
    public void setDexterty(int dexterty) {
        this.dexterty = dexterty;
    }

}
