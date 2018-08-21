package sort;

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score > b.score) {
            return -1;
        }
        else if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        else {
            return 1;
        }
    }
}

class Solution {

    public static void main(String[] args) {
        Player[] player = new Player[5];
        Checker checker = new Checker();

        player[0] = new Player("amy", 100);
        player[1] = new Player("david", 100);
        player[2] = new Player("heraldo", 50);
        player[3] = new Player("aakansha", 75);
        player[4] = new Player("aleksa", 150);

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}