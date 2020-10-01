package edu.escuelaing.arep.server.model;

public class Team {
    private String name;
    private String country;
    private String league;

    public Team(String name,String country,String league) {
        this.name = name;
        this.country = country;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
}
