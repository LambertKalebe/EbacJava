package tarefa.streams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class StreamsTest {

    @Test
    void testGroupNamesByGender() {
        String[] input = { "Ana-feminino", "João-masculino", "Maria-feminino", "Carlos-masculino" };
        Map<String, List<String>> expected = new HashMap<>();
        expected.put("feminino", List.of("Ana", "Maria"));
        expected.put("masculino", List.of("João", "Carlos"));

        Map<String, List<String>> result = Streams.groupNamesByGender(input);

        assertEquals(expected, result);
    }

    @Test
    void testGroupNamesByGenderEmptyInput() {
        String[] input = {};
        Map<String, List<String>> expected = new HashMap<>();

        Map<String, List<String>> result = Streams.groupNamesByGender(input);

        assertEquals(expected, result);
    }

    @Test
    void testFilterFemaleNames() {
        Map<String, List<String>> groupedNames = new HashMap<>();
        groupedNames.put("feminino", List.of("Ana", "Maria"));
        groupedNames.put("masculino", List.of("João", "Carlos"));

        List<String> femaleGenders = List.of("feminino", "femino", "mulher", "m", "f");
        List<String> expected = List.of("Ana", "Maria");

        List<String> result = Streams.filterFemaleNames(groupedNames, femaleGenders);

        assertEquals(expected, result);
    }

    @Test
    void testFilterFemaleNamesNoMatch() {
        Map<String, List<String>> groupedNames = new HashMap<>();
        groupedNames.put("masculino", List.of("João", "Carlos"));

        List<String> femaleGenders = List.of("feminino", "femino", "mulher", "m", "f");

        List<String> result = Streams.filterFemaleNames(groupedNames, femaleGenders);

        assertTrue(result.isEmpty());
    }
}
