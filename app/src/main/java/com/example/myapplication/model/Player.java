package com.example.myapplication.model;

import java.util.Objects;
import java.util.UUID;

public class Player implements SoccerEntity {
    private final String id;
    private final String name;
    private final int age;
    private final String nationality;
    private final String position;
    private final String currentTeam;
    private final int jerseyNumber;

    public Player(String name, int age, String nationality, String position, String currentTeam, int jerseyNumber) {
        Objects.requireNonNull(name, "Player name cannot be null");
        Objects.requireNonNull(nationality, "Nationality cannot be null");
        Objects.requireNonNull(position, "Position cannot be null");
        Objects.requireNonNull(currentTeam, "Current team cannot be null");
        if (name.trim().isEmpty() || nationality.trim().isEmpty() || position.trim().isEmpty() || currentTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Player fields cannot be empty");
        }
        if (age <= 0 || age > 60) { throw new IllegalArgumentException("Invalid age: " + age); }
        if (jerseyNumber < 0 || jerseyNumber > 999) { throw new IllegalArgumentException("Invalid jersey number: " + jerseyNumber); }

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.currentTeam = currentTeam;
        this.jerseyNumber = jerseyNumber;
    }

    @Override public String getId() { return id; }
    @Override public String getName() { return name; }
    public int getAge() { return age; }
    public String getNationality() { return nationality; }
    public String getPosition() { return position; }
    public String getCurrentTeam() { return currentTeam; }
    public int getJerseyNumber() { return jerseyNumber; }

    @Override
    public String toString() { return name + " (" + position + ", " + currentTeam + ")"; }
}