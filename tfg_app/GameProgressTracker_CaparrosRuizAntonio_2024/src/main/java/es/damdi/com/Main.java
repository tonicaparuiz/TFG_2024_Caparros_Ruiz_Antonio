package es.damdi.com;

import java.io.IOException;

import es.damdi.com.model.Juegos;
import es.damdi.com.view.LayoutPrincipalController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("GameProgressTracker");

        // Cargar el icono
        Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
        primaryStage.getIcons().add(icon);

        initLayoutPrincipal();

        mostrarLayoutPrincipal();
    }

    private ObservableList<Juegos> juegosData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public Main() {
        // Add some sample data
        juegosData.add(new Juegos("Red Dead Redemption 2", "Bla bla bla bla bla","",100));
        juegosData.add(new Juegos("Grand Thef Auto V", "Bla bla bla bla bla","",100));
        juegosData.add(new Juegos("The Witcher 3", "Bla bla bla bla bla","",100));
        juegosData.add(new Juegos("Pokemon Amarillo", "Bla bla bla bla bla","",100));
        juegosData.add(new Juegos("Solo Leveling Arise", "Bla bla bla bla bla","",100));

    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Juegos> getJuegosData() {
        return juegosData;
    }

    /**
     * Initializes the root layout.
     */
    public void initLayoutPrincipal() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LayoutMenu.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void mostrarLayoutPrincipal() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LayoutPrincipal.fxml"));
            AnchorPane LayoutPrincipal = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(LayoutPrincipal);

            // Give the controller access to the main app.
            LayoutPrincipalController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}