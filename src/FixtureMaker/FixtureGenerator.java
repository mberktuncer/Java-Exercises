package FixtureMaker;

import java.util.*;

public class FixtureGenerator {
    private List<String> teams;
    private List<List<String>> firstHalf;
    private List<List<String>> secondHalf;

    public FixtureGenerator(List<String> teams) {
        this.teams = new ArrayList<>(teams);

        if (teams.size() % 2 != 0) {
            this.teams.add("Bay");
        }

        this.firstHalf = new ArrayList<>();
        this.secondHalf = new ArrayList<>();
    }

    public void generateFixture() {
        int rounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        List<String> homeTeams = new ArrayList<>(teams.subList(0, matchesPerRound));
        List<String> awayTeams = new ArrayList<>(teams.subList(matchesPerRound, teams.size()));
        Collections.reverse(awayTeams);

        for (int i = 0; i < rounds; i++) {
            List<String> round = new ArrayList<>();

            for (int j = 0; j < matchesPerRound; j++) {
                String homeTeam = homeTeams.get(j);
                String awayTeam = awayTeams.get(j);

                round.add(homeTeam + " vs " + awayTeam);
            }

            firstHalf.add(round);

            if (matchesPerRound > 1) {
                homeTeams.add(1, awayTeams.remove(0));
                awayTeams.add(homeTeams.remove(homeTeams.size() - 1));
            }
        }


        for (List<String> round : firstHalf) {
            List<String> reversedRound = new ArrayList<>();
            for (String match : round) {
                String[] parts = match.split(" vs ");
                reversedRound.add(parts[1] + " vs " + parts[0]);
            }
            secondHalf.add(reversedRound);
        }
    }

    public void printFixture() {
        System.out.println("İlk Devre:");
        for (int i = 0; i < firstHalf.size(); i++) {
            System.out.println("Round " + (i + 1) + ": " + firstHalf.get(i));
        }

        System.out.println("\nİkinci Devre:");
        for (int i = 0; i < secondHalf.size(); i++) {
            System.out.println("Round " + (i + 1) + ": " + secondHalf.get(i));
        }
    }
}
