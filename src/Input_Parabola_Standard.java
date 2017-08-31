import javax.swing.*;
import java.awt.*;

public class Input_Parabola_Standard extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField a;
	private JTextField b;
	private JTextField c;
	
	public Input_Parabola_Standard()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		equation = new JLabel("y = ax\u00b2 + bx + c");
		
		JPanel abPane = new JPanel();
		abPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		abPane.add(new JLabel("a = "));
		a = new JTextField("1", 5);
		abPane.add(a);
		abPane.add(new JLabel("b = "));
		b = new JTextField("0", 5);
		abPane.add(b);
		
		JPanel constant = new JPanel();
		constant.setLayout(new FlowLayout(FlowLayout.LEFT));
		constant.add(new JLabel("c = "));
		c = new JTextField("0", 5);
		constant.add(c);
		
		add(equation);
		add(abPane);
		add(constant);
	}
	
	public double getA()
	{
		String input = a.getText().trim();
		return Double.parseDouble(input);
	}
	
	public double getB()
	{
		String input = b.getText().trim();
		return Double.parseDouble(input);
	}
	
	public double getC()
	{
		String input = c.getText().trim();
		return Double.parseDouble(input);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		plot(g, lowX, highX, lowY, highY, DEFAULT_COLOR);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		g.setColor(c);
		
		double A = getA();
		double B = getB();
		double C = getC();
		
		double dx = (highX-lowX)*STEP_SIZE;
		double p = A*lowX*lowX + B*lowX + C;
		
		for(double i = lowX+dx; i <= highX; i += dx)
		{
			double y = A*i*i + B*i + C;
			g.drawLine((int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY-p)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY-y)*Screen.HEIGHT/(highY-lowY)));
			p = y;
		}
	}
}
