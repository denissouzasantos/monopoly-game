package com.monopoly.game.player;

import com.monopoly.game.property.Property;
import com.monopoly.game.util.Input;

public class PayMortgageOption extends PlayerOption {
    Player player;

    public PayMortgageOption(Player currentPlayer) {
        super("Pay Mortgage");
        player = currentPlayer;
    }

    public void action() {
        Property payMortProperty = (Property) Input.selectOptions(player.getMortgagedProperties(), "Select a property to pay off mortgage");

        if (payMortProperty == null) {
            System.out.println("You do not have any mortgaged properties");
        } else {
            player.payMortgage(payMortProperty);
        }
    }
}
