package dev.vang.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.vang.models.Users;
import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;



public class UserServlet extends HttpServlet {
	public Gson gson = new Gson();
	UserRepo ur = new UserRepoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter();
		Users u = ur.getUserById(1);
		
		response.getWriter().append(gson.toJson(u, Users.class));


	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
