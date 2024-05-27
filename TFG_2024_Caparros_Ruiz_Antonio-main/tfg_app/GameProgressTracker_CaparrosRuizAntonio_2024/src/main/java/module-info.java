module GameProgressTracker_CaparrosRuizAntonio_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.prefs;
    requires flexjson;
    requires javafx.web;
    requires PDFViewerFX;

    opens es.damdi.com.view;
    opens es.damdi.com.model;
    opens es.damdi.com to javafx.fxml;
    exports es.damdi.com;
    exports es.damdi.com.view;
    exports es.damdi.com.model;
        }