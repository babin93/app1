package ca.uSherbrooke.gegi.reservation.server.dispatch;


import ca.uSherbrooke.gegi.reservation.server.logic.HoraireManager;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalAction;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalResult;

import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class LocalActionHandler  implements ActionHandler <LocalAction, LocalResult>{

    @Inject
	HoraireManager horaireManager;

	@Override
	public LocalResult execute(LocalAction action, ExecutionContext context)
			throws ActionException {
		LocalResult  localResult = new LocalResult();
		localResult.setPlageHoraires(horaireManager.getPlageHorraires(
						action.getCategorie_local_id(),
						action.getPeriode_debut(),
						action.getPeriode_fin(),
						action.getDate()));
		return localResult;
	}

	@Override
	public void undo(LocalAction action, LocalResult result,
			ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub
	}

	@Override
	public Class<LocalAction> getActionType() {
		// TODO Auto-generated method stub
		return null;
	}
}
