package org.team4977.LordDraw;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.team4977.LordDraw.menus.LordDrawMenu;

@SuppressWarnings("serial")
public class LordDraw extends JFrame implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
	static BufferedImage fieldImage;
	static public Dimension wsize;
	Waypoints points = new Waypoints(this);
	public static int selected = -1;
	LordDrawMenu menu = new LordDrawMenu();
	public LordDraw()
	{
		super();
		setResizable(false);
		menu.addActionListener(this);
		setLayout(new BorderLayout());
		add(menu, BorderLayout.NORTH);
		add(points, BorderLayout.CENTER);
		points.setLocation(0, 500);
		setTitle("LordDraw");
		setVisible(true);
		setSize(wsize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		fieldImage = ImageIO.read(new File("field.png"));
		wsize = new Dimension(fieldImage.getHeight()+17, fieldImage.getWidth()+60);
		new LordDraw();
	}


	@Override
	public void mouseClicked(MouseEvent m) {
		if ( m.getButton() == MouseEvent.BUTTON3 && points.len() != 0 )
		{
			selected = points.len();
			points.addWaypoint(m.getPoint());
			System.out.println("New point at ("+m.getX()+", "+m.getY()+")");
		}
		else if ( m.getButton() == MouseEvent.BUTTON3 && points.len() == 0 )
			JOptionPane.showMessageDialog(null, "Select an origin first.");
		else
			System.out.println(points.getContactedPointID(m.getPoint()));
		points.repaint();
		repaint();
		
	}


	@Override
	public void mouseEntered(MouseEvent m) {
	}


	@Override
	public void mouseExited(MouseEvent m) {
	}


	@Override
	public void mousePressed(MouseEvent m) {
		System.out.println("pressed");
		if ( m.getButton() == MouseEvent.BUTTON1 )
		{
			selected = points.getContactedPointID(m.getPoint());
			System.out.println("Dragging "+selected);
		}
		repaint();
	}


	@Override
	public void mouseReleased(MouseEvent m) {
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent m) {
		if ( selected != -1 )
		{
			System.out.println("Moving "+selected+" to "+m.getPoint().toString());
			points.modify(selected, m.getPoint());
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent m) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getKeyCode() == 127 || e.getKeyCode() == 8 )
		{
			if ( selected != -1 )
			{
				points.delete(selected);
				selected = -1;
				repaint();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String cmd = a.getActionCommand();
		
		if ( cmd == "Open..." )
		{
			JFileChooser openFC = new JFileChooser();
			if ( openFC.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
				points.loadFromFile(openFC.getSelectedFile());
		}
		else if ( cmd == "Save..." )
		{
			JFileChooser saveFC = new JFileChooser();
			if ( saveFC.showSaveDialog(this) == JFileChooser.APPROVE_OPTION )
				points.writeToFile(saveFC.getSelectedFile());
		}
		else if ( cmd == "Clear..." )
		{
				int selected = JOptionPane.showConfirmDialog(null, "Clear?");
				if ( selected == 0 ) // 0 is "Yes"
					points.reset();
		}
		else if ( cmd == "Exit" )
			System.exit(0);
		
		// Origin menu
		else if ( cmd == "Red Outside" )
			points.setOrigin(Waypoints.RED_OUTSIDE);
		else if ( cmd == "Red Inside" )
			points.setOrigin(Waypoints.RED_INSIDE);
		else if ( cmd == "Blue Outside" )
			points.setOrigin(Waypoints.BLUE_OUTSIDE);
		else if ( cmd == "Blue Inside" )
			points.setOrigin(Waypoints.BLUE_INSIDE);
		else
			System.out.println("Unhandled action: "+a.getActionCommand());
		
		repaint();
	}

}
