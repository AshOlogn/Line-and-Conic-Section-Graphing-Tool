import javax.imageio.ImageIO;
import java.net.URL;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TitleAndAuthorPane extends JPanel
{
	public static final String author = "Ashwin Devaraj";
	
	public TitleAndAuthorPane()
	{
		setBounds(726, 10, 250, 90);
	}
	
	public void paintComponent(Graphics g)
	{
		try 
		{
			URL url = TitleAndAuthorPane.class.getResource("/logo.jpg");
			BufferedImage img = ImageIO.read(url);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), 0, img.getHeight()/4-10, img.getWidth(), 3*img.getHeight()/4, null);
		}
		catch(IOException e)
		{
			
		}
		
		g.setColor(Color.WHITE);
		String m = "Graphing Tool";
		Font f = new Font("Times New Roman", Font.PLAIN, 30);
		g.setFont(f);
		
		FontMetrics metrics = g.getFontMetrics();
		g.drawString(m, (getWidth()-metrics.stringWidth(m))/2, 3 + metrics.getAscent());
		
		String m2 = "Developed by Ashwin Devaraj";
		Font f2 = new Font("Georgia", Font.BOLD, 15);
		g.setFont(f2);
		
		FontMetrics metrics2 = g.getFontMetrics();
		g.drawString(m2, (getWidth()-metrics2.stringWidth(m2))/2, 55 + metrics2.getAscent());
		
		
	}
	
}
