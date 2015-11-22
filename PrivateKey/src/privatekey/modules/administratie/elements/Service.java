package privatekey.modules.administratie.elements;

import privatekey.modules.administratie.Element;

public class Service extends Element{
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Account[] accounts;
	private int numberOfAccounts;
	private Group group;
	// ------------------------------- Constructors ------------------------------------ //
	
	public Service(String name, Group group, int numberOfAccounts){
		super(name);
		this.numberOfAccounts = numberOfAccounts;
		this.group = group;
	}
	
	public Service(String name, Group group, Account[] accounts){
		super(name);
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
	// ------------------------------- Queries ----------------------------------------- //
	
	public int getNoAccounts(){	return numberOfAccounts;	}
	
	public Account[] getAccounts(){
		return accounts;
	}
}
