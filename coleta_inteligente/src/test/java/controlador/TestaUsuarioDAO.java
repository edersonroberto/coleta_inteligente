package controlador;

import org.junit.Test;

public class TestaUsuarioDAO {
	
	@Test
	public void testaUsuarioDAO(){
		UsuarioDAO user = new UsuarioDAO();
		
		user.getUsuario("teste", "teste");
	}

}
