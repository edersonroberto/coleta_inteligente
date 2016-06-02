package managedbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controlador.UsuarioDAO;
import modelo.Usuario;
import util.Conversor;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	private List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		usuarios = new ArrayList<Usuario>();
		usuarios = usuarioDAO.findAll();
	}

	public void cadastrarUsuario() {

		usuario.setUltimoAcesso(new Date());
		usuario.setSenha(Conversor.converteStringToMD5(usuario.getSenha()));
		boolean inserido = usuarioDAO.createUsuario(usuario);
		
		if(inserido)
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sucesso!", "Usuário cadastrado com sucesso!"));
		else
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Falha ao cadastrar usuário!"));

	}

	public String atualizarUsuario() {

		usuarioDAO.updateUsuario(usuario);
		return "";
	}

	public String buscarUsuario() {

		Long id = usuario.getId();
		System.out.println("Id: " + id);
		System.out.println("Nome; " + id);
		usuario = usuarioDAO.getUsuarioById(id);
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!", "Usuário não encontrado!"));

		}
		return "";
	}
	
	public void editar(){
		Long id = usuario.getId();
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("teste", id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("editar_usuario.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
