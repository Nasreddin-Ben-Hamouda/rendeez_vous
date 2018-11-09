
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@page import=" java.sql.ResultSet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>gérer rendez vous </title>
 
    <!-- Favicon  -->
    <link rel="icon" href="/img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" type="text/css" href=" NewFile.css">

</head>

<body>
 
 <c:if test="${ empty sessionScope.emailpatient }">
            <% response.sendRedirect("/rendez_vous/connexion_patient"); %>  
      </c:if>

    <!-- Preloader -->
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>

    <!-- ***** Header Area Start ***** -->
   <%@ include file="header.jsp" %>
    <!-- ***** section ***** -->

    

<section class="breadcumb-area bg-img gradient-background-overlay" style="background-image: url(img/bg-img/breadcumb3.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-content">
                    <form action="" method="GET">
                    <c:if test="${ !empty sessionScope.emailpatient }">
                                     <input type="hidden" value="${sessionScope.emailpatient }" name="email">
                                     </c:if>
                    </form>                 
                        <h3 class="breadcumb-title"><% %>${sessionScope.emailpatient }</h3>
                        <h5>Votre liste rendez_vous</h5>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Breadcumb Area End ***** -->

    <section class="medilife-contact-area section-padding-100">
        <div class="container">
            <div class="row">
                <!-- Contact Form Area -->
                <table class="table table-striped table-advance table-hover">
                <thead>
                  <tr>
                 
                    <th><i class="icon_mobile"></i> Num Rendez_vous</th>
                    <th><i class="icon_profile"></i> Hopitale </th>
                    <th><i class="icon_profile"></i>  Medcin</th>
                    <th><i class="icon_calendar"></i> Date </th>
                    <th><i class="icon_mail_alt"></i> Heure </th>
                    <th><i class="icon_pin_alt"></i> Lieu</th>
                    <th><i class="icon_pin_alt"></i> Etat</th>
                    <th><i class="icon_mobile"></i> Affectation</th>
                    
                    <th><i class="icon_cogs"></i> Annuller</th>
                  </tr>
                  </thead>
                 <tbody id="tab1">
                
              <%  
              ResultSet rend1=(ResultSet)request.getAttribute("rend");
              while(rend1.next()) {
			
			%> 
               
                  <tr >
                  
                   <td ><c:out value="<%= rend1.getInt(1) %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(2) %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(3)%>"></c:out><c:out value=" "></c:out><c:out value="<%= rend1.getString(4)%>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(5)  %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(6) %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(8) %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(9) %>"></c:out></td>
                    <td><c:out value="<%= rend1.getString(7) %>"></c:out></td>
                   
                    <td>
                    <form method="POST">
                
                      <div class="btn-group" >
                      <input type="hidden" value="<%= rend1.getInt(1) %>" name="num_rdv"/>
                       
                        <button class="btn btn-danger" type="submit"  name="de" id="del" ><i class="icon_close_alt2"></i></button>
                      </div>
                      </form>
                    </td>
                  </tr>
            <%} %>
                  
                </tbody>
                <tbody id="txtHint">
                </tbody>
              </table>

                <div class="col-12 col-lg-4">
                    <div class="content-sidebar">


                        <!-- Contact Card -->
                       
                        

                        <!-- medilife Emergency Card -->
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
     
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Footer Area Start ***** -->
    <%@ include file="footer.jsp" %>
    <!-- ***** Footer Area End ***** -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>

</body>
</html>