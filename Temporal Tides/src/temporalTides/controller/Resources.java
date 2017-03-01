package temporalTides.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Resources 
{
	//public static BufferedImage[][] MENUBG = load("/HUD/menuscreen.gif", 128, 144);
	public static BufferedImage[][] BAR = load("/HUD/bar.png", 128, 16);
	
	public static BufferedImage[][] PLAYER = load("/Sprites/playersprites.png", 16, 16);
	//public static BufferedImage[][] DIAMOND = load("/Sprites/diamond.png", 16, 16);
	public static BufferedImage[][] SPARKLE = load("/Sprites/sparkle.png", 16, 16);
	public static BufferedImage[][] ITEMS = load("/Sprites/items.png", 16, 16);
	
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
