package br.com.registrationSystem.Functions;

import java.util.Scanner;

public class CreateParameter {

	public String createString(String mesage) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(mesage);
		return scanner.nextLine();
		
	}
	
	public int createInt(String mesage) {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		while (true) {
			System.out.print(mesage);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}else {
				System.out.println("Por favor digite um n�mero!");
				scanner.nextLine();
			}
		}
		return number;
	}
	
	public double createDouble(String mesage) {
		Scanner scanner = new Scanner(System.in);
		double number = 0.0;
		while (true) {
			System.out.print(mesage);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			}else {
				System.out.println("Por favor digite um n�mero!");
				scanner.nextLine();
			}
		}
		return number;
	}
	
	public String title(String mesage, int number) {
        String linha = "==".repeat(number);
        return linha + "\n" + mesage + "\n" + linha;
    }

    public String line(int number) {
        return "==".repeat(number);
    }
}
