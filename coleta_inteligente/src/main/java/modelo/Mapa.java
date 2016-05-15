package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Mapa {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Column(nullable = false, unique = true)
	private String latitude;
	@Column(nullable = false, unique = true)
	private String longitude;
	@Column(nullable = false, unique = true)
	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Lixeira", joinColumns={@JoinColumn(name = "mapa_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id")})
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
