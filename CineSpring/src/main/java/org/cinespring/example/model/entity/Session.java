package org.cinespring.example.model.entity;

// oturumlar için entity
public class Session {
    private int id;
    private String startDate;
    private String endDate;
    private String hour;

    public Session() {
    }

    public Session(int id, String startDate, String endDate, String hour) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hour='" + hour + '\'' +
                '}';
    }
}
