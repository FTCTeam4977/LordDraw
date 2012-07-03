import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;


public class Waypoints extends JPanel {
	Vector<Point> points = new Vector<Point>();
	public Waypoints(MouseListener ml)
	{
		super();
		addMouseListener(ml);
		setPreferredSize(LordDraw.size);
		setVisible(true);
	}
	
	public void addWaypoint(Point p)
	{
		points.add(p);
	}
	
	@Override 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(LordDraw.fieldImage, 0, 0, Color.white, null);
		Iterator<Point> it = points.iterator();
		Point previousPoint = null;
		while ( it.hasNext() )
		{
			Point p = it.next();
			g.fillRect((int)p.getX()-10, (int)p.getY()-10, 20, 20);
			
			if ( previousPoint != null )
				g.drawLine((int)p.getX(), (int)p.getY(), (int)previousPoint.getX(), (int)previousPoint.getY());
			previousPoint = p;
		}
    }
}
