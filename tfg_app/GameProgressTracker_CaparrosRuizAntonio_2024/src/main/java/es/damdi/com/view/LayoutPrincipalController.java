package es.damdi.com.view;


import es.damdi.com.Main;
import es.damdi.com.model.Juegos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class LayoutPrincipalController {
    @FXML
    private TableView<Juegos> juegosTable;
    @FXML
    private TableColumn<Juegos, String> tituloColumna;
    @FXML
    private TableColumn<Juegos, Integer> horasJugadasColumna;

    @FXML
    private Text tituloLabel;
    @FXML
    private Text descripcionLabel;
    @FXML
    private Text horasJugadasLabel;
    @FXML
    private Text resumenJuegoLabel;
    @FXML
    private AnchorPane menuPane;

    // Referencia al Main
    private Main main;

    /**--
     * Constructor
     * Llamamos al constructor mediante el metodo initialize
     */
    public LayoutPrincipalController() {
    }

    /**
     * Inicializa la clase de controlador. Este método se llama automáticamente
     * después de que se haya cargado el archivo fxml.
     */
    @FXML
    private void initialize() {
        tituloLabel.wrappingWidthProperty().bind(juegosTable.widthProperty().subtract(10)); // Ancho de la tabla menos un pequeño margen
        horasJugadasLabel.wrappingWidthProperty().bind(juegosTable.widthProperty().subtract(10));
        descripcionLabel.wrappingWidthProperty().bind(juegosTable.widthProperty().subtract(10));
        resumenJuegoLabel.wrappingWidthProperty().bind(juegosTable.widthProperty().subtract(10));

        // Inicializa los datos en las dos columnas
        tituloColumna.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        horasJugadasColumna.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getHorasJugadas()).asObject());

        // Limpiamos los datos visualizados
        showJuegosDetails(null);

        // Escuchamos los cambios de selección y mostramos los detalles de un juegos cuando se modifiquen.
        juegosTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showJuegosDetails(newValue));
    }

    private void showJuegosDetails(Juegos  juegos) {
        if (juegos != null) {
            // Lenamos las etiquetas con información del objeto juego.
            tituloLabel.setText(juegos.getTitulo());
            descripcionLabel.setText(juegos.getDescripcion());
            resumenJuegoLabel.setText(juegos.getResumenJugado());
            horasJugadasLabel.setText(Integer.toString(juegos.getHorasJugadas()));

        } else {
            tituloLabel.setText("");
            descripcionLabel.setText("");
            resumenJuegoLabel.setText("");
            horasJugadasLabel.setText("");
        }
    }

    /**
     * Método usado para borrar registros de la tabla
     */
    @FXML
    public void deleteJuegos() {
        int selectedIndex = juegosTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            juegosTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Sin selección");
            alert.setHeaderText("Ningún juegos seleccionado");
            alert.setContentText("Por favor selecciona un juego en la tabla.");

            alert.showAndWait();
        }
    }

    /**
     * Método que nos permitira añadir un registro
     */
    @FXML
    public void newJuego() {
        Juegos juegoEditar = new Juegos();
        boolean okClicked = main.mostrarLayoutEditar(juegoEditar);
        if (okClicked) {
            main.getJuegosData().add(juegoEditar);
        }
    }

    /**
     * Método que nos permitira editar un registro ya añadido
     */
    @FXML
    public void editJuego() {
        Juegos selectedPerson = juegosTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = main.mostrarLayoutEditar(selectedPerson);
            if (okClicked) {
                showJuegosDetails(selectedPerson);
            }

        } else {
            // Nada seleccionado
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Sin seleccion");
            alert.setHeaderText("Ningún juego seleccionado.");
            alert.setContentText("Por favor selecciona un juego de la tabla.");

            alert.showAndWait();
        }
    }

    /**
     * Llamamos a la aplicación principal para darse una referencia a sí misma.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

        juegosTable.setItems(main.getJuegosData());
    }
}