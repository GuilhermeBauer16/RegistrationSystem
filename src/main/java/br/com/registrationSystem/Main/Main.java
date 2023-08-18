package br.com.registrationSystem.Main;

import javax.persistence.EntityManager;

import br.com.registrationSystem.DAO.RegistrationDAO;
import br.com.registrationSystem.Functions.CreateParameter;
import br.com.registrationSystem.Registration.Registration;
import br.com.registrationSystem.Util.JPAUtil;

public class Main {

	public static void main(String[] args) {

		CreateParameter createParameter = new CreateParameter();

		EntityManager entityManager = new JPAUtil().getEntityManager();
		RegistrationDAO registrationDAO = new RegistrationDAO(entityManager);
		Registration registration = new Registration();

		while (true) {
			System.out.println(createParameter.title("Cadastro cliente", 50)); 
			System.out.println("[1]Cadastrar um cliente");
			System.out.println("[2]Ver clientes cadastrados");
			System.out.println("[3]Editar dados cliente");
			System.out.println("[4]Deletar cliente");
			System.out.println("[5]Sair ");
			System.out.println(createParameter.line(50));
			int option = createParameter.createInt("sua opção: ");

			if (option == 1) {
				System.out.println(createParameter.title("Novo cliente", 50)); 
				registration.registration();
				registrationDAO.InsertQuery(registrationDAO, registration);
				System.out.println(createParameter.line(50));

			} else if (option == 2) {

				registrationDAO.SelectAll();

			} else if (option == 3) {

				registrationDAO.Update();

			} else if (option == 4) {

				registrationDAO.Delete();
			} else if (option == 5) {
				System.out.println("Saindo...");
				entityManager.close();
				break;
			}else {
				System.out.println("Opção invalida!");
			}

		}
	}
}
