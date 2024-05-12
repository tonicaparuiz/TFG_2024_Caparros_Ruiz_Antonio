package es.damdi.com;

import java.io.IOException;

import es.damdi.com.model.Juegos;
import es.damdi.com.view.LayoutEditarController;
import es.damdi.com.view.LayoutPrincipalController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * Método para crear e inicializr las distintas ventanas de la app
     * @param primaryStage
     */
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
        juegosData.add(new Juegos("Red Dead Redemption 2", "Red Dead Redemption 2 es un videojuego de acción-aventura de temática western ambientado en un entorno de mundo abierto y jugado desde una perspectiva en tercera persona (con posibilidad de primera persona e incluso eliminar el HUD), con componentes para un jugador y multijugador en línea.","He terminado todo el capitulo 1 entero, el capitulo 2 entero y he completado las misiones disponibles de pistoleros famosos hasta ahora. He empezado el capitulo 3. AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",20));
        juegosData.add(new Juegos("Grand Thef Auto V", "GTA se trata de una serie de videojuegos de mundo abierto en el que los jugadores pueden controlar a un personaje en un ambiente urbano y realizar diversas actividades, como conducir vehículos, robar, luchar y realizar misiones.","He completado casi toda la historia. Tambien he realizado todas las misiones secundarias. Me queda la mision final.",60));
        juegosData.add(new Juegos("The Witcher 3: Wild Hunt", "The Witcher 3: Wild Hunt es un juego de rol de acción con una perspectiva en tercera persona. Los jugadores controlan a Geralt de Rivia, un cazador de monstruos conocido como brujo. Geralt camina, corre, rueda y esquiva, y (por primera vez en la serie) salta, trepa y nada.","He terminado la parte inicial del juegos, conociendo a los personajes básicos y ya accediendo al mundo abierto completo",3));
        juegosData.add(new Juegos("Pokemon Amarillo", "Pokémon Amarillo para Game Boy es un juego de la primera generación de Pokémon basado en la historia del anime. El juego cuenta con Pikachu como protagonista y permite a los jugadores capturar y entrenar a diferentes criaturas conocidas como Pokémon mientras viajan por la región de Kanto.","He salido del primer pueblo y llegado a la puerta del primer gimnasio.",2));
    }

    /**
     * Devolvemos una lista de juegos
     * @return
     */
    public ObservableList<Juegos> getJuegosData() {
        return juegosData;
    }

    /**
     * Inicializamos el layout base
     */
    public void initLayoutPrincipal() {
        try {
            // Cargamos el FXML con el menu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LayoutMenu.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostramos la escena principal con el menu
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que nos permitira mostrar el layout principal al abrir la aplicación
     */
    public void mostrarLayoutPrincipal() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LayoutPrincipal.fxml"));
            AnchorPane LayoutPrincipal = (AnchorPane) loader.load();

            // Mostramos el layout principal
            rootLayout.setCenter(LayoutPrincipal);

            // Damos acceso al controlador a la aplicación principal
            LayoutPrincipalController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que nos permitira editar juegos que ya hayamos registrado
     * @param juegos
     * @return
     */
    public boolean mostrarLayoutEditar(Juegos juegos) {
        try {
            // Cargamos el FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LayoutEditar.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Creamos el dialog
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Herramientas");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Seleccionamos el juego que se va a editar
            LayoutEditarController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setJuegos(juegos);

            // Mostramos el dialogo
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Devolvemos el escenario principal
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}