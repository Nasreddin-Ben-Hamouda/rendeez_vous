<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Liste Hopitals</title>

  <!-- Bootstrap CSS -->
  <link href="designadmin/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="designadmin/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="designadmin/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="designadmin/css/font-awesome.min.css" rel="stylesheet" />
  <!-- full calendar css-->
  <link href="designadmin/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <link href="designadmin/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="designadmin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <link rel="stylesheet" href="designadmin/css/owl.carousel.css" type="text/css">
  <link href="designadmin/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="designadmin/css/fullcalendar.css">
  <link href="designadmin/css/widgets.css" rel="stylesheet">
  <link href="designadmin/css/style.css" rel="stylesheet">
  <link href="designadmin/css/style-responsive.css" rel="stylesheet" />
  <link href="designadmin/css/xcharts.min.css" rel=" stylesheet">
  <link href="designadmin/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
  <!-- =======================================================
    Theme Name: NiceAdmin
    Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
<c:if test="${ empty sessionScope.email }">
            <% response.sendRedirect("/rendez_vous/login_admin"); %>  
      </c:if>
 <%@ include file="headeradmin.jsp" %>
  <!-- container section start -->
  <section id="container" class="">

    <!--header-- start-->
  
    <!--header end-->

    <!--sidebar--nav start-->
    <%@ include file="navadmin.jsp" %>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> Hopital</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-laptop"></i>Liste hopital</li>
            </ol>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
               Liste hopital
              </header>

              <table class="table table-striped table-advance table-hover">
                <tbody>
                  <tr>
                    <th><i class="fa fa-hospital-o"></i> Num Hopital</th>
                    <th><i class="fa fa-hospital-o"></i>Nom</th>
                    <th><i class="icon_pin_alt"></i> Region</th>
                    <th><i class="icon_pin_alt"></i> Adresse</th>
                    <th><i class="icon_profile"></i> Specialité</th>
                    
                  </tr> 
                  <c:forEach items="${hop}" var="hop1">
                  <tr>
                    <td><c:out value="${hop1.getNum_hopital()}"></c:out></td>
                    <td><c:out value="${hop1.getNom()}"></c:out></td>
                    <td><c:out value="${hop1.getRegion()}"></c:out></td>
                    <td><c:out value="${hop1.getAdresse()}"></c:out></td>
                    <td><c:out value="${hop1.getSpecialite()}"></c:out></td>
                    
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </section>
          </div>
        </div>

          

          

       
        <!--/.row-->


        
                <div class="widget-foot">
                  <!-- Footer goes here -->
                </div>
              </div>
            </div>

          </div>

        </div>
        <!-- project team & activity end -->

      </section>
      <div class="text-right">
        <div class="credits">
         
        </div>
      </div>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="designadmin/js/jquery.js"></script>
  <script src="designadmin/js/jquery-ui-1.10.4.min.js"></script>
  <script src="designadmin/js/jquery-1.8.3.min.js"></script>
  <script type="designadmin/text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="designadmin/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="designadmin/js/jquery.scrollTo.min.js"></script>
  <script src="designadmin/js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="designadmin/assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="designadmin/js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="designadmin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="designadmin/js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <script src="designadmin/js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="designadmin/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="designadmin/js/calendar-custom.js"></script>
    <script src="designadmin/js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="designadmin/js/jquery.customSelect.min.js"></script>
    <script src="designadmin/assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="designadmin/js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="designadmin/js/sparkline-chart.js"></script>
    <script src="designadmin/js/easy-pie-chart.js"></script>
    <script src="designadmin/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="designadmin/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="designadmin/js/xcharts.min.js"></script>
    <script src="designadmin/js/jquery.autosize.min.js"></script>
    <script src="designadmin/js/jquery.placeholder.min.js"></script>
    <script src="designadmin/js/gdp-data.js"></script>
    <script src="designadmin/js/morris.min.js"></script>
    <script src="designadmin/js/sparklines.js"></script>
    <script src="designadmin/js/charts.js"></script>
    <script src="designadmin/js/jquery.slimscroll.min.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>
<body>

</body>
</html>