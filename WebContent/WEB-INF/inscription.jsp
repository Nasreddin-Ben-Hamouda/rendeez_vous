<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Inscription</title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <!-- =======================================================
      Theme Name: NiceAdmin
      Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
      Author: BootstrapMade
      Author URL: https://bootstrapmade.com
    ======================================================= -->
 </head>

<style type="text/css">
    .login-form {

    max-width: 500px;

    margin: 90px auto 0;

    background: #d5d7de;    

}


  </style>
 
<body style="background-image: url(img/bg-img/hero1.jpg);">

  <div class="container">
 
    <form class="login-form form-validate "  method="POST">
      <div class="login-wrap">   
        <p class="login-img"><i class="icon_lock_alt"></i></p>
         <div class="input-group">
          
        
         <input class="form-control" id="cname" name="nom" minlength="4" type="text"placeholder="Votre Nom" required />
        
        </div>
         <div class="input-group">
          
          <input type="text" class="form-control" name="prenom" placeholder="Votre Prenom" minlength="4" required autofocus/>
        </div>
        <div class="input-group">
          
          <input type="email" class="form-control" name="email" placeholder="Email"  autofocus/>
        </div>
        <div class="input-group">
          
          <input type="text" class="form-control" name="sexe" placeholder="Votre Sexe" minlength="5" required autofocus/>
        </div>
        <div class="input-group">
        
          <input type="date" class="form-control" name="date_naiss" placeholder="date naissance">
        </div>
         
         <div class="input-group">
          
          <input type="text" class="form-control" name="region" placeholder="Votre Region" minlength="4" required autofocus/>
        </div>
         <div class="input-group">
          
          <input type="text" class="form-control" name="num_tel" placeholder="Votre Numéro du téléphone" minlength="8" required autofocus/>
        </div>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Enregistrer</button>
       
      </div>
    </form>
    
  </div>
  </body>
</html>