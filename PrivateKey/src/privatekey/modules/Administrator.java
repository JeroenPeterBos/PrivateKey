package privatekey.modules;

import java.util.ArrayList;

import privatekey.modules.administratie.elements.Account;
import privatekey.modules.administratie.elements.Group;
import privatekey.modules.administratie.elements.Service;
import privatekey.modules.administratie.sql.Sql;

public class Administrator {
	// -------------------------------- Instance Variables -------------------------------- //
	
	private Sql sql;
	private ArrayList<Group> groups;

	// -------------------------------- Constructors -------------------------------------- //
	
	public Administrator(){
		this.sql = new Sql();
		this.groups = sql.getGroups();
	}
	// -------------------------------- Commands ------------------------------------------ //
	
	/**
	 * Adds a new user <code>Account</code> to the database and adds a newly generated encrypted password.
	 * @param service name of the new service 
	 * @param username the username you will have for this <code>Service</code>
	 * @param superSecretKey the personal key for encryption
	 */
	public void addAccount(Service service, String username, String superSectretKey){
		int passCipher = 0;
		Account acc = new Account(service, username, passCipher);
		
		service.add(acc);
		sql.add(acc);
	}
	
	/**
	 * Adds a new <code>Service</code> to the database.
	 * @param service the service to add to the database.
	 */
	public void addService(Group group, String name){
		Service ser = new Service(group, name, 0);
		
		group.add(ser);
		sql.add(ser);
	}
	
	/**
	 * Adds a <code>Group</code> to the database
	 * @param group the group to add to the database.
	 */
	public void addGroup(String name){
		Group gro = new Group(name, 0);
		
		// TODO: add gro to group array
		sql.add(gro);
	}
	
	/**
	 * Edits the account in the database.
	 * @param oldAccount the account that is being modified
	 * @param newAccount the new status of the account
	 */
	public void editAccount(Account oldAccount, Account newAccount){
		
	}
	
	/**
	 * Edits the Service in the database.
	 * @param oldService the Service that is being modified
	 * @param newService the new status of the Service
	 */
	public void editService(Service oldService, Service newService){
		
	}
	
	/**
	 * Edits the Group in the database.
	 * @param oldGroup the Group that is being modified
	 * @param newGroup the new status of the Group
	 */
	public void editGroup(Group oldGroup, Group newGroup){
		
	}
	
	/**
	 * Deletes a certain account from the database.
	 * @param account the account to be deleted
	 */
	public void removeAccount(Account account){
		
	}
	
	/**
	 * Deletes a certain Service from the database.
	 * @param service the service to be deleted
	 */
	public void removeService(Service service){
		
	}
	
	/**
	 * Deletes a certain Group from the database.
	 * @param group the group to be deleted
	 */
	public void removeGroup(Group group){
		
	}
	
	// -------------------------------- Queries ------------------------------------------- //

	/**
	 * Returns a list of all the groups in the database;
	 * @return list of groups
	 */
	public ArrayList<Group> getGroups(){
		return groups;
	}
	
	/**
	 * Returns a list of all services in a certain category which an account is registered.
	 * @param group group which in the services are
	 * @return list of services
	 */
	public ArrayList<Service> getServices(Group group){
		if(group.getServices() == null){
			group.setServices(sql.getServices(group));
		}
		return group.getServices();
	}
	
	/**
	 * Returns all accounts registered at this service.
	 * @param service the service from which the accounts are requested.
	 * @return list of accounts.
	 */
	public ArrayList<Account> getAccounts(Service service){
		if(service.getAccounts() == null){
			service.setAccounts(sql.getAccounts(service));
		}
		return service.getAccounts();
	}
	
	// ----------------------------------- Dev Methods -------------------------------------------- //
	
	public static void main(String[] args){
		Administrator admin = new Administrator();
		
		ArrayList<Group> groups = admin.getGroups();
		for(Group g: groups){
			System.out.println("Group: " + g.getName() + " , " + g.getId() + " , " + g.getNoServices());
		}
		
		ArrayList<Service> services = admin.getServices(groups.get(0));
		for(Service s: services){
			System.out.println("Service: " + s.getGroup().getId() + " , " + s.getName() + " , " + s.getId() + " , " + s.getNoAccounts());
		}
		
		ArrayList<Account> accounts = admin.getAccounts(services.get(0));
		for(Account a: accounts){
			System.out.println("Account: " + a.getService().getGroup() + " , " + a.getName() + " , " + a.getId() + " , " + a.getPassCipher());
		}
	}
}
