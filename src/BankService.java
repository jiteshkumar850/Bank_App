
public class BankService 
{
	public static void showBalance(Account account)
	{
		System.out.println("Your current balance is "+account.getBalance());
	}
	public static void depositeMoney(Account account,double amount)
	{
		account.setBalance(account.getBalance()+amount);
		System.out.println("Your account is creadited by "+amount);
	}
	public static void withdrawMoney(Account account,double amount)
	{
		if(amount<=account.getBalance())
		{
			account.setBalance(account.getBalance()-amount);
			System.out.println("Rs. "+amount+" is successfully debited from your account.");
		}
	}
}
