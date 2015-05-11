package ca.uSherbrooke.gegi.reservation.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.Vector;


public class LocalResult implements Result {
	
    private Vector<PlageHoraire> plageHoraires;

 
	public LocalResult() {}
 
    public Vector<PlageHoraire> getPlageHoraires() {return plageHoraires;}
 	public void setPlageHoraires(Vector<PlageHoraire> plageHoraires) {this.plageHoraires = plageHoraires;}
}
