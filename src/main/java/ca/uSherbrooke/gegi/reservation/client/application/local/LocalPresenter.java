package ca.uSherbrooke.gegi.reservation.client.application.local;

import java.util.Iterator;
import java.util.logging.Logger;

import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.CategorieLocal;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.LocalInitAction;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.LocalInitResult;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.Periode;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;

import ca.uSherbrooke.gegi.reservation.client.application.ApplicationPresenter;
import ca.uSherbrooke.gegi.reservation.client.application.info.InfoEvent;
import ca.uSherbrooke.gegi.reservation.client.place.NameTokens;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalAction;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalResult;


public class LocalPresenter extends
Presenter<LocalPresenter.MyView, LocalPresenter.MyProxy> implements LocalUiHandlers {

	interface MyView extends View, HasUiHandlers<LocalUiHandlers> {
		void addCategorieLocal(String id, String description);
		void addPeriode(String heure);
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Local = new Type<RevealContentHandler<?>>();

	@NameToken(NameTokens.local)
	@ProxyStandard
	public interface MyProxy extends ProxyPlace<LocalPresenter> {
	}
	
	DispatchAsync dispatcher;
	EventBus eventBus;
	LocalPresenter me;


	@Inject
	public LocalPresenter(final EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
		this.dispatcher = dispatcher;
		this.eventBus = eventBus;
		this.me = this;
		getView().setUiHandlers(this);
	}

	@Override
	public void onReset(){
		LocalInitAction action = new LocalInitAction();
		dispatcher.execute(action, new AsyncCallback<LocalInitResult>() {
			@Override
			public void onSuccess(LocalInitResult result) {
				Logger logger = Logger.getLogger("Log variable");
				logger.log(java.util.logging.Level.INFO, "Categorie local charchés");

				// Add all results to the view
				for(Iterator<CategorieLocal> i = result.getCategoriesLocal().iterator(); i.hasNext(); ) {
					CategorieLocal categorieLocal = i.next();
					getView().addCategorieLocal(Integer.toString(categorieLocal.getId()), categorieLocal.getDescription());
				}

				for(Iterator<Periode> i = result.getPeriodes().iterator(); i.hasNext(); ) {
					Periode periode = i.next();
					getView().addPeriode(periode.getHeure());
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Logger logger = java.util.logging.Logger.getLogger("Error Log variable");
				logger.log(java.util.logging.Level.SEVERE, "Probleme de chargement des catégories de locaux");
			}
		});
	}


	@Override
	public void sendLocal(String local) {
		LocalAction localAction = new LocalAction();
		localAction.setLocal(local);
		dispatcher.execute(localAction, new AsyncCallback<LocalResult>() {
			@Override
			public void onSuccess(LocalResult result) {
				Logger logger = Logger.getLogger("Log variable");
				logger.log(java.util.logging.Level.SEVERE, "Local type " + result.getLocalType());
				InfoEvent.fire(me, result.getLocalType());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Logger logger = java.util.logging.Logger.getLogger("Error Log variable");
				logger.log(java.util.logging.Level.SEVERE, "Local choisi probleme");
			}
		});

	}

}





