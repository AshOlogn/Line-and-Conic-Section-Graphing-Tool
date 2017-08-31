import javax.swing.*;
import java.awt.*;

public class Input_Line extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField m;
	private JTextField b;
	
	public Input_Line()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		equation = new JLabel("y = mx + b");
		
		JPanel constants = new JPanel();
		constants.setLayout(new FlowLayout(FlowLayout.LEFT));
		constants.add(new JLabel("m = "));
		m = new JTextField("1", 5);
		constants.add(m);
		constants.add(new JLabel("b = "));
		b = new JTextField("0", 5);
		constants.add(b);
		
		add(equation);
		add(constants);
	}
	
	public double getM()
	{
		String input = m.getText().trim();
		return Double.parseDouble(input);
	}
	
	public double getB()
	{
		String input = b.getText().trim();
		return Double.parseDouble(input);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		plot(g, lowX, highX, lowY, highY, DEFAULT_COLOR);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		g.setColor(c);
		
		double M = getM();
		double B = getB();
		
		g.drawLine(0, (int)Math.round((highY - (M*lowX+B))*Screen.HEIGHT/(highY-lowY)), Screen.WIDTH, (int)Math.round((highY - (M*highX+B))*Screen.HEIGHT/(highY-lowY)));
	}
	
	public void plotDotted(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		Graphics2D g2 = (Graphics2D) g.create();
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2.setStroke(dashed);
		
		double M = getM();
		double B = getB();
		
		g2.setColor(c);
		g.drawLine(0, (int)Math.round((highY - (M*lowX+B))*Screen.HEIGHT/(highY-lowY)), Screen.WIDTH, (int)Math.round((highY - (M*highX+B))*Screen.HEIGHT/(highY-lowY)));
	}
}
