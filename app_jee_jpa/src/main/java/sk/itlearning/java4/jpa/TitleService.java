package sk.itlearning.java4.jpa;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class TitleService {

	@PersistenceContext(unitName = "APP_DB")
	private EntityManager em;

	public Title find(String id) {
		return em.find(Title.class, id);
	}
	
}
