package es.damdi.com.view;


import es.damdi.com.Main;
import es.damdi.com.model.Juegos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class LayoutPrincipalController {
    @FXML
    private TableView<Juegos> juegosTable;
    @FXML
    private TableColumn<Juegos, String> tituloColumna;
    @FXML
    private TableColumn<Juegos, Integer> horasJugadasColumna;

    @FXML
    private Label tituloLabel;
    @FXML
    private Label descripcionLabel;
    @FXML
    private Label horasJugadasLabel;
    @FXML
    private Label resumenJuegoLabel;

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LayoutPrincipalController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        tituloColumna.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        horasJugadasColumna.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getHorasJugadas()).asObject());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

        // Add observable list data to the table
        juegosTable.setItems(main.getJuegosData());
    }
}