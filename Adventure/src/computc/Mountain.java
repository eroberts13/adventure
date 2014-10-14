package computc;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Mountain 


{
	public Image image;
	private float x;
	private float y;
	private int z;
	public void render(Graphics graphics, int flightPath)
	{
		
		if(this.image != null)
		{
			this.image.draw(this.x + (flightPath/this.z), this.y);
		}
	}
	public Mountain(float x, float y, int z) throws SlickException
	{
		this.image = new Image("./res/Mountain.png");
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
