import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameState extends State
{
	private TileMap map;
	private Entity player;
	private ArrayList<Enemy> objectsArray = new ArrayList<Enemy> ( );
	private PlayerController playerController;

	/**
	 * @return the objectsArray
	 */
	public ArrayList<Enemy> getObjectsArray( )
	{
		return objectsArray;
	}

	/**
	 * @param objectsArray
	 *           the objectsArray to set
	 */
	public void setObjectsArray( ArrayList<Enemy> objectsArray )
	{
		this.objectsArray = objectsArray;
	}

	/**
	 * @return the playerController
	 */
	public PlayerController getPlayerController( )
	{
		return playerController;
	}

	/**
	 * @param playerController
	 *           the playerController to set
	 */
	public void setPlayerController( PlayerController playerController )
	{
		this.playerController = playerController;
	}

	/**
	 * @return the map
	 */
	public TileMap getMap( )
	{
		return map;
	}

	/**
	 * @param map
	 *           the map to set
	 */
	public void setMap( TileMap map )
	{
		this.map = map;
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity( )
	{
		return player;
	}

	/**
	 * @param entity
	 *           the entity to set
	 */
	public void setEntity( Entity entity )
	{
		this.player = entity;
	}

	/**
	 * @return the objects
	 */
	public ArrayList<Enemy> getObjects( )
	{
		return objectsArray;
	}

	/**
	 * @param objects
	 *           the objects to set
	 */
	public void setObjects( ArrayList<Enemy> objects )
	{
		this.objectsArray = objects;
	}

	public GameState()
	{

		int mapWidth = 120;
		int mapHeight = 50;
		this.map = new TileMap ( mapWidth, mapHeight );
		map.fillRandom ( 60 );
		map.smoothMap ( 1, 6 );
		map.smoothMap ( 3, 3 );
		map.fillRect ( 0, 0, mapWidth, 1, '*' );
		map.fillRect ( 0, mapHeight - 1, mapWidth, 0, '*' );
		map.fillRect ( 0, 0, 0, mapHeight, '*' );
		map.fillRect ( mapWidth - 1, 0, 1, mapHeight, '*' );
		//adding this 
		hardCodeOutLineOfGame();
		objectsArray = new ArrayList ( );
		this.player = null;
		player = new Player ( );
		player.setActionPoints ( 2 );
		vaildSpawn ( player );
		player.setDmg (  100);
		player.setHealth ( 100 );
		Enemy en1 = new Enemy ( );
		vaildSpawn ( en1 );
		en1.setHealth ( 100 );
		en1.setDmg ( 100 );
		en1.setActionPoints ( 2 );
		objectsArray.add ( en1 );
		

		playerController = new PlayerController ( );

	}

	private void hardCodeOutLineOfGame( )
	{
		for(int i = 0 ; i < 120 ; i ++)
		{
			map.setTile ( i, 0, '*' );
		}
		for(int i = 0 ; i < 50 ; i ++)
		{
			map.setTile ( 0, i, '*' );
		}
		for(int i = 0 ; i < 120 ; i ++)
		{
			map.setTile ( i, 49, '*' );
		}
		
	}

	public void vaildSpawn( Entity e )
	{
		Random randXNum = new Random ( );
		Random randyNum = new Random ( );
		int xNum = randXNum.nextInt ( 120) ;
		int yNum = randyNum.nextInt ( 50 );
		while ( map.getTile ( xNum, yNum ) != ' ' )
		{
			xNum = randXNum.nextInt ( 120 ) ;
			yNum = randyNum.nextInt ( 50 ) ;
		}
		e.x = xNum;
		e.y = yNum;

	}

	public void addEntity( Enemy entity )
	{
		objectsArray.add ( entity );
	}

	@Override
	public void handleInput( KeyEvent e )
	{
		System.out.println ( player.getHealth ( ) );
		System.out.println ( "test" );
		if ( player.getHealth ( ) != 0 )
		{
			switch ( e.getCode ( ) )
			{
				case W:
					playerAction ( player.getX ( ), player.getY ( ) - 1 );
					break;
				case A:
					playerAction ( player.getX ( ) - 1, player.getY ( ) );
					break;
				case S:
					playerAction ( player.getX ( ), player.getY ( ) + 1 );
					break;
				case D:
					playerAction ( player.getX ( ) + 1, player.getY ( ) );
					break;
			}
			player.setActionPoints ( player.getActionPoints ( ) - 1 );

			if ( player.getActionPoints ( ) == 0 )
			{
				for ( Enemy en : objectsArray )
				{

					for ( int i = 0; i < en.getActionPoints ( ); i++ )
					{
						
						enemyMovement ( en );
					}

				}
				player.setActionPoints ( 2 );
			}
		}
		if(player.getHealth ( ) <0)
		{
			gameOver();
		}
	}

	private void gameOver( )
	{
		System.out.println ( "THE GAME IS OVER!" );
		
		//map.setTile ( 10, 10, '-' );
		for(int i = 0 ; i < map.getHeight ( ) ; i ++)
		{
			for(int j = 0 ; j < map.getWidth ( );j++)
			{
				map.setTile ( j, i, '-' );
			}
		}
		
	}

	public void playerAction( int x, int y )
	{
		System.out.println ( player.x + " " + player.y );
		int moveX;
		int moveY;
		boolean attack = false;
		for ( Entity e : objectsArray )
		{
			if ( e.getX ( ) == player.getX ( ) && e.getY ( ) == player.getY ( ) )
			{

				attack = true;
				e.setHealth ( e.getHealth ( ) - player.getDmg ( ) );
				if ( e.getHealth ( ) == 0 )
				{
					objectsArray.remove ( e );
				}

			}
		}
		if ( attack == false && map.getTile ( x, y ) == ' ' )
		{
			player.setX ( x );
			player.setY ( y );
		}
		else if ( attack == false && map.getTile ( x, y ) == '*' )
		{
			player.setActionPoints ( player.getActionPoints ( ) + 1 );
		}
	}

	public void enemyMovement( Enemy enemy )
	{
		Random random = new Random ( );
		int movement = random.nextInt ( 100 ) + 1;

		if ( movement <= 25 )
		{
			// +x
			enemyAction ( enemy, enemy.getX ( ) + 1, enemy.getY ( ) );
		}
		else if ( movement > 25 && movement <= 50 )
		{
			// +y
			enemyAction ( enemy, enemy.getX ( ), enemy.getY ( ) + 1 );
		}
		else if ( movement > 50 && movement <= 75 )
		{
			// -x
			enemyAction ( enemy, enemy.getX ( ) - 1, enemy.getY ( ) );
		}
		else if ( movement > 75 )
		{
			// -y
			// obj.setY(obj.getY()-1);
			enemyAction ( enemy, enemy.getX ( ), enemy.getY ( ) - 1 );
		}

	}

	public void enemyAction( Enemy enemy, int x, int y )
	{
		int moveX;
		int moveY;
		boolean attack = false;

		if (enemy.getHealth ( ) > 0 && enemy.getX ( ) == player.getX ( ) && enemy.getY ( ) == player.getY ( ) )
		{

			attack = true;
			player.setHealth ( player.getHealth ( ) - enemy.getDmg ( ) );

		}

		if ( attack == false && map.getTile ( x, y ) == ' ' )
		{
			enemy.setX ( x );
			enemy.setY ( y );
		}

	}

	@Override
	public void begin( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void update( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void draw( Screen screen )
	{
		// TODO Auto-generated method stub
		map.draw ( screen );
		for ( Entity e : objectsArray )
		{
			e.draw ( screen );
		}
		player.draw ( screen );
	}

	@Override
	public void end( )
	{
		// TODO Auto-generated method stub

	}

}
