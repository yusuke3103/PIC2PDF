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
	 * �R���X�g���N�^
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * ����������
	 */
	private void initialize(){
		btnMenu1.setText("�P�ꏈ��");
		btnMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuView frame = new MenuView();
				frame.setVisible(true);
			}
		});
		
		btnMenu2.setText("��������");
		btnMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		getContentPane().add(btnMenu1, BorderLayout.WEST);
		getContentPane().add(btnMenu2, BorderLayout.EAST);
		
	}
	
}
