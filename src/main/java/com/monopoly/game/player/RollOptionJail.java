package com.monopoly.game.player;

import com.monopoly.game.board.Board;
import com.monopoly.game.dice.Dice;

public class RollOptionJail extends PlayerOption {
    Dice dice;
    Player player;
    Board board;

    public RollOptionJail(Dice dice, Player currentPlayer, Board board) {
        super("Roll");
        this.dice = dice;
        player = currentPlayer;
        this.board = board;
    }

    public void action() {
        int roll = dice.roll();

        if (dice.isDouble()) {
            player.inJail = false;
            player.move(roll, board);
        }
    }
}
