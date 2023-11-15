package modele;

import com.example.ratatouille.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class GestionVue {


    private static Scene accueil;
    private static Scene tableauDeBord;

    private static Scene produits;

    private static Scene commandes;

    public GestionVue() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(Application.class.getResource("acceuil-view.fxml")); accueil = new Scene(fxmlLoader1.load(), 1200, 754);
        FXMLLoader fxmlLoader2 = new FXMLLoader(Application.class.getResource("tableauDeBord-view.fxml")); tableauDeBord = new Scene(fxmlLoader2.load(), 1200, 754);
        FXMLLoader fxmlLoader3 = new FXMLLoader(Application.class.getResource("produits-view.fxml")); produits = new Scene(fxmlLoader3.load(), 1200, 754);
        FXMLLoader fxmlLoader4 = new FXMLLoader(Application.class.getResource("commandes-view.fxml")); commandes = new Scene(fxmlLoader4.load(), 1300, 754);

    }

    public static Scene getAccueil() {
        return accueil;
    }

    public static void setAccueil(Scene accueil) {
        GestionVue.accueil = accueil;
    }

    public static Scene getTableauDeBord() {
        return tableauDeBord;
    }

    public static void setTableauDeBord(Scene tableauDeBord) {
        GestionVue.tableauDeBord = tableauDeBord;
    }

    public static Scene getProduits() {
        return produits;
    }

    public static void setProduits(Scene produits) {
        GestionVue.produits = produits;
    }

    public static Scene getCommandes() {
        return commandes;
    }

    public static void setCommandes(Scene commandes) {
        GestionVue.commandes = commandes;
    }


}
