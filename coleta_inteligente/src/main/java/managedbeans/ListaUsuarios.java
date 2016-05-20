package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import controlador.UsuarioDAO;
import modelo.Usuario;

@ManagedBean(name = "ListaUsuariosMB")
@ViewScoped
public class ListaUsuarios {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		usuarios = new ArrayList<Usuario>();
		usuarios = usuarioDAO.findAll();	
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
