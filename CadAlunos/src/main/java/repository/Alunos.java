package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Aluno;
import model.Curso;
import util.JpaUtil;

public class Alunos implements Serializable {


	private static final long serialVersionUID = 1L;
	
	static EntityManager manager = JpaUtil.getEntityManager();
	
	public static List<Aluno> pegarTodosAlunos() {
		manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unchecked")		
		List<Aluno> alunos = manager.createQuery("from Aluno").getResultList();
		//alunos.remove(0);
		manager.close();
		return alunos;
	}
	
	public static void salvarUsuario(Aluno aluno) {		
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(aluno);
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	
	public static void excluirAluno(Aluno aluno) {
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.getReference(Aluno.class,aluno.getId()));
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	

}
