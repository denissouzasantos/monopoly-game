package com.monopoly.game.card;

import com.monopoly.game.jail.Jail;
import com.monopoly.game.player.Player;

public class ToJailCard extends Card {
    private Jail jail;

    public ToJailCard(Jail jail) {
        super("Go Directly To Jail");
        this.jail = jail;
    }

    public void doAction(Player player) {
        jail.sendToJail(player);
    }
}
