package org.timesheet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.timesheet.service.GenericDao;

public class InMemoryDao<E, K> implements GenericDao<E, K> {
	
	private List<E> entities = new ArrayList<E>();

	@Override
	public void add(E entity) {
		entities.add(entity);
	}

	@Override
	public void update(E entity) {
		throw new UnsupportedOperationException("Not supported in dummy in-memory impl!");
	}

	@Override
	public void remove(E entity) {
		entities.remove(entity);
	}

	@Override
	public E find(K key) {
		if (entities.isEmpty()) {
			return null;
		}
		// just return the first one sice we are not using any keys ATM
		return entities.get(0);
	}

	@Override
	public List<E> list() {
		return entities;
	}

}
