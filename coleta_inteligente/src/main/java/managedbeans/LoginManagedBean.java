package managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import controlador.UsuarioDAO;
import modelo.Usuario;

@ManagedBean(name = "UsuarioMB")
@ViewScoped
public class LoginManagedBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String logar() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());

		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/main";
		}
	}

	private String cadastrarUsuario() {

		if (usuarioDAO.createUsuario(usuario)) {
			// sucesso
		} else {
			// erro
		}
		;

		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
