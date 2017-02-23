package temporalTides.main;

import javax.swing.JFrame;

public class Game 
{
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Temporal Tides");
		
		frame.add(new Title());
		
		frame.setResizable(false);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
