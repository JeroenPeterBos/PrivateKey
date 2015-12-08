package privatekey.modules.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import privatekey.modules.Administrator;
import privatekey.modules.Main;

public class GroupView implements View {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private JLabel text;
	private JComboBox groups;
	private JButton button;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public GroupView(){		
		text = new JLabel("Select a category");		
		
		Administrator admin = Administrator.get();
		
		String[] options = admin.getNames(admin.allGroups());
		groups = new JComboBox(options);
	}
	
	// ------------------------------- Commands ---------------------------------------- //
	
	public void set(){
		GUI.get().add(text);
		GUI.get().add(groups);
	}
	
	
	public void close(){
		
	}
	// ------------------------------- Queries ----------------------------------------- //
	
}
