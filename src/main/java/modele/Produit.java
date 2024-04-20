package modele;

import javafx.beans.property.*;

public class Produit {
    private final StringProperty refProduit;
    private final StringProperty nomProduit;
    private final StringProperty typeProduit;
    //private FloatProperty prixProduit;
    private final StringProperty prixProduit;
    private final StringProperty quantiteProduit;

    public Produit(){
        this.refProduit = new SimpleStringProperty();
        this.nomProduit = new SimpleStringProperty();
        this.typeProduit = new SimpleStringProperty();
        //this.prixProduit = new SimpleFloatProperty();
        this.prixProduit = new SimpleStringProperty();
        this.quantiteProduit = new SimpleStringProperty();
    }



    public Produit(String refProduit_Text, String nomProduit_Text, String typeProduit_Text, String prixProduit_Text, String quantiteProduit_Text){
        this.refProduit = new SimpleStringProperty(refProduit_Text);
        this.nomProduit = new SimpleStringProperty(nomProduit_Text);
        this.typeProduit = new SimpleStringProperty(typeProduit_Text);
        //this.prixProduit = new SimpleFloatProperty(prixProduit_Text);
        this.prixProduit = new SimpleStringProperty(prixProduit_Text);
        this.quantiteProduit = new SimpleStringProperty(quantiteProduit_Text);
    }
    public String getRefProduit() {
        return refProduit.get();
    }

    public final StringProperty refProduitProperty() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit.set(refProduit);
    }

    public String getNomProduit() {
        return nomProduit.get();
    }

    public final StringProperty nomProduitProperty() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit.set(nomProduit);
    }
    public String getTypeProduit() {
        return typeProduit.get();
    }

    public StringProperty typeProduitProperty() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit.set(typeProduit);
    }
    public String getPrixProduit() {
        return prixProduit.get();
    }

    public StringProperty prixProduitProperty() {
        return prixProduit;
    }

    public void setPrixProduit(String prixProduit) {
        this.prixProduit.set(prixProduit);
    }
    public String getQuantiteProduit() {
        return quantiteProduit.get();
    }

    public StringProperty quantiteProduitProperty() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(String quantiteProduit) {
        this.quantiteProduit.set(quantiteProduit);
    }
}