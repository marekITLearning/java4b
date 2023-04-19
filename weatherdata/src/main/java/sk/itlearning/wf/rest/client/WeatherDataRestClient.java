package sk.itlearning.wf.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import sk.itlearning.wf.xml.Weatherdata;

public class WeatherDataRestClient {

	public static Weatherdata getByLatLon(String lat, String lon) {
		Client client = ClientBuilder.newClient();
		String target = "https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=" + lat + "&lon=" + lon + "&altitude=90";
		System.out.println(target);
		WebTarget webTarget = client.target(target);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		Weatherdata response = invocationBuilder.get(Weatherdata.class);
		return response;
	}

}
