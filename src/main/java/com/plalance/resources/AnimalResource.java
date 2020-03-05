package com.plalance.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.dao.AnimalDao;
import com.plalance.models.Animal;
import com.plalance.services.MainService;

@Path("/")
public class AnimalResource {

	@Inject
	MainService mainService;
	
	@Inject
	ObjectMapper jsonMapper;
	
	@Inject
	AnimalDao animalDao;
	
	@Autowired
	private Environment env;
	
//	/** Logger */
//	private static final Logger LOG = LoggerFactory.getLogger(MainResource.class);

	@GET
	@Path("/animaux")
	public Response animaux() throws Exception {
		
		String resp = jsonMapper.writeValueAsString(animalDao.list());
		
		return Response.status(Status.OK).entity(resp).build();

	}

	@GET
	@Path("/animaux/{id}")
	public Response animal(@PathParam("id") Integer id) throws Exception {
		
		Animal a = animalDao.find(id);
		
		String resp = jsonMapper.writeValueAsString(a);
		
		return Response.status(Status.OK).entity(resp).build();

	}
	
	@PUT
	@Path("/animaux")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response animalPut(Animal request) throws Exception {
		
		boolean status = animalDao.save(request);
		
		return Response.status(Status.OK).entity(status).build();

	}
	
	@DELETE
	@Path("/animaux/{id}")
	public Response animalDelete(@PathParam("id") Integer id) throws Exception {
		
		boolean status = animalDao.delete(id);
		
		return Response.status(Status.OK).entity(status).build();

	}
}
