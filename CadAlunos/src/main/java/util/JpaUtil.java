package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil
{
private static EntityManagerFactory factory;

public static EntityManager getEntityManager()  {
	
	factory = Persistence.createEntityManagerFactory("CadAlunos");
	
	return factory.createEntityManager();
}

public static void close() {
	factory.close();
}


}