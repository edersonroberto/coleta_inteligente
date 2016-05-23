package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Entity;
import modelo.Usuario;

public class UsuarioDAO {
	
	private EntityManager em = Entity.getEntityManager();
	
	public Usuario getUsuario(String nome, String senha){
		Usuario usuario;
		try{
			
			Query query = em.createQuery("Select u from Usuario u where u.nome =:nome and u.senha =:senha");
			query.setParameter("nome", nome);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
		}catch(NoResultException ne){
			System.out.println(ne.getMessage());
			usuario = null;
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll(){
		
		List<Usuario> usuarios;
		try{
			Query query = em.createQuery("Select u from Usuario u");
			usuarios = query.getResultList();
		}catch(NoResultException ne){
			System.out.println(ne.getMessage());
			usuarios = null;
		}
		
		return usuarios;
	}
	
	public boolean deleteUsuario(Usuario usuario){
		
		boolean removido;
		
		try{
			Usuario usuarioRemovido = em.merge(usuario);
			em.remove(usuarioRemovido);
			removido = true;
		}catch(NoResultException ne){
			System.out.println(ne.getMessage());
			removido = false;
		}
		return removido;
	}

	public boolean createUsuario(Usuario usuario) {
		
		boolean inserido;
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			inserido = true;
		} catch (NoResultException ne) {
			System.out.println(ne.getMessage());
			em.getTransaction().rollback();
			inserido = false;
		}
		
		return inserido;
		
	}
	
	

}
