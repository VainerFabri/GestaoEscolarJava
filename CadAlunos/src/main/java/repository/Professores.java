package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Aluno;
import model.Professor;
import util.JpaUtil;

public class Professores implements Serializable {


	private static final long serialVersionUID = 1L;
	
	static EntityManager manager = JpaUtil.getEntityManager();
	
	public static List<Professor> pegarTodosProfessores() {
		manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unchecked")		
		List<Professor> professores = manager.createQuery("from Professor").getResultList();
		manager.close();
		return professores;
	}
	
	public static void salvarUsuario(Professor professor) {		
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(professor);
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	
	public static void excluirProfessor(Professor professor) {
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.getReference(Professor.class,professor.getId()));
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	

}
