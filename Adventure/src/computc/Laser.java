package computc;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Laser 
{
	public float x;
	public float y;
	public float width = 40f;
	public float height = 10f;
	public boolean offScreen = false;
	public Sound sound;
	
	public Laser(float x, float y)
	{
		this.x = x;
		this.y = y;
		try {
			this.sound = new Sound("./res/PEWPEW.wav");
			this.sound.play();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
