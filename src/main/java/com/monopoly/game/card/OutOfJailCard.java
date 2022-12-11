package com.monopoly.game.card;

import com.monopoly.game.player.Player;

public class OutOfJailCard extends Card {
    public OutOfJailCard() {
        super("Get Out Of Jail For Free");
    }

    public void doAction(Player player) {
        player.outOfJailCards++;
    }
}
