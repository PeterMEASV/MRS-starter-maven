package dk.easv.mrs.DAL;
//Project Import
import dk.easv.mrs.BE.Movie;
//Java Import
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDAO_File implements IMovieDataAccess {

    private static final String MOVIES_FILE = "data/movie_titles.txt";
    File moviesList = new File(MOVIES_FILE);
    List<Movie> movies = new ArrayList<Movie>();

    //The @Override annotation is not required, but is recommended for readability
    // and to force the compiler to check and generate error msg. if needed etc.
    //@Override
    public List<Movie> getAllMovies() throws IOException {
        Scanner scanner = new Scanner(new File(MOVIES_FILE));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            int id = Integer.parseInt(tokens[0]);
            int year = Integer.parseInt(tokens[1]);
            String name = tokens[2];
            Movie movie = new Movie(id, year, name);
            movies.add(movie);
        }
        scanner.close();
        return movies;

    }

    @Override
    public Movie createMovie(String title, int year) throws Exception {
        List<String> movies2 = new ArrayList<String>();
        Scanner scanner = new Scanner(new File(MOVIES_FILE));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movies2.add(line);
        }
        scanner.close();

        String[] tokens = movies2.get(movies2.size()-1).split(",");
    int nextId = (Integer.parseInt(tokens[0])+1);
    Movie movie = new Movie(nextId, year, title);
    movies.add(movie);
    FileWriter writer = new FileWriter(MOVIES_FILE, true);
        writer.write(nextId + "," + year + "," + title + "\n");
        writer.close();
        return movie;
    }

    @Override
    public void updateMovie(Movie movie) throws Exception {
    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {
    }
}