package modelo;

import java.util.List;

public class Mapa {

	private Long id;
	private String latitude;
	private String longitude;
	private String nome;
	private List<Lixeira> lixeiras;
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Lixeira> getLixeiras() {
		return lixeiras;
	}
	public void setLixeiras(List<Lixeira> lixeiras) {
		this.lixeiras = lixeiras;
	}
}
