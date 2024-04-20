package com.example.ratatouille;

import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modele.GestionAcceuil;
import modele.GestionDataBase;
import modele.GestionVue;
import org.kordamp.ikonli.javafx.FontIcon;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static modele.DataBase.connect;
import static modele.DataBase.getConnect;

public class Acceuil_Controller {
    @FXML
    private Button acceuilButton;

    @FXML
    private Button commandesButton;

    @FXML
    private Button produitsButton;

    @FXML
    private Button tableauDeBord;

    @FXML
    private Button quitter;

    @FXML
    private Label bienvenue_Text;

    @FXML
    private TextField identifiant_Text;
    @FXML
    private Label Bienvenue_Text;

    @FXML
    private PasswordField mdp_Text;

    @FXML
    private FontIcon lockIcon;

    @FXML
    private Button SeConnecter;

    @FXML
    private Button CreerCompte;


    @FXML
    void SeConnecterButtonClick(ActionEvent event) {
        String id = identifiant_Text.getText();
        String mdp = mdp_Text.getText();
        connect = getConnect();

        String requeteConnexion = "SELECT COUNT(*) FROM UTILISATEUR WHERE Identifiant = '" + id + "' AND Mdp = '" + mdp + "'";
        try {
            Statement statement = connect.createStatement();
            ResultSet resultConnexion = statement.executeQuery(requeteConnexion);

            while (resultConnexion.next()){
                if(resultConnexion.getInt(1) == 1 ){
                    GestionAcceuil.setEtatRecherche(true);
                    Bienvenue_Text.setText("Bienvenue " + id);
                    Bienvenue_Text.setTextFill(Color.BLACK);
                    bienvenue_Text.setText(id);
                    lockIcon.setIconLiteral("fa-unlock");
                    lockIcon.setIconColor(Color.rgb(60,220,205));
                }
                else {
                    Bienvenue_Text.setText("L'identifiant ou le mot de passe sont incorrect");
                    Bienvenue_Text.setTextFill(Color.RED);
                    bienvenue_Text.setText("");
                    lockIcon.setIconLiteral("fa-lock");
                    lockIcon.setIconColor(Color.RED);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void CreerCompteButtonClick(ActionEvent event) throws SQLException {
        String id = identifiant_Text.getText();
        String mdp = mdp_Text.getText();
        connect = getConnect();

        String requeteCreerCompte = "INSERT INTO UTILISATEUR (Identifiant, Mdp) values ('" + id + "','" + mdp + "')";
        GestionDataBase.getSt().executeUpdate(requeteCreerCompte);
        Bienvenue_Text.setTextFill(Color.BLACK);
        Bienvenue_Text.setText("Votre compte à bien été créer");
        identifiant_Text.clear();
        mdp_Text.clear();
    }
    @FXML
    public void initialize(){
        BooleanProperty booleanTrouve = GestionAcceuil.getEtatRechercheProperty();

        booleanTrouve.addListener((e) ->{
            if (booleanTrouve.getValue().equals(true)){
                lockIcon.setIconLiteral("fa-unlock");
                booleanTrouve.setValue(false);
            }
            else {
                lockIcon.setIconLiteral("fa-lock");
            }
        });
    }
    @FXML
    void tableauDeBordButtonClick(ActionEvent event) {
        switchPane(GestionVue.getTableauDeBord());
    }
    @FXML
    void produitsButtonClick(ActionEvent event) {
        switchPane(GestionVue.getProduits());
    }
    @FXML
    void commandesButtonClick(ActionEvent event) {
         switchPane (GestionVue.getCommandes());
    }
    @FXML
        void quitterButtonClick(ActionEvent event) {

    }
    private void switchPane(Scene scene) {
        Application.getStagePricipal().setScene(scene);
        Application.getStagePricipal().show();
    }
}