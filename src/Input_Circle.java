import javax.swing.*;
import java.awt.*;

public class Input_Circle extends JPanel implements InputEquation
{
	
	private JLabel equation;
	private JTextField radius;
	private JTextField h;
	private JTextField k;
	
	public Input_Circle()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		equation = new JLabel("(x - h)\u00b2 + (y - k)\u00b2 = r\u00b2");
		
		JPanel coordinates = new JPanel();
		coordinates.setLayout(new FlowLayout(FlowLayout.LEFT));
		coordinates.add(new JLabel("h = "));
		h = new JTextField("0", 5);
		coordinates.add(h);
		coordinates.add(new JLabel("k = "));
		k = new JTextField("0", 5);
		coordinates.add(k);
		
		
		JPanel rad = new JPanel();
		rad.setLayout(new FlowLayout(FlowLayout.LEFT));
		rad.add(new JLabel("r = "));
		radius = new JTextField("1", 5);
		rad.add(radius);
		
		add(equation);
		add(coordinates);
		add(rad);
		add(new JPanel());
	}
	
	public double getR()
	{
		String input = radius.getText().trim();
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
		
		double R = getR();
		double H = getH();
		double K = getK();
		
		g.drawOval((int)Math.round((H-R-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY-K-R)*Screen.HEIGHT/(highY-lowY)),
				(int)Math.round(2*R*Screen.WIDTH/(highX-lowX)), (int)Math.round(2*R*Screen.HEIGHT/(highY-lowY)));
		
	}
}
