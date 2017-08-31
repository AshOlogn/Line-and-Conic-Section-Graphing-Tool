import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel
{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 550;
	
	private Console console;
	private GraphPlotter graphPlotter;
	
	public Screen(Console c)
	{
		super();
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setBounds(10, 10, WIDTH, HEIGHT);
		
		console = c;
		graphPlotter = new GraphPlotter(console);
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH,  HEIGHT);
		
		graphPlotter.plotGraph(g);
	}
	
	

}
