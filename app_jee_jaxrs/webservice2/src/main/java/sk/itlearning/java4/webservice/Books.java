package sk.itlearning.java4.webservice;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sk.itlearning.java4.a.xml.CatalogLoader;
import sk.itlearning.java4.book.Catalog;

@Path("books")
public class Books {

	@Context
	private HttpServletRequest servletRequest;

	@GET
	@Path("html")
	@Produces(MediaType.TEXT_HTML)
	public Response getBooksAsHtml(@QueryParam("name") String name) throws IOException {
		InputStream is = servletRequest.getServletContext().getResourceAsStream("/book.xml");
		Catalog catalog = CatalogLoader.getFullCatagalog(is);
		StringBuffer sb = new StringBuffer();
		catalog.getBook().forEach(b -> {

			if (b.getAuthor().contains(name == null ? "" : name)) {
				sb.append("<li>" + b.getAuthor() + " : " + b.getTitle() + "<br>");
			}
		});
		return Response.ok(sb.toString()).build();
	}

	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooksAsJson() throws IOException {
		InputStream is = servletRequest.getServletContext().getResourceAsStream("/book.xml");
		Catalog catalog = CatalogLoader.getFullCatagalog(is);
		return Response.ok(GsonUtil.getGson().toJson(catalog)).build();
	}

	@GET
	@Path("xml")
	@Produces(MediaType.APPLICATION_XML)
	public Response getBooksAsBytes() throws IOException {
		InputStream is = servletRequest.getServletContext().getResourceAsStream("/book.xml");
		return Response.ok(is.readAllBytes()).build();
	}

}
