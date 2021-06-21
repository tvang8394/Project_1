package dev.vang.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.vang.models.Users;
import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;



public class UserServlet extends HttpServlet {
	public Gson gson = new Gson();
	UserRepo ur = new UserRepoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
//		response.setHeader("Access-Control-Allow-Origin", "*");
//	    response.setHeader("Access-Control-Allow-Credentials", "true");
//		PrintWriter pw = response.getWriter();
//		Users u = ur.getUserById(25);
//		
//		response.getWriter().append(gson.toJson(u, Users.class));
//		HttpSession session = request.getSession();
//		System.out.println(session.getId());
//		session.setAttribute("gottenUser", u);
		
//		Users u2 = (Users) session.getAttribute("loggedUser");
//		System.out.println(u2);

	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Users u = gson.fromJson(request.getReader(), Users.class);
//		
//		System.out.println(u);
//		response.getWriter().append(gson.toJson(u));
//		if (u != null) {
//			
//			HttpSession session = request.getSession();
//			System.out.println(session.getId());
//			session.setAttribute("createdUser", u);
//			ur.createUser(u);
//		}
	}
}
