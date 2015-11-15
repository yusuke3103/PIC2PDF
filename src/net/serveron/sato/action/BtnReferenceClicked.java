package net.serveron.sato.action;

import javax.swing.JFileChooser;

public class BtnReferenceClicked extends ActionClass {

	public String run() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int selected = jFileChooser.showOpenDialog(null);
		String filePath = "";
		if (selected == 0) {
			filePath = jFileChooser.getSelectedFile().getAbsolutePath();
		}
		return filePath;
	}

}
