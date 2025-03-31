package com.example.myapplication.model;

import java.util.Objects;
import java.util.UUID;

public class Team implements SoccerEntity {
    private final String id;
    private final String name;
    private final String country;
    private final String league;
    private final String stadium;
    private final int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        Objects.requireNonNull(name, "Team name cannot be null");
        Objects.requireNonNull(country, "Country cannot be null");
        Objects.requireNonNull(league, "League cannot be null");
        Objects.requireNonNull(stadium, "Stadium cannot be null");
        if (name.trim().isEmpty() || country.trim().isEmpty() || league.trim().isEmpty() || stadium.trim().isEmpty()) {
            throw new IllegalArgumentException("Team fields cannot be empty");
        }
        if (foundedYear <= 1800 || foundedYear > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Invalid founded year: " + foundedYear);
        }

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    @Override public String getId() { return id; }
    @Override public String getName() { return name; }
    public String getCountry() { return country; }
    public String getLeague() { return league; }
    public String getStadium() { return stadium; }
    public int getFoundedYear() { return foundedYear; }

    @Override
    public String toString() { return name + " (" + league + ")"; }
}
