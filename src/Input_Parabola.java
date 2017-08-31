import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Input_Parabola extends JPanel implements InputEquation
{
	public static final String PARABOLA_S = "Standard";
	public static final String PARABOLA_HC = "Horizontal (Conic)";
	public static final String PARABOLA_VC = "Vertical (Conic)";
	
	
	private JPanel options;
	private JComboBox parabolaOptions;
	
	private String orientation;
	private Input_Parabola_Standard standardParabola;
	private Input_Parabola_HorizontalConic horizontalConicParabola;
	private Input_Parabola_VerticalConic verticalConicParabola;
	
	public Input_Parabola()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		options = new JPanel();
		options.setLayout(new CardLayout());
		
		standardParabola = new Input_Parabola_Standard();
		verticalConicParabola = new Input_Parabola_VerticalConic();
		horizontalConicParabola = new Input_Parabola_HorizontalConic();
		options.add(standardParabola, PARABOLA_S);
		options.add(verticalConicParabola, PARABOLA_VC);
		options.add(horizontalConicParabola, PARABOLA_HC);
		
		JPanel parabolaOptionMenuPane = new JPanel();
		parabolaOptionMenuPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		String[] parabolaOptionLabels = {PARABOLA_S, PARABOLA_VC, PARABOLA_HC};
		parabolaOptions = new JComboBox(parabolaOptionLabels);
		parabolaOptions.setSelectedIndex(0);
		
		parabolaOptions.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					JComboBox cb = (JComboBox) evt.getSource();
					((CardLayout) options.getLayout()).show(options, (String)cb.getSelectedItem());
					orientation = (String)cb.getSelectedItem();
				}
			});
		
		
		parabolaOptionMenuPane.add(parabolaOptions);
		
		add(options);
		add(parabolaOptionMenuPane);
		orientation = PARABOLA_S;
	}
	
	public String getOrientation() { return orientation; }
	public Input_Parabola_Standard getInput_Parabola_Standard() { return standardParabola; }
	public Input_Parabola_HorizontalConic getInput_Parabola_HorizontalConic() { return horizontalConicParabola; }
	public Input_Parabola_VerticalConic getInput_Parabola_VerticalConic() { return verticalConicParabola; }
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		plot(g, lowX, highX, lowY, highY, DEFAULT_COLOR);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		switch(orientation)
		{	case PARABOLA_S: getInput_Parabola_Standard().plot(g, lowX, highX, lowY, highY, c); break;
			case PARABOLA_HC: getInput_Parabola_HorizontalConic().plot(g, lowX, highX, lowY, highY, c); break;
			case PARABOLA_VC: getInput_Parabola_VerticalConic().plot(g, lowX, highX, lowY, highY, c); break;
		}
	}
	
}
