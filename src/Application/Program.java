package Application;

import java.util.Locale;
import java.util.Scanner;

import model.Exceptions.BusinessException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data:");
		System.out.println("Account number:");
		Integer number = sc.nextInt();
		System.out.println("Holder:");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Initial Limit:");
		Double initLimit = sc.nextDouble();
		System.out.println("Withdraw Limit:");
		Double withdraw = sc.nextDouble();
		
		Account ac = new Account(number, holder, initLimit, withdraw);
		System.out.println(ac.toString() + "\n");
		
		System.out.println("Enter withdraw:");
		Double withd = sc.nextDouble();
		
		try {
			ac.withdraw(withd);
			System.out.printf("New Balance: %.2f", ac.getBalance());
		
		}catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

}
