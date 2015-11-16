package net.serveron.sato.view;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ProgresView extends JDialog {
	private JProgressBar progressBar;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblCounter;
	private JLabel lblTotal;
	private DefaultTableModel model;
	private String path;
	private JButton btnOK;

	/**
	 * Create the dialog.
	 */
	public ProgresView(DefaultTableModel aModel, String aPath) {
		model = aModel;
		path = aPath;
		getContentPane().setLayout(null);
		initialize();
	}

	private void initialize() {
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 46, 285, 14);
		getContentPane().add(progressBar);

		label = new JLabel("出力中");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 285, 26);
		getContentPane().add(label);

		label_1 = new JLabel("／");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(208, 88, 26, 26);
		getContentPane().add(label_1);

		label_2 = new JLabel("件");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(271, 88, 26, 26);
		getContentPane().add(label_2);

		lblCounter = new JLabel("00000");
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounter.setBounds(171, 88, 39, 26);
		getContentPane().add(lblCounter);

		lblTotal = new JLabel("00000");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(233, 88, 39, 26);
		getContentPane().add(lblTotal);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(107, 124, 91, 21);
		btnOK.setVisible(false);
		getContentPane().add(btnOK);

		createPDF();
	}

	public void createPDF() {
		
		int total = model.getRowCount();
		lblTotal.setText(String.valueOf(total));
		int now = 0;
		float progress = total / 100f;
		PDDocument doc = new PDDocument();
		try {
			for (int i = 0; i < model.getRowCount(); i++) {
				lblCounter.setText(String.valueOf(i + 1));
				now += progress;
				progressBar.setValue(now);
				
				String imgPath = model.getValueAt(i, 0).toString();
				File f = new File(imgPath);
				BufferedImage bi = ImageIO.read(f);

				PDRectangle rec = new PDRectangle();
				rec.setUpperRightX(0);
				rec.setUpperRightY(0);
				rec.setLowerLeftX(bi.getWidth());
				rec.setLowerLeftY(bi.getHeight());

				bi.flush();

				PDPage page = new PDPage(rec);

				doc.addPage(page);

				PDPageContentStream contents = new PDPageContentStream(doc,
						page);

				PDImageXObject pdImageXObject = PDImageXObject.createFromFile(
						imgPath, doc);

				contents.drawImage(pdImageXObject, 0, 0);

				// ストリームを閉じる
				contents.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// pdfファイルを出力
				doc.save(path);
				doc.close();
				label.setText("出力完了");
			} catch (Exception e) {
				label.setText("出力失敗");
			}
		}
	}
}
