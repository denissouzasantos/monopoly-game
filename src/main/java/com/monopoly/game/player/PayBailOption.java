package com.monopoly.game.player;

import com.monopoly.game.board.Board;
import com.monopoly.game.dice.Dice;

public class PayBailOption extends PlayerOption {
    Dice dice;
    Player player;
    Board board;

    public PayBailOption(Dice dice, Player currentPlayer, Board board) {
        super("Pay $50");
        this.dice = dice;
        player = currentPlayer;
        this.board = board;
    }

    public void action() {
        player.addMoney(-50);
        player.inJail = false;
        player.move(dice.roll(), board);
    }
}
