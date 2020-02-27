package com.plalance.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class MainService {
	
	public List<String> listAll (){
		
		return Arrays.asList("Bonjour !", "Comment ça va ?", "Au revoir.");
		
	}
	
}
