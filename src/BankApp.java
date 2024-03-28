import java.util.Scanner;
public class BankApp
{
	static Account[] customer;
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		boolean status=true;
		System.out.println("Welcome to BankApp");
		System.out.println("Please, Define how many customers you want to create");
		System.out.print("=>");
		int size=sc.nextInt();
		sc.nextLine();
		customer=new Account[size];
		int index=0;
		// Main Program for bank app
		while(status)
		{
			System.out.println("----------------------------------------------");
			System.out.println("...............Welcome To Bank.............");
			System.out.println("Select any one option :");
			System.out.println("1. Create New Customer");
			System.out.println("2. Remove Existing Customer");
			System.out.println("3. Access Your Account (Enter User Id and Password)");
			System.out.println("0. Exit");
			System.out.print("=>");
			int option=sc.nextInt();
			sc.nextLine();
			switch(option)
			{
				case 0:
					System.out.println("Thank you!");
					status=false;
					break;
				case 1:
					if(index==size)
					{
						System.out.println("Sorry! No more customers can be created");
					}
					else
					{
						System.out.println("To Create New Customer please specify customer details");
						System.out.print("Enter Customer's Name : ");
						String name=sc.nextLine();
						System.out.print("Enter primary balance : ");
						double balance=sc.nextDouble();
						sc.nextLine();
						System.out.println("Here only saving accounts can be created");
						String type="Saving Account";
						System.out.print("Enter your mobile number : ");
						long mobile=sc.nextLong();
						sc.nextLine();
						System.out.println("Your user id and password will be system generated");
						String id=Integer.toString((int)(Math.random()*(9999-1000+1))+1000);
						String password=Integer.toString((int)(Math.random()*(9999-1000+1))+1000);
						customer[index++]=new Account(name,balance,type,mobile,id,password);
						System.out.println("New Customer Created Successfully, Thanks!");
						System.out.println("User Id : "+customer[index-1].getUserId());
						System.out.println("Password : "+customer[index-1].getPassword());
					}
					break;
				case 2:
						System.out.println("Do you want to remove your account?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						option=sc.nextInt();
						if(option==1)
						{
							boolean flag=true;
							do
							{
								System.out.println("Please! Enter your user id and password .....");
								System.out.print("User Id : ");
								String id=sc.next();
								String password=sc.next();
								sc.nextLine();
								int userindex=AccountVerification.isValidUser(id, password);
								if(userindex>-1)
								{
									for(int i=userindex;i<index;i++)
									{
										customer[i]=customer[i+1];
									}
									index--;
									System.out.println("This account is successfully removed");
								}
								else
								{
									System.out.println("Sorry! userid/password incorrect, try again");
								}
							}while(flag);
						}
						else if(option==2)
						{
							continue;
						}
						else
						{
							System.out.println("Invalid Option!");
						}
					break;
				case 3:
					System.out.println("Do you want to show your account?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					option=sc.nextInt();
					if(option==1)
					{
						boolean flag=true;
						do
						{
							System.out.println("Please! Enter your user id and password .....");
							System.out.print("User Id : ");
							String id=sc.next();
							System.out.print("Password : ");
							String password=sc.next();
							sc.nextLine();
							int userindex=AccountVerification.isValidUser(id, password);
							if(userindex>-1)
							{
								// To write more code here 
								System.out.println("User ID : "+customer[userindex].getUserId());
								System.out.println("Password : "+customer[userindex].getPassword());
								System.out.println("Customer's Name : "+customer[userindex].getName());
								System.out.println("Account Balance : "+customer[userindex].getBalance());
								System.out.println("Account Type : "+customer[userindex].getType());
								System.out.println("Mobile Number : "+customer[userindex].getMobileNumber());
								boolean flag1=true;
								do
								{
									System.out.println("You can do more - ");
									System.out.println("1. Show Balance");
									System.out.println("2. Deposit Money");
									System.out.println("3. Withdraw Money");
									System.out.println("0. Exit");
									option=sc.nextInt();
									switch(option)
									{
										case 1:
												BankService.showBalance(customer[userindex]);
											break;
										case 2:
												System.out.print("Enter amount you want to deposit : ");
												double amt=sc.nextDouble();
												BankService.depositeMoney(customer[userindex], amt);
												BankService.showBalance(customer[userindex]);
											break;
										case 3:
												System.out.print("Enter amount you want to withdraw : ");
												amt=sc.nextDouble();
												BankService.withdrawMoney(customer[userindex], amt);
												BankService.showBalance(customer[userindex]);
											break;
										case 0:
											flag1=false;
									}
								}while(flag1);
								flag=false;
							}
							else
							{
								System.out.println("Sorry! Incorrect userid/password, try again");
							}
						}while(flag);
					}
					else if(option==2)
					{
						continue;
					}
					else
					{
						System.out.println("Invalid Option!");
					}
				break;
				default:
					continue;
			}
			//status=false;
		}
		System.out.println("Thanks for using BankApp................");
	}
}
