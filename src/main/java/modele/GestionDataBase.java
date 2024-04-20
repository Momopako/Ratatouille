package modele;

import java.io.IOException;
import java.sql.*;

public class GestionDataBase {
    private static Connection connect;



    private static Statement st;

    private static PreparedStatement pSt; // A redéfinir

    public GestionDataBase() throws SQLException, IOException, ClassNotFoundException {
        connect = DataBase.getInstance();
        st = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


// Insertion tuples
//        String requete1 = "insert into PRODUIT values (1, 'azerty', 'carotte', '23.56', '11')";
//        GestionDataBase.getSt().executeUpdate(requete1);

// Recupération tuples
        String requeteTabProduit = "select * from PRODUIT";
        ResultSet resultatTabProduit = GestionDataBase.getSt().executeQuery(requeteTabProduit);
        while (resultatTabProduit.next()) {
            int IdProduit = resultatTabProduit.getInt("IdProduit");
            String RefProduit = resultatTabProduit.getString("RefProduit");
            String TypeProduit = resultatTabProduit.getString("TypeProduit");
            String PrixProduit = resultatTabProduit.getString("PrixProduit");
            String Quantite = resultatTabProduit.getString("Quantite");
        }
// Suppression ligne
//        GestionDataBase.getSt().executeUpdate("DELETE FROM PRODUIT WHERE IdProduit = 1;");

        // Mise à jour
//        GestionBaseDonnees.getSt) executeUpdate(requete) ;
    }
    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement st) {
        GestionDataBase.st = st;
    }
}
