package com.example.ratatouille;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import modele.*;
import modele.GestionDataBase;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static modele.DataBase.getConnect;



public class Produits_Controller implements Initializable {
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
    private TextField prixProduit_Text;


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
    private TableView<Produit> tableauProduit;

    @FXML
    private TableColumn<Produit, String> colonneNomProduit;

    @FXML
    private TableColumn<Produit, String> colonnePrixProduit;


    @FXML
    private TableColumn<Produit, String> colonneQuantiteProduit;

    @FXML
    private TableColumn<Produit, String> colonneRefProduit;

    @FXML
    private TableColumn<Produit, String> colonneTypeProduit;

    @FXML
    void searchButtonClick(MouseEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        GestionDonnees.rafraichirDonnees(tableauProduit);

        refProduit_Text.textProperty().bindBidirectional(GestionProduit.getProduit().refProduitProperty());
        nomProduit_Text.textProperty().bindBidirectional(GestionProduit.getProduit().nomProduitProperty());
        typeProduit_Text.getItems().addAll("Légumes", "Viande" , "Poisson" , "Fruit" , "Viennoiserie", "Féculent ","Légumineuse");
        typeProduit_Text.valueProperty().bindBidirectional(GestionProduit.getProduit().typeProduitProperty());
        prixProduit_Text.textProperty().bindBidirectional(GestionProduit.getProduit().prixProduitProperty());
        //prixProduit_Text.textProperty().bindBidirectional(Float.valueOf(GestionProduit.getProduit().prixProduitProperty());
        quantiteProduit_Text.textProperty().bindBidirectional(GestionProduit.getProduit().quantiteProduitProperty());


        colonneRefProduit.setCellValueFactory(donnees -> donnees.getValue().refProduitProperty());
        colonneNomProduit.setCellValueFactory(donnees -> donnees.getValue().nomProduitProperty());
        colonneTypeProduit.setCellValueFactory(donnees -> donnees.getValue().typeProduitProperty());
        colonnePrixProduit.setCellValueFactory(donnees -> donnees.getValue().prixProduitProperty());
    //  colonnePrixProduit.setCellValueFactory(donnees -> donnees.getValue().prixProduitProperty().asObject());
        colonneQuantiteProduit.setCellValueFactory(donnees -> donnees.getValue().quantiteProduitProperty());


        chargerDonneesProduit();
        tableauProduit.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Remplir les champs avec les valeurs du produit sélectionné
                refProduit_Text.setText(newSelection.getRefProduit());
                nomProduit_Text.setText(newSelection.getNomProduit());
                typeProduit_Text.setValue(newSelection.getTypeProduit());
                prixProduit_Text.setText(newSelection.getPrixProduit());
                quantiteProduit_Text.setText(newSelection.getQuantiteProduit());
            }
        });
    }
    private void chargerDonneesProduit() {
        try {
            // Créer la requête SQL SELECT
            String requeteSelect = "SELECT * FROM PRODUIT";

            // Exécuter la requête
            ResultSet resultSet = GestionDataBase.getSt().executeQuery(requeteSelect);

            // Effacer les données existantes dans le TableView
            tableauProduit.getItems().clear();

            // Parcourir les résultats et ajouter les produits dans le TableView
            while (resultSet.next()) {
                Produit produit = new Produit(
                        resultSet.getString("RefProduit"),
                        resultSet.getString("NomProduit"),
                        resultSet.getString("TypeProduit"),
                        resultSet.getString("PrixProduit"),
                        resultSet.getString("Quantite")
                );
                tableauProduit.getItems().add(produit);
            }
        } catch (SQLException e) {
            // Gérer l'exception (afficher un message, enregistrer dans les journaux, etc.)
            e.printStackTrace();
        }
    }

    @FXML
    void ajouterButtonClick(ActionEvent event) throws SQLException {
        String refProduit = refProduit_Text.getText().trim();
        String nomProduit = nomProduit_Text.getText().trim();
        String typeProduit = typeProduit_Text.getValue().trim();
        String prixProduit = prixProduit_Text.getText().trim();
        String quantiteProduit = quantiteProduit_Text.getText().trim();
        GestionProduit.ajouterProduit(refProduit,nomProduit, typeProduit, prixProduit, quantiteProduit);
        GestionCommande.ajouterNomProduit(nomProduit);
        String requeteAjouterProduit = "insert into PRODUIT (RefProduit, NomProduit, TypeProduit, PrixProduit, Quantite) values ('" + refProduit + "' , '" + nomProduit + "', '" + typeProduit + "', '" + prixProduit + "','" + quantiteProduit + "')";
        GestionDataBase.getSt().executeUpdate(requeteAjouterProduit);
    }

    @FXML
    void effacerButtonClick(ActionEvent event) {
        refProduit_Text.clear();
        nomProduit_Text.clear();
        prixProduit_Text.clear();
        quantiteProduit_Text.clear();
    }

    @FXML
    void majButtonClick(ActionEvent event) {
        // Récupérer la ligne sélectionnée dans le TableView
        Produit produitSelectionne = tableauProduit.getSelectionModel().getSelectedItem();

        if (produitSelectionne != null) {
            String nouveauRef = refProduit_Text.getText().trim();
            String nouveauNom = nomProduit_Text.getText().trim();
            String nouveauType = typeProduit_Text.getValue().trim();
            String nouveauPrix = prixProduit_Text.getText().trim();
            String nouvelleQuantite = quantiteProduit_Text.getText().trim();

            // Mettre à jour les propriétés du produit
            produitSelectionne.setRefProduit(nouveauRef);
            produitSelectionne.setNomProduit(nouveauNom);
            produitSelectionne.setTypeProduit(nouveauType);
            produitSelectionne.setPrixProduit(nouveauPrix);
            produitSelectionne.setQuantiteProduit(nouvelleQuantite);

            try {
                // Mettre à jour la base de données
                String requeteMajProduit = "UPDATE PRODUIT SET RefProduit = ?, NomProduit = ?, TypeProduit = ?, PrixProduit = ?, Quantite = ? WHERE RefProduit = ?";
                PreparedStatement preparedStatement = getConnect().prepareStatement(requeteMajProduit);
                preparedStatement.setString(1, nouveauRef);
                preparedStatement.setString(2, nouveauNom);
                preparedStatement.setString(3, nouveauType);
                preparedStatement.setString(4, nouveauPrix);
                preparedStatement.setString(5, nouvelleQuantite);
                preparedStatement.setString(6, produitSelectionne.getRefProduit());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                // Gérer l'exception (afficher un message, enregistrer dans les journaux, etc.)
                e.printStackTrace();
            }
            // Mettre à jour le TableView
            tableauProduit.refresh();
        }
    }


    @FXML
    void supprimerButtonClick(ActionEvent event) {
        // Récupérer la ligne sélectionnée dans le TableView
        Produit produitSelectionne = tableauProduit.getSelectionModel().getSelectedItem();

        if (produitSelectionne != null) {
            try {
                // Créer la requête SQL DELETE
                String requeteDelete = "DELETE FROM PRODUIT WHERE refProduit = '" + produitSelectionne.getRefProduit() + "'";

                // Exécuter la requête
                GestionDataBase.getSt().executeUpdate(requeteDelete);

                // Supprimer le produit de la liste dans GestionProduit
                GestionProduit.supprimerProduit(produitSelectionne);

                // Supprimer le produit de la liste affichée dans le TableView
                tableauProduit.getItems().remove(produitSelectionne);
            } catch (SQLException e) {
                // Gérer l'exception (afficher un message, enregistrer dans les journaux, etc.)
                e.printStackTrace();
            }
        }

    }


    public static class  GestionDonnees {
        public static void rafraichirDonnees(TableView<Produit> tableauProduit) {
            try {
                // Créer la requête SQL SELECT
                String requeteSelect = "SELECT * FROM PRODUIT";

                // Exécuter la requête
                ResultSet resultSet = GestionDataBase.getSt().executeQuery(requeteSelect);

                // Effacer les données existantes dans le TableView
                tableauProduit.getItems().clear();

                // Parcourir les résultats et ajouter les produits dans le TableView
                while (resultSet.next()) {
                    Produit produit = new Produit(
                            resultSet.getString("RefProduit"),
                            resultSet.getString("NomProduit"),
                            resultSet.getString("TypeProduit"),
                            resultSet.getString("PrixProduit"),
                            resultSet.getString("Quantite")
                    );
                    tableauProduit.getItems().add(produit);
                }
            } catch (SQLException e) {
                // Gérer l'exception (afficher un message, enregistrer dans les journaux, etc.)
                e.printStackTrace();
            }
        }
    }


    
    @FXML
    void searchButtonClick(ActionEvent event) {

    }
    @FXML
    void acceuilButtonClick(ActionEvent event) {
        GestionDonnees.rafraichirDonnees(tableauProduit);
        switchPane (GestionVue.getAccueil());
    }
    @FXML
    void tableauDeBordButtonClick(ActionEvent event) {
        GestionDonnees.rafraichirDonnees(tableauProduit);
        switchPane (GestionVue.getTableauDeBord());
    }

    @FXML
    void commandesButtonClick(ActionEvent event) {
        GestionDonnees.rafraichirDonnees(tableauProduit);
        switchPane (GestionVue.getCommandes());
    }

    @FXML
    void quitterButtonClick(ActionEvent event) {

    }
    private void switchPane(Scene scene){
        GestionDonnees.rafraichirDonnees(tableauProduit);
        Application.getStagePricipal().setScene(scene);
        Application.getStagePricipal().show();
    }
}