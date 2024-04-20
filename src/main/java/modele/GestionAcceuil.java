package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class GestionAcceuil {
    private static BooleanProperty etatRecherche;

    public GestionAcceuil(){
        etatRecherche = new SimpleBooleanProperty(false);
    }

    public static BooleanProperty getEtatRechercheProperty(){return etatRecherche;}
    public static boolean isEtatRecherche(){return etatRecherche.get();}
    public static void setEtatRecherche(boolean etatRecherche){GestionAcceuil.etatRecherche.set(etatRecherche);}
}
