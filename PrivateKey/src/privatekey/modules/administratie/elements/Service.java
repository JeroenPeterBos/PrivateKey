package privatekey.modules.administratie.elements;

import privatekey.modules.administratie.Element;

public class Service extends Element{
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Group group;
	private Account[] accounts;
	private int numberOfAccounts;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Service(Group group, String name, int numberOfAccounts){
		super(name, -1);
		this.numberOfAccounts = numberOfAccounts;
		this.group = group;
		this.accounts = new Account[0];
	}
	
	public Service(int service_id, Group group, String name, Account[] accounts){
		super(name, service_id);
		this.accounts = accounts;
		this.numberOfAccounts = accounts.length;
		this.group = group;
	}
	// ------------------------------- Commands ---------------------------------------- //
	
	public void incrementNoA(){	numberOfAccounts++;	}
	
	public void decrementNoA(){	numberOfAccounts--;	}
	
	public void setAccounts(Account[] accounts){
		this.accounts = accounts;
	}
	
	public void add(Account account){
		
	}
	
	public void edit(Account oldAccount, Account newAccount){
		
	}
	
	public void remove(Account account){
		
	}
	
	// ------------------------------- Queries ----------------------------------------- //
	
	public Group getGroup(){
		return group;
	}
	
	public int getNoAccounts(){	return numberOfAccounts;	}
	
	public Account[] getAccounts(){
		return accounts;
	}
}
