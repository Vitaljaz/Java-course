package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.User;
import main.UserDB;


@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldUsername = request.getParameter("username");
		String newUsername = request.getParameter("newusername");
		String newPassword = request.getParameter("newpassword");
		
		UserDB db = UserDB.getInstance();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<style> h2 { text-align: center; padding-top: 20%; } </style>");
		
		if (newUsername == "" && newPassword == "") {
			pw.println("<h2>ERROR! No inputs</h2>");
			pw.close();
			return;
		}
		
		if (!db.findUser(new User(oldUsername, "0")))  {
			pw.println("<h2>ERROR! " + oldUsername + " user not found</h2>");
			pw.close();
			return;
		}
		
		if (db.findUser(new User(newUsername, "0"))) {
			pw.println("<h2>ERROR! " + newUsername + " is already in use</h2>");
			pw.close();
			return;
		}
		
		System.out.println("[POST-edit]: " + oldUsername + " " + newUsername + " " + newPassword);
			
		List<User> users = db.getList();
		
		for (User user : users) {
			if (user.getUsername().equals(oldUsername)) {
				user.setUsername(newUsername);
				if (newPassword != "") {
					user.setPassword(newPassword);
				}
			}
		}
		
		pw.println("<h2>Successfully!</h2>");
		pw.close();
	}
}
