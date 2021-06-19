package dev.vang.repository;

import dev.vang.models.Users;

public interface UserRepo {
	public Users getUserById(Integer id);
	public void updateUser(Users u);
	public void createUser(Users u);
}
