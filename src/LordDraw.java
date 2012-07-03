import java.awt.Dimension;
import java.awt.Point;
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
import javax.swing.JFrame;

public class LordDraw extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
	static BufferedImage fieldImage;
	static public Dimension size;
	Waypoints points = new Waypoints(this);
	public static int selected = -1;
	public LordDraw()
	{
		super();
		
		add(points);
		setTitle("LordDraw");
		setVisible(true);
		setSize(size);
		points.addWaypoint(new Point(347, 426));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		fieldImage = ImageIO.read(new File("field.png"));
		size = new Dimension(fieldImage.getHeight()+17, fieldImage.getWidth()+37);
		new LordDraw();
	}


	@Override
	public void mouseClicked(MouseEvent m) {
		if ( m.getButton() == MouseEvent.BUTTON3 )
		{
			points.addWaypoint(m.getPoint());
			System.out.println("New point at ("+m.getX()+", "+m.getY()+")");
		}
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
	public void mouseMoved(MouseEvent m) {}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
