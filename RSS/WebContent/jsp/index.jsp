<!DOCTYPE html>
<html lang="en">
<head>
<title>Home - Home Page | Aberdeen Events</title>
<meta charset="utf-8">
<meta name="description" content="Place your description here">
<meta name="keywords" content="put, your, keyword, here">
<meta name="author" content="cssMoban.com - website templates provider">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.8.2.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/serviceHelper.js"></script>
</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
   <header>
      <div class="container">
         <h1><a href="index.html">Aberdeen Events</a></h1>
         <nav>
            <ul>
               <li class="current"><a href="index.html" class="m1">Home Page</a></li>
               <li><a href="Events.html" class="m2">Events</a></li>
               <li><a href="Maps.html" class="m3">Maps</a></li>
               <li><a href="contact-us.html" class="m4">Contact Us</a></li>
               <li class="last"><a href="sitemap.html" class="m5">Site Map</a></li>
            </ul>
         </nav>
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
            <li><span><a href="#">Events</a></span></li>
            <li><span><a href="#">Map</a></span></li>
            <li><span><a href="#">Bus time</a></span></li>           
            <li><span><a href="#">Contact us</a></span></li>            
         </ul>
         <h2>Fresh <span>News</span></h2>
         <ul class="news">
            <li><strong>October, 30, 2012</strong>
               <h4><a href="#">lecture 1</a></h4>
               aaaaaaa. </li>
            <li><strong>October 14, 2012</strong>
               <h4><a href="#">lecture 2</a></h4>
               bbbbbbbbbbbbbbbbbbbbbb. </li>
            <li><strong>September, 29, 2012</strong>
               <h4><a href="#">lecture 3</a></h4>
               ccccccccccccccccccccc. </li>
         </ul>
      </aside>
      <!-- content -->
      <section id="content">
         <div id="banner">
            <h2>Location <span>bus <span>2012</span></span></h2>
         </div><div class="inner_copy">More <a href="http://www.aberdeen.ac.uk">aberdeen</a> </div>
         <div class="inside">
            <h2>Recent <span>Events</span></h2>
            <ul class="list">
               <li><span><img src="images/icon1.png"></span>
                  <h4>event news</h4>
                  <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
               </li>
               <li><span><img src="images/icon2.png"></span>
                  <h4>some features</h4>
                  <p>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
               </li>
               <li class="last"><span><img src="images/icon3.png"></span>
                  <h4>Bus time</h4>
                  <p>cccccccccccccccccccccccccccccccccccccccccccccccccccccc</p>
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
<!-- footer -->
<footer>
   <div class="container">
      <div class="inside">
         <div class="wrapper">
            
            <div class="aligncenter"><a href="https://bitbucket.org/samjiks/cloudrepo" class="new_window">Team</a> from University of Aberdeen<br>
               <a href="http://www.aberdeen.ac.uk" class="new_window">aberdeen.ac.uk</a> </div>
         </div>
      </div>
   </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
<script type="text/javascript">    
window.onload=function()
{
  var aResp = getAllFeedItems(); 
  aResp.success(function (data) {
  var aAllItems = data;
   });
};
</script>

</body>
</html>
