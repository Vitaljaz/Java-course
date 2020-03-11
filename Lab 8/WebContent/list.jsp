<%@ page import="java.util.List" %>
<%@ page import="main.User" %>
<%@ page import="main.UserDB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Users List</title>
		
		<style>
			body, html {   
    			width: 100%;
    			height: 100%;
    			margin: 0;
    			padding: 0;
    			display: table;
			}
			
			#header {
				padding: 10px;
				text-align: left;
				background: #AEAEAE;
				color: white;
				font-size: 12px;
			}

			h2 {
   				text-align: center;
			}
			
			h3 {
				text-align: center;
			}
			
			table {
				 border-collapse: collapse;
				 display: table;
				 margin: auto;
				 border-spacing: 10px;
    		     font-size: 18px;
    		     text-align: center;
    		     width: 50%;
			}

			table, th, td {
 				 border: 2px solid black;
			}
			
		</style>
	</head>
	<body>
		<div id = "header">
			<h1>Admin panel v 1.0</h1>
		</div>
		
		<h2>A list of users:</h2>
		<br>
		<%
			List<User> users = (List<User>) request.getAttribute("users");
			
			if (users != null && !users.isEmpty()) {
				out.println("<table><tbody>");
				out.println("<tr><td>username</td><td>password</td></tr>");
				for (User user : users) {
					out.println("<tr><td>" + user.getUsername() + "</td><td>" + user.getPassword() + "</td></tr>");
				}
				out.println("</tbody></table>");
			} else {
				out.println("<h3>0 users<h3>");
			}
		%>
		
	</body>
</html>