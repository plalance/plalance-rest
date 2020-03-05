package com.plalance.services;

import java.io.Serializable;
import java.util.List;

public interface StackModelDaoService<T, V extends Serializable> {

	List<T> list();

	T find(V id);

	boolean delete(V id);

	boolean save(T obj);
}
