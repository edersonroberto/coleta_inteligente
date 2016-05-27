package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entity.Entity;
import modelo.Lixeira;

public class LixeiraDao {

	private EntityManager em = Entity.getEntityManager();

	public List<Lixeira> getLixeiras() {

		List<Lixeira> lixeiras = null;
		try {
			TypedQuery<Lixeira> query = em.createQuery("select l from Lixeira l", Lixeira.class);
			lixeiras = query.getResultList();

		} catch (NoResultException ne) {
			System.out.println(ne.getMessage());
		}
		return lixeiras;
	}

	public boolean createLixeira(Lixeira lixeira) {

		boolean inserido;
		try {
			em.getTransaction().begin();
			em.persist(lixeira);
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
