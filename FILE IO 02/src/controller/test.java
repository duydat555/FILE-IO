package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.NOTEPAD;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			NOTEPAD notepad = new NOTEPAD();
			notepad.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
