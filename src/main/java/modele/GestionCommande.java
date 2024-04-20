package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestionCommande {
    private static Commande Commande;
    private static ObservableList<Commande> listeCommandes;
    static ObservableList<Commande> listeProduit;


    public GestionCommande(){
        Commande = new Commande();
        listeCommandes = FXCollections.observableArrayList();
        listeProduit = FXCollections.observableArrayList();
    }
    public static ObservableList<Commande> getListeProduit() {
        return listeProduit;
    }

    public static void setListeProduit(ObservableList<Commande> listeProduit) {
        GestionCommande.listeProduit = listeProduit;
    }
    public static void ajouterNomProduit(String nom){
        Commande nomProduit = new Commande(nom);
        listeProduit.add(nomProduit);
    }


    public static ObservableList<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public static void setListeCommandes(ObservableList<Commande> listeCommandes) {
        GestionCommande.listeCommandes = listeCommandes;
    }

    public static Commande getCommande() {
        return Commande;
    }

    public static void setCommande(Commande Commande) {
        GestionCommande.Commande = Commande;
    }


    public static void ajouterCommande(String ref,String date ,String nom, String quantite){
        Commande nouveauCommande = new Commande(ref, date ,nom,quantite);
        listeCommandes.add(nouveauCommande);
    }
    public static void supprimerCommande(Commande Commande) {
        // Implémentez la logique pour supprimer le produit de la liste interne.
        // Par exemple, si vous utilisez une liste observable :
        listeCommandes.remove(Commande);
    }
}
