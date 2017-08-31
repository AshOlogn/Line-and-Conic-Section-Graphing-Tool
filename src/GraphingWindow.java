import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GraphingWindow extends JFrame
{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 625;
	
	public static final double ZOOM_OUT_SCALE_FACTOR = 1.25;
	public static final double ZOOM_IN_SCALE_FACTOR = 0.75;
	
	public static final String APP_TITLE = "Graphing Tool";
	
	private Screen screen;
	private Console console;
	
	
	GraphingWindow()
	{
		super();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLayout(null);
		setTitle(APP_TITLE);
		
		//add other components
		console = new Console();
		add(console);
		screen = new Screen(console);
		add(screen);
		
		add(new TitleAndAuthorPane());
		
		//Manage listeners, plotting tools, etc.
		setupListeners();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setupListeners()
	{
		JButton graphButton = console.getGraphButton();
		graphButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						screen.repaint();
					}
				});
		
		JButton setAxesButton = console.getSetAxesButton();
		setAxesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				AxesRange axesRange = console.getAxesRange();
				try
				{
					double lowX = Double.parseDouble(axesRange.getLowXText());
					double highX = Double.parseDouble(axesRange.getHighXText());
					double lowY = Double.parseDouble(axesRange.getLowYText());
					double highY = Double.parseDouble(axesRange.getHighYText());
					
					axesRange.setLowX(lowX);
					axesRange.setHighX(highX);
					axesRange.setLowY(lowY);
					axesRange.setHighY(highY);
					
					screen.repaint();
					
				} catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Incorrect number formatting. Please enter valid numbers for the axes ranges.");
					axesRange.setLowX(axesRange.getLowX());
					axesRange.setHighX(axesRange.getHighX());
					axesRange.setLowY(axesRange.getLowY());
					axesRange.setHighY(axesRange.getHighY());
					return;
				}
			}
		});
		
		JButton zoomInButton = console.getZoomInButton();
		zoomInButton.addActionListener(new ActionListener()
		{
			AxesRange axesRange = console.getAxesRange();
			public void actionPerformed(ActionEvent evt)
			{
				axesRange.setLowX(axesRange.getLowX()*ZOOM_IN_SCALE_FACTOR);
				axesRange.setHighX(axesRange.getHighX()*ZOOM_IN_SCALE_FACTOR);
				axesRange.setLowY(axesRange.getLowY()*ZOOM_IN_SCALE_FACTOR);
				axesRange.setHighY(axesRange.getHighY()*ZOOM_IN_SCALE_FACTOR);
				
				screen.repaint();
			}
		});
		
		JButton zoomOutButton = console.getZoomOutButton();
		zoomOutButton.addActionListener(new ActionListener()
		{
			AxesRange axesRange = console.getAxesRange();
			public void actionPerformed(ActionEvent evt)
			{
				axesRange.setLowX(axesRange.getLowX()*ZOOM_OUT_SCALE_FACTOR);
				axesRange.setHighX(axesRange.getHighX()*ZOOM_OUT_SCALE_FACTOR);
				axesRange.setLowY(axesRange.getLowY()*ZOOM_OUT_SCALE_FACTOR);
				axesRange.setHighY(axesRange.getHighY()*ZOOM_OUT_SCALE_FACTOR);
				
				screen.repaint();
			}
		});
		
		screen.addMouseMotionListener(new MouseMotionListener()
				{
					public void mouseDragged(MouseEvent evt) { }
					public void mouseMoved(MouseEvent evt) 
					{
						AxesRange axesRange = console.getAxesRange();
						CurrentLocationPane currentLocation = console.getCurrentLocationPane();
						currentLocation.changeLocation(axesRange.getLowX() + evt.getX()*(axesRange.getHighX()-axesRange.getLowX())/screen.WIDTH, 
								axesRange.getHighY()-(evt.getY()*(axesRange.getHighY()-axesRange.getLowY())/screen.HEIGHT));
					}
				});
		
	}
	
}
