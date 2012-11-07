package com.mmm.dsjsm.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	void create(T t);

	T read(ID id);

	void update(T t);

	void delete(T t);

	List<T> readAll();
}
