import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
       Scanner readInput = new Scanner(System.in);
        System.out.print("Primeiro Numero: ");
        float a = readInput.nextFloat();
        System.out.print("+, ou -, ou *, ou / ?: ");
        String operator = readInput.next();
        System.out.print("Segundo Numero: ");
        float b = readInput.nextFloat();

        if (operator.equals("+")) {
            System.out.println("O resultado é: " + (a + b));
        } else if (operator.equals("-")) {
            float result = a - b;
            System.out.println("O resultado é: " + result);
        } else if (operator.equals("*")) {
            System.out.println("O resultado é: " + (a * b));
        } else if (operator.equals("/")) {
            if (b != 0) {
                System.out.println("O resultado é: " + (a / b));
            } else {
                System.out.println("Erro: Não exite uma definição para uma divisão por Zero");
            }
        } else {
            System.out.println("Invalid operator. Please enter one of the following: +, -, *, /.");
        }
    }
}