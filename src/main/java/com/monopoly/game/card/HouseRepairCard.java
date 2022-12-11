package com.monopoly.game.card;

import com.monopoly.game.player.Player;
import com.monopoly.game.property.ColorProperty;

public class HouseRepairCard extends CollectCard {
    private int perHouse;
    private int perHotel;

    public HouseRepairCard(int perHouse, int perHotel, String text) {
        super(0, text);
        this.perHouse = perHouse;
        this.perHotel = perHotel;
    }

    private int calculateFee(Player player) {
        int fee = 0;

        for (ColorProperty p : player.getOwnColorGroupList()) {
            if (p.getNumHouses() == 5) {
                fee += perHotel;
            } else if (p.getNumHouses() > 0) {
                fee += perHouse * p.getNumHouses();
            }
        }

        amount = fee;
        return fee;
    }

    public void doAction(Player player) {
        player.addMoney(-calculateFee(player));
    }
}
