module es.damdi.com {
    requires javafx.fxml;
    requires javafx.controls;

    opens es.damdi.com.view to javafx.fxml;
    // Exporta el paquete es.damdi.com para que otros módulos puedan acceder a él
    exports es.damdi.com;
    exports es.damdi.com.view;

}