package modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	
	@Id
	@Column(name="id", nullable=false, unique = true)
	private long id;
	
	@Column(name="id", nullable=false, unique = true)
	private String nomeUsuario;
	
	@Column(name="id", nullable=false, unique = true)
	private String senha;
	
	@Column(name="ultimo_acesso", unique=true)
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	
}
