package sk.itlearning.java4.rest.endpoints;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sk.itlearning.java4.jpa.Rating;
import sk.itlearning.java4.jpa.RatingService;

@Path("imdb")
public class ImdbData {

	@Inject
	private RatingService ratingService;

	@GET
	@Path("createAndPersist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopRated() {
		RatingFactory rf = new RatingFactory();
		return Response.ok(rf.createAndPersistInstance(String.valueOf(new Date().getTime()))).build();
	}

	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCount() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return Response.ok(gson.toJson(ratingService.getAll())).build();
	}

	@POST
	@Path("updateRating")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCount(Rating rating) {
		Rating dbEntity = ratingService.find(rating.getId());
		dbEntity.setAveragerating(rating.getAveragerating());
		ratingService.update(rating);
		return Response.ok(rating).build();
	}

}
