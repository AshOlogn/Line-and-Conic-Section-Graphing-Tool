import javax.swing.*;
import java.awt.*;

public class AxesRange extends JPanel 
{
	public static final JLabel X = new JLabel("x-axis: ");
	private static final JLabel Y = new JLabel("y-axis: ");
	
	private JTextField xLow;
	private JTextField xHigh;
	private JTextField yLow;
	private JTextField yHigh;
	
	private double lowX;
	private double highX;
	private double lowY;
	private double highY;
	
	public AxesRange()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		lowX = -5.0; highX = 5.0; lowY = -5.0; highY = 5.0;
		
		xLow = new JTextField("-5.0", 5);
		xHigh = new JTextField("5.0", 5);
		yLow = new JTextField("-5.0", 5);
		yHigh = new JTextField("5.0", 5);
		
		JPanel xRow = new JPanel();
		xRow.setLayout(new FlowLayout(FlowLayout.LEFT));
		xRow.add(X); xRow.add(xLow); xRow.add(new JLabel("to")); xRow.add(xHigh);
		
		JPanel yRow = new JPanel();
		yRow.setLayout(new FlowLayout(FlowLayout.LEFT));
		yRow.add(Y); yRow.add(yLow); yRow.add(new JLabel("to")); yRow.add(yHigh);
		
		add(xRow);
		add(yRow);
	}
	
	public double getLowX()
	{
		return lowX;
	}
	
	public double getHighX()
	{
		return highX;
	}
	
	public double getLowY()
	{
		return lowY;
	}
	
	public double getHighY()
	{
		return highY;
	}
	
	//-------------------------------------------------
	
	public String getLowXText()
	{
		return xLow.getText();
	}
	
	public String getHighXText()
	{
		return xHigh.getText();
	}
	
	public String getLowYText()
	{
		return yLow.getText();
	}
	
	public String getHighYText()
	{
		return yHigh.getText();
	}
	
	//------------------------------------------
	
	public void setLowX(double lx)
	{
		lowX = lx;
		xLow.setText(lx+"");
	}
	
	public void setHighX(double hx)
	{
		highX = hx;
		xHigh.setText(hx+"");
	}
	
	public void setLowY(double ly)
	{
		lowY = ly;
		yLow.setText(ly+"");
	}
	
	public void setHighY(double hy)
	{
		highY = hy;
		yHigh.setText(hy+"");
	}
	
}
