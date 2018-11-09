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

  <title>INDEX</title>

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
  <!-- container section start -->
  <section id="container" class="">

    <!--header-- start-->
   <%@ include file="headeradmin.jsp" %>
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
            <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-laptop"></i>Dashboard</li>
            </ol>
          </div>
        </div>

        

          

          

        </div>
        <!--/.row-->


        <div class="row">
          <div class="col-lg-9 col-md-12">

            <div class="panel panel-default">
              <div class="panel-heading">
                <h2><i class="fa fa-map-marker red"></i><strong>Countries</strong></h2>
                <div class="panel-actions">
                  <a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
                  <a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
                  <a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
                </div>
              </div>
              <div class="panel-body-map">
                <div id="map" style="height:380px;"></div>
              </div>

            </div>
          </div>
          


        </div>


        <!-- Today status end -->



        
        <div class="row">
          <div class="col-md-6 portlets">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h2><strong>Calendar</strong></h2>
                <div class="panel-actions">
                  <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
                  <a href="#" class="wclose"><i class="fa fa-times"></i></a>
                </div>

              </div><br><br><br>
              <div class="panel-body">
                <!-- Widget content -->

                <!-- Below line produces calendar. I am using FullCalendar plugin. -->
                <div id="calendar"></div>

              </div>
            </div>

          </div>

          <div class="col-md-6 portlets">
            <div class="panel panel-default">
              <div class="panel-heading">
                <div class="pull-left">Quick Post</div>
                <div class="widget-icons pull-right">
                  <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
                  <a href="#" class="wclose"><i class="fa fa-times"></i></a>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="panel-body">
                <div class="padd">

                  <div class="form quick-post">
                    <!-- Edit profile form (not working)-->
                    <form class="form-horizontal">
                      <!-- Title -->
                      <div class="form-group">
                        <label class="control-label col-lg-2" for="title">Title</label>
                        <div class="col-lg-10">
                          <input type="text" class="form-control" id="title">
                        </div>
                      </div>
                      <!-- Content -->
                      <div class="form-group">
                        <label class="control-label col-lg-2" for="content">Content</label>
                        <div class="col-lg-10">
                          <textarea class="form-control" id="content"></textarea>
                        </div>
                      </div>
                      <!-- Cateogry -->
                      <div class="form-group">
                        <label class="control-label col-lg-2">Category</label>
                        <div class="col-lg-10">
                          <select class="form-control">
                                                  <option value="">- Choose Cateogry -</option>
                                                  <option value="1">General</option>
                                                  <option value="2">News</option>
                                                  <option value="3">Media</option>
                                                  <option value="4">Funny</option>
                                                </select>
                        </div>
                      </div>
                      <!-- Tags -->
                      <div class="form-group">
                        <label class="control-label col-lg-2" for="tags">Tags</label>
                        <div class="col-lg-10">
                          <input type="text" class="form-control" id="tags">
                        </div>
                      </div>

                      <!-- Buttons -->
                      <div class="form-group">
                        <!-- Buttons -->
                        <div class="col-lg-offset-2 col-lg-9">
                          <button type="submit" class="btn btn-primary">Publish</button>
                          <button type="submit" class="btn btn-danger">Save Draft</button>
                          <button type="reset" class="btn btn-default">Reset</button>
                        </div>
                      </div>
                    </form>
                  </div>


                </div>
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
          <!--
            All the links in the footer should remain intact.
            You can delete the links only if you purchased the pro version.
            Licensing information: https://bootstrapmade.com/license/
            Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin
          -->
          <a href="https://bootstrapmade.com/">Free Bootstrap Templates</a> by <a href="https://bootstrapmade.com/">BootstrapMade</a>
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