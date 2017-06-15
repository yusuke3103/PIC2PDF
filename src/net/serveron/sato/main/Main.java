package net.serveron.sato.main;

import java.awt.EventQueue;

import net.serveron.sato.view.MenuView;
import net.serveron.sato.view.PIC2PDF;

public class Main{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
