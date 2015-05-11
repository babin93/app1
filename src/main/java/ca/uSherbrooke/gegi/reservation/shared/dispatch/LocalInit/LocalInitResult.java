package ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit;


import com.gwtplatform.dispatch.rpc.shared.Result;
import java.util.Vector;

/**
 * Created by Marc-Antoine on 2015-05-10.
 */
public class LocalInitResult implements Result {

    private Vector<CategorieLocal> categoriesLocal;

    private Vector<Periode>  periodes;

    public LocalInitResult() {}

    public Vector<Periode> getPeriodes() {
        return periodes;
    }

    public void setPeriodes(Vector<Periode> periodes) {
        this.periodes = periodes;
    }

    public Vector<CategorieLocal> getCategoriesLocal() {
        return categoriesLocal;
    }

    public void setCategoriesLocal(Vector<CategorieLocal> categoriesLocal) {
        this.categoriesLocal = categoriesLocal;
    }
}
