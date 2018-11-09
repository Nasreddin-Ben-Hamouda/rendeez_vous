<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>prendre rendez vous</title>
    
    <!-- Favicon  -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
      <link rel="icon" href="/img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" type="text/css" href=" NewFile.css">
  <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
         <script src="js/eventjs.js"></script>
</head>

<body onload="initMap()">
    <!-- Preloader -->
    <div id="preloader">
        <div class="medilife-load"></div>
    </div>

    <!-- ***** Header Area Start ***** -->
   <%@ include file="header.jsp" %>
    <!-- ***** section ***** -->

    <c:if test="${ empty sessionScope.emailpatient }">
            <% response.sendRedirect("/rendez_vous/connexion_patient"); %>  
      </c:if>

   <section class="breadcumb-area bg-img gradient-background-overlay" style="background-image: url(img/bg-img/breadcumb2.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-content">
                        <h3 class="breadcumb-title">Nouveau</h3>
                        <p>Reservez un rendez-vous</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Blog Area Start ***** -->
    <section class="medilife-tabs-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="medilife-tabs-content">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="institution-tab" data-toggle="tab" href="#institution" role="tab" aria-controls="institution" aria-selected="false">Rendez_vous</a>
                            </li>
                            
                            
                        </ul>

                        <div class="tab-content" id="myTabContent">
                       <!-- div etablissement -->
                            <div class="tab-pane fade show active" id="institution" role="tabpanel" aria-labelledby="institution-tab ">
                                <div class="medilife-tab-content d-md-flex align-items-center">
                                    <!-- Medilife Tab Text  -->
                                   
                                    <form   method="POST">
                                    
                                    
                                   
                                    
                                    
                                   <%
                                    String msg=(String)request.getAttribute("verifdate");
                                    if(msg!=null){
                                    
                                    
                                    
                                    %>
                                     <div class="alert alert-danger">
                                        <i class="icon-remove-sign"></i>
                                       <strong><% out.println(msg);%></strong> 
                                    </div>
                                    <% } %>
                                     
                                    <%
                                    String msg1=(String)request.getAttribute("msg");
                                    if(msg1!=null){
                                    
                                    
                                    
                                    %>
                                    	                                                   
                                  <div class="alert alert-danger">
                                        <i class="icon-remove-sign"></i>
                                       <strong><% out.println(msg1);%></strong> 
                                    </div>
                                    <% } %>
                                    	                                                   
                                 
                                     <h2>Où?<hr></h2><br>
                                     <c:if test="${ !empty sessionScope.emailpatient }">
                                     <input type="hidden" value="${sessionScope.emailpatient }" name="email">
                                     </c:if>
                                        <div class="row align-items-end">
                                        
                                        
                                            <div class="col-12 col-md-4">
                                                <div class="form-group">
                                                 
                                                    <select class="form-control" id="regio" name="reg" required>
                                                    <option value=""> Selectionnez Région:</option>
                                                    <option value="Bizerte">Bizerte</option>
                                                    <option value="al alia">El alia</option>
                                                    <option value="Manzel bourguiba">Manzel bourguiba</option>
                                                    <option value="Zarzouna">Zarzouna</option>
                                                    <option value="Manzel abed rahmen">Manzel abed rahmen</option>                                                  
                                                    <option value="Rass Rjbal">Rass Rjbal</option>
            	                                    <option value="Ghar el meleh">Ghar el meleh</option>
                                                    <option value="Manzel jemil">Manzel jemil</option>
                                                    
                                                </select>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-4">
                                                <div class="form-group">
                                                    <select class="form-control" id="myselect" onchange="service_change()"  name="serv" required>
                                                    <option value="">Choisir Le service medicale :</option>
                                                    <option value="Cardiologie">Cardiologie</option>
                                                    <option value="Ophtalmologie">Ophtalmologie</option>
                                                    <option value="Anatomie">Anatomie</option>
                                                    <option value="Neurologie">Neurologie</option>
                                                    <option value="Génétique">Génétique</option>
                                                    <option value="biochimie">biochimie</option>
                                                     <option value="hématologie">hématologie</option>
                                                   
                                                </select>
                                                </div>
                                            </div>
                                          
                                            <div class="col-12 col-md-4" id="load">
                                                 <div class="form-group">
                                                   <select class="form-control" id="jamais" name="hop" onchange="hopital_change()" required>
                                                  
                                                   </select>
                                                  </div>
                                           </div> 
                                            <h2>Medecin?<hr></h2><br>
                                             </div>
                                             <div class="row align-items-end">
                                            <div class="col-12 col-md-12">
                                                <div class="form-group">
                                                    <select class="form-control" id="medrend" name="med" required >
                                                    
                                                    
                                                   
                                                    </select>
                                                </div><br>
                                            </div>
                                          
                                            <h2>Qaund?<hr></h2><br>
                                     
                                        <div class="col-12 col-md-12">
                                                <div class="form-group">
                                                
                                                    <h6>Veuillez saisir la date souhaitée :</h6><br>
                                                    <input type="date"  class=" form-control border-top-0 border-right-0 border-left-0"  name="date" id="" placeholder="mm/dd/yyyy" required>
                                               
                                                </div>
                                                
                                            </div><br>
                                            <div class="col-12 col-md-12">
                                                <div class="form-group">
                                                
                                                    <h6>Veuillez saisir l'heure souhaitée :</h6><br>
                                                    <input type="time" name="time" placeholder="hrs:mins" pattern="^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$" class="inputs time form-control border-top-0 border-right-0 border-left-0" required>
                                               
                                                </div>
                                                
                                            <div class="col-12 col-md-5 mb-0">
                                                <div class="form-group mb-0">
                                                   <button type="submit"  class="btn medilife-btn btn btn-link">Enregistrer <span>+</span></button>
                                                </div><br><br>
                                               
                                            </div>
                                            
                                        </div>
                                        
                                        </div>
                                        
                                        <div id="map"></div>
                                    </form>
                                    
                                </div>
                            </div>
                            <!-- end div etablissement -->
                            <!-- start div choix -->
                           
                </div>
                </div>
            </div>
       
    </section>
    <!-- script -->
    <script type="text/javascript">
    /*function submitForm(){
		$("#load").load("/WEB-INF/select.jsp",{spec:$('#myselect').val()} ).fadeIn("slow");}*/
		
		function change(){
			
			alert('d5all');
		} 
		
		
		 function service_change()
		   {
					console.log('d5all on chnga');
		       var spec = $("#myselect").val();
		       var reg=$("#regio").val();
		        //console.log(spec);
		    
		       $.ajax({
		           type: "POST",
		           url: "/rendez_vous/select_hopital?specialite="+spec+"&regi="+reg,
		           contentType:"application/json",
		           //cache : false,
		           data: "specialite="+spec+"regi="+reg,
		           success: function(response)
		           {
		           	var select = $("#jamais");
		           	console.log(select);
		           	var dataArray = response;
		           	var elements ="<option value='0'>choisir un hopital</option>";
		           	for(var i=0;i<dataArray.length;i++) {
		           		//console.log(dataArray[i].nom);
		           		elements += " <option value="+dataArray[i].num_hopital+">"+dataArray[i].nom+"</option>";
		           		
		           	}
		           	$("#jamais").html(elements);
		           	
		       }
		       });
		       }
		
		
		
		
		
   function hopital_change()
    {
			console.log('d5all on chnga');
        var num = $("#jamais").val();
      
        console.log(num);
     
        $.ajax({
            type: "POST",
            url: "/rendez_vous/select_medcin?num_hop="+num,
            contentType:"application/json",
            //cache : false,
            data: "num_hop="+num,
            
            success: function(response)
            {
            	var select = $("#medrend");
            	console.log(select);
            	var data1 = response;
            	var element ="<option value='0'>choisir un medcin</option>";
            	for(var i=0;i<data1.length;i++) {
            		console.log(data1[i].nom);
            		element += "<option value="+data1[i].id_medcin+">"+data1[i].nom+" "+data1[i].prenom+"</option>";
            		
            	}
            	$("#medrend").html(element);
        }
        });
        }
  
	</script>
	
  
    
   
    
     <!-- ***** Book An Appoinment Area Start ***** -->
    
    <!-- ***** Book An Appoinment Area End ***** -->
    <!-- ***** Blog Area End ***** -->
    <!-- ***** Footer Area Start ***** -->
    <%@ include file="footer.jsp" %>
    <!-- ***** Footer Area End ***** -->
    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <!-- <script src="js/jquery/jquery-2.2.4.min.js"></script>-->
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