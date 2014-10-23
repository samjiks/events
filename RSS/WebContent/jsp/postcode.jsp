<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="../RSS/js/Maps.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body onload="initialize()">
	<div>
		<input id="address" type="text" value=""> <input
			type="button" value="Geocode" onclick="codeAddress()">
	</div>
	<div id="map_canvas" style="height: 50%; width: 50%"></div>
</body>
</html>