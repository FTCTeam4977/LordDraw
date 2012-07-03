import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.Vector;




public class LordDraw extends Frame implements MouseListener  {
	Vector<Ellipse2D.Double> pointList = new Vector<Ellipse2D.Double>();
	public LordDraw()
	{
		Dimension size = new Dimension(800,600);
		setSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setLayout(null);
		setVisible(true);
		addMouseListener(this);

	}
	
	public static void main(String[] args) {
		new LordDraw();
	}


	@Override
	public void mouseClicked(MouseEvent m) {
		if ( m.getButton() == m.BUTTON3 )
		{
			Ellipse2D.Double thisCircle = new Ellipse2D.Double(m.getX(), m.getY(), 1,1);
			pointList.add(thisCircle);
			System.out.println("Right click at ("+m.getX()+", "+m.getY()+")");
			//window.add(thisCircle);
			
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
