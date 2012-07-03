package org.team4977.LordDraw.menus;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class OriginMenu extends JMenu {
	JMenuItem red1 = new JMenuItem("Red Outside");
	JMenuItem red2 = new JMenuItem("Red Inside");
	JMenuItem blue1 = new JMenuItem("Blue Outside");
	JMenuItem blue2 = new JMenuItem("Blue Inside");
	public OriginMenu()
	{
		super("Origin");
		add(red1);
		add(red2);
		add(blue1);
		add(blue2);
	}
	
	public void addActionListener(ActionListener al)
	{
		red1.addActionListener(al);
		red2.addActionListener(al);
		blue1.addActionListener(al);
		blue2.addActionListener(al);
	}
}
