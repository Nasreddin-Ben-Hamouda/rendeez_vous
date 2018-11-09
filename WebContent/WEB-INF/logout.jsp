<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

HttpSession sess=request.getSession();
if(sess !=null){
	session.removeAttribute("email");
	session.invalidate();
	String pageToForward=request.getContextPath();
	response.sendRedirect("/rendez_vous/bienvenu");
}






%>