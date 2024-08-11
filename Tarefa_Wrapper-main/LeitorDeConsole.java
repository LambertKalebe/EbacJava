import java.util.Scanner;

public class LeitorDeConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Informe um número: \n");
        float x = scanner.nextFloat();
        Float number = x;
        System.out.printf("Você digitou: %.2f\n", number);

        scanner.close();
    }
}