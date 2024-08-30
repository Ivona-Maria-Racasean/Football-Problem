package com.company;

public class Team {
    private final String name;
    private final int goalsFor;
    private final int goalsAgainst;

    public Team(String name, int goalsFor, int goalsAgainst) {
        this.name = name;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public String getName() {
        return name;
    }

    public int getGoalDifference() {
        return Math.abs(goalsFor - goalsAgainst);
    }
}
