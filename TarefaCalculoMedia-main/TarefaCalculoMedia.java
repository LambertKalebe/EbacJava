import java.util.Scanner;

public class TarefaCalculoMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a Primeira Nota");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a Segunda Nota");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a Terceira Nota");
        double nota3 = scanner.nextDouble();
        System.out.println("Digite a Quarta Nota");
        double nota4 = scanner.nextDouble();
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        System.out.println("Ótimo, suas notas são: " + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + "; a média dessas notas é: " + media);

        scanner.close();
    }
}
