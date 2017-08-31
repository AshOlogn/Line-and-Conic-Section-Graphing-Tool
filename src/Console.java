import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Console extends JPanel
{
	public static final int WIDTH = 250;
	public static final int HEIGHT = 400;
	public static final int X_POSITION = 726;
	public static final int Y_POSITION = 125;
	
	private GraphSelection selection;
	private JButton graphButton;
	private AxesRange axesRange;
	private CurrentLocationPane currentLocation;
	private JButton setAxesButton;
	private JButton zoomInButton;
	private JButton zoomOutButton;
	
	public Console()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(X_POSITION, Y_POSITION, WIDTH, HEIGHT);
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		selection = new GraphSelection();
		add(selection);
		
		JPanel graphButtonPane = new JPanel();
		graphButtonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		graphButton = new JButton("Graph");
		graphButtonPane.add(graphButton);
		add(graphButtonPane);
		
		//Allows user to specify range of values on graph axes
		axesRange = new AxesRange();
		add(axesRange);
		
		JPanel setAxesButtonPane = new JPanel();
		setAxesButtonPane.setLayout(new BoxLayout(setAxesButtonPane, BoxLayout.LINE_AXIS));
		setAxesButtonPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Zoom In Button
		URL urlIn = Console.class.getResource("/zoomin.jpg");
		ImageIcon zinIcon = new ImageIcon(urlIn);
		zoomInButton = new JButton("", zinIcon);
		zoomInButton.setSize(new Dimension(15,15));
		zoomInButton.setMargin(new Insets(0,0,0,0));
		setAxesButtonPane.add(zoomInButton);
		
		setAxesButtonPane.add(new JPanel());
		
		//Zoom Out Button
		URL urlOut = Console.class.getResource("/zoomout.jpg");
		ImageIcon zoutIcon = new ImageIcon(urlOut);
		zoomOutButton = new JButton("", zoutIcon);
		zoomOutButton.setSize(new Dimension(15,15));
		zoomOutButton.setMargin(new Insets(0,0,0,0));
		setAxesButtonPane.add(zoomOutButton);
		
		setAxesButtonPane.add(new JPanel());
		
		setAxesButton = new JButton("Set Axes");
		setAxesButtonPane.add(setAxesButton);
		
		add(setAxesButtonPane);
		
		//shows coordinates of cursor on the graph
		currentLocation = new CurrentLocationPane();
		add(currentLocation);
	}
	
	public GraphSelection getGraphSelection()
	{
		return selection;
	}
	
	public JButton getGraphButton()
	{
		return graphButton;
	}
	
	public AxesRange getAxesRange()
	{
		return axesRange;
	}
	
	public CurrentLocationPane getCurrentLocationPane()
	{
		return currentLocation;
	}
	
	public JButton getZoomInButton()
	{
		return zoomInButton;
	}
	
	public JButton getZoomOutButton()
	{
		return zoomOutButton;
	}
	
	public JButton getSetAxesButton()
	{
		return setAxesButton;
	}
}
