package privatekey.modules.administratie.sql;

import privatekey.modules.administratie.elements.Account;
import privatekey.modules.administratie.elements.Group;
import privatekey.modules.administratie.elements.Service;

public class Sql {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Sql(){
		// TODO: setup sql db connection;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	public void add(Group group){
		
	}
	
	public void add(Service service){
		
	}
	
	public void add(Account account){
		
	}
	
	public void edit(Group oldGroup, Group newGroup){
		
	}
	
	public void edit(Service oldService, Service newService){
		
	}
	
	public void edit(Account oldAccount, Account newAccount){
		
	}
	
	public void remove(Group group){
		
	}
	
	public void remove(Service service){
		
	}
	
	public void remove(Account account){
		
	}
	// ------------------------------- Queries ----------------------------------------- //
	
	public Group[] getGroups(){
		return null;
	}
	
	public Service[] getServices(Group group){
		return null;
	}
	
	public Account[] getAccounts(Service service){
		return null;
	}
}
