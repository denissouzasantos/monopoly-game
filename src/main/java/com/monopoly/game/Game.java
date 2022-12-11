package com.monopoly.game;

import com.monopoly.game.board.Board;
import com.monopoly.game.dice.Dice;
import com.monopoly.game.jail.Jail;
import com.monopoly.game.player.*;
import com.monopoly.game.util.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final Jail jail;
    private final Dice dice;
    private final Board board;
    private List<Player> players = new ArrayList<>();

    public Game(Jail jail, Dice dice, Board board, List<Player> players){
        this.jail = jail;
        this.dice = dice;
        this.board = board;
        this.players = players;
    }

    public List<Player> getPlayers (){
        return players;
    }
    //pass turn to next Player
    public void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\nMoney: $" + currentPlayer.getMoney());

        if(currentPlayer.inJail){ //if player doesn't escape jail on turn, skips to showOptions

            if(!jail.jailTurn(currentPlayer, dice, board)) {
                showOptions(currentPlayer);
            }
        } else { //if player is not in jail
            System.out.println("Position: " + board.getCurrentSquare(currentPlayer));
            int numDoubles = 0;

            do{
                currentPlayer.move(dice.roll(), board);
                numDoubles++;

                if(numDoubles == 3){
                    jail.sendToJail(currentPlayer);
                }
            } while (numDoubles < 3 && dice.isDouble());
        }

        showOptions(currentPlayer);
    }

    public void endTurn(Player currentPlayer){
        int currentIndex = players.indexOf(currentPlayer);
        if(currentIndex + 1 == players.size()){
            turn(players.get(0));
        } else {
            turn(players.get(currentIndex + 1));
        }
    }

    //player options after roll and land on a square
    private void showOptions(Player currentPlayer){
        List<PlayerOption> options = Arrays.asList(
                new ListPropertiesOption(currentPlayer),
                new BuyHouseOption(currentPlayer),
                new MortgageOption(currentPlayer),
                new PayMortgageOption(currentPlayer),
                new EndTurnOption(this, currentPlayer)
        );

        PlayerOption selectedOption = (PlayerOption) Input.selectOptions(options, "Additional Actions:");
        selectedOption.action();

        showOptions(currentPlayer); //when player does not select end turn
    }
}
