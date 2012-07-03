package org.team4977.LordDraw.menus;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu
{
	JMenuItem open = new JMenuItem("Open...");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem saveAs = new JMenuItem("Save as...");
	JMenuItem clear = new JMenuItem("Clear...");
	JMenuItem exit = new JMenuItem("Exit");
	public FileMenu()
	{
		super("File");
		add(open);
		add(save);
		add(saveAs);
		add(clear);
		add(exit);
	}
	
	public void addActionListener(ActionListener al)
	{
		open.addActionListener(al);
		save.addActionListener(al);
		saveAs.addActionListener(al);
		clear.addActionListener(al);
		exit.addActionListener(al);
	}
}
