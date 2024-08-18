package tarefa_coleções;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TarefaParte2 {
    // ler diversos nomes e generos no console ( Nome-Genero, Nome2-Genero, Nome3-Genero, etc)
    // Separa-los em grupos de acordo com seus generos
    // Mostra-los no console com os grupos separados
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os Nomes no Seguinte Padrão (Nome-Genero,Nome2-Genero):");
        String input = scanner.nextLine();
        String[] nameGenderPairs = input.split(",");
        
        Map<String, List<String>> groupedNames = new HashMap<>();
        
        for (String pair : nameGenderPairs) {
            String[] parts = pair.split("-");
            String name = parts[0].trim();
            String gender = parts[1].trim();
            
            groupedNames.computeIfAbsent(gender, k -> new ArrayList<>()).add(name);
        }
        
        for (String gender : groupedNames.keySet()) {
            List<String> names = groupedNames.get(gender);
            Collections.sort(names);
            System.out.println("Gênero: " + gender + " -> " + names);
        }
        
        scanner.close();
    }
}
