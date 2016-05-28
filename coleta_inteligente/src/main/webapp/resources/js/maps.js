var map;

// Esta função vai percorrer a informação contida na variável markersData
// e cria os marcadores através da função createMarker
function displayMarkers(markers) {

	// esta variável vai definir a área de mapa a abranger e o nível do zoom
	// de acordo com as posições dos marcadores
	var bounds = new google.maps.LatLngBounds();

	// Loop que vai percorrer a informação contida em markersData
	// para que a função createMarker possa criar os marcadores
	for (var i = 0; i < markers.length; i++) {

		var latlng = new google.maps.LatLng(markers[i].latitude,
				markers[i].longitude);
		var id = markers[i].id;
		var nome = markers[i].nome;
		var descLatitude = "Latitude: " + markers[i].latitude;
		var descLongitude = "Longitude: " + markers[i].longitude;

		createMarker(id, latlng, nome, descLatitude, descLongitude);

		// Os valores de latitude e longitude do marcador são adicionados à
		// variável bounds
		bounds.extend(latlng);
	}

	// Depois de criados todos os marcadores,
	// a API, através da sua função fitBounds, vai redefinir o nível do zoom
	// e consequentemente a área do mapa abrangida de acordo com
	// as posições dos marcadores
	map.fitBounds(bounds);
}

// Função que cria os marcadores e define o conteúdo de cada Info Window.
function createMarker(id, latlng, nome, descLatitude, descLongitude) {
	var marker = new google.maps.Marker({
		map : map,
		position : latlng,
		title : nome,
		icon : "resources/imagens/lixeira_vazia.jpg"
	});

	// Evento que dá instrução à API para estar alerta ao click no marcador.
	// Define o conteúdo e abre a Info Window.
	google.maps.event.addListener(marker, 'click', function() {

		// Variável que define a estrutura do HTML a inserir na Info Window.
		var iwContent = '<div id="iw_container">' + '<div class="iw_title">'
				+ nome + '</div>' + '<br />' + descLatitude + '<br />'
				+ descLongitude + '</div></div>';

		// O conteúdo da variável iwContent é inserido na Info Window.
		infoWindow.setContent(iwContent);

		// A Info Window é aberta com um click no marcador.
		infoWindow.open(map, marker);
	});


	// Muda o ícone da lixeira e muda o status para cheia
	google.maps.event.addListener(marker, 'dblclick', function() {
		
		
		if($("#"+id).html() == "Vazia"){
			$("#"+id).html("Cheia");
			marker.setIcon("resources/imagens/lixeira_cheia.jpg");

		}else{
			$("#"+id).html("Vazia");
			marker.setIcon("resources/imagens/lixeira_vazia.jpg");
		}
		

	});
}

// Coloca o foco da lixeira no mapa
function mostraLixeiraNoMapa(latitude, longitude) {

	var location = new google.maps.LatLng(latitude, longitude);
	map.setCenter(location);
	map.setZoom(18);
}

// funcao que inicaliza o mapa
function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(-19.96199, -44.201138),
		zoom : 15,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

	// Cria a nova Info Window com referência à variável infoWindow.
	// O conteúdo da Info Window é criado na função createMarker.
	infoWindow = new google.maps.InfoWindow();

	// Evento que fecha a infoWindow com click no mapa.
	google.maps.event.addListener(map, 'click', function() {
		infoWindow.close();
	});

}

// Inicializa o mapa
google.maps.event.addDomListener(window, "load", initialize);
