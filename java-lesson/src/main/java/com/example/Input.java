package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Input {

    public void inputData(){


        ClassLoader classLoader = SnakeLadder.class.getClassLoader();
        URL resource = classLoader.getResource("input.txt");

        if (resource == null) {
            System.err.println("File input.txt not found!");
            return;
        }

        try (Scanner scanner = new Scanner(new File(resource.toURI()))) {

            int numSnakes = scanner.nextInt();
            Map<Integer, Integer> snakeMap = locationMap(numSnakes, scanner);

            int numLadder = scanner.nextInt();
            Map<Integer, Integer> ladderMap = locationMap(numLadder, scanner);

            int numPlayer = scanner.nextInt();
            List<Player> players = mappingPlayer(numPlayer, scanner);

            scanner.close();

            Board board = new Board();
            board.game(players, snakeMap, ladderMap);

        }catch (FileNotFoundException | URISyntaxException e){
            e.printStackTrace();
        }
    }

    public Map<Integer, Integer> locationMap(int num, Scanner scanner){
        Map<Integer, Integer> locMap = new HashMap<>();

        for (int i = 0; i < num; i++) {
            locMap.put(scanner.nextInt(), scanner.nextInt());
        }
        return locMap;
    }

    public List<Player> mappingPlayer(int num, Scanner scanner){
        List<Player> players = new ArrayList<>();

        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            Player player = new Player();
            player.setName(scanner.nextLine().trim());
            players.add(player);
        }
        return players;
    }
}
