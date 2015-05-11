package ca.uSherbrooke.gegi.reservation.shared.dispatch;


import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import java.util.Date;

public class LocalAction extends UnsecuredActionImpl<LocalResult> {
	
    private int categorie_local_id;
    private String periode_debut;
    private String periode_fin;

    private Date date;

    public LocalAction() {}

	public int getCategorie_local_id() {
        return categorie_local_id;
    }

	public void setCategorie_local_id(int categorie_local_id) {
        this.categorie_local_id = categorie_local_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPeriode_fin() {
        return periode_fin;
    }

    public void setPeriode_fin(String periode_fin) {
        this.periode_fin = periode_fin;
    }

    public String getPeriode_debut() {
        return periode_debut;
    }

    public void setPeriode_debut(String periode_debut) {
        this.periode_debut = periode_debut;
    }

}

 

