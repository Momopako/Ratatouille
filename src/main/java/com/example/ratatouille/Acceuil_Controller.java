package com.example.ratatouille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.GestionVue;

public class Acceuil_Controller {
    @FXML
    private Button acceuilButton;

    @FXML
    private Button commandesButton;

    @FXML
    private Button produitsButton;

    @FXML
    private Button tableauDeBord;

    private Button quitter;

    @FXML
    private Label bienvenue_Text;

    @FXML
    private TextField identifiant_Text;

    @FXML
    private PasswordField mdp_Text;

    @FXML
    void tableauDeBordButtonClick(ActionEvent event) {
     switchPane (GestionVue.getTableauDeBord());

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