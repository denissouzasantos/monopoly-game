package com.monopoly.game.player;

public class ListPropertiesOption extends PlayerOption {
    Player player;

    public ListPropertiesOption(Player currentPlayer) {
        super("List Properties");
        player = currentPlayer;
    }

    public void action() {
        player.listProperties();
    }
}
