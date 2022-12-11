package com.monopoly.game.player;

import com.monopoly.game.property.Property;
import com.monopoly.game.util.Input;

public class MortgageOption extends PlayerOption {
    Player player;

    public MortgageOption(Player currentPlayer) {
        super("Mortgage Properties");
        player = currentPlayer;
    }

    public void action() {
        Property mortgageProperty = (Property) Input.selectOptions(player.getUnimprovedProperties(), "Select an unimproved property");

        if (mortgageProperty == null) {
            System.out.println("You do not have any unimproved properties to mortgage");
        } else {
            player.mortgage(mortgageProperty);
        }
    }
}
