package managedbeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import controlador.UsuarioDAO;
import modelo.Usuario;
import util.Conversor;

@ManagedBean
@ViewScoped
public class LoginBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public void logar() {
		
		String nome = usuario.getNome();
		String senha = Conversor.converteStringToMD5(usuario.getSenha());
		
		usuario = usuarioDAO.getUsuario(nome, senha);

		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
		
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}	
	
		}
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
