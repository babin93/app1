package ca.uSherbrooke.gegi.reservation.server.logic;

import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.CategorieLocal;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.Periode;

import java.util.Vector;

/**
 * Created by Marc-Antoine on 2015-05-10.
 */
public class HoraireManager {

    public HoraireManager(){ }

    public Vector<CategorieLocal> getCategoriesLocal(){

        Vector<CategorieLocal> categoriesLocal = new Vector<>();
        categoriesLocal.add(new CategorieLocal(110, "Salle de classe générale"));
        categoriesLocal.add(new CategorieLocal(120, "Salle de classe séminaire"));
        categoriesLocal.add(new CategorieLocal(111, "Salle de classe spécialisée"));

        return categoriesLocal;
    }

    public Vector<Periode> getPeriodes(){

        Vector<Periode> periodes = new Vector<>();
        periodes.add(new Periode("00:00"));
        periodes.add(new Periode("00:30"));
        periodes.add(new Periode("01:00"));

        return periodes;
    }
}
