import javax.swing.*;
import java.awt.*;

public class Input_Hyperbola_Horizontal extends JPanel implements InputEquation
{
	private JLabel equation;
	private JTextField h;
	private JTextField k;
	private JTextField a;
	private JTextField b;
	
	public Input_Hyperbola_Horizontal() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		equation = new JLabel("(x - h)\u00b2/a\u00b2 - (y - k)\u00b2/b\u00b2 = 1");
		
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
	}
	
	public double getA()
	{
		String input = a.getText();
		return Double.parseDouble(input);
	}
	
	public double getB()
	{
		String input = b.getText();
		return Double.parseDouble(input);
	}
	
	public double getH()
	{
		String input = h.getText();
		return Double.parseDouble(input);
	}
	
	public double getK()
	{
		String input = k.getText();
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
		
		double dx = (highX-lowX)*STEP_SIZE;


		//first component
		double p1 = K + Math.abs(B/A)*Math.sqrt((lowX-H)*(lowX-H) - A*A);
		double p2 = K - Math.abs(B/A)*Math.sqrt((lowX-H)*(lowX-H) - A*A);

		for(double i = lowX + dx; i <= H-A; i += dx)
		{
			double y1 = K + Math.abs(B/A)*Math.sqrt((i-H)*(i-H) - A*A);
			double y2 = K - Math.abs(B/A)*Math.sqrt((i-H)*(i-H) - A*A);

			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - p1)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y1)*Screen.HEIGHT/(highY-lowY)));
			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - p2)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y2)*Screen.HEIGHT/(highY-lowY)));

			p1 = y1;
			p2 = y2;
		}

		//second component
		p1 = 0.0;
		p2 = 0.0;

		for(double i = H+A+dx; i <= highX; i += dx)
		{
			double y1 = K + Math.abs(B/A)*Math.sqrt((i-H)*(i-H) - A*A);
			double y2 = K - Math.abs(B/A)*Math.sqrt((i-H)*(i-H) - A*A);

			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - p1)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y1)*Screen.HEIGHT/(highY-lowY)));
			g.drawLine( (int)Math.round((i-dx-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - p2)*Screen.HEIGHT/(highY-lowY)), 
					(int)Math.round((i-lowX)*Screen.WIDTH/(highX-lowX)), (int)Math.round((highY - y2)*Screen.HEIGHT/(highY-lowY)));

			p1 = y1;
			p2 = y2;
		}

		
		Graphics2D g2 = (Graphics2D) g.create();
		Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2.setStroke(dashed);
        g2.setColor(Color.RED);
        
        g2.drawLine(0, (int)Math.round((highY - (Math.abs(B/A)*(lowX-H)+K))*Screen.HEIGHT/(highY-lowY)), 
        		Screen.WIDTH, (int)Math.round((highY - (Math.abs(B/A)*(highX-H)+K))*Screen.HEIGHT/(highY-lowY)));
		
        g2.drawLine(0, (int)Math.round((highY - (-Math.abs(B/A)*(lowX-H)+K))*Screen.HEIGHT/(highY-lowY)), 
        		Screen.WIDTH, (int)Math.round((highY - (-Math.abs(B/A)*(highX-H)+K))*Screen.HEIGHT/(highY-lowY)));
        
		g2.dispose();
	}
}
