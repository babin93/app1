package ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit;

import java.io.Serializable;

/**
 * Created by Marc-Antoine on 2015-05-10.
 */
public class CategorieLocal implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public CategorieLocal(){

    }

    public CategorieLocal(int id, String description){
        this.id = id;
        this.description = description;
    }
}
