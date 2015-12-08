package privatekey.modules;

import javax.swing.JFrame;

import privatekey.modules.gui.GUI;

public class Main {
	
	public static void main(String[] args){
		
		GUI gui = GUI.get();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gui.setSize(500, 200);
		gui.setVisible(true);
	}
}
