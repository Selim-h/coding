package Exception;


import java.io.*;
import java.util.*;

class UnderageVoterException extends Exception {
    public UnderageVoterException(String msg) { super(msg); }
}

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) { super(msg); }
}

public class VotingSystem {
    static Set<String> voted = new HashSet<>();

    public static void castVote(int age, String voterID) throws UnderageVoterException, DuplicateVoteException, IOException {
        if (age < 18) throw new UnderageVoterException("You must be at least 18 to vote!");
        if (voted.contains(voterID)) throw new DuplicateVoteException("Duplicate vote detected for ID: " + voterID);

        voted.add(voterID);

        try (FileWriter fw = new FileWriter("votes.txt", true)) {
            fw.write(voterID + "\n");
        }
        System.out.println("Vote cast successfully for voter ID: " + voterID);
    }

    public static void main(String[] args) {
        try {
            castVote(20, "V001");
            castVote(17, "V002"); // underage
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            castVote(22, "V001"); // duplicate
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
