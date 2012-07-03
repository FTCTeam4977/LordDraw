import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;


public class Waypoints extends JPanel {
	Vector<Point> points = new Vector<Point>();
	public Waypoints(LordDraw ml)
	{
		super();
		addMouseListener(ml);
		addMouseMotionListener(ml);
		setPreferredSize(LordDraw.size);
		setVisible(true);
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
	
	public int getContactedPointID(Point mouse)
	{
		for ( int i = 0; i < points.size(); i++ )
		{
			Point thisPoint = points.get(i);
			if ( (new Rectangle2D.Double(thisPoint.getX()-10, thisPoint.getY()-10, 20, 20)).contains(mouse) )
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
		for ( int i = 0; i < points.size(); i++ )
		{
			Point p = points.get(i);
			if ( i == LordDraw.selected )
				g.setColor(Color.GREEN);
			g.fillRect((int)p.getX()-10, (int)p.getY()-10, 20, 20);
			g.setColor(Color.GRAY);
			if ( previousPoint != null )
				g.drawLine((int)p.getX(), (int)p.getY(), (int)previousPoint.getX(), (int)previousPoint.getY());
			previousPoint = p;
		}
    }
}
