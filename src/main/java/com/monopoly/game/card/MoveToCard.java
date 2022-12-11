package com.monopoly.game.card;

import com.monopoly.game.board.Board;
import com.monopoly.game.player.Player;

public class MoveToCard extends Card {
    private int[] index;
    private Board board;

    public MoveToCard(int[] index, Board board, String text) {
        super(text);
        this.index = index;
        this.board = board;
    }

    public void doAction(Player player) {
        int minimumDistance = 40;

        for (int i = 0; i < index.length; i++) {
            int distanceToIndex = (40 + index[i] - player.getPosition()) % 40;
            if ((40 + index[i] - player.getPosition()) < minimumDistance) {
                minimumDistance = distanceToIndex;
            }
        }

        player.move(minimumDistance, board);
    }
}
