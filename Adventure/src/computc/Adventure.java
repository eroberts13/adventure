package computc;



import java.awt.Rectangle;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.tiled.TiledMap;

public class Adventure extends BasicGame
{
	public Starship arwing;
	public int flightPath;
	public TiledMap planetx;
	public ArrayList<Asteroid> asteroids; 
	public ArrayList<Laser> lasers;
	private Mountain mountain;
	public Adventure()
	{
		super("We don't have a name yet.");
	}
	
	public void init(GameContainer container) throws SlickException
	{
				reset();
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		Input myinput = container.getInput();
		
		if(myinput.isKeyDown(Input.KEY_LEFT))
		{
			if(arwing.x > 0)
			{	
				arwing.x -= 0.25f * delta;
			}
		}
		if(myinput.isKeyDown(Input.KEY_RIGHT))
		{
			if(arwing.x + arwing.width < WIDTH)
			{	
				arwing.x += 0.25f * delta;
			}
		}
		if(myinput.isKeyDown(Input.KEY_UP))
		{
			if(arwing.y > 0)
			{
				arwing.y -= 0.25f * delta;
			}
		}
		if(myinput.isKeyDown(Input.KEY_DOWN))
		{
			if(arwing.y + arwing.height < HEIGHT)
			{
				arwing.y += 0.25f * delta;
			}
		}
		for(Asteroid asteroid : asteroids)
		{
			if(!asteroid.destroyed)
			{
				Rectangle myRect = arwing.getRect();
				Rectangle hisRect = asteroid.getRect(flightPath);
				if(myRect.intersects(hisRect))
				{
					System.out.println("BOOM");
					reset();
				}
				for(Laser laser : lasers)
				{
					if(!laser.offScreen)
					{
						Rectangle laserRect = laser.getRect();
						if(hisRect.intersects(laserRect))
						{
							System.out.println("BAM!!");
							laser.offScreen = true;
							asteroid.hp -= 1;
							if(asteroid.hp <=0 && !(asteroid instanceof Terrain))
							{
								asteroid.destroyed = true;
							}
						}
					}
				}
			}
		}
		flightPath -= 0.25f * delta;
		
		if(flightPath <= -33 * 64)
		{
			if(myinput.isKeyDown(Input.KEY_R))
			{
				reset();
			}
		}
		if(myinput.isKeyDown(Input.KEY_SPACE))
		{
			if(arwing.laserCoolDown <= 0)
			{
				lasers.add(new Laser(arwing.x + (arwing.width/2), arwing.y + (arwing.height/2)));
				arwing.laserCoolDown = 50;
			}
		}
		arwing.laserCoolDown -=1 * delta;
		for(Laser laser : lasers)
		{
			laser.update(delta);
		}  
	}
	
	public void render(GameContainer container, Graphics graphics) throws SlickException
	{
		
		planetx.render(flightPath, 0, 0);
		mountain.render(graphics, flightPath);
		arwing.render(graphics);
		for(Laser laser : lasers)
		{
			if(!laser.offScreen)
			{
				laser.render(graphics);
			}
		}
		
		if(flightPath <= -33 * 64)
		{
			if(shouldWePaintItRed())
			{
				graphics.setColor(Color.red);
			}
			else
			{
				graphics.setColor(Color.white);
			}
			graphics.drawString("Joo Win!!! Press R to play again!!!!!!!!111!`", 50, 50);
		}
		
		for(Asteroid asteroid : asteroids)
		{
			if(!asteroid.destroyed)
			{
				asteroid.render(graphics, flightPath);
			}
		}
		
	}
	
	public void reset()
	{
		
		flightPath = 0;
		asteroids = new ArrayList<Asteroid>();
		lasers = new ArrayList<Laser>();
		
		try
		{
			planetx = new TiledMap("./res/PlanetX.tmx");
			arwing = new Starship(10, 20);
			for(int tx = 0; tx < planetx.getWidth(); tx++)
			{
				for(int ty = 0; ty < 7; ty++)
				{
					if(planetx.getTileId(tx, ty, 0) == 3)
					{
						asteroids.add(new Terrain(tx, ty));
					}
					if(planetx.getTileId(tx, ty, 1) == 4)
					{
						asteroids.add(new Asteroid(tx, ty));
					}
					
				}
			}
			mountain = new Mountain(352, 224-64, 2);
		}
		catch(Exception exception)
		{
			//Meh.
		}
		
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer container = new AppGameContainer(new Adventure());
			container.setDisplayMode(WIDTH, HEIGHT, false);
			container.start();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public boolean shouldWePaintItRed()
	{
		for(Laser laser : lasers)
		{
			if(!laser.offScreen)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static final int SCREEN_WIDTH = 11;
	public static final int SCREEN_HEIGHT = 7;
	public static final int WIDTH = SCREEN_WIDTH * 64;
	public static final int HEIGHT = SCREEN_HEIGHT * 64;
}
