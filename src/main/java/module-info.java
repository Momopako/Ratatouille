module com.example.ratatouille {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.ikonli.javafx;
    requires jdk.hotspot.agent;
    requires java.desktop;
    requires mysql.connector.j;

    opens com.example.ratatouille to javafx.fxml;
    exports com.example.ratatouille;
    exports modele;
    opens modele to javafx.fxml;
}