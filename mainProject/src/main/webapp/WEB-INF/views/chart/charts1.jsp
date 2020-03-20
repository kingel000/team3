<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ela Admin - HTML5 Admin Template</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">

    <link rel="stylesheet" href="<c:url value="/resources/assets/css/cs-skin-elastic.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/style.css"/>">
    <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">
</head>
<script type="text/javascript">
	var nomalMemberCount = '${nomalMemberCount}';
	var expertMemberCount = '${expertMemberCount}';
	
	var category_totalSales1 = '${category_totalSales1}';
	var category_totalSales2 = '${category_totalSales2}';
	var category_totalSales3 = '${category_totalSales3}';
	var category_totalSales4 = '${category_totalSales4}';
	var category_totalSales5 = '${category_totalSales5}';
	
	var M1 = '${M1}'; var M2 = '${M2}'; var M3 = '${M3}'; var M4 = '${M4}'; var M5 = '${M5}';
	var M6 = '${M6}'; var M7 = '${M7}'; var M8 = '${M8}'; var M9 = '${M9}'; var M10 = '${M10}';
	var M11 = '${M11}'; var M12 = '${M12}';
</script>
<body>
     <!-- Left Panel -->
    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="chartMain.mdo"><i class="menu-icon fa fa-laptop"></i> 간단 통계 보기 </a>
                    </li>
                    <li class="menu-title">Table</li><!-- /.menu-title -->
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>tables</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="tables1.mdo">매출 Table</a></li>
                            <li><i class="fa fa-table"></i><a href="tables2.mdo">회원 Table</a></li>
                        </ul>
                    </li>
                    

                    <li class="menu-title">Chart</li><!-- /.menu-title -->

                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Charts</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="charts1.mdo">Chart</a></li>
                        </ul>
                    </li>

                    
                    
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>
    <!-- /#left-panel -->
    <!-- Right Panel -->
    <div id="right-panel" class="right-panel">
        
        <!-- Breadcrumbs-->
        <div class="breadcrumbs">
            <div class="breadcrumbs-inner">
                <div class="row m-0">
                    <div class="col-sm-4">
                        <div class="page-header float-left">
                            <div class="page-title">
                                <h1>All Chart</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="page-header float-right">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.breadcrumbs-->
        <!-- Content -->
        <div class="content">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-body">
                                	월별 매출 통계 
                                <select name="year">
					               <option value="" selected disabled hidden>=연도 선택=</option>
					               <option value="2020" selected="selected">${year }</option>
					            </select>
                                <canvas id="sales-chart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->

                    <div class="col-lg-6" hidden="hidden">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">Team Commits </h4>
                                <canvas id="team-chart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->

                    <div class="col-lg-6" hidden="hidden">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">Bar chart </h4>
                                <canvas id="barChart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->

                    <div class="col-lg-6" hidden="hidden">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">Rader chart </h4>
                                <canvas id="radarChart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->

                    <div class="col-lg-6" hidden="hidden">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">Line Chart </h4>
                                <canvas id="lineChart"></canvas>
                            </div>
                        </div>

                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="mb-3">Doughut Chart </h4>
                                    <canvas id="doughutChart"></canvas>
                                </div>
                            </div>
                        </div><!-- /# column -->

                    </div><!-- /# column -->


                    <div class="col-lg-6" hidden="hidden">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">Polar Chart </h4>
                                <canvas id="polarChart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">카테고리별 매출 통계</h4>
                                <canvas id="singelBarChart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->
                    
                    <br>
                    
                    <div class="col-lg-6" >
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mb-3">회원 통계</h4>
                                <canvas id="pieChart"></canvas>
                            </div>
                        </div>
                    </div><!-- /# column -->



                </div>

            </div><!-- .animated -->
        </div>
        <!-- /.content -->
        <div class="clearfix"></div>
        <!-- Footer -->
        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row">
                    <div class="col-sm-6">
                        Copyright &copy; 2018 Ela Admin
                    </div>
                    <div class="col-sm-6 text-right">
                        Designed by <a href="https://colorlib.com">Colorlib</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- /.site-footer -->
    </div>
    <!-- /#right-panel -->

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
    <script src="<c:url value="/resources/assets/js/main.js"/>"></script>
    <!--  Chart js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>
    <script src="<c:url value="/resources/assets/js/init/chartjs-init.js"/>"></script>
    <!--Flot Chart-->
    <script src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>
</body>
</html>
