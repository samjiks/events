<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>Geocoding UK Postcodes with Google APIs Demo</title>
	<link rel="stylesheet" href="styles.css" type="text/css" />
	<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA0jNoc89uwkdl4LgfM9KldRRiKve6JGS7u_Ryr84nOMdV8_I6oxT2bBrU1PUkF3dX7EBzDf0LW8QFBw" type="text/javascript"></script>
	<script src="http://www.google.com/uds/api?file=uds.js&amp;v=1.0&amp;key=ABQIAAAA0jNoc89uwkdl4LgfM9KldRRiKve6JGS7u_Ryr84nOMdV8_I6oxT2bBrU1PUkF3dX7EBzDf0LW8QFBw" type="text/javascript"></script>
	<script src="js/gmap.js" type="text/javascript"></script>
		<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-24776145-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
	<p>If you want to know how this works, please see the <a href="http://www.tomanthony.co.uk/blog/geocoding-uk-postcodes-with-google-map-api/">tutorial</a>.</p>
	
	Postcode: <input type="text" id="postcode" size="10" />
	<input type="submit" value="Place Marker" onclick="javascript:usePointFromPostcode(document.getElementById('postcode').value, placeMarkerAtPoint)" />
	<input type="submit" value="Center Map" onclick="javascript:usePointFromPostcode(document.getElementById('postcode').value, setCenterToPoint)" />
	<input type="submit" value="Show Lat/Lng" onclick="javascript:usePointFromPostcode(document.getElementById('postcode').value, showPointLatLng)" />
	
	<div id="map">
	</div>
	
	
</body>
</html>