package ca.uSherbrooke.gegi.reservation.client.application.info;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

class InfoView extends PopupViewImpl implements InfoPresenter.MyView {
    interface Binder extends UiBinder<Widget, InfoView> {
    }

    @UiField
    Label label;

    @Inject
    InfoView(Binder uiBinder, EventBus eventBus) {
    	super(eventBus);
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void setInfo(String info) {
		label.setText(info);
		
	}
    
}