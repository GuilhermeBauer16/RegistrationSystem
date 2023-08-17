package br.com.registrationSystem.DAO;

import javax.persistence.EntityManager;

import br.com.registrationSystem.Registration.Registration;

public class RegistrationDAO {
	
	private EntityManager entityManager;
	
	public RegistrationDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void Insert(Registration registration) {
		
		this.entityManager.persist(registration);
		
	}
	

}
