package ca.uSherbrooke.gegi.reservation.client.application.info;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class InfoEvent extends GwtEvent<InfoEvent.InfoHandler> {
  
	private static Type<InfoHandler> TYPE = new Type<InfoHandler>();
    
    public interface InfoHandler extends EventHandler {
        void onInfo(InfoEvent event);
    }
    
    public interface InfoHandlers extends HasHandlers {
        HandlerRegistration addInfoHandler(InfoHandler handler);
    }
    
    private String info;
   
    public InfoEvent(String info) {
        this.info = info;
    }

    static Type<InfoHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final InfoHandler handler) {
        handler.onInfo(this);
    }

    @Override
    public Type<InfoHandler> getAssociatedType() {
        return TYPE;
    }
    
    public String getInfo() { return info;}
	public void setInfo(String info) {this.info = info;}	

    
    public static void fire(HasHandlers source,  String data) {
		InfoEvent eventInstance = new InfoEvent(data);
		source.fireEvent(eventInstance);
	}

	public static void fire(HasHandlers source, InfoEvent eventInstance) {
		source.fireEvent(eventInstance);
	}
}
