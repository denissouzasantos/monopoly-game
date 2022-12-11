package com.monopoly.game.card;

import com.monopoly.game.player.Player;

import java.util.List;

public class CollectEveryCard extends CollectCard {
    private List<Player> players;

    public CollectEveryCard(List<Player> players, int amount, String text) {
        super(amount, createCollectMessage(amount, text));
        this.players = players;
    }

    protected static String createCollectMessage(int amount, String text) {
        return CollectCard.createCollectMessage(amount, text) + ((amount > 0) ? " from every player" : " to every player");
    }

    public void doAction(Player player) {
        player.addMoney(amount * players.size());

        for (Player p : players) {
            p.addMoney(-amount);
        }
    }
}
