package controlador;

import org.junit.Test;

import modelo.Usuario;

public class TestaUsuarioDAO {
	
	@Test
	public void testaUsuarioDAO(){
		UsuarioDAO user = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = user.getUsuario("ederson", "123");
		
		System.out.println(usuario.getNomeUsuario());
	}

}
