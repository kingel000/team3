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
    
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/lib/datatable/dataTables.bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/cs-skin-elastic.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/style.css"/>">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

	 
</head>
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

       

        <div class="breadcrumbs">
            
        </div>

        <div class="content">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">매출 Table</strong>
                            </div>
                            <div class="card-body">
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>상품번호</th> 
                                            <th>상품명</th>
                                            <th>결제 날짜</th> 
                                            <th>상태</th> 
                                            <th>판매자</th>
                                            <th>구매자</th> 
                                            <th>금액</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	 <c:forEach var="purchase" items="${T1purchase}" varStatus="status">
	                                        <tr>
	                                            <td>${purchase.product_num}</td>
	                                            <td>${productTitleList.get(status.index)}</td>
	                                            <td>${purchase.purchase_date}</td>
	                                            <td>${purchase.purchase_state}</td>
	                                            <td>${purchase.expert_id}</td>
	                               	            <td>${purchase.member_id}</td>
	                                            <td>${purchase.purchase_price}</td>
	                                        </tr>
	                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->


        <div class="clearfix"></div>

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

    </div><!-- /#right-panel -->

    <!-- Right Panel -->
	 <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
	<script src="<c:url value="/resources/assets/js/main.js"/>"></script>

    
    <script src="<c:url value="/resources/assets/js/lib/data-table/datatables.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/dataTables.buttons.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/buttons.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/jszip.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/vfs_fonts.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/buttons.html5.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/buttons.print.min.js"/>"></script>
    <script src="<c:url value="/resources/assets/js/lib/data-table/buttons.colVis.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/init/datatables-init.js"/>"></script>

    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
      } );
  </script>
  


</body>
</html>
