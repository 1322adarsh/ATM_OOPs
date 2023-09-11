package oops;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		ATMop obj = new ATMop();
	}

}

class Data {
	float balance;
}

class ATMop {
//	float balance;
	Scanner sc = new Scanner(System.in);

	HashMap<Integer, Data> map = new HashMap<>();

	ATMop() {
		System.out.println("*******************************************************");
		System.out.println("Welcome to our ATM");
		op();
	}

	public void op() {
		System.out.println("*******************************************************");
		System.out.println("Enter your Pincode");
		int pincode = sc.nextInt();
		

		if (map.containsKey(pincode) == true) {
			Data obj = map.get(pincode);
			menu(obj);
		}
		else {
			System.out.println("*******************************************************");
			System.out.println("Please craete account first.");
			System.out.println("Set your pin code");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin , obj);
			menu(obj);
		}
	}

	public void menu(Data obj) {

		System.out.println("******************************************************************");
		System.out.println("Please enter valid number");
		System.out.println("1, Check Balance");
		System.out.println("2, Deposit Money");
		System.out.println("3, Withraw Money");
		System.out.println("4, Check Another Account");
		System.out.println("5, Exit");

		int x = sc.nextInt();

		if (x == 1) {
			checkBalance(obj);
		} else if (x == 2) {
			deposit(obj);
		} else if (x == 3) {
			withdraw(obj);
		} else if (x == 4) {
			op();
		} else if (x == 5) {
			System.out.println("......THANK YOU......");
		} else {
			System.out.println("Please Enter Valid Number");
			menu(obj);
		}
	}

	public void checkBalance(Data obj) {
		System.out.println("**************************************************************");
		System.out.println("your balance " + obj.balance);
		menu(obj);
	}

	public void deposit(Data obj) {
		System.out.println("**************************************************************");
		System.out.println("Enter your amount");
		float a = sc.nextFloat();

		obj.balance = obj.balance + a;

		System.out.println("Amount Deposited Succesfully");
		menu(obj);
	}

	public void withdraw(Data obj) {
		System.out.println("**************************************************************");
		System.out.println("Enter your amount");
		float a = sc.nextFloat();
		if(obj.balance>=a) {
			obj.balance = obj.balance - a;
			System.out.println("Amount Withdraw Succesfully");
		}
		else {
			System.out.println("Insufficient Balance");
		}
		
		System.out.println("*************************************************************");
		menu(obj);
	}
}