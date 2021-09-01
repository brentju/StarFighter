//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.out;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
	private Image image;

	public Ammo()
	{
		this(0,0,0, 0, 0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 10, 10, 0);
	}

	public Ammo(int x, int y, int w, int h, int s)
	{
		super(x, y);
		speed = s;
		try
		{
			URL url = getClass().getResource("/images/bullet.png");
			image = ImageIO.read(url);
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

	public void draw( Graphics window )
	{
		
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	
	public void move( String direction )
	{
		//add code to draw the ammo
		if(direction.equals("UP"))
		      setY(getY()-getSpeed());
	    else if(direction.equals("DOWN"))
		      setY(getY()+getSpeed());
	}

	public String toString()
	{
		return "";
	}
}
