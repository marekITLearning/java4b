package sk.itlearning.java4.rest.endpoints;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sk.itlearning.java4.jpa.Rating;
import sk.itlearning.java4.jpa.RatingService;
import sk.itlearning.java4.jpa.Title;

public class RatingFactory {

	public Rating createAndPersistInstance(String movieName) {
		Rating r = new Rating();

		Title t = new Title();
		t.setPrimarytitle(movieName);
		t.setTconst(movieName);

		r.setTitle(t);
		r.setAveragerating(6.5f);
		r.setNumvotes(1234);
		r.setTconst(movieName);

		RatingService rs = null;
		try {
			InitialContext initialContext = new InitialContext();
			rs = (RatingService) initialContext.lookup("java:global/restapi/RatingService");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		rs.create(r);

		return r;
	}

}
