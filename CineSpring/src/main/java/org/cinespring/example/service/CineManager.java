package org.cinespring.example.service;

import org.cinespring.example.model.entity.*;

import java.util.List;

public class CineManager {
    private List<Cinema> cinemaList;
    private List<Movie> movieList;
    private List<MovieGenre> movieGenreList;
    private List<MovieSession> movieSessionList;
    private List<Screening> screeningList;
    private List<Session> sessionList;
    private List<Theatre> theatreList;

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<MovieGenre> getMovieGenreList() {
        return movieGenreList;
    }

    public void setMovieGenreList(List<MovieGenre> movieGenreList) {
        this.movieGenreList = movieGenreList;
    }

    public List<MovieSession> getMovieSessionList() {
        return movieSessionList;
    }

    public void setMovieSessionList(List<MovieSession> movieSessionList) {
        this.movieSessionList = movieSessionList;
    }

    public List<Screening> getScreeningList() {
        return screeningList;
    }

    public void setScreeningList(List<Screening> screeningList) {
        this.screeningList = screeningList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public void setTheatreList(List<Theatre> theatreList) {
        this.theatreList = theatreList;
    }
}
