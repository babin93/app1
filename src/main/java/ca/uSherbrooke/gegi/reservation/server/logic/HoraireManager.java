package ca.uSherbrooke.gegi.reservation.server.logic;

import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.CategorieLocal;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.Periode;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.PlageHoraire;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Marc-Antoine on 2015-05-10.
 */
public class HoraireManager {
    private DatabaseConnection db;
    public HoraireManager(){
        this.db = new DatabaseConnection();
    }

    public Vector<CategorieLocal> getCategoriesLocal(){

        Vector<CategorieLocal> categoriesLocal = new Vector<>();
        ResultSet result = db.execute("SELECT categorie_id, libelle FROM categorie_locaux");
        try {
            while (result.next()) {
                categoriesLocal.add(new CategorieLocal(Integer.parseInt(result.getString("categorie_id")), result.getString("libelle")));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return categoriesLocal;
    }

    public Vector<Periode> getPeriodes(){

        Vector<Periode> periodes = new Vector<>();
        ResultSet result = db.execute("SELECT heure FROM periode");
        try {
            while (result.next()) {
                periodes.add(new Periode(result.getString("heure")));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return periodes;
    }

    public Vector<PlageHoraire> getPlageHoraires(int categorie_local_id, String periode_debut, String periode_fin, Date date){

        Vector<PlageHoraire> plageHoraires = new Vector<>();
        ResultSet result = db.execute("SELECT local, heure, description FROM get_horaire("
                                        + date + ", "
                                        + periode_debut + ", "
                                        + periode_fin + ", "
                                        + categorie_local_id + ")");
        try {
            while (result.next()) {
                plageHoraires.add(new PlageHoraire(result.getString("local"), result.getString("heure"), result.getString("description")));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return plageHoraires;
    }


}
