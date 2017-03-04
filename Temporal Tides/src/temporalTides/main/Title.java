package temporalTides.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import temporalTides.controller.KeyController;
import temporalTides.controller.MouseController;
import temporalTides.controller.StateController;

public class Title extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	public static int WIDTH = 1024;
	public static int HEIGHT = 576;
		
	private int mousex;
	private int mousey;
	
	private Thread thread;	
	private boolean go;
	private final int FRAMES = 60;
	private final int DELAY = 1000 / FRAMES;
	
	private BufferedImage image;
	private Graphics2D g;
	
	
	StateController state;
	
	public Title()
	{
		setPreferredSize(new Dimension(WIDTH ,HEIGHT));
		setFocusable(true);
		requestFocus();
	}


	@Override
	public void run() 
	{
		intitalize();
		
		long start;
		long elapsed;
		long wait;
		
		while(go)
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = DELAY - elapsed / 1000000;
			if(wait < 0) wait = DELAY;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}
	
	private void update()
	{
		state.update();
		KeyController.update();
		MouseController.update(mousex,mousey);
	}
	
	// draws game
	private void draw() 
	{
		state.draw(g);		
	}
	
	// copy buffer to screen
	private void drawToScreen() 
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
		g.clearRect(0, 0, WIDTH, HEIGHT);
	}
	
	public void intitalize()
	{
		image = new BufferedImage(WIDTH, HEIGHT, 1);
		g = (Graphics2D) image.getGraphics();
		state = new StateController();
		go = true;
	}
	
	public void addNotify() 
	{
		super.addNotify();
		if(thread == null)
		{
			addKeyListener(this);
			addMouseListener(this);
			addMouseMotionListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {KeyController.process(e.getKeyCode(), true);}
	@Override
	public void keyReleased(KeyEvent e) {KeyController.process(e.getKeyCode(), false);}
	@Override
	public void keyTyped(KeyEvent e){}


	@Override
	public void mouseDragged(MouseEvent e) {mousex = e.getX(); mousey = e.getY();}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}	
	@Override
	public void mousePressed(MouseEvent e){MouseController.process(true); mousex = e.getX(); mousey = e.getY();}
	@Override
	public void mouseReleased(MouseEvent e){MouseController.process(false); mousex = e.getX(); mousey = e.getY();}
	@Override
	public void mouseMoved(MouseEvent e) {mousex = e.getX(); mousey = e.getY();}

}
