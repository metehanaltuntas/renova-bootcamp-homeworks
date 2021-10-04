package org.cinespring.example.model.entity;

// film türleri için entity
public class MovieGenre {
    private int movieId;
    private String genreName;

    public MovieGenre() {
    }

    public MovieGenre(int movieId, String genreName) {
        this.movieId = movieId;
        this.genreName = genreName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "MovieGenre{" +
                "movieId=" + movieId +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
