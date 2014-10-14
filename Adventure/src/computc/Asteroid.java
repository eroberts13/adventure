package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Asteroid 
{
	public float x;
	public float y;
	public float width = 64f;
	public float height = 64f;
	public int hp = 5;
	public boolean destroyed = false;
	public Image image;
	
	public Asteroid(float x, float y) throws SlickException
	{
		this.x = x;
		this.y = y;
		
			this.image = new Image("./res/Asteroid.png");
			
		
	}
	
	public Asteroid(int tx, int ty) throws SlickException
	{
		this.x = tx * 64;
		this.y = ty * 64;
		
		this.image = new Image("./res/Asteroid.png");
		System.out.println(this.image);
	
	}
	
	public void render(Graphics graphics, int flightPath)
	{
		
		if(this.image != null)
		{
			this.image.draw(this.x + flightPath, this.y);
		}
	}
	public Rectangle getRect(int flightPath)
	{
		return new Rectangle((int)this.x + flightPath, (int)this.y, (int)this.width, (int)this.height);
		
	}
}

