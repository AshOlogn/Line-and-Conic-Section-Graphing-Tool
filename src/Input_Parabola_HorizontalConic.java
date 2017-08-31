import javax.swing.*;
import java.awt.*;

public class Input_Parabola_HorizontalConic extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField h;
	private JTextField k;
	private JTextField p;
	
	public Input_Parabola_HorizontalConic()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		equation = new JLabel("(x - h) = 4p(y - k)\u00b2");
		
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
		double b1;
		double b2;
		
		
		if(P < 0) 
		{
			b1 = lowX; b2 = H;
		} else 
		{
			b1 = H; b2 = highX;
		}
		
		double prev1 = K + 0.5*Math.sqrt((b1-H)/P);
		double prev2 = K - 0.5*Math.sqrt((b1-H)/P);
		for(double i = b1+dx; i <= b2; i += dx)
		{
			double y1 = K + 0.5*Math.sqrt((i-H)/P);
			double y2 = K - 0.5*Math.sqrt((i-H)/P);
			
			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - prev1)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y1)*Screen.HEIGHT/(highY-lowY)));
			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - prev2)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y2)*Screen.HEIGHT/(highY-lowY)));
			
			prev1 = y1; prev2 = y2;
		}
 	}
}
