
public class AccountVerification 
{
	public static int isValidUser(String id,String password)
	{
		boolean flag=false;
		int index=0;
		if(AccountVerification.checkPassword(password))
		{
			for(int i=0;i<BankApp.customer.length;i++)
			{
				if(BankApp.customer[i].getUserId().equals(id)&&BankApp.customer[i].getPassword().equals(password))
				{
					flag=true;
					index=i;
					break;
				}
				else
				{
					continue;
				}
			}
		}
		if(flag==true)
			return index;
		else
			return -1;
	}
	public static boolean checkPassword(String password)
	{
		boolean flag=false;
		for(int i=0;i<password.length();i++)
		{
			char ch=password.charAt(i);
			if((ch>='0'&&ch<='9')||(ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z'))
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
}
