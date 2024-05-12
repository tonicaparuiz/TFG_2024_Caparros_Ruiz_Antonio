package es.damdi.com.view;


import es.damdi.com.model.Juegos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class LayoutEditarController {

    @FXML
    private TextField tituloField;
    @FXML
    private TextField horasJugadasField;
    @FXML
    private TextArea descripcionField;
    @FXML
    private TextArea resumenJugadoField;


    private Stage dialogStage;
    private Juegos juegos;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        // Cargar el icono
        Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
        dialogStage.getIcons().add(icon);
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param juegos
     */
    public void setJuegos(Juegos juegos) {
        this.juegos = juegos;

        tituloField.setText(juegos.getTitulo());
        horasJugadasField.setText(Integer.toString(juegos.getHorasJugadas()));
        descripcionField.setText(juegos.getDescripcion());
        resumenJugadoField.setText(juegos.getResumenJugado());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            juegos.setTitulo(tituloField.getText());
            juegos.setHorasJugadas(Integer.parseInt(horasJugadasField.getText()));
            juegos.setDescripcion(descripcionField.getText());
            juegos.setResumenJugado(resumenJugadoField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (tituloField.getText() == null || tituloField.getText().length() == 0) {
            errorMessage += "Titulo no valido\n";
        }

        if (horasJugadasField.getText() == null || horasJugadasField.getText().length() == 0) {
            errorMessage += "Código postarl no valido\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(horasJugadasField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Horas jugadas no válidad, tienen que ser un numero entero\n";
            }
        }
        if (descripcionField.getText() == null || descripcionField.getText().length() == 0) {
            errorMessage += "Descripción no valida\n";
        }
        if (resumenJugadoField.getText() == null || resumenJugadoField.getText().length() == 0) {
            errorMessage += "Resumen jugado no valido\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos invalidos");
            alert.setHeaderText("Por favor corrige los campos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}