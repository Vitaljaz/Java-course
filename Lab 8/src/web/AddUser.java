package web;

import main.UserDB;
import main.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.UserDB;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDB db = UserDB.getInstance();
		
		System.out.println("[POST]: " + username + " " + password);
		
		if (username == null || password == null) {
			return;
		}
		
		User user = new User(username, password);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<style> h2 { text-align: center; padding-top: 20%; } </style>");
		
		if (db.findUser(user)) {
			pw.println("<h2>ERROR! This username already in use!</h2>");
			System.out.println("[POST]: FAIL: " + username + " " + password);
		} else {
			db.add(user);
			pw.println("<h2>" + username + " was added to the list!</h2>");
		}
		
		pw.close();
	}
}
