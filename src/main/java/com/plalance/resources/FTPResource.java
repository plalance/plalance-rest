package com.plalance.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.plalance.services.FTPService;

@Path("/ftp")
public class FTPResource{

	@Autowired
	private Environment env;
	
	@Inject
	FTPService ftpService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<String> list = ftpService.getFilesList();
		return Response.status(Status.OK).entity(list).build();
	}
}
