package ca.uSherbrooke.gegi.reservation.client.application;

import ca.uSherbrooke.gegi.reservation.client.application.home.HomeModule;
import ca.uSherbrooke.gegi.reservation.client.application.info.InfoModule;
import ca.uSherbrooke.gegi.reservation.client.application.local.LocalModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new InfoModule());
        install(new LocalModule());
        install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}