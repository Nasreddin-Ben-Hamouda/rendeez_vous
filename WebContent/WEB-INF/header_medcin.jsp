<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page import=" java.sql.ResultSet" %>
     <%@page import=" metier_model.metierRDV" %>
     <%@page import=" metier_model.metieradmin" %>
      <%@page import="java.sql.SQLException" %>
      <%@page import="javax.servlet.http.HttpSession" %>
    
 <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="/rendez_vous/index_admin" class="logo">Mawiidi <span class="lite">Medecin</span></a>
      <!--logo end-->

      <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
         
        </ul>
        <!--  search form end -->
      </div>

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">

          <!-- task notificatoin start -->
          
          <!-- task notificatoin end -->
          <!-- inbox notificatoin start-->
          <li id="mail_notificatoin_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="icon-envelope-l"></i>
                            <span class="badge bg-important">5</span>
                        </a>
            <ul class="dropdown-menu extended inbox">
              
              <li>
                <p class="blue">You have 5 new messages</p>
              </li>
              <li>
                <a href="#">
                                    <span class="photo"><img alt="avatar" src="designadmin/./img/avatar-mini.jpg"></span>
                                    
                                    <span class="from">Greg  Martin</span>
                                    <span class="time">1 min</span>

                                    <span class="message">
                                        I really like this admin panel.
                                    </span>
                                </a>
              </li>
              
              
              <li>
                <a href="#">See all messages</a>
              </li>
            </ul>
          </li>
          <!-- inbox notificatoin end -->
          <!-- alert notification start-->
          <li id="alert_notificatoin_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                 
                            <i class="icon-bell-l"></i>
                            <span class="badge bg-important">7</span>
                        </a>
            <ul class="dropdown-menu extended notification">
              <div class="notify-arrow notify-arrow-blue"></div>
              <li>
                <p class="blue">You have 4 new notifications</p>
              </li>
               
		      <%// <c:forEach items="${noti }" var="notif">%>
	
              <li>
                <a href="">
                                    <span class="label label-primary"><i class="icon_profile"></i></span>
                                    Rendez_vous Numéro:de la patient Numéro : de date et l'heure:  
                                    
                             </a>   
              </li>
            
             
             
              
              <li>
                <a href="/rendez_vous/liste_RDV">Voir tout les rendez_vous</a>
              </li>
            </ul>
          </li>
          <!-- alert notification end-->
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                              <img alt="" src="img/images.jpg" style="width:40px" >
                            </span>
                            <c:if test="${!empty sessionScope.emailmedcin }">
                            <span class="username"><% %>${ sessionScope.emailmedcin }</span></c:if>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li class="eborder-top">
                <a href="#"><i class="icon_profile"></i> My Profile</a>
              </li>
              <li>
                <a href="#"><i class="icon_mail_alt"></i> My Inbox</a>
              </li>
              
              <li>
                <a href="/rendez_vous/logout"><i class="icon_key_alt"></i> Log Out</a>
              </li>
              
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>