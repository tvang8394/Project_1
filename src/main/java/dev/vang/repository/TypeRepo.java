package dev.vang.repository;

import java.util.List;

import dev.vang.models.Type;

public interface TypeRepo {
	public Type getTypeById(Integer id);
	public List<Type> getAllType();
	
}
