package com.example;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {

    List<Integer> dices = List.of(1,2,3,4,5,6);


    public void game(List<Player> players, Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap){

        int index = 0;

        while(index < 100){
            for(Player p : players){

                int dice = rollDice();

                int oldPosition = p.getPosition();
                int newPosition = p.getPosition() + dice;

                String hit = "";

                if (snakeMap.containsKey(newPosition)) {
                    newPosition = snakeMap.get(newPosition);
                    hit = " hit Snanke ";
                }

                if (ladderMap.containsKey(newPosition)) {
                    newPosition = ladderMap.get(newPosition);
                    hit = " hit Ladder ";
                }

                if(newPosition > 100) newPosition = oldPosition ;

                p.setPosition(newPosition);
                index = newPosition;

                System.out.println(p.getName() + " rolled a " + dice + " and moved from "+ oldPosition +" to "+ p.getPosition() + hit);

                if(newPosition == 100) System.out.println(p.getName() + " wins the game");

            }
        }
    }

    public int rollDice(){
        Random random = new Random();
        return dices.get(random.nextInt(dices.size()));
    }
}
