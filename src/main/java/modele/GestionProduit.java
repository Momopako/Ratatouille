package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestionProduit {
    private static Produit produit;
    private static ObservableList<Produit> listeProduits;
    public static ObservableList<Produit> getListeProduits() {
        return listeProduits;
    }

    public static void setListeProduits(ObservableList<Produit> listeProduits) {
        GestionProduit.listeProduits = listeProduits;
    }
    public GestionProduit(){
        produit = new Produit();
        listeProduits = FXCollections.observableArrayList();
    }
    public static Produit getProduit() {
        return produit;
    }

    public static void setProduit(Produit produit) {
        GestionProduit.produit = produit;
    }

    public static void ajouterProduit(String ref, String nom, String type, String prix, String quantite){
        Produit nouveauProduit = new Produit(ref, nom, type, prix, quantite);
        listeProduits.add(nouveauProduit);
    }
    public static void supprimerProduit(Produit produit) {
        // Implémentez la logique pour supprimer le produit de la liste interne.
        // Par exemple, si vous utilisez une liste observable :
        listeProduits.remove(produit);
    }
}
