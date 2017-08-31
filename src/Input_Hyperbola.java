import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Input_Hyperbola extends JPanel implements InputEquation
{
	public static final String HYPERBOLA_V = "HYPERBOLA_V";
	public static final String HYPERBOLA_H = "HYPERBOLA_H";
	
	
	private String orientation;
	private JPanel options;
	private JRadioButton verticalOptionButton;
	private JRadioButton horizontalOptionButton;
	private Input_Hyperbola_Vertical verticalHyperbola;
	private Input_Hyperbola_Horizontal horizontalHyperbola;
	
	
	public Input_Hyperbola() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		options = new JPanel();
		options.setLayout(new CardLayout());
		
		//add options
		verticalHyperbola = new Input_Hyperbola_Vertical();
		horizontalHyperbola = new Input_Hyperbola_Horizontal();
		options.add(verticalHyperbola, HYPERBOLA_V);
		options.add(horizontalHyperbola, HYPERBOLA_H);
		
		ButtonGroup group = new ButtonGroup();
		verticalOptionButton = new JRadioButton("Vertical", true);
		horizontalOptionButton = new JRadioButton("Horizontal");
		group.add(verticalOptionButton);
		group.add(horizontalOptionButton);
		
		JPanel hyperbolaOptionButtonPane = new JPanel();
		hyperbolaOptionButtonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		hyperbolaOptionButtonPane.add(verticalOptionButton);
		hyperbolaOptionButtonPane.add(horizontalOptionButton);
		
		verticalOptionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				((CardLayout)options.getLayout()).show(options, HYPERBOLA_V);
				orientation = HYPERBOLA_V;
			}
		});
		
		horizontalOptionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				((CardLayout)options.getLayout()).show(options, HYPERBOLA_H);
				orientation = HYPERBOLA_H;
			}
		});
		
		
		add(options);
		add(hyperbolaOptionButtonPane);
		orientation = HYPERBOLA_V;
	}
	
	public String getOrientation() { return orientation; }
	public Input_Hyperbola_Vertical getInput_Hyperbola_Vertical() { return verticalHyperbola; }
	public Input_Hyperbola_Horizontal getInput_Hyperbola_Horizontal() { return horizontalHyperbola; }
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		switch(orientation)
		{
			case HYPERBOLA_V: getInput_Hyperbola_Vertical().plot(g, lowX, highX, lowY, highY); break;
			case HYPERBOLA_H: getInput_Hyperbola_Horizontal().plot(g, lowX, highX, lowY, highY);
		}
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		switch(orientation)
		{
			case HYPERBOLA_V: getInput_Hyperbola_Vertical().plot(g, lowX, highX, lowY, highY, c); break;
			case HYPERBOLA_H: getInput_Hyperbola_Horizontal().plot(g, lowX, highX, lowY, highY, c);
		}
	}
	
}
