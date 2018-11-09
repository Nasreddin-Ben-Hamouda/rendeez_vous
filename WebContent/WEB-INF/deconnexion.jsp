<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<% 

HttpSession sess=request.getSession();
if(sess !=null){
	session.removeAttribute("emailpatient");
	session.invalidate();
	String pageToForward=request.getContextPath();
	response.sendRedirect("/rendez_vous/bienvenu");
}

%>