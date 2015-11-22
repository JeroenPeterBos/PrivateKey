package privatekey.modules.administratie;

public class Administrator {
	// -------------------------------- Instance Variables -------------------------------- //
	
	// -------------------------------- Constructors -------------------------------------- //
	
	// -------------------------------- Commands ------------------------------------------ //
	
	/**
	 * Adds a new user <code>Account</code> to the database and adds a newly generated encrypted password.
	 * @param service name of the new service 
	 * @param username the username you will have for this <code>Service</code>
	 * @param superSecretKey the personal key for encryption
	 */
	public void addAccount(Service service, String username, String superSectretKey){
		
	}
	
	/**
	 * Adds a new <code>Service</code> to the database.
	 * @param service the service to add to the database.
	 */
	public void addService(Service service){
		
	}
	
	// -------------------------------- Queries ------------------------------------------- //

	/**
	 * Returns a list of all services at which an account is registered.
	 * @return list of services
	 */
	public Service[] allServices(){
		return null;
	}
	
	public Account[] allAccounts(Service service){
		return null;
	}
}
