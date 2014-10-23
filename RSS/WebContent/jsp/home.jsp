<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.events.rss.RSSFeed, com.events.rss.RSSItem, com.events.time.PseudoTime;"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home - Home Page | Aberdeen Events</title>
<meta name="description" content="Place your description here">
<meta name="keywords" content="put, your, keyword, here">
<meta name="author" content="cssMoban.com - website templates provider">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBUL_UsYS3SDzBp43RZL2Rmx5NmNuJh6O0&sensor=true"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!--<script type="text/javascript" src="js/test.js"></script>-->
<script type="text/javascript" src="js/Maps.js"></script>
</head>
<body id="page1" onload="initialize()">
<div class="wrap">
	<header>
      <div class="container">
         <h1><a href="index.html">Aberdeen Events</a></h1>
         <form action="" id="search-form">
            <fieldset>
            <div class="rowElem">
               <input type="text">
               <a href="#" onClick="document.getElementById('search-form').submit()">Search</a></div>
            </fieldset>
         </form>
      </div>
   	</header>
   <div class="container">
      <!-- aside -->
    <aside>
         <h3>Categories</h3>
         <ul class="categories">
            <li><span><a href="#">Map</a></span></li>
            <li><span><a href="#">Bus time</a></span></li>           
            <li><span><a href="#">Contact us</a></span></li>            
         </ul>
         <h2>Direction List</h2> 
         <div id="panel"></div>
				<form action="#" onsubmit="geoCode('Union Square, Aberdeen'); return false;" id="routeForm">
					<button type="submit" class="btn btn-large btn-block btn-primary">Get Directions</button>
				</form>		     
   </aside>   
      <!-- content -->
      	<section id="content">
         <div id="map_canvas"></div>
         <div class="inner_copy">More <a href="http://www.aberdeen.ac.uk">aberdeen</a> </div>
         <div class="inside">
            <h2>Recent <span>Events</span></h2>
            <ul class="list">
               <li><span><img src="images/icon1.png"></span>
                  <h4>event news</h4>
                  <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
               </li>
               <li><span><img src="images/icon2.png"></span>
                  <h4>some features</h4>
                  <p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
               </li>
               <li class="last"><span><img src="images/icon3.png"></span>
                  <h4>Bus time</h4>
                  <p>ccccccccccccccccccccccccccccccccccccccccccccccccccccc</p>
               </li>
            </ul>
            <h2>Free to<span>find your way</span></h2>
            <p><span class="txt1">Aberdeen Events</span>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>
            <div class="img-box"><img src="images/1page-img.jpg">zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz</div>
            <p class="p0">pages: <a href="index.html">Home</a>, <a href="about-us.html">About us</a>, <a href="articles.html">Events</a> (with Events page), <a href="contact-us.html">Contact us</a>  <a href="sitemap.html">Site Map</a>.</p>
         </div>
      </section>
   </div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>