package net.serveron.sato.view;

import javax.swing.*;

public class PIC2PDFVer2 extends JFrame{

	private JLabel lblWorkDir = new JLabel();
	private JTextField txtWorkDir = new JTextField();
	private JButton btnFilePref = new JButton();
	private JButton btnExecute = new JButton();
	
	
	public PIC2PDFVer2(){
		getContentPane().setLayout(null);
		initialize();
	}
	
	private void initialize(){
		lblWorkDir.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkDir.setLocation(12, 10);
		lblWorkDir.setSize(72, 20);
		lblWorkDir.setText("作業フォルダ");

		txtWorkDir.setSize(254, 20);
		txtWorkDir.setLocation(96, 11);
		
		btnFilePref.setText("参照");
		btnFilePref.setLocation(362, 10);
		btnFilePref.setSize(60, 20);
		
		btnExecute.setText("実行");
		btnExecute.setLocation(12, 40);
		btnExecute.setSize(410, 20);
		
		getContentPane().add(lblWorkDir);
		getContentPane().add(txtWorkDir);
		getContentPane().add(btnFilePref);
		getContentPane().add(btnExecute);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 70, 410, 181);
		getContentPane().add(textArea);
	}
}
