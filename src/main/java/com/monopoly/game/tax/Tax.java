package com.monopoly.game.tax;

import com.monopoly.game.player.Player;
import com.monopoly.game.util.Square;

public class Tax extends Square {
    private int taxAmount;

    public Tax(String name, int taxAmount){
        super(name);
        this.taxAmount = taxAmount;
    }

    public void doAction(Player p) {

    }
}
