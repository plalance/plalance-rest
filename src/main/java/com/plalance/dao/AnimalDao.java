package com.plalance.dao;

import org.springframework.stereotype.Service;

import com.plalance.models.Animal;
import com.plalance.stack.StackModelDaoServiceImpl;

@Service
public class AnimalDao extends StackModelDaoServiceImpl<Animal, Integer>{
	
}