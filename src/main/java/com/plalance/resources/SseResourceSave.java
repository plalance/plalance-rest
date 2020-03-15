package com.plalance.resources;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/sse")
public class SseResourceSave {

	@Inject
	ObjectMapper jsonMapper;

	@Inject
	BroadcastResource br;

	@Context
	Sse sse;

	private static final Logger LOG = Logger.getLogger(SseResourceSave.class.getName());

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void sendtoEverybody(String message) {
		br.getBrI().broadcast(sse.newEvent(message));
	}
}
