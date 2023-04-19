package sk.itlearning.java4.rest.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import sk.itlearning.java4.rest.endpoints.ImdbData;

@ApplicationPath("api")
public class WebApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(ImdbData.class);
		return resources;
	}

}
