package com.plalance.resources;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Path("/broadcast")
@Singleton
public class BroadcastResource {

	private static final Logger LOG = Logger.getLogger(BroadcastResource.class.getName());

	@Context
	private Sse sse;

	private volatile SseBroadcaster broadcaster;

	@PostConstruct
	public void init() {
		this.broadcaster = sse.newBroadcaster();
	}

	/*
	 * This is the endpoint to connect Client's Event Sources to. 
	 * Purpose : Sending application broadcast global messages (for example notifications for all users...)
	 * 
	 * ------------------------
	 * Example (Javascript) :
	 * 
	 * 	let es = new EventSource("[BACKEND_URL]/broadcast");
	 * 
	 * 	es.addEventListener("message", (e) => {
     *      do something with e.data
     *  });
     *  
     *  -----------------------
	 * 
	 */
	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void register(@Context SseEventSink eventSink) {

		eventSink.send( //
				sse.newEventBuilder() //
						.name("message") //
						.data(String.class, "Bienvenue !") //
						.build() //
		);

		broadcaster.register(eventSink);
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void broadcast(final String message) throws IOException {

		LOG.info("BROADCAST : " + message);
		
		broadcaster.broadcast( //
				sse.newEventBuilder() //
						.name("message") //
						.data(String.class, message) //
						.build() //
		);

	}
	
	SseBroadcaster getBrI() {
		return this.broadcaster;
	}
}
