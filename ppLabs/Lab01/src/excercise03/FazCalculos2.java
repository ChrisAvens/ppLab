package excercise03;
import java.util.Scanner;

public class FazCalculos2 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the first number: ");
        double num1 = sc.nextDouble();

        System.out.println("Type the second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Addition of both numbers :" + calculadora.addition(num1, num2));
        System.out.println("Subtraction of both numbers :" + calculadora.subtraction(num1, num2));
        System.out.println("Multiplication of both numbers :" + calculadora.multiplication(num1, num2));
        try {
            System.out.println("Division of both numbers :" + calculadora.division(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
