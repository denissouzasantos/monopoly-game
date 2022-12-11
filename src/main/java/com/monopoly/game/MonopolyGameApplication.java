package com.monopoly.game;

import com.monopoly.game.board.Board;
import com.monopoly.game.dice.Dice;
import com.monopoly.game.jail.Jail;
import com.monopoly.game.player.Player;
import com.monopoly.game.util.Input;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MonopolyGameApplication {

	public static void main(String[] args) {
		Dice dice = new Dice();
		Jail jail = new Jail();
		List<Player> players = createPlayers(2);
		Board board = new Board(jail, dice, players);

		Game game = new Game(jail, dice, board, players);
		jail.setGame(game);

		game.turn(players.get(0));

		SpringApplication.run(MonopolyGameApplication.class, args);
	}

	static List<Player> createPlayers(int numPlayers){
		List<Player> players = new ArrayList<>();

		for(int i = 1; i <= numPlayers; i++){
			System.out.print("Player " + i + " name: ");
			players.add(new Player(Input.read()));
		}

		return players;
	}

}
