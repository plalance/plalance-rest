package com.plalance.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.dao.AnimalDao;
import com.plalance.models.Animal;
import com.plalance.services.MainService;

@Path("/")
public class MainResource {

	@Inject
	MainService mainService;
	
	@Inject
	ObjectMapper jsonMapper;
	
	@Autowired
	private Environment env;
	
//	/** Logger */
//	private static final Logger LOG = LoggerFactory.getLogger(MainResource.class);

	@GET
	@Path("/animaux")
	public Response totoMain() throws Exception {
		
		AnimalDao animalDao = new AnimalDao();

		Animal chat = new Animal();
		chat.setNom("POTTÉ");
		chat.setType("CHAT NINJA");
		
		animalDao.save(chat);
		
		String resp = jsonMapper.writeValueAsString(animalDao.list());
		
		return Response.status(Status.OK).entity(resp).build();

	}
}
