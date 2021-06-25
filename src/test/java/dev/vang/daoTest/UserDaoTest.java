package dev.vang.daoTest;

import org.junit.Assert;
import org.junit.Test;

import dev.vang.models.Genre;
import dev.vang.models.Users;
import dev.vang.repository.GenreRepo;
import dev.vang.repository.GenreRepoImpl;
import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;


public class UserDaoTest {
	
	@Test
	public void loginUserTest() {
		UserRepo ur = new UserRepoImpl();
//		ur.getByUserandPass("tom", "vang");
		Users u = new Users();
		
		u = ur.getByUserandPass("author1", "password");
		Assert.assertEquals(u, u);
	}
	@Test 
	public void createUserTest() {
		UserRepo ur = new UserRepoImpl();
		Users u = new Users();
		GenreRepo gr = new GenreRepoImpl();
		Genre g = gr.getGenreById(1);
		u.setFirstName("test");
		u.setLastName("test");
		u.setGenre(g);
		u.setType("Assistant");
		u.setPassword("password");
		u.setUserName("test");
//		ur.createUser(u);
		Assert.assertNotNull(u);
	}
	@Test
	public void getUserByIdTest() {
		UserRepo ur = new UserRepoImpl();
		Users u = new Users();
		u = ur.getUserById(11);
		System.out.println(u);
		Assert.assertEquals(u, u);
	}
}

