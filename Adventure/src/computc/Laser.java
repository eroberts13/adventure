package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Laser 
{
	public float x;
	public float y;
	public float width = 40f;
	public float height = 10f;
	public boolean offScreen = false;
	
	public Laser(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void update(int delta)
	{
		this.x += 2 * delta;
		if(this.x > Adventure.WIDTH)
		{
			this.offScreen = true;
		}
	}
	public void render(Graphics graphics)
	{
		graphics.setColor(Color.red);
		graphics.fillRect(this.x, this.y, this.width, this.height);
	}
	public Rectangle getRect()
	{
		return new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.height);
		
	}
	
}
