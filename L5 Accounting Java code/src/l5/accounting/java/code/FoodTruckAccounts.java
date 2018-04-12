package l5.accounting.java.code;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DUVALL NOTEBOOK
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FoodTruckAccounts {

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
	
	public FoodTruckAccounts()
	{
		super();
		accountBalance = setAccountBalance();
		escoBalance = setEscoBalance();
		expenses = setExpenses();
	    
		double nytaxcollected = 0.0;
		double njtaxcollected = 0.0;
		double cttaxcollected = 0.0;
            
		// ***************************************************************** //
		// 		   FORMAT FOR HOW THE DATE IS DISPLAY IN THE CSV FILE        //
		// STRING = (CLIENT NAME AND ID, STATE, DATE, INCOME, EXPENSES, TAX) //
		// ***************************************************************** //
		
		String fileName = "C:/wamp64/www/L5 Accounting Java code/src/data/food_truck.csv";
        Scanner inputStream = null;
        PrintWriter outputStream = null;// object to output to the file
        PrintWriter outputStream2 = null;// output to html file
        PrintWriter outputStream3 = null;// output to css file
		try {
			
			int numCounter = 0;
			
			
		    inputStream = new Scanner(new File(fileName));
		    inputStream.nextLine();
			while (inputStream.hasNextLine()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				numCounter++;
				//outputStream = new PrintWriter("/Users/DUVALL NOTEBOOK/Documents/NetBeansProjects/L5 Accounting Project 2018 version 6/public_html/Food Truck Company Statement"+ numCounter +".txt");
				outputStream2 = new PrintWriter("C:/wamp64/www/L5 Accounting Java code/public_html2/Food Truck Company Statement"+ numCounter +".html");
				outputStream3 = new PrintWriter("C:/wamp64/www/L5 Accounting Java code/public_html2/Food Truck Company Statement"+ numCounter +".css");
				
				// create outputstream2 comments to set up webpages in html
			    outputStream2.println("<!DOCTYPE html>");
			    outputStream2.println("<html>");
			    outputStream2.println("        <head>");
			    outputStream2.println("                <title>Food Truck Company Statement"+ numCounter +"</title>");
			    outputStream2.println("<meta charset='UTF-8'>");
			    outputStream2.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
				outputStream2.println(" <link rel='stylesheet' href='website.css'>");
				outputStream2.println("        </head>");
				outputStream2.println("<body>");
				//outputStream2.println("<p>");
				outputStream2.println("<nav> <a href='mainpage.html'>Main page</a></nav>");
				outputStream2.println("");
				//outputStream2.println("</p>");
				outputStream2.println("<div>");
				outputStream2.println("<p>");
				
				//css file data inputs
				outputStream3.println(".body{\n");
                outputStream3.println("        height: 100vh;");
                outputStream3.println("        background-size: cover;");
                outputStream3.println("        background-position: center;");
                outputStream3.println("        background-image: url(home_background.jpg);");
                outputStream3.println("}");
				
				//---------------------------------------------------------------------------------------
				// ************************ //
				// ADD VALUES INTO ACCOUNTS //
				// ************************ //
				System.out.println("***************Beginning of transaction" + numCounter+"************************");
				
				outputStream.println("*************Beginning of transaction"+ numCounter+"**********");
				outputStream2.println("<p>*************Beginning of transaction"+ numCounter+"**********</p>");
				
				double bal = Double.parseDouble(values[3]);
				System.out.println("The income for the date " + values[2] + " is: " 
						+ bal);
				
				outputStream.println("The income for the date " + values[2] + " is: " 
						+ bal);
				
				outputStream2.println("<p>The income for the date " + values[2] + " is: " 
						+ bal+"</p>");
				/*
				if (numCounter >= 2)
				{
					accountBalance = bal + getAccountBalance( remainingBalance );
					
					cttaxcollected = setCtTaxCollected(cttaxcollected, newTotalcttaxcollected);
					njtaxcollected = setNjTaxCollected(njtaxcollected, newTotalnjtaxcollected);
					nytaxcollected = setNyTaxCollected( nytaxcollected, newTotalnytaxcollected);
				}
				*/
				
				accountBalance = accountBalance + bal;
				System.out.println("\n The account balance is : " + accountBalance);
				
				outputStream.println("\n The account balance is : " + accountBalance);
				
				outputStream2.println("<p>\n The account balance is : " + accountBalance+"</p>");
				
				double escobal = Double.parseDouble(values[5]);
				escoBalance = escoBalance + escobal;
				
				System.out.println("The tax collected for the date " + values[2] + " is: " 
						+ escobal);
				
				outputStream.println("The tax collected for the date " + values[2] + " is: " 
						+ escobal);
				
				outputStream2.println("<p>The tax collected for the date " + values[2] + " is: " 
						+ escobal+"</p>");
				
				double expenses = Double.parseDouble(values[4]);
				accountBalance = accountBalance - expenses;
				
				
				System.out.println("The expenses for the date " + values[2] + " is: " 
						+ expenses);
				
				outputStream.println("The expenses for the date " + values[2] + " is: " 
						+ expenses);
				
				outputStream2.println("<p>The expenses for the date " + values[2] + " is: " 
						+ expenses+"</p>");
				
				System.out.println("The new account balance is :"+ accountBalance);
				
				outputStream.println("The new account balance is :"+ accountBalance);
				
				outputStream2.println("<p>The new account balance is :"+ accountBalance+"</p>");
				
				// ******************************************************************** //
				// DEPOSIT AMOUNTS INTO EACH ACCOUNT CHECKING AND ESCO PER EACH COMPANY //
				// ******************************************************************** //
				//accountBalance = getAccountBalance(accountBalance);
				double newAccountBalance = depositInChecking(accountBalance, bal);
				
				System.out.println("The new account balance is: " + newAccountBalance);
				outputStream.println("The new account balance is: " + newAccountBalance);
				
				outputStream2.println("<p>The new account balance is: " + newAccountBalance+"</p>");
				
                System.out.println("***************END of transaction" + numCounter+"************************");
				
				outputStream.println("*************END of transaction"+ numCounter+"**********");
				
				outputStream2.println("<p>*************END of transaction"+ numCounter+"**********</p>");
				
				
				if ( values[1] == "NY")
				{
				       newTotalnytaxcollected = nytaxcollected + Double.parseDouble(values[5]);
				       
				       System.out.println("the amount of total ny tax collected is: " +
				       newTotalnytaxcollected);
				       
				       outputStream.println("the amount of total ny tax collected is: " +
						       newTotalnytaxcollected);
				       
				       outputStream2.println("<p>the amount of total ny tax collected is: " +
						       newTotalnytaxcollected+"</p>");
				}
				else if (values[1] == "NJ")
				{
					newTotalnjtaxcollected = njtaxcollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of NJ tax collected is: "+ 
					newTotalnjtaxcollected);
					
					outputStream.println("the amount of NJ tax collected is: "+ 
							newTotalnjtaxcollected);
					
					outputStream2.println("<p>the amount of NJ tax collected is: "+ 
							newTotalnjtaxcollected+"</p>");
				}
				else if (values[1] == "CT")
				{
					newTotalcttaxcollected = cttaxcollected + Double.parseDouble(values[5]);
					
					System.out.println("the amount of CT tax collected is: " + 
					newTotalcttaxcollected);
					
					outputStream.println("the amount of CT tax collected is: " + 
							newTotalcttaxcollected);
					
					outputStream2.println("<p>the amount of CT tax collected is: " + 
							newTotalcttaxcollected+"</p>");
				}
				escoBalance = getEscoBalance(escoBalance);
				double newEscoBalance = depositInEsco(escoBalance, escobal);
				
				accountBalance = getAccountBalance(accountBalance);
				double newAccountBalance1 = depositInChecking(accountBalance, bal);
				
				expenses = getExpenses(expenses);
				double remainingBalance = newAccountBalance1 - expenses;
				
				
                System.out.println("***************Beginning of Statement for Transaction " + numCounter+"************************");
				
				outputStream.println("*************Beginning of Statement for Transaction "+ numCounter+"**********");
				
				outputStream2.println("<p>*************Beginning of Statement for Transaction "+ numCounter+"**********</p>");
				
				System.out.println("The new account balance minus total "+ expenses 
						+ " in expenses is " + remainingBalance);
				
				outputStream.println("The new account balance minus total "+ expenses 
						+ " in expenses is " + remainingBalance);
				
				outputStream2.println("<p>The new account balance minus total "+ expenses 
						+ " in expenses is " + remainingBalance+"</p>");
				
				System.out.println("The new Esco balance is: " + newEscoBalance);
				outputStream.println("The new Esco balance is: " + newEscoBalance);
				outputStream2.println("<p>The new Esco balance is: " + newEscoBalance+"</p>");

				System.out.println(" the total new york tax collected is: " + nytaxcollected);
				outputStream.println("the total new york tax collected is: " + nytaxcollected );
				outputStream2.println("<p>the total new york tax collected is: " + nytaxcollected+"</p>" );
				
				System.out.println(" the total CT tax collected is: " + cttaxcollected);
				outputStream.println("the total CT tax collected is: " + cttaxcollected );
				outputStream2.println("<p>the total CT tax collected is: " + cttaxcollected+"</p>" );
				
				System.out.println(" the total New Jersey tax collected is: " + njtaxcollected);
				outputStream.println("the total New Jersey tax collected is: " + njtaxcollected );
				outputStream2.println("<p>the total New Jersey tax collected is: " + njtaxcollected+"</p>" );
				
                System.out.println("***************END of Statement "+numCounter+"************************");
				
				outputStream.println("*************END of Statement "+ numCounter + "**********************");
				outputStream2.println("<p>*************END of Statement "+ numCounter + "**********************</p>");

				//ending html page statements
				outputStream2.println("</p>");
				outputStream2.println("</div>");
				outputStream2.println(" <nav><a href='mainpage.html'>Main page</a> </nav> ");
				outputStream2.println("               </body>");
				outputStream2.println("        </html>");
	            outputStream.close();
	            outputStream2.close();
	            outputStream3.close();

			}
			System.out.println(" the total new york tax collected is: " + nytaxcollected);
			outputStream.println("the total new york tax collected is: " + nytaxcollected );
			
			System.out.println(" the total CT tax collected is: " + cttaxcollected);
			outputStream.println("the total CT tax collected is: " + cttaxcollected );
			
			System.out.println(" the total New Jersey tax collected is: " + njtaxcollected);
			outputStream.println("the total New Jersey tax collected is: " + njtaxcollected );
			
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

		// **************************** //
		// DISPLAY BALANCE TO TEXT AREA //
		// **************************** //
		public static double displayAccountBalance(double accountBalance){
			accountBalance = FoodTruckAccounts.accountBalance;
			return accountBalance;
		}

		// ******************** //
		// DISPLAY ESCO BALANCE //
		// ******************** //
		public static double displayEscoBalance(double escoBalance){
			escoBalance = FoodTruckAccounts.escoBalance;
			return escoBalance;
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
		public static double setNyTaxCollected( double nytaxcollected, double prevamount){
			nytaxcollected = nytaxcollected + prevamount;
			return nytaxcollected;
		}
		
		//getter for nj tax collected
		public static double setNjTaxCollected(double njtaxcollected, double prevamount){
			njtaxcollected = njtaxcollected + prevamount;
			return njtaxcollected;
		}
		// getter for ct tax collected
		public static double setCtTaxCollected(double cttaxcollected, double prevamount){
			cttaxcollected = cttaxcollected + prevamount;
			return cttaxcollected;
		}


	// *********** //
	// MAIN METHOD //
	// *********** //
	public static void main(String[] args) {
            
              new FoodTruckAccounts();		
	}

	
}