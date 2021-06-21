package dev.vang.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.vang.models.Users;
import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;

public class LoginServlet extends HttpServlet {
	
	UserRepo ur = new UserRepoImpl();
	public Gson gson = new Gson();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("here");
		
		response.getWriter().append("Here");
			
	
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Users u = gson.fromJson(request.getReader(), Users.class);
		
		u = ur.getByUserandPass(u.getUserName(), u.getPassword());
		response.getWriter().append(gson.toJson(u, Users.class));
		System.out.println(u);
		HttpSession session = request.getSession();
		session.setAttribute("loggedUser", u);
//		response.getWriter().append(gson.toJson(u, Users.class));
		
		System.out.println("login " + session.getId());
		System.out.println("login " + session.getAttribute("loggedUser"));
		}
}
