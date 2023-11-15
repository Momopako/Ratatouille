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

public class Produits_Controller {
    @FXML
    private Button aceuilButton;

    @FXML
    private Label bienvenue_Text;

    @FXML
    private ChoiceBox<String> typeProduit_Text;


    @FXML
    private Button commandesButton;

    @FXML
    private TextField nomProduitSearch_Text;

    @FXML
    private TextField nomProduit_Text;


    @FXML
    private Button produitsButton;

    @FXML
    private TextField quantiteProduit_Text;

    @FXML
    private Button quitter;

    @FXML
    private TextField refProduit_Text;

    @FXML
    private Button tableauDeBordButton;

    @FXML
    void searchButtonClick(MouseEvent event) {

    }

    @FXML
    private void initialize(){
        typeProduit_Text.getItems().addAll("Légumes", "Viande" , "Poisson," , "Fruit" , "Viennoiserie", "Féculent ","Légumineuse");
    }


    @FXML
   void acceuilButtonClick(ActionEvent event) {
    switchPane (GestionVue.getAccueil());

   }
   @FXML
   void tableauDeBordButtonClick(ActionEvent event) {
    switchPane (GestionVue.getTableauDeBord());

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
    void searchButtonClick(ActionEvent event) {

    }

    @FXML
    void supprimerButtonClick(ActionEvent event) {

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