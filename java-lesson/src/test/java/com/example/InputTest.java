package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    Input input = new Input();

    @Test
    void testLocationMap() {
        Scanner scanner = Mockito.mock(Scanner.class);

        Mockito.when(scanner.nextInt())
                .thenReturn(3, 7, 5, 9, 10, 2);

        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(3, 7);
        expectedMap.put(5, 9);
        expectedMap.put(10, 2);

        Map<Integer, Integer> actualMap = input.locationMap(3, scanner);

        assertEquals(expectedMap, actualMap);
        assertEquals(expectedMap.get(5), actualMap.get(5));
    }


    @Test
    void testMappingPlayer() {
        Scanner scanner = Mockito.mock(Scanner.class);

        Mockito.when(scanner.nextLine())
                .thenReturn("Alda", "Wadi");

        List<Player> expectedPlayers = new ArrayList<>();

        Player player1 = new Player();
        player1.setName("Alda");
        expectedPlayers.add(player1);
        Player player2 = new Player();
        player2.setName("Wadi");
        expectedPlayers.add(player2);

        List<Player> players = input.mappingPlayer(2, scanner);

        assertEquals(expectedPlayers.size(), players.size());
    }

}
