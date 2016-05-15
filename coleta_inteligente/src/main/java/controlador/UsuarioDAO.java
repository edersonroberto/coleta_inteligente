package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Usuario;

public class UsuarioDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("coleta_inteligente");
	private EntityManager em = factory.createEntityManager();
	
	public Usuario getUsuario(String nomeUsuario, String senha){
		
		Usuario usuario;
		
		try{
			
			Query query = em.createQuery("Select u from Usuario u where u.nomeUsuario =:nome and u.senha =:senha");
			query.setParameter("nome", nomeUsuario);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
		}catch(NoResultException ne){
			usuario = null;
		}
			
		return usuario;
	}

}
