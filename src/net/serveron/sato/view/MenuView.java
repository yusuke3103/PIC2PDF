package net.serveron.sato.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {
	
	
	private JButton btnMenu1 = new JButton();
	private JButton btnMenu2 = new JButton();

	/**
	 * コンストラクタ
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * 初期化処理
	 */
	private void initialize(){
		btnMenu1.setText("単一処理");
		btnMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuView frame = new MenuView();
				frame.setVisible(true);
			}
		});
		
		btnMenu2.setText("複数処理");
		btnMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		getContentPane().add(btnMenu1, BorderLayout.WEST);
		getContentPane().add(btnMenu2, BorderLayout.EAST);
		
	}
	
}
