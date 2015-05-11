package ca.uSherbrooke.gegi.reservation.client.application.local;

import javax.inject.Inject;

import com.github.gwtbootstrap.datepicker.client.ui.DateBox;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;


public class LocalView extends ViewWithUiHandlers<LocalUiHandlers> implements LocalPresenter.MyView {
	interface Binder extends UiBinder<Widget, LocalView> {
	}
	//@UiField
	//DateBox dateBox;

	@UiField ListBox listBox;

	@UiField ListBox listBoxPeriodeDebut;

	@UiField ListBox listBoxPeriodeFin;

	@Inject
	LocalView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		listBox.setVisibleItemCount(5);
		java.util.logging.Logger.getLogger("Local envoyer dans le listbox ");

	}
	
	
	@UiHandler("listBox")	
    void onChange(ChangeEvent event) {
		int selectedIndex = listBox.getSelectedIndex();
		String local = listBox.getValue(selectedIndex);
        getUiHandlers().sendLocal(local);
    }

	public void addCategorieLocal(String id, String description){
		listBox.addItem(description, id);
	}

	public void addPeriode(String heure){
		listBoxPeriodeDebut.addItem(heure);
		listBoxPeriodeFin.addItem(heure);
	}
}
