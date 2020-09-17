<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="guest.*"%>
 
<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>
 
    <body>

        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <a href="${pageContext.request.contextPath}/hello.html">Click Here for HelloController</a>
	</body>
</html>