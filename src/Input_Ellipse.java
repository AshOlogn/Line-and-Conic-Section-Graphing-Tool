import javax.swing.*;
import java.awt.*;

public class Input_Ellipse extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField h;
	private JTextField k;
	private JTextField a;
	private JTextField b;
	
	public Input_Ellipse()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		equation = new JLabel("(x - h)\u00b2/a\u00b2 + (y - k)\u00b2/b\u00b2 = 1");
		
		JPanel coordinates = new JPanel();
		coordinates.setLayout(new FlowLayout(FlowLayout.LEFT));
		coordinates.add(new JLabel("h = "));
		h = new JTextField("0", 5);
		coordinates.add(h);
		coordinates.add(new JLabel("k = "));
		k = new JTextField("0", 5);
		coordinates.add(k);
		
		JPanel constants = new JPanel();
		constants.setLayout(new FlowLayout(FlowLayout.LEFT));
		constants.add(new JLabel("a = "));
		a = new JTextField("2", 5);
		constants.add(a);
		constants.add(new JLabel("b = "));
		b = new JTextField("1", 5);
		constants.add(b);
		
		add(equation);
		add(coordinates);
		add(constants);
		add(new JPanel());
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
	
	public double getH()
	{
		String input = h.getText().trim();
		return Double.parseDouble(input);
	}
	
	public double getK()
	{
		String input = k.getText().trim();
		return Double.parseDouble(input);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		plot(g, lowX, highX, lowY, highY, DEFAULT_COLOR);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		g.setColor(c);
		
		double H = getH();
		double K = getK();
		double A = getA();
		double B = getB();
		
		g.drawOval((int)Math.round((H-A-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY-K-B)*Screen.HEIGHT/(highY-lowY)),
				(int)Math.round(2*A*Screen.WIDTH/(highX-lowX)), (int)Math.round(2*B*Screen.HEIGHT/(highY-lowY)));
	}
}
