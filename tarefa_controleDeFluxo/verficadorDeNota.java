package tarefa_controleDeFluxo;

import java.util.Scanner;

public class verficadorDeNota {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        float sum = scanner.nextFloat();
        System.out.print("Digite a segunda nota: ");
        sum += scanner.nextFloat();
        System.out.print("Digite a terceira nota: ");
        sum += scanner.nextFloat();
        System.out.print("Digite a quarta nota: ");
        sum += scanner.nextFloat();
        scanner.close();

        float result = sum / 4;
        if (result >= 7) {
            System.out.print("APROVADOOOOO. Sua média foi: " + result);
        } else if (result >= 5) {
            System.out.print("Recuperação... Sua média foi: " + result);
        } else if (result < 5) {
            System.out.print("Reprovado... Sua média foi: " + result);
        }

    }

}
