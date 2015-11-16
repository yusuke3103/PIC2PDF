package net.serveron.sato.action;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BtnOutPutPDFClicked {
	public String run() {
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

	
}
