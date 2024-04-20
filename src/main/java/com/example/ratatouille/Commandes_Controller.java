package com.example.ratatouille;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import modele.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Commandes_Controller {
    @FXML
    private ChoiceBox<String> NomProduit_Commande;

    @FXML
    private Button acceuilButton;

    @FXML
    private Button commandesButton;

    @FXML
    private Button produitsButton;

    @FXML
    private Button quitter;
    @FXML
    private DatePicker dateCommande_Text;

    @FXML
    private TextField nomCommandeSearch_Text;


    @FXML
    private TextField quantiteCommande_Text;

    @FXML
    private TextField refCommande_Text;

    @FXML
    private TextField sommeRecue_Text;


    @FXML
    private Button tableauDeBordButton;
    @FXML
    private TableView<Commande> tableauCommande;
    @FXML
    private TableColumn<Commande, String> colonneRefCommande;
    @FXML
    private TableColumn<Commande, String> colonneDateCommande;
    @FXML
    private TableColumn<Commande, String> colonneNomCommande;
    @FXML
    private TableColumn<Commande, String> colonnePuCommande;
    @FXML
    private TableColumn<Commande, String> colonneQuantiteCommande;
    private final String dateCommande = String.valueOf(dateCommande_Text);

    private final Map<String, String> prixProduits = new HashMap<>();

    @FXML
    private void initialize(){
        refCommande_Text.textProperty().bindBidirectional(GestionCommande.getCommande().refCommandeProperty());
//        dateCommande.repeat().bindBidirectional(GestionCommande.getCommande().refCommandeProperty());
//        NomProduit_Commande.setItems(GestionProduit.getListeProduits());
        quantiteCommande_Text.textProperty().bindBidirectional(GestionCommande.getCommande().quantiteCommandeProperty());

        tableauCommande.setItems(GestionCommande.getListeCommandes());
        colonneRefCommande.setCellValueFactory(donnees -> donnees.getValue().refCommandeProperty());
        colonneDateCommande.setCellValueFactory(donnees -> donnees.getValue().dateCommandeProperty());
        colonneNomCommande.setCellValueFactory(donnees -> donnees.getValue().nomCommandeProperty());
        colonneQuantiteCommande.setCellValueFactory(donnees -> donnees.getValue().quantiteCommandeProperty());

        // Créer une liste observable pour stocker les noms de produit
        ObservableList<String> nomsProduits = FXCollections.observableArrayList();

        try {
            // Exécuter une requête SQL pour sélectionner les noms de produit et leurs prix depuis la table "PRODUIT"
            ResultSet resultSet = GestionDataBase.getSt().executeQuery("SELECT NomProduit, PrixProduit FROM PRODUIT");

            // Parcourir les résultats de la requête et ajouter les noms de produit à la liste observable
            while (resultSet.next()) {
                String nomProduit = resultSet.getString("NomProduit");
                String prixProduit = resultSet.getString("PrixProduit");
                nomsProduits.add(nomProduit);
                // Stocker la correspondance entre le nom du produit et son prix dans la Map
                prixProduits.put(nomProduit, prixProduit);
            }

            // Lier la liste observable au ChoiceBox
            NomProduit_Commande.setItems(nomsProduits);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception (afficher un message d'erreur, etc.)
        }
    }

    @FXML
    void onNomProduitSelected() {
        // Récupérer le nom du produit sélectionné
        String nomProduitSelectionne = NomProduit_Commande.getValue();
        // Récupérer le prix associé au nom du produit depuis la Map
        String prixProduit = prixProduits.get(nomProduitSelectionne);
        // Utiliser le prix pour effectuer toute action nécessaire (par exemple, l'insérer dans une colonne)
        // Par exemple :
        colonnePuCommande.setText(prixProduit);
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
    void produitsButtonClick(ActionEvent event) {
     switchPane (GestionVue.getProduits());
    }

    @FXML
    void quitterButtonClick(ActionEvent event) {

    }

    @FXML
    void ajouterButtonClick(ActionEvent event) {
        String refCommande = refCommande_Text.getText().trim();
        String dateCommandeS = String.valueOf(dateCommande_Text.getValue());
        String nomCommande = String.valueOf(NomProduit_Commande.getValue());
        String quantiteCommande = quantiteCommande_Text.getText().trim();
        GestionCommande.ajouterCommande(refCommande,dateCommandeS ,nomCommande,quantiteCommande);
    }

    @FXML
    void effacerButtonClick(ActionEvent event) {
        refCommande_Text.clear();
//        dateCommande_Text.clear();;
        nomCommandeSearch_Text.clear();
        quantiteCommande_Text.clear();
        sommeRecue_Text.clear();
    }

    @FXML
    void majButtonClick(ActionEvent event) {
        Commande commandeSelectionne = tableauCommande.getSelectionModel().getSelectedItem();

        if (commandeSelectionne != null) {
            // Mettre à jour les informations du produit
            String nouveauRef = refCommande_Text.getText().trim();
            String nouveauDate = String.valueOf(dateCommande);
            String nouveauNom = String.valueOf(NomProduit_Commande.getItems());
            String nouveauQuantite = quantiteCommande_Text.getText().trim();

            // Mettre à jour les propriétés du produit
            commandeSelectionne.setRefCommande(nouveauRef);
            commandeSelectionne.setDateCommande(nouveauDate);
            commandeSelectionne.setNomCommande(nouveauNom);
            commandeSelectionne.setQuantiteCommande(nouveauQuantite);

            // Mettre à jour le TableView
            tableauCommande.refresh();

            // Vous devrez peut-être également mettre à jour la liste de produits dans GestionProduit
            // GestionProduit.miseAJourProduit(produitSelectionne);
        } else {
            // Aucun produit sélectionné, afficher un message d'erreur ou effectuer une action appropriée.
        }
    }

    @FXML
    void payerButtonClick(ActionEvent event) {

    }

    @FXML
    void searchButtonClick(MouseEvent event) {

    }

    @FXML
    void supprimerButtonClick(ActionEvent event) {
        // Récupérer la ligne sélectionnée dans le TableView
        Commande commandeSelectionne = tableauCommande.getSelectionModel().getSelectedItem();

        if (commandeSelectionne != null) {
            // Supprimer le produit de la liste dans GestionProduit
            GestionCommande.supprimerCommande(commandeSelectionne);

            // Supprimer le produit de la liste affichée dans le TableView
            tableauCommande.getItems().remove(commandeSelectionne);
        } else {
            // Aucun produit sélectionné, afficher un message d'erreur ou effectuer une action appropriée.
        }
    }

    private void switchPane(Scene scene){
     Application.getStagePricipal().setScene(scene);
     Application.getStagePricipal().show();
    }
}