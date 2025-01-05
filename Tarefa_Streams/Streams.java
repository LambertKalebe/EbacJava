package Tarefa_Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Streams {
    // ler diversos nomes e generos no console ( Nome-Genero, Nome2-Genero,
    // Nome3-Genero, etc)
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
            String gender = parts[1].trim().toLowerCase();

            // Adiciona o nome à lista correspondente ao gênero
            groupedNames.computeIfAbsent(gender, k -> new ArrayList<>()).add(name);
        }

        // Lista de gêneros femininos considerados
        List<String> femaleGenders = List.of("feminino", "femino", "mulher", "m", "f");

        // Filtragem de nomes femininos
        List<String> femaleNames = groupedNames.entrySet().stream()
                .filter(entry -> femaleGenders.contains(entry.getKey()))
                .flatMap(entry -> entry.getValue().stream())
                .sorted()
                .collect(Collectors.toList());

        if (!femaleNames.isEmpty()) {
            System.out.println("Nomes Femininos: " + femaleNames);
        } else {
            System.out.println("Nenhum nome feminino encontrado.");
        }

        scanner.close();
    }
}
