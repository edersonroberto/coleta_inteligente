package controlador;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Usuario;

public class TestaUsuarioDAO {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	@Before
	public void criaUsuario(){
		usuarioDAO = new UsuarioDAO();
		usuario = new Usuario();
	}
	
	@Test
	public void testaGetUsuario(){
		
		usuario = usuarioDAO.getUsuario("ederson", "123");
		
		System.out.println(usuario.getNomeUsuario());
	}
	
	public void testaRemoveUsuario(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario = usuarioDAO.getUsuario("ederson", "123");
		usuarioDAO.deleteUsuario(usuario);
		
		usuario = usuarioDAO.getUsuario("ederson", "123");
		
	}
	
	@Test
	public void testaInsereUsuario(){
		
		usuario.setNomeUsuario("Teste");
		usuario.setSenha("testando");
		usuario.setUltimoAcesso(new Date());
		
		
		assertEquals(false, usuarioDAO.createUsuario(usuario));
		
	}
	
	@Test
	public void testaFindAll(){
		
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNomeUsuario());
		}
		
	}
}
