package com.monopoly.game.player;

import com.monopoly.game.player.Player;
import com.monopoly.game.player.PlayerOption;
import com.monopoly.game.property.ColorProperty;
import com.monopoly.game.util.Input;

public class BuyHouseOption extends PlayerOption {
    Player player;

    public BuyHouseOption(Player currentPlayer) {
        super("Buy Houses");
        player = currentPlayer;
    }

    public void action() {
        ColorProperty houseProperty = (ColorProperty) Input.selectOptions(player.getHouseableProperties(), "Select property to purchase house on: ");

        if (houseProperty == null) {
            System.out.println("You do not have any properties to place a house on");
        } else {
            houseProperty.addHouse();
        }
    }
}
