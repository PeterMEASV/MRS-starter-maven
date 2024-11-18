package dk.easv.mrs.DAL;
//Project Import
import dk.easv.mrs.BE.Movie;
//Java Import
import java.util.List;

public interface IMovieDataAccess {

     List<Movie> getAllMovies() throws Exception;

     Movie createMovie(String title, int year) throws Exception;

     void updateMovie(Movie movie) throws Exception;

     void deleteMovie(Movie movie) throws Exception;

}
