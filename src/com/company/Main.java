package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String fileName = "football.dat";
        try {
            Optional<String> teamWithSmallestDifference = findTeamWithSmallestGoalDifference(fileName);
            teamWithSmallestDifference.ifPresentOrElse(
                    team -> System.out.println("Team with the smallest goal difference: " + team),
                    () -> System.out.println("No team found.")
            );
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }

    // Method to find the team with the smallest goal difference
    public static Optional<String> findTeamWithSmallestGoalDifference(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Skip the first line with columns' names
            br.readLine();

            String minDiffTeamName = null;
            int minGoalDifference = Integer.MAX_VALUE;
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip empty lines or lines with dashes
                if (line.isEmpty() || line.contains("---")) continue;

                Team team = parseTeamFromLine(line);

                int goalDifference = team.getGoalDifference();

                if (goalDifference < minGoalDifference) {
                    minGoalDifference = goalDifference;
                    minDiffTeamName = team.getName();
                }
            }

            return Optional.ofNullable(minDiffTeamName);
        }
    }

    // Method that parses a team from a line of the file
    private static Team parseTeamFromLine(String line) {
        String[] parts = line.split("\\s+");
        String teamName = extractTeamName(line, parts);

        int goalsFor = Integer.parseInt(parts[6]);
        int goalsAgainst = Integer.parseInt(parts[8]);

        return new Team(teamName, goalsFor, goalsAgainst);
    }

    // Method that extracts team name, removing the leading number
    private static String extractTeamName(String line, String[] parts) {
        return line.substring(line.indexOf(" ") + 1, line.indexOf(parts[2]));
    }
}

