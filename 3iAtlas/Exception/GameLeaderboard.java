package Exception;

import java.io.*;
import java.util.*;

class InvalidScoreException extends Exception {
    public InvalidScoreException(String msg) { super(msg); }
}

class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String msg) { super(msg); }
}

class Leaderboard {
    Map<String, Integer> scores = new HashMap<>();

    public void addPlayer(String name) {
        scores.put(name, 0);
        System.out.println("Added player: " + name);
    }

    public void updateScore(String name, int score)
            throws InvalidScoreException, PlayerNotFoundException, IOException {
        if (score < 0)
            throw new InvalidScoreException("Score cannot be negative!");
        if (!scores.containsKey(name))
            throw new PlayerNotFoundException("Player not found: " + name);

        scores.put(name, scores.get(name) + score);
        try (FileWriter fw = new FileWriter("leaderboard.txt", true)) {
            fw.write(name + " -> " + scores.get(name) + "\n");
        }
        System.out.println("Score updated for " + name + ": " + scores.get(name));
    }
}

public class GameLeaderboard {
    public static void main(String[] args) {
        Leaderboard lb = new Leaderboard();
        lb.addPlayer("Selim");

        try {
            lb.updateScore("Selim", 50);
            lb.updateScore("Rafi", 30); // player not found
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            lb.updateScore("Selim", -10); // invalid score
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

