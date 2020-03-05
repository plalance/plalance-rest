package com.plalance.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.dao.PersonneDao;
import com.plalance.models.Personne;

@Path("/")
public class PersonneResource {

	@Inject
	ObjectMapper jsonMapper;
	
	@Inject
	PersonneDao personneDao;
	
	@GET
	@Path("/personnes")
	public Response personnes() throws Exception {
		
		String resp = jsonMapper.writeValueAsString(personneDao.list());
		
		return Response.status(Status.OK).entity(resp).build();

	}

	@GET
	@Path("/personnes/{id}")
	public Response personne(@PathParam("id") Integer id) throws Exception {
		
		Personne p = personneDao.find(id);
		
		String resp = jsonMapper.writeValueAsString(p);
		
		return Response.status(Status.OK).entity(resp).build();

	}
}
