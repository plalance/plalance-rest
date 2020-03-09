package com.plalance;


import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plalance.stack.ApplicationRunner;

/**
 * Application runner for developement test.
 */
@Component
public class AppTest extends ApplicationRunner {

	
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

	/**
	 * Do run things
	 *
	 * @throws Exception
	 */
	@Override
	public void run() {
		
		Integer toto = 15;
		
		try {
			System.out.println(jsonMapper.writeValueAsString(toto));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
