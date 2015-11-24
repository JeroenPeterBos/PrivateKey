package privatekey.modules.administratie.elements;

import privatekey.modules.administratie.Element;

/**
 * 
 * @author Jeroen
 * @version v0.1
 */
public class Group extends Element{

	// -------------------------------- Instance Variables -------------------------------- //
	
	private int numberOfServices;
	private Service[] services;
	
	// -------------------------------- Constructors -------------------------------------- //
	
	/**
	 * Creates a new <code>Group</code> with a given name and numberOfServices it contains.
	 * @param name the name of the group
	 * @param numberOfServices the number of services it has
	 */
	public Group(String name, int numberOfServices){
		super(name, -1);
		this.numberOfServices = numberOfServices;
	}
	
	public Group(int group_id, String name, int numberOfServices){
		super(name, group_id);
		this.numberOfServices = numberOfServices;
	}
	
	/**
	 * Creates a new <code>Group</code> with the given name and the services.
	 * @param name the name of the group
	 * @param services the list of services belonging to this group.
	 */
	public Group(int group_id, String name, Service[] services){
		super(name, group_id);
		this.services = services;
		this.numberOfServices = services.length;
	}
	// -------------------------------- Commands ------------------------------------------ //
	/**
	 * Increases the numberOfServicesCounter by one.
	 */
	public void incrementNoS(){
		numberOfServices++;
	}
	
	/**
	 * Decreases the numberOfServicesCounter by one.
	 */
	public void decrementNoS(){
		numberOfServices--;
	}
	
	/**
	 * Sets the list of services to the provided list.
	 * @param services list of services
	 */
	public void setServices(Service[] services){
		this.services = services;
	}
	
	public void add(Service service){
		
	}
	
	public void edit(Service oldService, Service newService){
		
	}
	
	public void remove(Service service){
		
	}
	
	// -------------------------------- Queries ------------------------------------------- //
	
	/**
	 * Returns the number of services belonging to this group.
	 * @return the number of services
	 */
	public int getNoServices(){
		return numberOfServices;
	}
	
	/**
	 * Returns the list containing the services
	 * @return list of services
	 */
	public Service[] getServices(){
		return services;
	}
}