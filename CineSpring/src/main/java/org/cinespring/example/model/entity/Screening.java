package org.cinespring.example.model.entity;

// gösterimdeki filmler için entity
public class Screening {
    private int cinemaId;
    private int theatreId;
    private int sessionId;

    public Screening() {
    }

    public Screening(int cinemaId, int theatreId, int sessionId) {
        this.cinemaId = cinemaId;
        this.theatreId = theatreId;
        this.sessionId = sessionId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "cinemaId=" + cinemaId +
                ", theatreId=" + theatreId +
                ", sessionId=" + sessionId +
                '}';
    }
}
