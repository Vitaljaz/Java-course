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


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("delete.jsp");
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		UserDB db = UserDB.getInstance();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<style> h2 { text-align: center; padding-top: 20%; } </style>");
		
		if (!db.findUser(new User(username, "0"))) {
			pw.println("<h2>ERROR! " + username + " user not found</h2>");
			pw.close();
			return;
		}
		
		List<User> users = db.getList();
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				users.remove(i);
				pw.println("<h2>Successfully!</h2>");
				pw.close();
				return;
			}
		}
	}
}
