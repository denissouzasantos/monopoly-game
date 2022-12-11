package com.monopoly.game.card;

import com.monopoly.game.player.Player;

import java.util.ArrayList;

public abstract class Card {
    String text;

    public Card(String message){
        this.text = message;
    }

    public void play(Player player){
        doAction(player);
        System.out.println("You drew: " + text);
    }

    public abstract void doAction(Player player);
}

