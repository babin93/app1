package ca.uSherbrooke.gegi.reservation.shared.dispatch;

import java.io.Serializable;

/**
 * Created by Marc-Antoine on 2015-05-11.
 */
public class PlageHoraire implements Serializable {

    private String local;
    private String heure;
    private String description;

    public PlageHoraire(){}

    public PlageHoraire(String local, String heure, String description){
        this.local = local;
        this.heure = heure;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
