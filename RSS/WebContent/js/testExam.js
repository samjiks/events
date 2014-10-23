      var marker;
	  var geocoder;
      var map;
      function initialize() {
        geocoder = new google.maps.Geocoder();
        var latlng = new google.maps.LatLng(57, -2);
        var mapOptions = {
          zoom: 8,
          center: latlng,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
      
        
      }

      
      function codeAddress() 
      { 
        var address = document.getElementById('address').value;
        geocoder.geocode( { 'address': address}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) 
          {
            map.setCenter(results[0].geometry.location);
            	marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location,
                title: address
                
            });
            infowindow = new google.maps.InfoWindow({
            	 content: address
            });
            infowindow.open(map, marker);
    
           // google.maps.event.addListener(marker, "", function() {
               // infowindow.open(map, marker);
              //});
     
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
        infowindow.close();
       
      }
      