<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
 <header class="header-area">
        <!-- Top Header Area -->
        <div class="top-header-area">
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-12 h-100">
                        <div class="h-100 d-md-flex justify-content-between align-items-center">
                            <p>Bienvenu sur <span>Medilife</span> Site Web </p>
                            <c:if test="${ empty sessionScope.emailpatient }">
                             <a href="/rendez_vous/inscription_patient"> <p> <span style="color:white;"><i class="fa fa-user-plus">Inscription</i></span></p></a>
                              <a href="/rendez_vous/connexion_patient"> <p> <span style="color:white;"><i class="fa fa-sign-in">Patient</i></span></p></a>
                              <a href="/rendez_vous/login_admin"> <p> <span style="color:white;"><i class="fa fa-sign-in">Secretere</i></span></p></a>
                              <a href="/rendez_vous/login_medcin" > <p>  <span style="color:white;"><i class="fa fa-sign-in " >Medecin</i></span></p></a>
                             </c:if>
                            <c:if test="${ !empty sessionScope.emailpatient }">
                             <a href=""> <p> <span style="color:white;"><i class="fa fa-user-circle"><% %>${sessionScope.emailpatient }</i></span></p></a>
                             <a href="/rendez_vous/deconnexion_patient"> <p> <span style="color:white;"><i class="fa fa-sign-out">Déconnexion</i></span></p></a>
                            </c:if>
                           
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Main Header Area -->
        <div class="main-header-area" id="stickyHeader">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 h-100">
                        <div class="main-menu h-100">
                            <nav class="navbar h-100 navbar-expand-lg">
                                <!-- Logo Area  -->
                                <a class="navbar-brand" href="/rendez_vous/bienvenu"><img src="img/core-img/logo.png" alt="Logo"></a>

                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#medilifeMenu" aria-controls="Mawiidi" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

                                <div class="collapse navbar-collapse" id="medilifeMenu">
                                    <!-- Menu Area -->
                                    <ul class="navbar-nav ml-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="/rendez_vous/bienvenu">Acceuil
                                             <span class="sr-only">(current)</span></a>
                                        </li>
                                        
                                        <li class="nav-item">
                                            <a class="nav-link" href="/rendez_vous/prendre_rendez_vous">Prendre un rendez-vous</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="/rendez_vous/gerer_rendez_vous">Gérer mes rendez-vous</a>
                                       <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Langue</a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                                <a class="dropdown-item" href="">Français</a>
                                                <a class="dropdown-item" href="">العربية</a>
                                               
                                            </div>
                                        </li>
                                    </ul>
                                    <!-- Appointment Button -->
                                   
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>