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
		WebTarget webTarget = client.target("https://api.met.no/weatherapi/locationforecast/1.9/?lat=" + lat + "&lon=" + lon + "&msl=70");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		Weatherdata response = invocationBuilder.get(Weatherdata.class);
		return response;
	}

}
