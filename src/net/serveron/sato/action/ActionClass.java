package net.serveron.sato.action;

import java.awt.Component;


public abstract class ActionClass {
	private Component comp = null;

	/**
	 * @return comp
	 */
	public Component getComp() {
		return comp;
	}

	/**
	 * @param comp 設定する comp
	 */
	public void setComp(Component comp) {
		this.comp = comp;
	}
	
}
