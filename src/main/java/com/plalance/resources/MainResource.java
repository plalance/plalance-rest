package com.plalance.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cerprrm.mg2.service.impl.ProposalServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(MainResource.class);

	@GET
	@Path("/x")
	public Response totoMain() throws Exception {

		LOG.info(jsonMapper.writeValueAsString((5)));

		return Response.status(Status.OK).entity(mainService.listAll().toString()).build();

	}
}
