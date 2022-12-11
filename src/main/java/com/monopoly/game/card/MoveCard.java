package com.monopoly.game.card;

import com.monopoly.game.board.Board;
import com.monopoly.game.player.Player;

public class MoveCard extends Card {
    private int numSquares;
    private Board board;

    public MoveCard(int numSquares, Board board, String text) {
        super(text);
        this.numSquares = numSquares;
        this.board = board;
    }

    public void doAction(Player player) {
        player.move(numSquares, board);
    }
}
