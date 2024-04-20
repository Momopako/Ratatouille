package com.example.ratatouille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modele.GestionVue;

public class TableauDeBord_Controller {
    @FXML
    private Button acceuilButton;

    @FXML
    private Button commandesButton;

    @FXML
    private Button produitsButton;

    @FXML
    private Button quitter;

    @FXML
    private Button tableauDeBord;

    @FXML
    private Label nbCaA;

    @FXML
    private Label nbCaM;

    @FXML
    private Label nbCommandesMensuelles;

    @FXML
    private Label nbProduitsStock;

    @FXML
    private Label bienvenue_Text;


    @FXML
   void acceuilButtonClick(ActionEvent event) {
    switchPane (GestionVue.getAccueil());

   }

   @FXML
   void produitsButtonClick(ActionEvent event) {
    switchPane (GestionVue.getProduits());
   }
   @FXML
   void commandesButtonClick(ActionEvent event) {
    switchPane (GestionVue.getCommandes());
   }
   @FXML
   void quitterButtonClick(ActionEvent event) {

    }
   private void switchPane(Scene scene){
    Application.getStagePricipal().setScene(scene);
    Application.getStagePricipal().show();
   }
}