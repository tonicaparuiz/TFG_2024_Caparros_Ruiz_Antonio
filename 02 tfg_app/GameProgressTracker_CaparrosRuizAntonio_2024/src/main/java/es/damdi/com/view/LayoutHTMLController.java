package es.damdi.com.view;

import es.damdi.com.Main;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * El tipo de controlador HTML de diseño.
 *
 * @author Antonio Caparros Ruiz
 */
public class LayoutHTMLController {

    @FXML
    private WebView webView;

    private Main mainApp;

    /**
     * Establece la clase main
     *
     * @param mainApp clase main
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        // Load the HTML file
        WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/HTML/web_app.html").toString());
    }
}
