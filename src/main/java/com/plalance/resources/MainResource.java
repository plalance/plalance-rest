package com.plalance.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.dao.AnimalDao;
import com.plalance.services.MainService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class MainResource {

	@Inject
	MainService mainService;

	@Inject
	ObjectMapper jsonMapper;
	

	@Value("${toto}")
	private String test;
	

//	/** Logger */
//	private static final Logger LOG = LoggerFactory.getLogger(MainResource.class);

	@GET
	public Response totoMain() throws Exception {
		
		System.out.println("TEST : " + test);
		
		AnimalDao animalDao = new AnimalDao();

		String resp = jsonMapper.writeValueAsString(animalDao.list());
		
		return Response.status(Status.OK).entity(resp).build();

	}
}
