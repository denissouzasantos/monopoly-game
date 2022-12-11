package com.monopoly.game.card;

import com.monopoly.game.deck.Deck;
import com.monopoly.game.player.Player;
import com.monopoly.game.util.Square;

public class CardDraw extends Square {
    private Deck deck;

    public CardDraw(Deck deck, String name){
        super(name);
        this.deck = deck;
    }

    @Override
    public void doAction(Player player) {
        deck.playTop(player);
    }
}
