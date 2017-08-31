import javax.swing.*;
import java.awt.*;

public class GraphPlotter
{
	private Console console;
	
	public GraphPlotter(Console c)
	{
		console = c;
	}
	
	public void plotGraph(Graphics g)
	{
		double lowX = console.getAxesRange().getLowX();
		double highX = console.getAxesRange().getHighX();
		double lowY = console.getAxesRange().getLowY();
		double highY = console.getAxesRange().getHighY();
	
		//plot axes
		double[] bounds = new AxesPlotter(lowX, highX, lowY, highY).plotAxes(g);
		AxesRange axesRange = console.getAxesRange();
		axesRange.setLowX(bounds[0]); axesRange.setHighX(bounds[1]); axesRange.setLowY(bounds[2]); axesRange.setHighY(bounds[3]);
		
		//plot equation
		GraphSelection selection = console.getGraphSelection();
		InputEquation input;
		switch(selection.getState())
		{
			case GraphSelection.CIRCLE: input = selection.getInput_Circle(); break; 
			case GraphSelection.ELLIPSE: input = selection.getInput_Ellipse(); break;
			case GraphSelection.HYPERBOLA: input = selection.getInput_Hyperbola(); break;
			case GraphSelection.PARABOLA: input = selection.getInput_Parabola(); break;
			default: input = selection.getInput_Line(); break; 
		}
		
		input.plot(g, bounds[0], bounds[1], bounds[2], bounds[3]);
	}
	
}
