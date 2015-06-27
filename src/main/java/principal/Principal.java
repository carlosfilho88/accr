package principal;

import java.util.Date;

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
			user.setCpf("83581499568");
			user.setSenha("83581499568");
			user.setCreated(new Date());
			user.setModified();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			
			entityManager = Conexao.getEntityManager();
			entityManager.getTransaction().begin();
			user = entityManager.find(Usuario.class, 1);
			System.out.println(user.getCpf());
			user.setCpf("333323332");
			user.setStatus(0);
			
			Thread.sleep(3000);
			user.setModified();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch(Exception e){
			System.out.println("DEU PAU: " + e.getMessage());
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
