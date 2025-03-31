package com.example.myapplication.data;

import com.example.myapplication.model.Match;
import com.example.myapplication.model.Player;
import com.example.myapplication.model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        try {
            teams.add(new Team("FC Barcelona", "Spain", "La Liga", "Camp Nou", 1899));
            teams.add(new Team("Manchester United", "England", "Premier League", "Old Trafford", 1878));
            teams.add(new Team("Bayern Munich", "Germany", "Bundesliga", "Allianz Arena", 1900));
            teams.add(new Team("Juventus", "Italy", "Serie A", "Allianz Stadium", 1897));
            teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1", "Parc des Princes", 1970));
            teams.add(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie", "Johan Cruyff Arena", 1900));
            teams.add(new Team("River Plate", "Argentina", "Primera División", "El Monumental", 1901));
            teams.add(new Team("Flamengo", "Brazil", "Brasileirão", "Maracanã", 1895));
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating sample teams: " + e.getMessage());
        }
        return teams;
    }

    public List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        try {
            players.add(new Player("Lionel Messi", 36, "Argentina", "Forward", "Inter Miami", 10));
            players.add(new Player("Cristiano Ronaldo", 38, "Portugal", "Forward", "Al Nassr", 7));
            players.add(new Player("Robert Lewandowski", 34, "Poland", "Forward", "FC Barcelona", 9));
            players.add(new Player("Kevin De Bruyne", 31, "Belgium", "Midfielder", "Manchester City", 17));
            players.add(new Player("Virgil van Dijk", 31, "Netherlands", "Defender", "Liverpool", 4));
            players.add(new Player("Manuel Neuer", 37, "Germany", "Goalkeeper", "Bayern Munich", 1));
            players.add(new Player("Kylian Mbappé", 24, "France", "Forward", "Paris Saint-Germain", 7));
            players.add(new Player("Erling Haaland", 22, "Norway", "Forward", "Manchester City", 9));
            players.add(new Player("Bruno Fernandes", 28, "Portugal", "Midfielder", "Manchester United", 8));
            players.add(new Player("Joshua Kimmich", 28, "Germany", "Midfielder", "Bayern Munich", 6));
            players.add(new Player("Jan Oblak", 30, "Slovenia", "Goalkeeper", "Atletico Madrid", 13));
            players.add(new Player("Neymar Jr.", 31, "Brazil", "Forward", "Al Hilal", 10));
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating sample players: " + e.getMessage());
        }
        return players;
    }

    public List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();
        try {
            matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2024-10-28", "Estadi Olímpic Lluís Companys"));
            matches.add(new Match("Manchester United", "Liverpool", "0-5", "Premier League", "2024-10-24", "Old Trafford"));
            matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-0", "Bundesliga", "2024-11-04", "Allianz Arena"));
            matches.add(new Match("Juventus", "AC Milan", "0-1", "Serie A", "2024-05-28", "Allianz Stadium"));
            matches.add(new Match("Paris Saint-Germain", "AS Monaco", "5-2", "Ligue 1", "2024-11-24", "Parc des Princes"));
            matches.add(new Match("FC Porto", "FC Barcelona", "0-1", "Champions League", "2024-10-04", "Estádio do Dragão"));
            matches.add(new Match("Manchester City", "RB Leipzig", "3-1", "Champions League", "2024-10-04", "Etihad Stadium"));
            matches.add(new Match("Liverpool", "Union SG", "2-0", "Europa League", "2024-10-05", "Anfield"));
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating sample matches: " + e.getMessage());
        }
        return matches;
    }
}