package excercise01;
import java.util.Scanner;

public class UsaPessoa {
    public static void main(String[] args) {
        // creating Pessoa objects with the different constructors
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setName("Joel");
        pessoa1.setGender('M');
        pessoa1.setAge(19);

        Pessoa pessoa2 = new Pessoa("Maria", 'F');
        pessoa2.setAge(30);

        Pessoa pessoa3 = new Pessoa("Carlos", 'M', 21);

        // print details
        System.out.println("=== Pessoa 1 ===");
        System.out.println("Name: " + pessoa1.getName());
        System.out.println("Gender: " + pessoa1.getGender());
        System.out.println("Age: " + pessoa1.getAge());
        pessoa1.falar();

        System.out.println("\n=== Pessoa 2 ===");
        System.out.println("Name: " + pessoa2.getName());
        System.out.println("Gender: " + pessoa2.getGender());
        System.out.println("Age: " + pessoa2.getAge());
        pessoa2.falar();

        System.out.println("\n=== Pessoa 3 ===");
        System.out.println("Name: " + pessoa3.getName());
        System.out.println("Gender: " + pessoa3.getGender());
        System.out.println("Age: " + pessoa3.getAge());
        pessoa3.falar();

        // Pessoa object created by user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCreating a new person.....");
        System.out.print("Give it a name: ");
        String name = scanner.nextLine();

        System.out.print("What´s it´s gender? (M/F): ");
        char gender = scanner.nextLine().charAt(0);

        System.out.print("GIve it a age: ");
        int age = scanner.nextInt();

        Pessoa novaPessoa = new Pessoa(name, gender, age);

        System.out.println("\n=== New person created ===");
        System.out.println("Nome: " + novaPessoa.getName());
        System.out.println("Gênero: " + novaPessoa.getGender());
        System.out.println("Idade: " + novaPessoa.getAge());
        novaPessoa.falar();

        scanner.close();
    }
}