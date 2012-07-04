package org.team4977.LordDraw.menus;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FileMenu extends JMenu
{
	JMenuItem open = new JMenuItem("Open...");
	JMenuItem save = new JMenuItem("Save...");
	JMenuItem export = new JMenuItem("Export");
	JMenuItem clear = new JMenuItem("Clear...");
	JMenuItem exit = new JMenuItem("Exit");
	public FileMenu()
	{
		super("File");
		add(open);
		add(save);
		add(export);
		add(clear);
		add(exit);
	}
	
	public void addActionListener(ActionListener al)
	{
		open.addActionListener(al);
		save.addActionListener(al);
		export.addActionListener(al);
		clear.addActionListener(al);
		exit.addActionListener(al);
	}
}
