package com.monopoly.game.util;

import com.monopoly.game.player.Player;

public class Square implements Comparable<Square>{
    public int index;
    public final String name;

    public Square(String name){
        this.name = name;
    }

    public void doAction(Player currentPlayer){};

    public String toString(){
        return name;
    }

    public int compareTo(Square s){
        if(index < s.index){
            return -1;
        } else if (index == s.index){
            return 0;
        } else {
            return 1;
        }
    }
}
