package net.serveron.sato.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.serveron.sato.action.BtnListClicked;
import net.serveron.sato.action.BtnOutPutPDFClicked;
import net.serveron.sato.action.BtnReferenceClicked;
import net.serveron.sato.util.StringUtil;

public class PIC2PDF extends JFrame {

	private JPanel contentPane;
	private JLabel lblSourcePath;
	private JTextField txtSourcePath;
	private JButton btnReference;
	private JButton btnList;
	private JButton btnOutPutPDF;
	private JScrollPane scrollPane;
	private JTable table;

	private DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Create the frame.
	 */
	public PIC2PDF() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		lblSourcePath = new JLabel("取得元 ： ");
		lblSourcePath.setBounds(12, 10, 63, 13);

		txtSourcePath = new JTextField();
		txtSourcePath.setBounds(78, 7, 267, 19);

		txtSourcePath.setColumns(10);

		btnReference = new JButton("参照");
		btnReference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnReferenceClicked rc = new BtnReferenceClicked();
				String path = rc.run();
				txtSourcePath.setText(path);
			}
		});
		btnReference.setBounds(359, 6, 63, 21);

		btnList = new JButton("ファイル一覧取得");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnListClicked blc = new BtnListClicked();
				ArrayList<String> list = blc.run(txtSourcePath.getText());
				for (int i = 0; i < list.size(); i++) {
					tableModel.addRow(new Object[] { list.get(i) });
				}
			}
		});
		btnList.setBounds(12, 33, 410, 21);

		btnOutPutPDF = new JButton("PDF出力");
		btnOutPutPDF.setBounds(12, 219, 410, 21);
		btnOutPutPDF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BtnOutPutPDFClicked boppc = new BtnOutPutPDFClicked();
				String path = boppc.run();
				if (!StringUtil.isNull(path)) {
					ProgressView pv = new ProgressView(null, "メッセージ", "", 0, tableModel.getRowCount());
					pv.createPDF(path, tableModel);
				}
			}
		});

		setContentPane(contentPane);
		contentPane.add(lblSourcePath);
		contentPane.add(txtSourcePath);
		contentPane.add(btnReference);
		contentPane.add(btnList);
		contentPane.add(btnOutPutPDF);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 64, 410, 145);
		contentPane.add(scrollPane);

		table = new JTable();
		tableModel.addColumn("PATH");
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

	}
}
