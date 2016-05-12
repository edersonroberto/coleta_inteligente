package managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Usuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean {
	
	//private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    
    public String envia() {
          
          //usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
          
    	if (usuario == null) {
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                       "Erro no Login!"));
                return null;
          } else {
                return "/main";
          }
          
          
    }

    public Usuario getUsuario() {
          return usuario;
    }

    public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
    }

}
