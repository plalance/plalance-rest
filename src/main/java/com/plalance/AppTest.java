package com.plalance;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.stack.ApplicationRunner;

/**
 * Application runner for developement test.
 */
@Component
@SuppressWarnings("preview")
public class AppTest extends ApplicationRunner {

	private Logger LOG = Logger.getLogger(AppTest.class.getName());

	@Inject
	ObjectMapper jsonMapper;

	/**
	 * MAIN
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		initialize(AppTest.class, args);
	}

	@Override
	public void run() throws Exception {

		String myBlock = """
				line 1
				line 2
				line 3
				""";

		LOG.info(myBlock);

		Integer toto = 15;
		
		LOG.info(jsonMapper.writeValueAsString(toto));
	}
}
