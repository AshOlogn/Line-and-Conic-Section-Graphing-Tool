import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphSelection extends JPanel
{
	public static final String LINE = "Line";
	public static final String CIRCLE = "Circle";
	public static final String ELLIPSE = "Ellipse";
	public static final String HYPERBOLA = "Hyperbola";
	public static final String PARABOLA = "Parabola";
	
	private String state;
	
	private JPanel equationPane;
	private Input_Line line;
	private Input_Circle circle;
	private Input_Ellipse ellipse;
	private Input_Hyperbola hyperbola;
	private Input_Parabola parabola;
	
	private JRadioButton lineButton;
	private JRadioButton circleButton;
	private JRadioButton ellipseButton;
	private JRadioButton hyperbolaButton;
	private JRadioButton parabolaButton;
	
	GraphSelection()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Equation Windows
		equationPane = new JPanel(); 
		equationPane.setLayout(new CardLayout());
		equationPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		line = new Input_Line();
		circle = new Input_Circle();
		ellipse = new Input_Ellipse();
		parabola = new Input_Parabola();
		hyperbola = new Input_Hyperbola();
		
		equationPane.add(line, LINE);
		equationPane.add(circle, CIRCLE);
		equationPane.add(ellipse, ELLIPSE);
		equationPane.add(parabola, PARABOLA);
		equationPane.add(hyperbola, HYPERBOLA);
		
		//RadioButton Selection Interface
		JPanel graphSelectionButtonPane = new JPanel();
		graphSelectionButtonPane.setLayout(new BoxLayout(graphSelectionButtonPane, BoxLayout.Y_AXIS));
		lineButton = new JRadioButton(LINE, true);
		circleButton = new JRadioButton(CIRCLE);
		ellipseButton = new JRadioButton(ELLIPSE);
		hyperbolaButton = new JRadioButton(HYPERBOLA);
		parabolaButton = new JRadioButton(PARABOLA);
		
		lineButton.addActionListener(new EquationListener());
		circleButton.addActionListener(new EquationListener());
		ellipseButton.addActionListener(new EquationListener());
		hyperbolaButton.addActionListener(new EquationListener());
		parabolaButton.addActionListener(new EquationListener());
		
		ButtonGroup group = new ButtonGroup();
		group.add(lineButton);
		group.add(circleButton);
		group.add(ellipseButton);
		group.add(hyperbolaButton);
		group.add(parabolaButton);

		JPanel titlePane = new JPanel();
		titlePane.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel title = new JLabel("Options");
		titlePane.add(title);
		
		JPanel buttons = new JPanel();
		buttons.setSize(100,100);
		buttons.setLayout(new GridLayout(3,2));
		buttons.add(lineButton);
		buttons.add(circleButton);
		buttons.add(ellipseButton);
		buttons.add(hyperbolaButton);
		buttons.add(parabolaButton);

		graphSelectionButtonPane.add(titlePane);
		graphSelectionButtonPane.add(buttons);
		
		//combine everything
		add(graphSelectionButtonPane);
		add(new JPanel());
		add(equationPane);
		
		state = LINE;
	}
	
	private class EquationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			((CardLayout)equationPane.getLayout()).show(equationPane, evt.getActionCommand()); 
			state = evt.getActionCommand();
		}
	}
	
	public String getState() { return state; }
	public Input_Line getInput_Line() { return line; }
	public Input_Circle getInput_Circle() { return circle; }
	public Input_Ellipse getInput_Ellipse() { return ellipse; }
	public Input_Hyperbola getInput_Hyperbola() { return hyperbola; }
	public Input_Parabola getInput_Parabola() { return parabola; }
}
