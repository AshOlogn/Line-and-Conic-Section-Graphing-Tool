import javax.swing.*;
import java.awt.*;

public class CurrentLocationPane extends JPanel
{
	private JLabel x;
	private JLabel y;
	
	public CurrentLocationPane()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		x = new JLabel("x: 0.000");
		x.setAlignmentX(LEFT_ALIGNMENT);
		y = new JLabel("y: 0.000");
		y.setAlignmentX(CENTER_ALIGNMENT);
		
		add(x);
		add(y);
		//setBorder(BorderFactory.createLineBorder(Color.BLUE));
	}
	
	public void changeLocation(double a, double b)
	{
		x.setText("x: " + String.format("%.3f", a));
		y.setText("y: " + String.format("%.3f", b));
	}
}
