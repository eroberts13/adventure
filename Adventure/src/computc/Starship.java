package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class Starship 
{
	public float x;
	public float y;
	public float width = 50f;
	public float height = 50f;
	public int laserCoolDown = 0;
	
	public Starship(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics graphics)
	{
		graphics.setColor(Color.white);
		graphics.fillRect(this.x, this.y, this.width, this.height);
	}
	
	public Rectangle getRect()
	{
		return new Rectangle((int)this.x + 5, (int)this.y + 5, (int)this.width - 5, (int)this.height - 5);
		
	}
}