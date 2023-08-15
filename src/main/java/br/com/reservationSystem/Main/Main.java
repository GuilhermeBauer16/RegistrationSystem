package br.com.reservationSystem.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.reservationSystem.Functions.CreateParameter;

public class Main {
	
	public static void main(String[] args) {
		
		CreateParameter createParameter = new CreateParameter();
		String name = createParameter.createString("Digite o seu nome: ");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("resistrationSystem");
		EntityManager entityManager = factory.createEntityManager();
	}
}
