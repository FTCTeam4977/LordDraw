import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;


public class MB extends MenuBar {
	Menu file = new Menu("File");
	Menu startpoint = new Menu("Origin");
	public MB()
	{
		super();
		file.add(new MenuItem("Clear"));
		add(file);
		
		startpoint.add(new MenuItem("Red Inside"));
		startpoint.add(new MenuItem("Red Outside"));
		
		startpoint.add(new MenuItem("Blue Inside"));
		startpoint.add(new MenuItem("Blue Outside"));
		add(startpoint);
	}
}
