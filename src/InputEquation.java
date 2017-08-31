import javax.swing.*;
import java.awt.*;

public interface InputEquation 
{
	public static final Color DEFAULT_COLOR = Color.BLUE;
	public static final double STEP_SIZE = 1E-6;
	
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY, Color c);
	public void plot(Graphics g, double lowX, double highX, double lowY, double highY);
}
