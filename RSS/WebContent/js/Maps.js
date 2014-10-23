var geocoder;
var map;
var directionsDisplay = new google.maps.DirectionsRenderer();
var directionsService = new google.maps.DirectionsService();
var latlang;
var infowindow;
var eventMarker;
var userMarker;
var aberdeen = new google.maps.LatLng(57.1497171, -2.094278);

function initialize(){
	$(window).resize(function() {
		var h = $(window).height(), offsetTop = 50;
		$('#map_canvas').css('height', (h-offsetTop));
	}).resize();
	directionsDisplay = new google.maps.DirectionsRenderer();
	geocoder = new google.maps.Geocoder();
	var mapOptions = {
			zoom: 15,
			center: aberdeen,
			mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById('panel'));
	var transitLayer = new google.maps.TransitLayer();
	transitLayer.setMap(map);

	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(function(position){
			var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
			infowindow = new google.maps.InfoWindow({
				map: map,
				position: pos,
				content: "Location estimated by HTML5 - Please drag marker if is not correct."
			});
			latlang = geocoder.geocode({'location': pos}, function(results, status){
				if(status == google.maps.GeocoderStatus.OK){
					$("#from").append(""+results[0].formatted_address+"");
				}else{
					alert('The Address failed to be located: ' + status);
				}
			});

			userMarker = new google.maps.Marker({
				map: map,
				position: pos,
				draggable: true,
				title: "User Defined Location",
				animation: google.maps.Animation.DROP
			});
			
			google.maps.event.addListener(userMarker, "dragend", pushAddresstoPage);
			map.setCenter(pos);
		}, function(){
			handleNoGeolocation(true);
		});
	}else{
		handleNoGeolocation(false);
	}
	google.maps.event.addListener(infowindow, "changed", setTimeout(function(){infowindow.close();}, '2000'));
}

function handleNoGeolocation(errorFlag){
	var content;
	if(errorFlag){
		content = "Error: No Geolocation. Please input your address into the search-bar provided";
	}else{
		content =  "Error: Your browser doesn't support Geolocation. Please input your address into the search-bar provided";
	}

	var options = {
			map: map,
			position: aberdeen,
			content: content
	};

	infowindow = new google.maps.InfoWindow(options);
	google.maps.event.addListener(infowindow, "changed", setTimeout(function(){infowindow.close();}, '2000'));
	map.setCenter(aberdeen);
}

function getUnixTime(dt){
	var cdate=dt.split(" ");
	var date=cdate[0].split("-");
	var time=cdate[1].split(":");
	//var time="21:00";
	date[1] = String(parseInt(date[1])-1);
	for(var x=0;time.length<x;x++){
		if(time[x].charAt(0)=="0"){
			time[x] = time[x].charAt(1);
		}
	}
	var unixTime=new Date(date[0],date[1],date[2],time[0],time[1],0,0);
	return unixTime;
}

function transitDirections(date){

	var start = userMarker.getPosition();//get start from user
	var end = eventMarker.getPosition(); //get end from event	
	var request ={
			origin: start,
			destination: end,
			travelMode: google.maps.DirectionsTravelMode.TRANSIT,
			transitOptions:{
				arrivalTime: getUnixTime(date)
			}//,
	//optimizeWaypoints: true
	};

	directionsService.route(request, function(reply, status){
		if(status == google.maps.DirectionsStatus.OK){
			directionsDisplay.setDirections(reply);
		}	
	});
}

function showBusID(directionResult){
	var transit = directionResult.routes[0].legs[0].steps[0].transit.line.name;
	alert(transit);
	return transit;
}

function geoCode(address, user){
	if(eventMarker)
	{
	  eventMarker.setMap(null);
	}
	if(address.toLowerCase().indexOf("aberdeen") == -1){
		address = address + ', Aberdeen';
	}
	if(eventMarker && user==false){
		eventMarker.setMap(null);
	}

	latlang = geocoder.geocode({'address': address}, function(results, status){
		if(status == google.maps.GeocoderStatus.OK){
			if(user){
				userMarker = new google.maps.Marker({
					map:map,
					position: results[0].geometry.location,
					title: "User Defined Location",
					animation: google.maps.Animation.DROP,
					draggable: true
				});
				google.maps.event.addListener(userMarker, "dragend", pushAddresstoPage);
			}else{
				eventMarker = new google.maps.Marker({
					map: map,
					position: results[0].geometry.location,
					title: address,
					animation: google.maps.Animation.DROP
				});
			}
		}else{
			alert('The Address failed to be located: ' + status);
		}
	});
}


function pushAddresstoPage(){
	$("#from").empty();
	latlang = geocoder.geocode({'location': userMarker.position}, function(results, status){
		if(status == google.maps.GeocoderStatus.OK){
			$("#from").append(""+results[0].formatted_address+"");
		}else{
			alert('The Address failed to be located: ' + status);
		}
	});
}

google.maps.event.addDomListener(window, 'load', initialize);

function codeAddress(){ 
	if(userMarker){
		userMarker.setMap(null);
		$("#from").empty();
	}

	if(infowindow){
		infowindow.setMap(null);
	}

	var address = document.getElementById('address').value;
	if(address.toLowerCase().indexOf("aberdeen") == -1){
		address = address + ', Aberdeen';
	}

	geocoder.geocode( { 'address': address}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK){
			map.setCenter(results[0].geometry.location);
			userMarker = new google.maps.Marker({
				map: map,
				position: results[0].geometry.location,
				title: "User Defined Location",
				animation: google.maps.Animation.DROP
			});
			$("#from").append(""+results[0].formatted_address+"");
			google.maps.event.addListener(userMarker, "dragend", pushAddresstoPage);
			infowindow = new google.maps.InfoWindow({
				content: results[0].formatted_address
			});
			infowindow.open(map, userMarker);
			google.maps.event.addListener(infowindow, "changed", setTimeout(function(){infowindow.close();}, '2000'));
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}
