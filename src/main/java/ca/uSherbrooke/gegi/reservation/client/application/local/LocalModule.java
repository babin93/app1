package ca.uSherbrooke.gegi.reservation.client.application.local;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LocalModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		bindPresenter(LocalPresenter.class, LocalPresenter.MyView.class,
				LocalView.class, LocalPresenter.MyProxy.class);
	}
}
