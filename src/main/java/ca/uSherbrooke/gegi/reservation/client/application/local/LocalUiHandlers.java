package ca.uSherbrooke.gegi.reservation.client.application.local;

import com.gwtplatform.mvp.client.UiHandlers;

import java.util.Date;

public interface LocalUiHandlers extends UiHandlers {
    void sendSearch(int categorie_local_id, String periodeDebut, String periodeFin, Date date);
}
