package modelo;

public class Lixeira {
	
	private Long id;
	private String latitude;
	private String longitude;
	private Double capacidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Double getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Double capacidade) {
		this.capacidade = capacidade;
	}

}
