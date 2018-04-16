package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BatteryCompanyAccount {

	// ********* //
	// VARIABLES //
	// ********* //
	private static double accountBalance = 0.0;
	private static double escoBalance = 0.0;
	

	//private static Object acct;

	//private static Object file;
	private static double expenses = 0.0;
	private double remainingBalance = 0.0;
	private double newTotalnytaxcollected;
	private double newTotalcttaxcollected;
	//private double amount;
	private double newTotalnjtaxcollected;
	private double newTotalBostonTaxCollected;
	private double newTotalChicagoTaxCollected;
	
	public BatteryCompanyAccount()
	{
		super();
		accountBalance = setAccountBalance();
		escoBalance = setEscoBalance();
		expenses = setExpenses();
	    
		double nytaxcollected = 0.0;
		double njtaxcollected = 0.0;
		double cttaxcollected = 0.0;
		double chicagoTaxCollected = 0.0;
		double bostonTaxCollected = 0.0;
            
		// ***************************************************************** //
		// 		   FORMAT FOR HOW THE DATE IS DISPLAY IN THE CSV FILE        //
		// STRING = (CLIENT NAME AND ID, STATE, DATE, INCOME, EXPENSES, TAX) //
		// ***************************************************************** //
		
		String fileName = "/Users/Duvall/workspace/Software Engineering Project version 4/data/battery_company.csv";
        Scanner inputStream = null;
        PrintWriter outputStream = null;// object to output to the file
		try {
			
			int numCounter = 0;
			
			
		    inputStream = new Scanner(new File(fileName));
		    inputStream.nextLine();
			while (inputStream.hasNextLine()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				numCounter++;
				outputStream = new PrintWriter("/Users/Duvall/workspace/Software Engineering Project version 4/ battery company statements/BatteryCompanyStatement"+ numCounter +".txt");
				
				
				
				// ************************ //
				// ADD VALUES INTO ACCOUNTS //
				// ************************ //
				System.out.println("***************Beginning of transaction" + numCounter+"************************");
				
				outputStream.println("*************Beginning of transaction"+ numCounter+"**********");
				
				
				double bal = Double.parseDouble(values[3]);
				System.out.println("The income for the date " + values[2] + " is: " 
						+ bal);
				
				outputStream.println("The income for the date " + values[2] + " is: " 
						+ bal);
				
				if (numCounter >= 2)
				{
					accountBalance = bal + getAccountBalance( remainingBalance );
					
					cttaxcollected = totalCtTaxCollected(cttaxcollected, newTotalcttaxcollected);
					njtaxcollected = totalNjTaxCollected(njtaxcollected, newTotalnjtaxcollected);
					nytaxcollected = totalNyTaxCollected( nytaxcollected, newTotalnytaxcollected);
				}
				
				
				accountBalance = accountBalance + bal;
				System.out.println("\n The account balance is : " + accountBalance);
				
				outputStream.println("\n The account balance is : " + accountBalance);
				
				double escobal = Double.parseDouble(values[5]);
				escoBalance = escoBalance + escobal;
				
				System.out.println("The tax collected for the date " + values[2] + " is: " 
						+ escobal);
				
				outputStream.println("The tax collected for the date " + values[2] + " is: " 
						+ escobal);
				
				double expenses = Double.parseDouble(values[4]);
				accountBalance = accountBalance - expenses;
				
				
				System.out.println("The expenses for the date " + values[2] + " is: " 
						+ expenses);
				
				outputStream.println("The expenses for the date " + values[2] + " is: " 
						+ expenses);
				
				System.out.println("The new account balance is :"+ accountBalance);
				
				outputStream.println("The new account balance is :"+ accountBalance);
				
				// ******************************************************************** //
				// DEPOSIT AMOUNTS INTO EACH ACCOUNT CHECKING AND ESCO PER EACH COMPANY //
				// ******************************************************************** //
				accountBalance = getAccountBalance(accountBalance);
				double newAccountBalance = depositInChecking(accountBalance, bal);
				
				System.out.println("The new account balance is: " + newAccountBalance);
				outputStream.println("The new account balance is: " + newAccountBalance);
				
                System.out.println("***************END of transaction" + numCounter+"************************");
				
				outputStream.println("*************END of transaction"+ numCounter+"**********");
				if ( values[1] == "NY")
				{
				       newTotalnytaxcollected = nytaxcollected + Double.parseDouble(values[5]);
				       
				       System.out.println("the amount of total ny tax collected is: " +
				       newTotalnytaxcollected);
				       
				       outputStream.println("the amount of total ny tax collected is: " +
						       newTotalnytaxcollected);
				}
				else if (values[1] == "NJ")
				{
					newTotalnjtaxcollected = njtaxcollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of NJ tax collected is: "+ 
					newTotalnjtaxcollected);
					
					outputStream.println("the amount of NJ tax collected is: "+ 
							newTotalnjtaxcollected);
				}
				else if (values[1] == "CT")
				{
					newTotalcttaxcollected = cttaxcollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of CT tax collected is: " + 
					newTotalcttaxcollected);
					
					outputStream.println("the amount of CT tax collected is: " + 
							newTotalcttaxcollected);
				}else if (values[1] == "BOSTON")
				{
					newTotalBostonTaxCollected = bostonTaxCollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of BOSTON tax collected is: " + 
							newTotalBostonTaxCollected);
					
					outputStream.println("the amount of CT tax collected is: " + 
							newTotalBostonTaxCollected);
				}else if (values[1] == "CHICAGO")
				{
					newTotalChicagoTaxCollected = chicagoTaxCollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of Chicago tax collected is: " + 
							newTotalChicagoTaxCollected);
					
					outputStream.println("the amount of Chicago tax collected is: " + 
							newTotalChicagoTaxCollected);
				}
				
				
				
				escoBalance = getEscoBalance(escoBalance);
				double newEscoBalance = depositInEsco(escoBalance, escobal);
				
				accountBalance = getAccountBalance(accountBalance);
				double newAccountBalance1 = depositInChecking(accountBalance, bal);
				
				expenses = getExpenses(expenses);
				double remainingBalance = newAccountBalance1 - expenses;
				
				
                System.out.println("***************Beginning of Statement for Transaction " + numCounter+"************************");
				
				outputStream.println("*************Beginning of Statement for Transaction "+ numCounter+"**********");
				
				System.out.println("The new account balance minus total "+ expenses 
						+ " in expenses is " + remainingBalance);
				
				outputStream.println("The new account balance minus total "+ expenses 
						+ " in expenses is " + remainingBalance);
				
				System.out.println("The new Esco balance is: " + newEscoBalance);
				outputStream.println("The new Esco balance is: " + newEscoBalance);

				System.out.println(" the total new york tax collected is: " + nytaxcollected);
				outputStream.println("the total new york tax collected is: " + nytaxcollected );
				
				System.out.println(" the total CT tax collected is: " + cttaxcollected);
				outputStream.println("the total CT tax collected is: " + cttaxcollected );
				
				System.out.println(" the total New Jersey tax collected is: " + njtaxcollected);
				outputStream.println("the total New Jersey tax collected is: " + njtaxcollected );
				
				System.out.println(" the total BOSTON tax collected is: " + bostonTaxCollected);
				outputStream.println("the total BOSTON tax collected is: " + bostonTaxCollected );
				
				System.out.println(" the total CHICAGO tax collected is: " + chicagoTaxCollected);
				outputStream.println("the total CHICAGO tax collected is: " + chicagoTaxCollected );
				
                System.out.println("***************END of Statement "+numCounter+"************************");
				
				outputStream.println("*************END of Statement "+ numCounter + "**********************");

	            outputStream.close();
			}
			
					/*
			System.out.println(" the total new york tax collected is: " + nytaxcollected);
			outputStream.println("the total new york tax collected is: " + nytaxcollected );
			
			System.out.println(" the total CT tax collected is: " + cttaxcollected);
			outputStream.println("the total CT tax collected is: " + cttaxcollected );
			
			System.out.println(" the total New Jersey tax collected is: " + njtaxcollected);
			outputStream.println("the total New Jersey tax collected is: " + njtaxcollected );
			
			System.out.println(" the total BOSTON tax collected is: " + bostonTaxCollected);
			outputStream.println("the total BOSTON tax collected is: " + bostonTaxCollected );
			
			System.out.println(" the total CHICAGO tax collected is: " + chicagoTaxCollected);
			outputStream.println("the total CHICAGO tax collected is: " + chicagoTaxCollected );
			
			*/
			inputStream.close();
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	   
	}
	
	

	// ************************* //
		// SETTER FOR ACCOUNTBALANCE //
		// ************************* // 
		public static double setAccountBalance(){ 
			double accountBalance = 0.0;
			return accountBalance;
		}

		// *********************** //
		// SETTER FOR ESCO BALANCE //
		// *********************** //
		public static double setEscoBalance(){
			double escoBalance = 0.0;
			return escoBalance;
		}

		// ******************************* //
		// SETTER AND GETTER FOR EXPENSIVE //
		// ******************************* //
		public static double setExpenses(){
			double expenses = 0.0;
			return expenses;
		}

		// ************************** //
		// GETTER FOR ACCOUNT BALANCE //
		// ************************* // 
		public static double getAccountBalance( double bal ) {
			accountBalance = bal;
			return accountBalance;
		}

		// ********************** //
		// GETTER FOR ESCOBALANCE //
		// ********************** //
		public static double getEscoBalance( double bal ){
			escoBalance = bal;
			return escoBalance;
		}

		// ******************* //
		// GETTER FOR EXPENSES //
		// ******************* //
		public static double getExpenses( double amount) {
			expenses = amount;
			return expenses;
		}

		

		// ************************************************************ //
		// DEPOSITS INTO CHECKING ACCOUNT & RETURNS NEW ACCOUNT BALANCE //
		// ************************************************************ //
		public static double depositInChecking(double amount, double accountBalance){
			accountBalance = amount + accountBalance;
			return accountBalance;
		}

		// ************************************************************* //
		// DEPOSITS INTO TAX ACCOUNT RETURN NEW SALESTAX ACCOUNT BALANCE //
		// ************************************************************* //
		public static double depositInEsco(double amount, double escoBalance){
			escoBalance = amount + escoBalance;
			return escoBalance;
		}
		
		//getter for ny tax collected
		public static double totalNyTaxCollected( double nytaxcollected, double prevamount){
			nytaxcollected = nytaxcollected + prevamount;
			return nytaxcollected;
		}
		
		//getter for nj tax collected
		public static double totalNjTaxCollected(double njtaxcollected, double prevamount){
			njtaxcollected = njtaxcollected + prevamount;
			return njtaxcollected;
		}
		// getter for ct tax collected
		public static double totalCtTaxCollected(double cttaxcollected, double prevamount){
			cttaxcollected = cttaxcollected + prevamount;
			return cttaxcollected;
		}


	// *********** //
	// MAIN METHOD //
	// *********** //
	public static void main(String[] args) {
            
              new BatteryCompanyAccount();		
	}

	
}
