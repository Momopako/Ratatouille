package com.example.ratatouille;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.*;

import java.io.IOException;
import java.sql.SQLException;

public class Application extends javafx.application.Application {



    private static Stage stagePricipal;

    public  void  init() throws IOException, SQLException, ClassNotFoundException {
        GestionDataBase gestionDataBase = new GestionDataBase();
        GestionAcceuil gestionAcceuil = new GestionAcceuil();
        GestionProduit gestionProduit = new GestionProduit();
        GestionCommande gestionCommande =new GestionCommande();
        GestionVue gestionVue = new GestionVue();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("acceuil-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1093, 754);
        stage.setTitle("Ratatouille");
        stage.setScene(scene);
        stage.show();
        stagePricipal = stage;
    }

    public static Stage getStagePricipal() {
        return stagePricipal;
    }

    public static void setStagePricipal(Stage stagePricipal) {
        Application.stagePricipal = stagePricipal;
    }
    public static void main(String[] args) {
        launch();
    }
}