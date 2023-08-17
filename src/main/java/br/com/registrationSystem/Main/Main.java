package br.com.registrationSystem.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.registrationSystem.DAO.RegistrationDAO;
import br.com.registrationSystem.Registration.Item;
import br.com.registrationSystem.Registration.PaymentMethod;
import br.com.registrationSystem.Registration.Registration;
import br.com.registrationSystem.Util.JPAUtil;
import br.com.reservationSystem.Functions.CreateParameter;

public class Main {
	
	public static void main(String[] args) {
		Item item = new Item();
		item.showItens();
		CreateParameter createParameter = new CreateParameter();
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		RegistrationDAO registrationDAO =  new RegistrationDAO(entityManager);
		
		entityManager.getTransaction().begin();
		registrationDAO.Insert( new Registration());
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
