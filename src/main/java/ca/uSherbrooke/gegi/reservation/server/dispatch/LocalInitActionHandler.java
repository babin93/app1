package ca.uSherbrooke.gegi.reservation.server.dispatch;

import ca.uSherbrooke.gegi.reservation.server.logic.HoraireManager;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.LocalInitAction;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.LocalInitResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by Marc-Antoine on 2015-05-10.
 */
public class LocalInitActionHandler implements ActionHandler<LocalInitAction, LocalInitResult> {
    @Inject
    HoraireManager horaireManager;

    @Override
    public LocalInitResult execute(LocalInitAction action, ExecutionContext context)
            throws ActionException {
        LocalInitResult localInitResult = new LocalInitResult();
        localInitResult.setCategoriesLocal(horaireManager.getCategoriesLocal());
        localInitResult.setPeriodes(horaireManager.getPeriodes());
        return localInitResult;
    }

    @Override
    public Class<LocalInitAction> getActionType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void undo(LocalInitAction localInitAction, LocalInitResult localInitResult, ExecutionContext executionContext)
            throws ActionException {

    }
}
