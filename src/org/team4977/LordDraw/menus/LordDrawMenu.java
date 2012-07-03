package org.team4977.LordDraw.menus;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;


@SuppressWarnings("serial")
public class LordDrawMenu extends JMenuBar {
	FileMenu file = new FileMenu();
	OriginMenu startpoint = new OriginMenu();
	public LordDrawMenu()
	{
		super();
		add(file);
		add(startpoint);
	}
	
	public void addActionListener(ActionListener al)
	{
		file.addActionListener(al);
		startpoint.addActionListener(al);
	}
}
