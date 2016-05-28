var geocoder;
var map;
var marker;

// Inicializa o Mapa
function initialize() {
	var latlng = new google.maps.LatLng(-18.8800397, -47.05878999999999);
	var options = {
		zoom : 15,
		center : latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById("mapa"), options);

	geocoder = new google.maps.Geocoder();

	marker = new google.maps.Marker({
		map : map,
		draggable : true,
	});

	marker.setPosition(latlng);
}

$(document).ready(function() {
	initialize();

	// Mostra no mapa o ponto correspondente ao endereço digitado e carrega os
	// dados nos campos da lixeira
	function carregarNoMapa(endereco) {
		geocoder.geocode({
			'address' : endereco + ', Brasil',
			'region' : 'BR'
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					atualizaCampos(results)

					var location = new google.maps.LatLng(latitude, longitude);
					marker.setPosition(location);
					map.setCenter(location);
					map.setZoom(18);
				}
			}
		});
	}

	$("#btnEndereco").click(function() {
		if ($(this).val() != "")
			carregarNoMapa($("#txtEndereco").val());
	})

	$("#txtEndereco").blur(function() {
		if ($(this).val() != "")
			carregarNoMapa($(this).val());
	})

	// Evento que muda os dados da lixeira ao mover o marcador
	google.maps.event.addListener(marker, 'drag', function() {

		geocoder.geocode({
			'latLng' : marker.getPosition()
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0]) {
					atualizaCampos(results)

				}
			}
		});
	});
	
	//Auto complete
	 $("#txtEndereco").autocomplete({
	        source: function (request, response) {
	            geocoder.geocode({ 'address': request.term + ', Brasil', 'region': 'BR' }, function (results, status) {
	                response($.map(results, function (item) {
	                    return {
	                        label: item.formatted_address,
	                        value: item.formatted_address,
	                        latitude: item.geometry.location.lat(),
	                        longitude: item.geometry.location.lng()
	                    }
	                }));
	            })
	        },
	        select: function (event, ui) {
	            $("#txtLatitude").val(ui.item.latitude);
	            $("#txtLongitude").val(ui.item.longitude);
	            var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
	            marker.setPosition(location);
	            map.setCenter(location);
	            map.setZoom(16);
	        }
	    });
	
	// Atualiza os campos da lixeira com os dados do mapa
	function atualizaCampos(results) {
		var latitude = results[0].geometry.location.lat();
		var longitude = results[0].geometry.location.lng();
		var descricao = results[0].formatted_address;

		PF('nome').jq.val(descricao.substring(0, descricao.indexOf(',')));
		PF('lat').jq.val(latitude);
		PF('lgn').jq.val(longitude);
		PF('desc').jq.val(descricao);

	}
});
