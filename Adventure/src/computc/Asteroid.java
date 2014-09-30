package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Asteroid 
{
	public float x;
	public float y;
	public float width = 64f;
	public float height = 64f;
	public int hp = 5;
	public boolean destroyed = false;
	
	public Asteroid(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Asteroid(int tx, int ty)
	{
		this.x = tx * 64;
		this.y = ty * 64;
	}
	
	public void render(Graphics graphics, int flightPath)
	{
		graphics.setColor(new Color(112, 146, 190));
		graphics.fillRect(this.x + flightPath, this.y, this.width, this.height);
	}
	public Rectangle getRect(int flightPath)
	{
		return new Rectangle((int)this.x + flightPath, (int)this.y, (int)this.width, (int)this.height);
		
	}
}

