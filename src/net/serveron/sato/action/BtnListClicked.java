package net.serveron.sato.action;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;

import net.serveron.sato.util.StringUtil;

public class BtnListClicked extends ActionClass {

	private final String EXTENSION_FILETER = "jpg|png";

	public ArrayList<String> run(String filePath) {
		
		ArrayList<String> model = new ArrayList<>();
		
		if (StringUtil.isNull(filePath)) {
			return model;
		}

		File dir = new File(filePath);
		File[] files = dir.listFiles();
		
		for (File f : files) {
			if (f.isDirectory()) {
				continue;
			}
			String path = f.getAbsolutePath();
			if (StringUtil.isNull(path)) {
				continue;
			}

			int index = path.lastIndexOf(".");
			String ext = path.substring(index + 1).toLowerCase();

			if (isExtension(ext)) {
				model.add(path);
			}
		}
		
		return model;
	}

	private boolean isExtension(String aStr) {
		Pattern p = Pattern.compile(EXTENSION_FILETER);
		Matcher m = p.matcher(aStr);

		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

}
