var map;

// funcao que inicaliza o mapa
function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(-19.96199, -44.201138),
		zoom : 15,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

// Inicializa o mapa
google.maps.event.addDomListener(window, "load", initialize);

// Carrega as lixeiras no mapa
function carregarMarkers() {

	$.getJSON('js/markers.json', function(pontos) {

		$.each(pontos, function(index, ponto) {

			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(ponto.Latitude,
						ponto.Longitude),
				title : "Meu ponto personalizado! :-D",
				map : map,
				icon : "imagens/lixeira.jpg"
			});

			var infowindow = new google.maps.InfoWindow(), marker;

			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent("Conteúdo do marcador.");
							infowindow.open(map, marker);
						}
					})(marker));

		});

	});

}

carregarMarkers();