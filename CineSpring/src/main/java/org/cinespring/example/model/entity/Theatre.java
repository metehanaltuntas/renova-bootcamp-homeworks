package org.cinespring.example.model.entity;

// film salonları için entity
public class Theatre {
    private int cinemaId;
    private int theatreId;
    private String theatreName;
    private int totalCapacity;

    public Theatre() {
    }

    public Theatre(int cinemaId, int theatreId, String theatreName, int totalCapacity) {
        this.cinemaId = cinemaId;
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.totalCapacity = totalCapacity;
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

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "cinemaId=" + cinemaId +
                ", theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", totalCapacity=" + totalCapacity +
                '}';
    }
}
