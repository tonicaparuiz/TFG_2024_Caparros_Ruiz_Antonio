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
 * Dialog para editar y añadir juegos a la tabla
 *
 * @author Antonio Caparros Ruiz
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
     * Inicializa la clase de controlador. Este método se llama automáticamente
     * después de que se haya cargado el archivo fxml.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Establece el escenario de este diálogo.
     *
     * @param dialogStage el dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        // Cargar el icono
        Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
        dialogStage.getIcons().add(icon);
        this.dialogStage = dialogStage;
    }

    /**
     * Establece la persona que se va a editar en el cuadro de diálogo.
     *
     * @param juegos de juegos
     */
    public void setJuegos(Juegos juegos) {
        this.juegos = juegos;

        tituloField.setText(juegos.getTitulo());
        horasJugadasField.setText(Integer.toString(juegos.getHorasJugadas()));
        descripcionField.setText(juegos.getDescripcion());
        resumenJugadoField.setText(juegos.getResumenJugado());
    }

    /**
     * Devuelve verdadero si el usuario hizo clic en Aceptar, falso de lo contrario.
     *
     * @return boolean boolean
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Se llama cuando el usuario hace clic ok.
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
     * Se llama cuando el usuario hace clic en cancelar.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Valida la entrada del usuario en los campos de texto.
     *
     * @return verdadero si la entrada es válida
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (tituloField.getText() == null || tituloField.getText().length() == 0) {
            errorMessage += "Titulo no valido\n";
        }

        if (horasJugadasField.getText() == null || horasJugadasField.getText().length() == 0) {
            errorMessage += "Horas jugadas no validas\n";
        } else {
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