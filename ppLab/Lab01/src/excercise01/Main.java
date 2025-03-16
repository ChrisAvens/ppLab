package excercise01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create instances of the Pessoa objects with the different constructors
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setName("Joel");
        pessoa1.setGender('M');
        pessoa1.setAge(25);

        Pessoa pessoa2 = new Pessoa("Maria", 'F');
        pessoa2.setAge(30);

        Pessoa pessoa3 = new Pessoa("Carlos", 'M', 40);

        // Print details
        System.out.println("=== Pessoa 1 ===");
        System.out.println("Nome: " + pessoa1.getName());
        System.out.println("Gênero: " + pessoa1.getGender());
        System.out.println("Idade: " + pessoa1.getAge());
        pessoa1.falar();

        System.out.println("\n=== Pessoa 2 ===");
        System.out.println("Nome: " + pessoa2.getName());
        System.out.println("Gênero: " + pessoa2.getGender());
        System.out.println("Idade: " + pessoa2.getAge());
        pessoa2.falar();

        System.out.println("\n=== Pessoa 3 ===");
        System.out.println("Nome: " + pessoa3.getName());
        System.out.println("Gênero: " + pessoa3.getGender());
        System.out.println("Idade: " + pessoa3.getAge());
        pessoa3.falar();

        // Allow user to input values for a new Pessoa object
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Criando uma nova Pessoa ===");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o gênero (M/F): ");
        char genero = scanner.nextLine().charAt(0);

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        Pessoa novaPessoa = new Pessoa(nome, genero, idade);

        System.out.println("\n=== Nova Pessoa Criada ===");
        System.out.println("Nome: " + novaPessoa.getName());
        System.out.println("Gênero: " + novaPessoa.getGender());
        System.out.println("Idade: " + novaPessoa.getAge());
        novaPessoa.falar();

        scanner.close();
    }
}