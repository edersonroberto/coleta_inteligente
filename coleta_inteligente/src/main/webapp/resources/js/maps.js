var map;


// Esta função vai percorrer a informação contida na variável markersData
//e cria os marcadores através da função createMarker
function displayMarkers(markers){
	
// esta variável vai definir a área de mapa a abranger e o nível do zoom
// de acordo com as posições dos marcadores
var bounds = new google.maps.LatLngBounds();

// Loop que vai percorrer a informação contida em markersData 
// para que a função createMarker possa criar os marcadores 
for (var i = 0; i < markers.length; i++){
	
   //alert(i + ": " + markers[0].latitude + "\n" + markers[i].descricao);	
   var latlng = new google.maps.LatLng(markers[i].latitude, markers[i].longitude);
   var nome = markers[i].descricao;
   var morada1 = "teste";//markers[i].morada1;
   var morada2 = "teste";//markersData[i].morada2;
   var codPostal = "teste";//markersData[i].codPostal;

   createMarker(latlng, nome, morada1, morada2, codPostal);

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

//Função que cria os marcadores e define o conteúdo de cada Info Window.
function createMarker(latlng, nome, morada1, morada2, codPostal){
   var marker = new google.maps.Marker({
      map: map,
      position: latlng,
      title: nome
   });

   // Evento que dá instrução à API para estar alerta ao click no marcador.
   // Define o conteúdo e abre a Info Window.
   google.maps.event.addListener(marker, 'click', function() {
      
      // Variável que define a estrutura do HTML a inserir na Info Window.
      var iwContent = '<div id="iw_container">' +
      '<div class="iw_title">' + nome + '</div>' +
      '<div class="iw_content">' + morada1 + '<br />' +
      morada2 + '<br />' +
      codPostal + '</div></div>';
      
      // O conteúdo da variável iwContent é inserido na Info Window.
      infoWindow.setContent(iwContent);

      // A Info Window é aberta com um click no marcador.
      infoWindow.open(map, marker);
   });
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

	   // Chamada para a função que vai percorrer a informação
	   // contida na variável markersData e criar os marcadores a mostrar no mapa
	   

}

// Inicializa o mapa
google.maps.event.addDomListener(window, "load", initialize);
