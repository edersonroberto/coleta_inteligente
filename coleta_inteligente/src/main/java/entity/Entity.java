package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Entity {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("coleta_inteligente");
	
	public static EntityManager getEntityManager(){
		
		return factory.createEntityManager();
		
	}
}
