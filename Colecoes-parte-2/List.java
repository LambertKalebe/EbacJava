import java.util.ArrayList;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização das listas com nomes
        ArrayList<String> listF = new ArrayList<>();
        ArrayList<String> listM = new ArrayList<>();

        // Adicionando nomes às listas
        listF.add("Alice");
        listF.add("Sophia");
        listF.add("Julia");
        listF.add("Helena");
        listF.add("Isabella");
        listF.add("Laura");
        listF.add("Mariana");
        listF.add("Nicole");
        listF.add("Lara");
        listF.add("Manuela");

        listM.add("David");
        listM.add("Jose");
        listM.add("Lucas");
        listM.add("Mateus");
        listM.add("Pedro");
        listM.add("Rafael");
        listM.add("Samuel");
        listM.add("Thiago");
        listM.add("Vinicius");
        listM.add("William");

        // Solicitando informações ao usuário
        System.out.println("Digite o Nome:");
        String name = scanner.next();
        System.out.println("Digite o Sexo (Feminino/Masculino):");
        String sexo = scanner.next();

        // Adicionando o nome à lista apropriada
        if (sexo.equalsIgnoreCase("Feminino")) {
            listF.add(name);
        } else if (sexo.equalsIgnoreCase("Masculino")) {
            listM.add(name);
        } else {
            System.out.println("Sexo inválido.");
            scanner.close();
            return;
        }

        // Solicitando escolha para exibir a lista
        System.out.println("Deseja ver a lista Feminina (digite 1) ou Masculina (digite 2)?");
        int choice = scanner.nextInt();

        // Exibindo a lista conforme a escolha do usuário
        if (choice == 1) {
            System.out.println("Listagem Feminina: \n" + listF);
        } else if (choice == 2) {
            System.out.println("Listagem Masculina: \n" + listM);
        } else {
            System.out.println("Escolha inválida.");
        }

        scanner.close();
    }
}
