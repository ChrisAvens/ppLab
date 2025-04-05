package Lab01.Ex02;

public class Condutor {
    private String name;
    private int age;
    private int dexterty;

    public Condutor(String name, int age, int dexterty) {
        this.name = name;
        this.age = age;
        this.dexterty = dexterty;
    }

    // Getters e setters

    public String getName() {
        return name;
    }

    public void setNome(String name) {
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

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dexterty=" + dexterty +
                '}';
    }
}
