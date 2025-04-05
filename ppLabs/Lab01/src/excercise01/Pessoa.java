package excercise01;
public class Pessoa {
    private String name;
    private char gender;
    private int age;

    // Default constructor
    public Pessoa() {
    }

    // Constructor with name and gender
    public Pessoa(String n, char g) {
        this.name = n;
        this.gender = g;
    }

    // Constructor with all 3 attributes
    public Pessoa(String n, char g, int i) {
        this(n, g);
        this.age = i;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // speak
    public void falar() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}
