package excercise03;

public class FazCalculos1 {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();
        double num1 = 10;
        double num2 = 20;

        System.out.println(calc.addition(num1, num2));
        System.out.println(calc.subtraction(num1, num2));
        System.out.println(calc.multiplication(num1, num2));
        System.out.println(calc.division(num1, num2));

        try{
            System.out.println("Dividing by zero" + calc.division(num1, 0));
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
