package principal;

import javax.persistence.EntityManager;

import conexao.Conexao;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {
		EntityManager entityManager = Conexao.getEntityManager();
		try{
			entityManager.getTransaction().begin();
			Usuario user = new Usuario();
			user.setNome("Carlos Filho");
			user.setEmail("carlosfilho88@gmail.com");
			user.setCpf("83581499568");
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			if(entityManager.isOpen()){
				entityManager.getTransaction().rollback();
			}
		}finally{
			if(entityManager.isOpen()){
				entityManager.close();
			}
		}
	}

}
