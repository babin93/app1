package ca.uSherbrooke.gegi.reservation.client.application.info;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class InfoModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(InfoPresenter.class, InfoPresenter.MyView.class, InfoView.class);
    }
}