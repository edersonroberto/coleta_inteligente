var map;
var pos;

function inicializaMapa(lat, lng){
	//pos = new google.maps.LatLng(-19.96199, -44.201138);
	//pos = new google.maps.LatLng(lat, lng);
	
}
// funcao que inicaliza o mapa
function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(-19.96199, -44.201138),
		zoom : 15,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

// Adiciona o marcador
function addMarker(lat, lng) {
	var pos = new google.maps.LatLng(lat, lng);
  	var marker = new google.maps.Marker({
	    position: pos,
	    icon: 'imagens/lixeira_vazia.jpg',
	    draggable: true,
	    map: map
	});
  	
  	google.maps.event.addListener(marker, 'click', function() {
	    var icon = marker.getIcon();
	    if (icon == "imagens/lixeira_cheia.jpg")
	    	marker.setIcon("imagens/lixeira_vazia.jpg");
	    else
	    	marker.setIcon("imagens/lixeira_cheia.jpg");                                    
    });
}

// Inicializa o mapa
google.maps.event.addDomListener(window, "load", initialize);
