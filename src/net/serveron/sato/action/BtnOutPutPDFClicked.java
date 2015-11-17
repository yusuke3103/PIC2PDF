package net.serveron.sato.action;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.ProgressMonitor;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class BtnOutPutPDFClicked {
	public String run( ) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
		int selected = filechooser.showSaveDialog(null);
		if (selected == 0) {
			String path = filechooser.getSelectedFile().getAbsolutePath();
			String extension = ".pdf";
			return path + extension;
		}
		return "";
	}

//	public void createPDF(String path, DefaultTableModel model) {
//		ProgressMonitor pm = new ProgressMonitor(null, "変換中", "", 0, fileCount);
//		int fileCount = model.getRowCount();
//		
//		
//		PDDocument doc = new PDDocument();
//		try {
//			for (int i = 0; i < fileCount; i++) {
//
//				pm.setNote(i + "/" + fileCount);
//				pm.setProgress(i);
//				
//				
//				String imgPath = model.getValueAt(i, 0).toString();
//				File f = new File(imgPath);
//				BufferedImage bi = ImageIO.read(f);
//
//				PDRectangle rec = new PDRectangle();
//				rec.setUpperRightX(0);
//				rec.setUpperRightY(0);
//				rec.setLowerLeftX(bi.getWidth());
//				rec.setLowerLeftY(bi.getHeight());
//
//				bi.flush();
//
//				PDPage page = new PDPage(rec);
//
//				doc.addPage(page);
//
//				PDPageContentStream contents = new PDPageContentStream(doc,
//						page);
//
//				PDImageXObject pdImageXObject = PDImageXObject.createFromFile(
//						imgPath, doc);
//
//				contents.drawImage(pdImageXObject, 0, 0);
//
//				// ストリームを閉じる
//				contents.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// pdfファイルを出力
//				doc.save(path);
//				doc.close();
//			} catch (Exception e) {
//			}
//		}
//	}
}
