package br.com.registrationSystem.DAO;

import java.util.List;  

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.registrationSystem.Functions.CreateParameter;
import br.com.registrationSystem.Registration.Registration;

public class RegistrationDAO {

	private EntityManager entityManager;

	public RegistrationDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void Insert(Registration registration) {

		this.entityManager.persist(registration);

	}

	public Registration FindId(long id) {
		return entityManager.find(Registration.class, id);
	}

	public void SelectAll() {
		String jpql = "SELECT R FROM Registration R";
		Query query = entityManager.createQuery(jpql, Registration.class);

		List<Registration> registrations = query.getResultList();
		System.out.println("=".repeat(162));
		System.out.printf("| %-4s | %-35s | %-3s | %-14s | %-35s | %-50s |%n", "ID", "Nome do Item", "Idade",
				"Telefone", "Email", "Endereço");
		System.out.println("=".repeat(162));

		for (Registration registration : registrations) {
			System.out.printf("| %-4d | %-35s | %-4d | %-15s | %-35s | %-50s |%n", registration.getId_registration(),
					registration.getCustomerName(), registration.getAge(), registration.getPhone(),
					registration.getEmail(), registration.getAddress());
		}
		System.out.println("=".repeat(162));
	}

	public void Update() {
		CreateParameter createParameter = new CreateParameter();
		SelectAll();

		int idToUpdate = createParameter.createInt("digite o Id para atualizar dados: ");
		System.out.println(createParameter.line(50));
		Registration registrationToUpdate = FindId(idToUpdate);

		if (registrationToUpdate != null) {

			String newCustomerName = createParameter.createString("Nome: ");
			int newAge = createParameter.createInt("Sua idade: ");
			String newPhone = createParameter.createString("telefone (XX) XX-XXXXX-XXXX: ");
			String newEmail = createParameter.createString("email: ");
			String newAddress = createParameter.createString("Endereço: ");

			entityManager.getTransaction().begin();

			registrationToUpdate.setCustomerName(newCustomerName);
			registrationToUpdate.setAge(newAge);
			registrationToUpdate.setPhone(newPhone);
			registrationToUpdate.setEmail(newEmail);
			registrationToUpdate.setAddress(newAddress);

			entityManager.getTransaction().commit();

		} else {

			System.out.println("Registro não encontrado!");
		}

	}

	public void Delete() {

		CreateParameter createParameter = new CreateParameter();
		SelectAll();

		int idToDelete = createParameter.createInt("digite o Id para deletar os dados: ");
		System.out.println(createParameter.line(50));
		Registration registrationToDelete = FindId(idToDelete);

		if (registrationToDelete != null) {

			entityManager.getTransaction().begin();
			entityManager.remove(registrationToDelete);
			entityManager.getTransaction().commit();

		} else {

			System.out.println("Registro não encontrado!");
		}

	}

	public void InsertQuery(RegistrationDAO registrationDAO, Registration registration) {
		entityManager.getTransaction().begin();
		registrationDAO.Insert(registration);
		entityManager.getTransaction().commit();


	}

}
