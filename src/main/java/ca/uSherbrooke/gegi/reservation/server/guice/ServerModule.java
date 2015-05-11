package ca.uSherbrooke.gegi.reservation.server.guice;

import ca.uSherbrooke.gegi.reservation.server.dispatch.LocalInitActionHandler;
import ca.uSherbrooke.gegi.reservation.server.dispatch.LocalActionHandler;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalInit.LocalInitAction;
import ca.uSherbrooke.gegi.reservation.shared.dispatch.LocalAction;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(LocalAction.class, LocalActionHandler.class);
        bindHandler(LocalInitAction.class, LocalInitActionHandler.class);
    }
}