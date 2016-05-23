package managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controlador.UsuarioDAO;
import modelo.Usuario;
import util.Conversor;

@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		usuarios = new ArrayList<Usuario>();
		usuarios = usuarioDAO.findAll();	
	}
	
	public String cadastrarUsuario() {
		
		usuario.setUltimoAcesso(new Date());
		usuario.setSenha(Conversor.converteStringToMD5(usuario.getSenha()));
		usuarioDAO.createUsuario(usuario);

		return "";
	}

	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
