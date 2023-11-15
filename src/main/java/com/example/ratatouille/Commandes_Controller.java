package com.example.ratatouille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modele.GestionVue;

public class Commandes_Controller {
    @FXML
    private ChoiceBox<?> NomProduit;

    @FXML
    private Button acceuilButton;

    @FXML
    private Button commandesButton;

    @FXML
    private TextField nomProduitSearch_Text;

    @FXML
    private TextField prixProduit_Text;

    @FXML
    private Button produitsButton;

    @FXML
    private Button quitter;

    @FXML
    private TextField refCommande_Text;

    @FXML
    private TextField sommeRecue_Text;

    @FXML
    private Button tableauDeBordButton;
   @FXML
   void acceuilButtonClick(ActionEvent event) {
    switchPane (GestionVue.getAccueil());

   }
    @FXML
    void tableauDeBordButtonClick(ActionEvent event) {
     switchPane (GestionVue.getTableauDeBord());

    }
    @FXML
    void produitsButtonClick(ActionEvent event) {
     switchPane (GestionVue.getProduits());
    }

    @FXML
    void quitterButtonClick(ActionEvent event) {

    }

    @FXML
    void ajouterButtonClick(ActionEvent event) {

    }

    @FXML
    void effacerButtonClick(ActionEvent event) {

    }

    @FXML
    void majButtonClick(ActionEvent event) {

    }

    @FXML
    void payerButtonClick(ActionEvent event) {

    }

    @FXML
    void searchButtonClick(MouseEvent event) {

    }

    @FXML
    void supprimerButtonClick(ActionEvent event) {

    }

    private void switchPane(Scene scene){
     Application.getStagePricipal().setScene(scene);
     Application.getStagePricipal().show();
    }


}