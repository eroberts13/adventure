package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Starship 
{
	public float x;
	public float y;
	public float width = 50f;
	public float height = 50f;
	public int laserCoolDown = 0;
	public Image image;
	
	public Starship(float x, float y) throws SlickException
	{
		this.x = x;
		this.y = y;
		
		this.image = new Image("./res/arwing.png");
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	public void render(Graphics graphics)
	{
		image.draw(this.x, this.y);
	}
	
	public Rectangle getRect()
	{
		return new Rectangle((int)this.x + 5, (int)this.y + 5, (int)this.width - 5, (int)this.height - 5);
		
	}
}