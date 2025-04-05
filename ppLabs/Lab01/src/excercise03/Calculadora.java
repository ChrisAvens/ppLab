package excercise03;

public class Calculadora {
    public double addition(double a, double b) { return a + b; }
    public double subtraction(double a, double b) { return a - b; }
    public double multiplication(double a, double b) { return a * b; }
    public double division(double a, double b) {
        if (a == 0 || b == 0) throw new ArithmeticException("You can't divide by zero!");
        return a / b;
    }
}
