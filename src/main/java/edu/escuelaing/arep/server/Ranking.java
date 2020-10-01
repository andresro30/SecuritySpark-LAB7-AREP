package edu.escuelaing.arep.server;

import edu.escuelaing.arep.server.model.Team;

import java.util.LinkedList;
import java.util.List;

public class Ranking {

    private List<Team> teams;

    public Ranking() {
        teams = new LinkedList<Team>();
        teams.add(new Team("Bayer munich","Germany","Bundesliga"));
        teams.add(new Team("Paris Sait Germant","France","League One"));
        teams.add(new Team("Real Madrid","Spain","Liga Santander"));
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team){
        if(team != null)
            teams.add(team);
    }

}
