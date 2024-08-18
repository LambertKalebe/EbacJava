package tarefa_coleções;
import java.util.Scanner;
import java.util.Arrays;

public class TarefaParte1 {


    // ler diversos nomes colocados no console, e separados por virgula (split)
    // guardar em uma variavel
    //ordenar em ordem alfabetica e console.log

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os Nomes (separados por ','):");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        Arrays.sort(names);
        System.out.println("Nomes Digitas: " + Arrays.toString(names));




        scanner.close();
    }
}
