package dev.vang.daoTest;

import org.junit.Test;

import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;

public class UserDaoTest {
	
	@Test
	public void loginUserTest() {
		UserRepo ur = new UserRepoImpl();
//		ur.getByUserandPass("tom", "vang");
		System.out.println(ur.getByUserandPass("tom", "vang"));
	}
}
