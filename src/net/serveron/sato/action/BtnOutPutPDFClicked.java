package net.serveron.sato.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class BtnOutPutPDFClicked {
	public void run(ArrayList<String> file) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
		int selected = filechooser.showSaveDialog(null);
		if (selected == 0) {
			String path = filechooser.getSelectedFile().getAbsolutePath();
			String extension = ".pdf";
			createPDF(file);
		}
	}

	private void createPDF(ArrayList<String> file) {

		try {
			PDDocument doc = new PDDocument();

			File f = new File("D:\\Users\\yusuke\\Desktop\\第06巻\\[井上智徳] COPPELION -コッペリオン- 第06巻\\000.jpg");
			BufferedImage bi = ImageIO.read(f);
			
			PDRectangle rec = new PDRectangle();
		    rec.setUpperRightX(0);
		    rec.setUpperRightY(0);
		    rec.setLowerLeftX(bi.getWidth());
		    rec.setLowerLeftY(bi.getHeight());
			
			PDPage page = new PDPage(rec);
			
			
			doc.addPage(page);

			PDPageContentStream contents = new PDPageContentStream(doc, page);
			
			PDImageXObject pdImageXObject = PDImageXObject.createFromFile("D:\\Users\\yusuke\\Desktop\\第06巻\\[井上智徳] COPPELION -コッペリオン- 第06巻\\000.jpg", doc);
			
			contents.drawImage(pdImageXObject,0,0);
			
	        // ストリームを閉じる
	        contents.close();
	        // pdfファイルを出力
	        doc.save("c:\\sample.pdf");
	        doc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
