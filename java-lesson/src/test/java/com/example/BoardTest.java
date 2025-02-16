package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;



public class BoardTest {

    List<Player> players = new ArrayList<>();
    Map<Integer, Integer> snakeMap = new HashMap<>();
    Map<Integer, Integer> ladderMap = new HashMap<>();


    @BeforeEach
    public void setUp(){

        Player player1 = new Player();
        player1.setName("Alda");
        players.add(player1);
        Player player2 = new Player();
        player2.setName("Wadi");
        players.add(player2);

        snakeMap.put(2, 0);

        ladderMap.put(39, 25);
        ladderMap.put(5, 10);


    }

    @Test
    void testRollDice() {
        Board board= new Board();
        Assertions.assertNotNull(board.rollDice());
    }

    @Test
    void testGame() {
        Board board = Mockito.spy(new Board());

        doReturn(2,5).when(board).rollDice();

        board.game(players, snakeMap, ladderMap);

        verify(board, times(1)).game(players, snakeMap, ladderMap);
    }

}
