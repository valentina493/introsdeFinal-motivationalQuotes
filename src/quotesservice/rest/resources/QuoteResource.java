package quotesservice.rest.resources;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import quotesservice.rest.model.Quote;

@Stateless
@LocalBean
@Path("/quote")
public class QuoteResource {
	final String persistenceUnitName = "motivationalQuotesService";

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@PersistenceUnit(unitName = persistenceUnitName)
	EntityManager entityManager;

	@PersistenceContext(unitName = persistenceUnitName, type = PersistenceContextType.TRANSACTION)
	private EntityManagerFactory entityManagerFactory;

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Quote getRandomQuote() {
		Random rand = new Random();
		long randomLong = rand.nextInt(100) + 1;
		Quote randomQuote = Quote.findQuote(randomLong);
		return randomQuote;
	}
}