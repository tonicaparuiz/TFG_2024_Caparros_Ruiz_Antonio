package es.damdi.com.view;

import es.damdi.com.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * El tipo de controlador de menú Diseño.
 *
 * @author Antonio Caparros Ruiz
 */
public class LayoutMenuController {
    private Main main;

    /**
     * Establece el main
     *
     * @param main el main
     */
    public void setMain(Main main) {this.main = main; }
    /**
     * Controlador para manejar la acción de guardar
     */
    @FXML
    private void handleSave() {
        try {
            main.saveJuegosDataToMongoDB();
            mostrarMensajeDatosGuardados();
        } catch (Exception e) {
            mostrarMensajeError(e.getMessage());
        }    }
    /**
     * Cierra la aplicacion
     */
    @FXML
    private void handleExit() {
        main.stop();
        System.exit(0);
    }

    @FXML
    private void handleMostrarLayoutPrincipal() {
        main.mostrarLayoutPrincipal();
    }

    @FXML
    private void handleMostrarLayoutHTML() {
        main.mostrarLayoutHTML();
    }
    @FXML
    private void handlePDF(){ main.showAyudaPDF(); }

    private void mostrarMensajeDatosGuardados() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Datos Guardados");
        alert.showAndWait();
    }

    private void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Ocurrió un error al guardar los datos: " + mensaje);
        alert.showAndWait();
    }
}
