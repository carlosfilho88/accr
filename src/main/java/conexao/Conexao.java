package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	private static final String PERSISTENCE = "LibSystem";
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
	
	private static EntityManagerFactory emf;
	
	private Conexao(){
		
	}
	
	public static EntityManager getEntityManager(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory(PERSISTENCE);
		}
		EntityManager entityManager = threadEntityManager.get();
		if(entityManager == null || !entityManager.isOpen()){
			entityManager = emf.createEntityManager();
			Conexao.threadEntityManager.set(entityManager);
		}
		
		return entityManager;
	}
	
	public static void closeEntityManager(){
		closeEntityManager();
		emf.close();
	}
	
}
