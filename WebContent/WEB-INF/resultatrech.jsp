<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <% String hint=""; %>
 <c:if test="${nom !=''}">
  <c:if test="${ hint ==''}">
     <c:forEach items="${adminArray}" var="admin">
                  
              ${hint ="<tr >
                  
                    <td >${admin.getNom()}</td>
                    <td>${admin.getPrenom()}</td>
                    <td>${admin.getDate_naiss()}</td>
                    <td>${admin.getEmail()}</td>
                    <td>${admin.getRegion()}</td>
                    <td>${admin.getNum_hopital()}</td>
                    <td>${admin.getNum_tel()}</td>
                   
                    <td>
                    <form method="POST">
                      <div class="btn-group" >
                      <input type="hidden" value="${admin.getId_admin()}" name="id_admin"/>
                       <a  href="/rendez_vous/modif_admin?id=${admin.getId_admin()}" class="btn btn-primary" name="update" ><i class="icon_plus_alt2"></i></a>
                        <button class="btn btn-danger" type="submit" name="de" id="del" ><i class="icon_close_alt2"></i></button>
                      </div>
                      </form>
                    </td>
                  </tr> ';}
                  </c:forEach></c:if></c:if> 