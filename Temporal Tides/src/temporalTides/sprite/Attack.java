package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import temporalTides.controller.MouseController;
import temporalTides.state.Play;

public class Attack 
{
	private int range;
	private double traveled;
	private double speed;
	private double xSpeed;
	private double ySpeed;
	
	private double width;
	private double height;
	
	private double x;
	private double y; 
	
	private double fireAngle;
	
	private boolean collided = false;
		
	Animation animation = new Animation();
	Animation deathAnimation;
	
	protected int damage;
	
	public Attack(double x, double y, int dmg, int speed, int range, BufferedImage[] anims)
	{
		this.speed = speed;
		this.damage = dmg;
		this.range = range;
		this.x = x;
		this.y = y;
		
		height = anims[0].getHeight(); //Temp Values
		width = anims[0].getWidth();  //Temp Values
					
		
		init(anims);
		
		
		
		
	}
	
	private void init(BufferedImage[] anims)
	{
						    		    
		fireAngle = Math.atan2(MouseController.mousex - x, MouseController.mousey - y);
		
		xSpeed = speed * Math.cos((5 *Math.PI)/2 - fireAngle);
		ySpeed = speed * Math.sin((5 *Math.PI)/2 - fireAngle);
		
		Play.getPlayer().setArmAngle(fireAngle);
		
		/*for(int i = 0; i < anims.length; i++)
		{
			//BufferedImage bufferedImage = new BufferedImage((int)width, (int)height,anims[i].TYPE_BYTE_INDEXED);

		    AffineTransform tx = new AffineTransform();
		    tx.rotate(fireAngle, anims[i].getWidth() / 2, anims[i].getHeight() / 2);

		    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		    anims[i] = op.filter(anims[i], null);
		    
		   // anims[i] = bufferedImage;
		}*/
		
		animation.setFrames(anims);
		animation.setDelay(2);
	}
	
	public void update()
	{
		if(! collided)
		{
			x += xSpeed;
			y += ySpeed;
			traveled += speed;	
			animation.update();
		}
		
			
		
	}
	
	public int getDamage(){collided = true; return damage;}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(x - width/2), (int)(y - height/2),(int)height,(int)width);
	}
	
	public void draw(Graphics2D g)
	{
		
		g.setColor(Color.MAGENTA);
		
		
		/*AffineTransform rotate = new AffineTransform();
		rotate.setToRotation(fireAngle);
		
		/*Graphics2D img2 = animation.getImage().createGraphics();
		img2.rotate(fireAngle);
		img2.dr*/
		
		g.drawImage(animation.getImage(),(int)(x - width/2), (int)(y - height/2),null);
	}
}
