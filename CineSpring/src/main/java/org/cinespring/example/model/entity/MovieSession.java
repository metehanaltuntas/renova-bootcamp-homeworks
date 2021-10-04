package org.cinespring.example.model.entity;

// film oturumları için entity
public class MovieSession {
    private int movieId;
    private int sessionId;

    public MovieSession() {
    }

    public MovieSession(int movieId, int sessionId) {
        this.movieId = movieId;
        this.sessionId = sessionId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "MovieSession{" +
                "movieId=" + movieId +
                ", sessionId=" + sessionId +
                '}';
    }
}
