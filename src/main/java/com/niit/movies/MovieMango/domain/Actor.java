package com.niit.movies.MovieMango.domain;

public class Actor {
    private String actorId;
    private String actorName;

    public Actor() {
    }

    public Actor(String actorId, String actorName) {
        this.actorId = actorId;
        this.actorName = actorName;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId='" + actorId + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
