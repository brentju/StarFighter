//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
			if( x > 750)
			{
				x = 25;
				y += 75;
			}
			aliens.add( new Alien( x, y, 35, 35, 1) );
			x += 75;
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens)
		{
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a : aliens)
		{
			a.move("DOWN");
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int i = 0; i < shots.size(); i++)
		{
			Ammo am = shots.get(i);
			for(int j=0; j<aliens.size();j++)
			{
				Alien al = aliens.get(j);
				if ((am.getX() >= al.getX() && am.getX() <= al.getX()+60) ||
			        (am.getX()+10 >= al.getX() && am.getX()+10 <= al.getX()+60))
			   	     if ((am.getY() >= al.getY() && am.getY() <= al.getY()+60) ||
			   	     	   (am.getY()+10 >= al.getY() && am.getY()+10 <= al.getY()+60))
			   	     	   {
			   		         aliens.remove(j);
			   		         shots.remove(i);
			   		         break;
			   	     	   }
		   }
		}
	}
	
	public void madeShipContact(Ship s)
	{
		for (int i = 0; i < aliens.size(); i++)
		{
			Alien al = aliens.get(i);
			if ((s.getX() >= al.getX() && s.getX() <= al.getX()+60) ||
			        (s.getX()+10 >= al.getX() && s.getX()+10 <= al.getX()+60))
			   	     if ((s.getY() >= al.getY() && s.getY() <= al.getY()+60) ||
			   	     	   (s.getY()+10 >= al.getY() && s.getY()+10 <= al.getY()+60))
			   	     {
			   	    	 aliens.remove(i);
			   	    	 s.decrementLife();
			   	    	 break;
			   	     }
		}
	}
	
	public List<Alien> getList()
	{
		return aliens;
	}

	public String toString()
	{
		return "" + aliens;
	}
}
