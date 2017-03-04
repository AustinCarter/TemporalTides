package temporalTides.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Resources 
{
	//public static BufferedImage[][] MENUBG = load("/HUD/menuscreen.gif", 128, 144);
	public static BufferedImage[][] BAR = load("/HUD/Bar.png", 800, 64);
	public static BufferedImage[][] FILL = load("/HUD/HealthBarFIll.png",237,17);
	
	public static BufferedImage[][] ARCHER = load("/Sprites/Archer.png", 16, 32);
	public static BufferedImage[][] BRUTE = load("/Sprites/Brute.png", 16, 32);
	public static BufferedImage[][] WISP = load("/Sprites/Wisp.png", 48, 64);
	public static BufferedImage[][] FLYER = load("/Sprites/Flyer.png", 16, 16);
	
	public static BufferedImage[][] BOLTS_TORNADO = load("/Sprites/Bolt_Tornado.png",16,8);
	
	public static BufferedImage[][]PLAYER_WALK = load("/Sprites/CharWalk.png",16,32);
	public static BufferedImage[][]PLAYER_ARM = load("/Sprites/PlayerArm.png",4,18);
	
	//public static BufferedImage[][] font = load("/HUD/font.png", 8, 8);
	
	public static BufferedImage[][] load(String s, int w, int h) 
	{
		BufferedImage[][] images;
		try 
		{
			BufferedImage spritesheet = ImageIO.read(Resources.class.getResourceAsStream(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			
			images = new BufferedImage[height][width];
			
			for(int i = 0; i < height; i++) 
			{
				for(int j = 0; j < width; j++)
				{
					images[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
				}
			}
			return images;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error loading graphics.");
			System.exit(0);
		}
		return null;
	}
}
