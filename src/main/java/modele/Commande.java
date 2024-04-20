package modele;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Commande {
    private StringProperty refCommande;



    private StringProperty dateCommandeS;
    private final StringProperty nomCommande;
    //private FloatProperty prixProduit;
    private StringProperty quantiteCommande;

    public Commande(){
        this.refCommande = new SimpleStringProperty();
        this.dateCommandeS = new SimpleStringProperty();
        this.nomCommande = new SimpleStringProperty();
        this.quantiteCommande = new SimpleStringProperty();
    }




    public Commande(String refCommande_Text,String dateCommande,String NomProduit_Commande, String quantiteCommande_Text){
        this.refCommande = new SimpleStringProperty(refCommande_Text);
        this.dateCommandeS = new SimpleStringProperty(dateCommande);
        this.nomCommande = new SimpleStringProperty(NomProduit_Commande);
        this.quantiteCommande = new SimpleStringProperty(quantiteCommande_Text);
    }

    public Commande(String NomProduit_Commande) {
        this.nomCommande = new SimpleStringProperty(NomProduit_Commande);
    }

    public String getRefCommande() {
        return refCommande.get();
    }

    public StringProperty refCommandeProperty() {
        return refCommande;
    }

    public void setRefCommande(String refCommande) {
        this.refCommande.set(refCommande);
    }

    public String getDateCommande() {
        return dateCommandeS.get();
    }

    public StringProperty dateCommandeProperty() {
        return dateCommandeS;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommandeS.set(dateCommande);
    }

    public String getNomCommande() {
        return nomCommande.get();
    }

    public StringProperty nomCommandeProperty() {
        return nomCommande;
    }

    public void setNomCommande(String nomCommande) {
        this.nomCommande.set(nomCommande);
    }

    public String getQuantiteCommande() {
        return quantiteCommande.get();
    }

    public StringProperty quantiteCommandeProperty() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(String quantiteCommande) {
        this.quantiteCommande.set(quantiteCommande);
    }
}
