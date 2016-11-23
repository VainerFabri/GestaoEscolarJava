package util;

import javax.persistence.Persistence;

public class CriarTabela {
	
	public static void main(String[] args){
		Persistence.createEntityManagerFactory("CadAlunos");
	}

}
