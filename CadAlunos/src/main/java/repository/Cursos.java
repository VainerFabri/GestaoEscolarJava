package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Curso;
import util.JpaUtil;

public class Cursos implements Serializable {


	private static final long serialVersionUID = 1L;
	
	static EntityManager manager = JpaUtil.getEntityManager();
	
	public static List<Curso> pegarTodosCursos() {
		manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unchecked")		
		List<Curso> cursos = manager.createQuery("from Curso").getResultList();
		manager.close();
		return cursos;
	}
	
	public static void salvarUsuario(Curso curso) {		
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(curso);
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	
	public static void excluirCurso(Curso curso) {
		EntityTransaction tx;
		manager = JpaUtil.getEntityManager();
		try {
			manager = JpaUtil.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.getReference(Curso.class,curso.getId()));
			tx.commit();
		} catch (Exception e) {
			
		}
		finally {
			manager.close();
		}
	}
	

}
