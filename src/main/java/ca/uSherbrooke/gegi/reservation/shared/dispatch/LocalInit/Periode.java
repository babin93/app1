package ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit;

import java.io.Serializable;

/**
 * Created by Marc-Antoine on 2015-05-11.
 */
public class Periode implements Serializable {

    private String heure;


    public Periode(){ }

    public Periode(String heure){
        this.heure = heure;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
