package dev.vang.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.vang.models.Genre;
import dev.vang.models.Pitch;
import dev.vang.models.Type;
import dev.vang.models.Users;
import dev.vang.repository.GenreRepo;
import dev.vang.repository.GenreRepoImpl;
import dev.vang.repository.PitchRepo;
import dev.vang.repository.PitchRepoImpl;
import dev.vang.repository.TypeRepo;
import dev.vang.repository.TypeRepoImpl;
import dev.vang.repository.UserRepo;
import dev.vang.repository.UserRepoImpl;

public class FrontControllerServlet extends HttpServlet {
	public Gson gson = new Gson();
	UserRepo ur = new UserRepoImpl();
	GenreRepo gr = new GenreRepoImpl();
	PitchRepo pr = new PitchRepoImpl();
	TypeRepo tr = new TypeRepoImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		
		HttpSession session = request.getSession();
		
//		System.out.println(session.getId());
		
		
		switch (uri) {
		case "/Project_1/getUserById": {
			response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Credentials", "true");
			PrintWriter pw = response.getWriter();
			Users u = ur.getUserById(7);
			
			response.getWriter().append(gson.toJson(u, Users.class));
			System.out.println(u);
//			HttpSession session = request.getSession();
			session.getAttribute("loggedUser");
			System.out.println("session " + session.getId());
//			session.setAttribute("gottenUser", u);
			break;
		}
		case "/Project_1/userByUserAndPass": {
			Users u = gson.fromJson(request.getReader(), Users.class);
			
			System.out.println(u);
			response.getWriter().append(gson.toJson(u));
			if (u != null) {
				
//				HttpSession session = request.getSession();
				System.out.println(session.getId());
				//session.setAttribute("createdUser", u);
				ur.createUser(u);
			}
			break;
		}
		case "/Project_1": {
			response.getWriter().append("\n" + session.getAttribute("loggedUser"));
			System.out.println(session.getId());
			System.out.println(session.getAttribute("loggedUser"));
			break;
		}
		case "/Project_1/login": {
//			response.sendRedirect("/Project_1/LoginServlet");
//			response.getWriter().append("\n" + "made it");
//		
//			System.out.println("login " + session.getId());
//			System.out.println("login " + session.getAttribute("loggedUser"));
			
			Users u = gson.fromJson(request.getReader(), Users.class);
			
			u = ur.getByUserandPass(u.getUserName(), u.getPassword());
			response.getWriter().append(gson.toJson(u, Users.class));
			System.out.println(u);
//			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", u);

			System.out.println("login " + session.getId());
			System.out.println("login " + session.getAttribute("loggedUser"));
			break;
		}
		case "/Project_1/createUser": {
			Users u = gson.fromJson(request.getReader(), Users.class);
			
			System.out.println(u);
			response.getWriter().append(gson.toJson(u));
			if (u != null) {
				
//				HttpSession session = request.getSession();
				ur.createUser(u);
//				System.out.println(session.getId());
//				session.setAttribute("createdUser", u);
				
			}
			break;
		}
		case "/Project_1/getAllGenre": {
			response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Credentials", "true");
//			PrintWriter pw = response.getWriter();
			List<Genre> g = gr.getAllGenre();
			System.out.println(g);
			response.getWriter().append(gson.toJson(g));
			
			
//			HttpSession session = request.getSession();
//			System.out.println(session.getId());
//			session.setAttribute("gottenUser", u);
			break;
		}
		case "/Project_1/createPitch": {
			Pitch p = gson.fromJson(request.getReader(), Pitch.class);
			
			System.out.println(p);
			response.getWriter().append(gson.toJson(p));
			if (p != null) {
				
				
//				HttpSession session = request.getSession();
			pr.createPitch(p);
			System.out.println(session.getId());
//				session.setAttribute("createdUser", p);
		}
		}
		case "/Project_1/getAllType": {
			response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Credentials", "true");
//			PrintWriter pw = response.getWriter();
			List<Type> t = tr.getAllType();
			System.out.println(t);
			response.getWriter().append(gson.toJson(t));
			
			
//			HttpSession session = request.getSession();
//			System.out.println(session.getId());
//			session.setAttribute("gottenUser", u);
			break;
		}
		case "/Project_1/getAllPitch": {
			response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Credentials", "true");
//			PrintWriter pw = response.getWriter();
			List<Pitch> p = pr.getAllPitch();
			System.out.println(p);
			response.getWriter().append(gson.toJson(p));
			break;
		}
		case "/Project_1/deletePitch": {
			Pitch p = gson.fromJson(request.getReader(), Pitch.class);
			System.out.println(p);
			pr.deletePitch(p);
//			response.getWriter().append(gson.toJson(p, Users.class));
			break;
		}
		case "/Project_1/updatePitch": {
			Pitch p = gson.fromJson(request.getReader(), Pitch.class);
			
			System.out.println(p);
			response.getWriter().append(gson.toJson(p));
			if (p != null) {
				
				
//				HttpSession session = request.getSession();
			pr.updatePitch(p);
			
		}
		}}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		doGet(request, response);
		
	}
}
