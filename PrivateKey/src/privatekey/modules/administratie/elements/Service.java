package privatekey.modules.administratie.elements;

import java.util.ArrayList;

import privatekey.modules.administratie.Element;

public class Service extends Element{
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Group group;
	private ArrayList<Account> accounts;
	private int numberOfAccounts;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Service(Group group, String name, int numberOfAccounts){
		super(name, -1);
		this.numberOfAccounts = numberOfAccounts;
		this.group = group;
	}
	
	public Service(int service_id, Group group, String name, int numberOfAccounts){
		super(name, service_id);
		this.group = group;
		this.numberOfAccounts = numberOfAccounts;
	}
	
	public Service(int service_id, Group group, String name, ArrayList<Account> accounts){
		super(name, service_id);
		this.accounts = accounts;
		this.numberOfAccounts = accounts.size();
		this.group = group;
	}
	// ------------------------------- Commands ---------------------------------------- //
	
	public void incrementNoA(){	numberOfAccounts++;	}
	
	public void decrementNoA(){	numberOfAccounts--;	}
	
	public void setAccounts(ArrayList<Account> accounts){
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
	
	public ArrayList<Account> getAccounts(){
		return accounts;
	}
}
