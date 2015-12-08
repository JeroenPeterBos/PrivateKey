package privatekey.modules.administratie.elements;

import privatekey.modules.administratie.Element;

public class Account extends Element{
	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Service service;
	private int passCipher;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Account(Service service, String userName, int passCipher){
		super(userName, -1);
		this.service = service;
		this.passCipher = passCipher;
	}
	
	public Account(int account_id, Service service, String userName, int passCipher){
		super(userName, account_id);
		this.service = service;
		this.passCipher = passCipher;
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	// ------------------------------- Queries ----------------------------------------- //
	
	public Service getService(){
		return service;
	}
	
	public int getPassCipher(){
		return passCipher;
	}
}
