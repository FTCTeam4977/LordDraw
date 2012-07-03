import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class LordDraw extends JFrame implements MouseListener  {
	static BufferedImage fieldImage;
	static public Dimension size;
	Waypoints points = new Waypoints(this);
	
	public LordDraw()
	{
		super();
		
		add(points);
		setTitle("LordDraw");
		setVisible(true);
		setSize(size);
		points.addWaypoint(new Point(347, 426));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		fieldImage = ImageIO.read(new File("field.png"));
		size = new Dimension(fieldImage.getHeight()+17, fieldImage.getWidth()+37);
		new LordDraw();
	}


	@Override
	public void mouseClicked(MouseEvent m) {
		if ( m.getButton() == m.BUTTON3 )
		{
			points.addWaypoint(m.getPoint());
			System.out.println("New point at ("+m.getX()+", "+m.getY()+")");
		}
		points.repaint();
		repaint();
		
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
