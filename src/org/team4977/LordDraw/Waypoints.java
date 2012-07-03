package org.team4977.LordDraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class Waypoints extends JPanel {
	Vector<Point> points = new Vector<Point>();
	
	static public Point RED_OUTSIDE = new Point(347, 426);
	static public Point RED_INSIDE = new Point(433, 426);
	
	static public Point BLUE_OUTSIDE = new Point(42,119);
	static public Point BLUE_INSIDE = new Point(42,40);
	
	public Waypoints(LordDraw ml)
	{
		super();
		addMouseListener(ml);
		addMouseMotionListener(ml);
		addKeyListener(ml);
		setPreferredSize(LordDraw.wsize);
		
		setVisible(true);
	}
	
	public void loadFromFile(File f)
	{
		try {
			BufferedReader fReader = new BufferedReader(new FileReader(f));
			LordDraw.selected = -1;
			points = new Vector<Point>();
			while ( fReader.ready() )
			{
				String[] thisLine = fReader.readLine().split(",");
				if ( thisLine.length == 2 )
				{
					Point p = new Point(Integer.parseInt(thisLine[0]), Integer.parseInt(thisLine[1]));
					points.add(p);
					System.out.println(p.toString());
				}
			}
		} catch (Throwable e) {
			System.out.println("Failed to open file");
			e.printStackTrace();
		}
	}
	
	public void writeToFile(File selectedFile)
	{
		try
		{
			if ( !selectedFile.exists() )
				selectedFile.createNewFile();
			FileWriter fWriter = new FileWriter(selectedFile);
			for ( int i = 0; i < points.size(); i++ )
			{
				Point p = points.get(i);
				fWriter.write((int)p.getX()+","+(int)p.getY()+"\n");
			}
			fWriter.flush();
			fWriter.close();
		} catch ( Throwable e )
		{
			e.printStackTrace();
		}
	}
	
	public void setOrigin(Point p)
	{
		if ( points.size() == 0 )
			points.add(0, p);
		else points.get(0).setLocation(p.getX(), p.getY());
	}
	
	public void addWaypoint(Point p)
	{
		points.add(p);
	}
	
	public void modify(int pID, Point newPosition)
	{
		points.get(pID).setLocation(newPosition.getX(), newPosition.getY());
	}
	
	public void delete(int pID)
	{
		points.remove(pID);
	}
	
	public void reset()
	{
		for ( int i = 0; i < points.size(); i++ )
			delete(i);
		points = new Vector<Point>();
		LordDraw.selected = -1;
	}
	
	public int getContactedPointID(Point mouse)
	{
		for ( int i = 0; i < points.size(); i++ )
		{
			Point thisPoint = points.get(i);
			if ( (new Rectangle2D.Double(thisPoint.getX()-10, thisPoint.getY()-10, 20, 20)).contains(mouse) && i != 0 )
			{
				return i;
			}
		}
		
		return -1;
	}
	
	@Override 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(LordDraw.fieldImage, 0, 0, Color.white, null);
		Point previousPoint = null;
		boolean previousWasSelected = false;
		for ( int i = 0; i < points.size(); i++ )
		{
			Point p = points.get(i);
			if ( i == LordDraw.selected )
				g.setColor(Color.GREEN);

			g.fillRect((int)p.getX()-10, (int)p.getY()-10, 20, 20);
			
			if ( previousPoint != null )
			{
				if ( previousWasSelected )
					g.setColor(Color.GREEN);
				g.drawLine((int)p.getX(), (int)p.getY(), (int)previousPoint.getX(), (int)previousPoint.getY());
			}
			
			g.setColor(Color.GRAY);
			previousPoint = p;
			previousWasSelected = (i == LordDraw.selected);
		}
    }
	
	public int len()
	{
		return points.size();
	}
	
	public Point getPoint(int i)
	{
		return points.get(i);
	}

}
