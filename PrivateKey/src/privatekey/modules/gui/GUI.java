package privatekey.modules.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import privatekey.modules.Main;

public class GUI extends JFrame {

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private static GUI gui;
	
	private View currentView;
	private GroupView groupView;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	private GUI(){
		super("PrivateKey");
		setLayout(new FlowLayout());
		
		this.groupView = new GroupView();
	}
	
	public static GUI get(){
		if(gui == null){
			gui = new GUI();
			gui.setup();
		}
		return gui;
	}
	// ------------------------------- Commands ---------------------------------------- //
	
	private void setup(){
		currentView = groupView;
		currentView.set();
	}
	// ------------------------------- Queries ----------------------------------------- //
}
