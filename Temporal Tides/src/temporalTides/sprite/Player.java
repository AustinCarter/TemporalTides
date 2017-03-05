package temporalTides.sprite;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import temporalTides.controller.Resources;
import temporalTides.map.Tile;
import temporalTides.playerStates.*;

public class Player extends Sprite
{

	/*private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;*/
	
	public boolean airborne = false;
	
	private Animation playerArm = new Animation();
	//private BufferedImage pArm;
	private double armAngle;

	
	PlayerState state;
	
	public int shift = 2;
	
	
	
	public Player(double x, double y) 
	{
		super(x, y);		
		health = 100;
		animation.setFrames(Resources.PLAYER_WALK[0]);
		playerArm.setFrames(Resources.PLAYER_ARM[0]);
		//pArm = playerArm.getImage();
		state = new GeneralState(this);
		height = animation.getHeight();
		width = animation.getWidth();
		animation.setDelay(15);
		
	}
	
	public boolean collide(Attack a) {return 	state.collide(a);}
	
	public Rectangle getBounds() {return state.getBounds();}
	
	
	public void collide(Tile tile)
	{
		state.collide(tile);
	}
	
	
	public void update() {state.update();}
	
	public void setState(PlayerState state)
	{
		this.state = state;
	}
	
	public void getDamage(Enemy e){state.getDamage(e);}
	
	public void land()
	{
		vy = 0;
		airborne = false;
	}
	
	public void draw(Graphics2D g)
	{
		g.drawImage(animation.getImage(),(int)(x - width/2),(int)(y - height/2),null);
		
		//g.drawImage(playerArm.getImage(),(int)(x - width/2)+shift,(int)(y - height/4 - 1) ,null);
		
		for(int i = 0; i < playerArm.getHeight(); i++)
		{
			for(int j = 0; j < playerArm.getWidth(); j++)
			{
				
				int RGB = playerArm.getImage().getRGB(j, i);
				
				 
				
				g.setColor(new Color(RGB));
				//System.out.println(g.getColor());
				if(! (RGB == 0))
				{
					g.fillRect((int)Math.floor(x - width/2+shift +j*Math.cos(armAngle) + i*Math.sin(armAngle)), 
							(int)Math.floor(y - height/2 + 7 + j*Math.sin(armAngle)*-1 + i*Math.cos(armAngle)),1,1); 
					
					/*g.fillRect((int)Math.ceil(x - width/2+shift +j*Math.cos(armAngle) + i*Math.sin(armAngle)), 
							(int)Math.ceil(y - height/2 + 7 + j*Math.sin(armAngle)*-1 + i*Math.cos(armAngle)),1,1);*/
				}
				
				//System.out.printf("%d , %d\n", j, i);
			}
		}
		
		//g.drawRect((int)(x - width/2)+shift, (int)(y - height/2) + 7, pArm.getWidth(), pArm.getHeight());
		
		for(Attack a: myAttacks)
			a.draw(g);
	}
	
	public Animation getAnimation()
	{
		return this.animation;
	}
	
	public void setAnimation(BufferedImage[] i)
	{
		this.animation.setFrames(i);
	}
	
	public void setArmAnimation(BufferedImage[] i)
	{
		this.playerArm.setFrames(i);
	}
	
	public void setArmAngle(double d)
	{
		
		

		armAngle = d;
		
		
		
		 /*if (src == null) {

		      System.out.println("getRotatedImage: input image is null");
		      return null;

		    }*/

		
		/*
			//GraphicsConfiguration gc = Title.getGraphicsContext();
		
		    //int transparency = playerArm.getImage().getColorModel().getTransparency();
		    //BufferedImage pArm =  gc.createCompatibleImage(playerArm.getImage().getWidth(), playerArm.getImage().getHeight(), transparency );
			//pArm = new BufferedImage((int)(pArm.getWidth()), (int)(pArm.getHeight()),playerArm.getImage().TYPE_BYTE_INDEXED);
		    Graphics2D g2d = pArm.createGraphics();

		    //AffineTransform origAT = g2d.getTransform(); 

		    AffineTransform rot = new AffineTransform();
		    
		    rot.rotate(-d, playerArm.getImage().getWidth()/2,playerArm.getImage().getHeight()/2); 
		    g2d.transform(rot); 
		    
		   //g2d.setBackground(Color.);
		   // g2d.
		   g2d.clearRect(0, 0, pArm.getWidth(), pArm.getHeight());
		   g2d.drawImage(playerArm.getImage(), 0, 0, null);   

		   // g2d.setTransform(origAT);   
		    g2d.dispose();
		    //System.out.println(pArm.get);*/
		
		
		
		
		
		//this.armAngle = d;
		/*Graphics2D out = pArm.createGraphics();
		
		BufferedImage bufferedImage = new BufferedImage((int)(pArm.getWidth()), (int)(pArm.getHeight()),playerArm.getImage().TYPE_BYTE_INDEXED);

	    AffineTransform tx = new AffineTransform();
	    tx.rotate(armAngle, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
	    
	    out.transform(tx);
	    
	    out.drawImage(playerArm.getImage(),0,0,null);
	    
	    out.dispose();
	    
	   / pArm = bufferedImage;

	   AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
	   // pArm = op.filter(bufferedImage, null);*/
	    
		System.out.printf("Player Fire Angle updated to %f radians \n", d);
	}
	
	/*public static Image rotate(Image img, double angle)
	{
	    double sin = Math.abs(Math.sin(Math.toRadians(angle))),
	           cos = Math.abs(Math.cos(Math.toRadians(angle)));

	    int w = img.getWidth(null), h = img.getHeight(null);

	    int neww = (int) Math.floor(w*cos + h*sin),
	        newh = (int) Math.floor(h*cos + w*sin);

	    BufferedImage bimg = toBufferedImage(getEmptyImage(neww, newh));
	    Graphics2D g = bimg.createGraphics();

	    g.translate((neww-w)/2, (newh-h)/2);
	    g.rotate(Math.toRadians(angle), w/2, h/2);
	    g.drawRenderedImage(toBufferedImage(img), null);
	    g.dispose();

	    return toImage(bimg);
	}*/
		
			
	public boolean getDelay(){return state.getDelay();}
	
	
	
}
