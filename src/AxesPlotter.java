import javax.swing.*;
import java.awt.*;

public class AxesPlotter 
{
	public static final int TICK_LENGTH = 10;
	private double lowX;
	private double highX;
	private double lowY;
	private double highY;
	
	public AxesPlotter(double lx, double hx, double ly, double hy)
	{
		lowX = lx; highX = hx; lowY = ly; highY = hy;
	}
	
	public double[] plotAxes(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 8));
		FontMetrics metrics = g.getFontMetrics();
		
		//y-axis
		int yPosition = -1;
		if(lowX <= 0)
		{
			yPosition = (int)(-1.0 * Screen.WIDTH * lowX/(highX-lowX)); 
		} else
			yPosition = 0;
		
		g.drawLine(yPosition, 0, yPosition, Screen.HEIGHT);
		
		//y-axis tick marks
		double yInterval = (highY-lowY)/20;
		int exp = (int)Math.floor(Math.log10(yInterval));
		yInterval = Math.pow(10, exp);
		
		double yBottom = (int)(lowY/yInterval)*yInterval;
		double yTop = Math.ceil(highY/yInterval)*yInterval;
		
		int count = 0;
		for(double i = yBottom; i <= yTop; i += yInterval, count++)
		{
			int yPixelPosition = (int)Math.round((yTop - i)*Screen.HEIGHT/(yTop-yBottom));
			g.drawLine(yPosition-TICK_LENGTH/2, yPixelPosition, yPosition + TICK_LENGTH/2, yPixelPosition);
			if(count > 0 && count % 5 == 0 && Math.abs(i) > 1E-6)
			{
				int height = metrics.getAscent();
				g.drawString(String.format("%.3f", i), yPosition + TICK_LENGTH/2 + 2, yPixelPosition+height/2);
			}
		}
		
		//x-axis
		int xPosition = -1;
		if(lowY <= 0)
		{
			xPosition = (int)(Screen.HEIGHT * highY/(highY-lowY)); 
		} else
			xPosition = 0;
		
		g.drawLine(0, xPosition, Screen.WIDTH, xPosition);
		
		//x-axis tick marks
		double xInterval = (highX - lowX)/20;
		exp = (int)Math.floor(Math.log10(xInterval));
		xInterval = Math.pow(10, exp);
		
		double xBottom = (int)(lowX/xInterval)*xInterval;
		double xTop = Math.ceil(highX/xInterval)*xInterval;
		
		count = 0;
		for(double i = xBottom; i <= xTop; i += xInterval, count++)
		{
			int xPixelPosition = (int)Math.round((i - xBottom)*Screen.WIDTH/(xTop-xBottom));
			g.drawLine(xPixelPosition, xPosition-TICK_LENGTH/2, xPixelPosition, xPosition + TICK_LENGTH/2);
			if(count > 0 && count % 5 == 0 && Math.abs(i) > 1E-6)
			{
				int width = metrics.stringWidth(String.format("%.3f", i));
				int height = metrics.getAscent();
				
				g.drawString(String.format("%.3f", i), xPixelPosition-width/2, xPosition+height+5);
			}
		}
		
		double[] vals = {xBottom, xTop, yBottom, yTop};
		return vals;
	}
}
