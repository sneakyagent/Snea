
public abstract class Entity
{
private int health;
private int actionPoints;
int x;
 int y; 
private String name;
private int dmg;


public void draw(Screen screen)
{
	char [] [] array = screen.getPixels ( );
	array [x] [y]= 'E';
	
}

/**
 * @return the actionPoints
 */
public int getActionPoints( )
{
	return actionPoints;
}
/**
 * @param actionPoints the actionPoints to set
 */
public void setActionPoints( int actionPoints )
{
	this.actionPoints = actionPoints;
}
/**
 * @return the dmg
 */
public int getDmg( )
{
	return dmg;
}
/**
 * @param dmg the dmg to set
 */
public void setDmg( int dmg )
{
	this.dmg = dmg;
}
public Entity(int health, int actionPoints, int x, int y, String name, int dmg)
{
	super ( );
	this.health = health;
	this.actionPoints = actionPoints;
	this.x = x;
	this.y = y;
	this.name = name;
	this.dmg = dmg;
}
/**
 * @return the health
 */
public int getHealth( )
{
	return health;
}
/**
 * @param health the health to set
 */
public void setHealth( int health )
{
	this.health = health;
}
/**
 * @return the actionPotins
 */
public int getActionPotins( )
{
	return actionPoints;
}
/**
 * @param actionPotins the actionPotins to set
 */
public void setActionPotins( int actionPotins )
{
	this.actionPoints = actionPotins;
}
/**
 * @return the x
 */
public int getX( )
{
	return x;
}
/**
 * @param x the x to set
 */
public void setX( int x )
{
	this.x = x;
}
/**
 * @return the y
 */
public int getY( )
{
	return y;
}
/**
 * @param y the y to set
 */
public void setY( int y )
{
	this.y = y;
}
/**
 * @return the name
 */
public String getName( )
{
	return name;
}
/**
 * @param name the name to set
 */
public void setName( String name )
{
	this.name = name;
}
public Entity()
{
	super ( );
	  health= -1;
	  actionPoints=-1;
	  x=-1;
	  y=-1; 
	 name= " ";
	
	
}
public Entity(int health, int actionPotins, int x, int y, String name)
{
	super ( );
	this.health = health;
	this.actionPoints = actionPotins;
	this.x = x;
	this.y = y;
	this.name = name;
}






}
