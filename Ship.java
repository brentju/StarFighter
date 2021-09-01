//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import static java.lang.System.*;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private int lives;
	private Image heart;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
		this(x, y, 10, 10, 10);
	}

	public Ship(int x, int y, int s)
	{
		this(x, y);
		speed = s;
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		lives = 3;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
			URL heartURL = getClass().getResource("/images/heart.png");
			heart = ImageIO.read(heartURL);
		}
		catch(Exception e)
		{
			out.println("Bro wyd");
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if(direction.equals("LEFT"))
		      setX(getX()-getSpeed());
	      else if(direction.equals("RIGHT"))
		      setX(getX()+getSpeed());
	      else if(direction.equals("UP"))
		      setY(getY()-getSpeed());
	      else if(direction.equals("DOWN"))
		      setY(getY()+getSpeed());
	}

	public int getLives()
	{
		return lives;
	}
	
	public void decrementLife()
	{
		lives--;
	}
	
	public void drawLives(Graphics window)
	{
		int x = 5;
		int y = 5;
		for (int i = 0; i < lives; i++)
		{
			window.drawImage(heart, x, y, 30, 30, null);
			x += 35;
		}
	}
	
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
		drawLives(window);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
