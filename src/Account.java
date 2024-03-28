// This class can create an object to keep data of an account holder
public class Account 
{
	private String name;
	private double balance;
	private String type;
	private long mobile;
	private String id;
	private String password;
	
	// Code for parameterised constructor 
	public Account(String name,double balance,String type,long mobile,String id,String password)
	{
		this.name=name;
		this.balance=balance;
		this.type=type;
		this.mobile=mobile;
		this.id=id;
		this.password=password;
	}
	
	// Code for all setters
	public void setName(String name)
	{
		this.name=name;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	public void setMobileNumber(long mobile)
	{
		this.mobile=mobile;
	}
	/*private void setUserId(String id)
	{
		this.id=id;
	}
	private void setPassword(String password)
	{
		this.password=password;
	}*/
	// Code for all getters
	public String getName()
	{
		return this.name;
	}
	public double getBalance()
	{
		return this.balance;
	}
	public String getType()
	{
		return this.type;
	}
	public long getMobileNumber()
	{
		return this.mobile;
	}
	public String getUserId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
}
