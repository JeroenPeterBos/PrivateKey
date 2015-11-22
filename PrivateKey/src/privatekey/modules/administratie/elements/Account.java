package privatekey.modules.administratie.elements;

import privatekey.modules.administratie.Element;

public class Account extends Element{
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Service service;
	private int passCipher;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Account(Service service, String userName, int passCipher){
		super(userName);
		this.service = service;
		this.passCipher = passCipher;
	}
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	public Service getService(){
		return service;
	}
	
	public String getUserName(){
		return getName();
	}
	
	public int getPassCipher(){
		return passCipher;
	}
}
