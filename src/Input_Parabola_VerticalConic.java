import javax.swing.*;
import java.awt.*;

public class Input_Parabola_VerticalConic extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField h;
	private JTextField k;
	private JTextField p;
	
	public Input_Parabola_VerticalConic()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		equation = new JLabel("(y - k) = 4p(x - h)\u00b2");
		
		JPanel hkPane = new JPanel();
		hkPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		hkPane.add(new JLabel("h = "));
		h = new JTextField("0", 5);
		hkPane.add(h);
		hkPane.add(new JLabel("k = "));
		k = new JTextField("0", 5);
		hkPane.add(k);
		
		JPanel constant = new JPanel();
		constant.setLayout(new FlowLayout(FlowLayout.LEFT));
		constant.add(new JLabel("p = "));
		p = new JTextField("0.25", 5);
		constant.add(p);
		
		add(equation);
		add(hkPane);
		add(constant);
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
	
	public double getP()
	{
		String input = p.getText().trim();
		return Double.parseDouble(input);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY)
	{
		plot(g, lowX, highX, lowY, highY, DEFAULT_COLOR);
	}
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c)
	{
		g.setColor(c);
		
		double P = getP();
		double H = getH();
		double K = getK();
		
		double dx = (highX-lowX)*STEP_SIZE;
		
		double prev = K + 4*P*(lowX-H)*(lowX-H);
		
		for(double i = lowX+dx; i <= highX; i += dx)
		{
			double y = K + 4*P*(i-H)*(i-H);
			
			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - prev)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y)*Screen.HEIGHT/(highY-lowY)));
			
			prev = y;
		}
 	}
}
