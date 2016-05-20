package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Mapa;

public class ControladorMapa {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("coleta_inteligente");
	private EntityManager em = factory.createEntityManager();

	public boolean createMapa(Mapa mapa) {

		boolean inserido;
		try {
			em.getTransaction().begin();
			em.persist(mapa);
			em.getTransaction().commit();
			inserido = true;
		} catch (NoResultException ne) {
			System.out.println(ne.getMessage());
			em.getTransaction().rollback();
			inserido = false;
		}

		return inserido;

	}

	public Mapa getMapa(String lat, String longt) {
		Mapa mapa;
		try {

			Query query = em.createQuery("Select m from Mapa m where m.latitude =:lat and u.longitude =:longitude");
			query.setParameter("nome", lat);
			query.setParameter("senha", longt);
			mapa = (Mapa) query.getSingleResult();
		} catch (NoResultException ne) {
			System.out.println(ne.getMessage());
			mapa = null;
		}
		return mapa;
	}

}
