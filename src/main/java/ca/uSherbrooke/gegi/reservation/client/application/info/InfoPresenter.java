package ca.uSherbrooke.gegi.reservation.client.application.info;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasPopupSlot;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;

import ca.uSherbrooke.gegi.reservation.client.application.info.InfoEvent.InfoHandler;




public class InfoPresenter extends PresenterWidget<InfoPresenter.MyView> implements InfoHandler {
    interface MyView extends PopupView  {
       public void setInfo(String info);
    }

    @Inject
    InfoPresenter(
            EventBus eventBus,
            MyView view) {
        super(eventBus, view);
    }
    

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub
		super.onBind();
		addRegisteredHandler(InfoEvent.getType(), this);
	}

	@Override
	public void onInfo(InfoEvent event) {
		getView().setInfo(event.getInfo());
	    ((HasPopupSlot) event.getSource()).addToPopupSlot(this);
		
	}
    
    
}