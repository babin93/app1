package ca.uSherbrooke.gegi.reservation.client.application.local;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import java.util.Date;


public class LocalView extends ViewWithUiHandlers<LocalUiHandlers> implements LocalPresenter.MyView {
	interface Binder extends UiBinder<Widget, LocalView> {
	}

	@UiField
	Button searchButton;

	@UiField
	DateBox dateBox;

	@UiField ListBox listBox;

	@UiField ListBox listBoxPeriodeDebut;

	@UiField ListBox listBoxPeriodeFin;

	@Inject
	LocalView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		listBox.setVisibleItemCount(5);
		java.util.logging.Logger.getLogger("Local envoyer dans le listbox ");

	}
	
	
	@UiHandler("searchButton")
    void onChange(ClickEvent event) {
		int selectedIndex = listBox.getSelectedIndex();
		int id_categorie = Integer.parseInt(listBox.getSelectedValue());
		String periodeDebut = listBoxPeriodeDebut.getSelectedItemText();
		String periodeFin = listBoxPeriodeFin.getSelectedItemText();
		Date date = dateBox.getValue();

        getUiHandlers().sendSearch(id_categorie, periodeDebut, periodeFin, date);
    }

	public void addCategorieLocal(String id, String description){
		listBox.addItem(description, id);
	}

	public void addPeriode(String heure){
		listBoxPeriodeDebut.addItem(heure);
		listBoxPeriodeFin.addItem(heure);
	}
}
