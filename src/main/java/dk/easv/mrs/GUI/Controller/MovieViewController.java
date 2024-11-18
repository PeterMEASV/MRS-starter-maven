package dk.easv.mrs.GUI.Controller;
//Project Import
import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.BLL.MovieManager;
import dk.easv.mrs.DAL.MovieDAO_File;
import dk.easv.mrs.GUI.Model.MovieModel;
//Java Import
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieViewController implements Initializable {
    MovieManager movieManager;


    public TextField txtMovieSearch;
    public ListView<Movie> lstMovies;
    private MovieModel movieModel;
    public TextField txtTitleInput;
    public TextField txtYearInput;

    public MovieViewController()  {

        try {
            movieModel = new MovieModel();
        } catch (Exception e) {
            displayError(e);
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        lstMovies.setItems(movieModel.getObservableMovies());

        txtMovieSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                movieModel.searchMovie(newValue);
            } catch (Exception e) {
                displayError(e);
                e.printStackTrace();
            }
        });

    }

    private void displayError(Throwable t)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Something went wrong");
        alert.setHeaderText(t.getMessage());
        alert.showAndWait();
    }

    @FXML
    private void OnCreateMovie(ActionEvent actionEvent) throws Exception {
        MovieManager manager = new MovieManager();
        Movie tempMovie = manager.createMovie(txtTitleInput.getText(), Integer.parseInt(txtYearInput.getText()));
        movieModel.getObservableMovies().add(tempMovie);

    }
}
