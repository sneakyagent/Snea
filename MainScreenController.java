


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainScreenController 
{
	@FXML private BorderPane root; 
	@FXML private Canvas mapView; 
	@FXML private Text hp; 
	@FXML private Text ap; 
	
	private Screen screen;
	private StateMachine fsm;

	/**
	 * @return the screen
	 */
	public Screen getScreen( )
	{
		return screen;
	}

	/**
	 * @param screen the screen to set
	 */
	public void setScreen( Screen screen )
	{
		this.screen = screen;
	}

	/**
	 * @return the fsm
	 */
	public StateMachine getFsm( )
	{
		return fsm;
	}

	/**
	 * @param fsm the fsm to set
	 */
	public void setFsm( StateMachine fsm )
	{
		this.fsm = fsm;
	}

	public void initialize ()
	{
		 screen = new Screen(120, 50);
 		
 		fsm = new StateMachine();
 		fsm.setMainScreenController ( this );
 		

 		
 		GameState gameState = new GameState();
 		
 		fsm.push(gameState);
 		fsm.draw ( screen );
 		char array [][] = screen.getPixels ( );
 		draw(array);
 		
		/*root.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			fsm.handleInput ( key );
		}); */ 
 		
 	
	}

	public void draw (char array [] [])
	{
		for (int i = 0; i < 120; i++)
		{
			for (int j = 0; j < 50; j++)
			{
				double x = i*10; 
				double y = j*10;
				if (array[i][j] == '*')
				{

					mapView.getGraphicsContext2D ( ).setFill ( Color.GRAY );
					mapView.getGraphicsContext2D ( ).fillRect(x, y, 10, 10);
				}
				else if (array [i][j] == 'E')
				{
					mapView.getGraphicsContext2D ( ).setFill ( Color.BROWN );
					mapView.getGraphicsContext2D ( ).fillRect(x, y, 10, 10);
				}
				else if (array [i][j] == 'P')
				{
					mapView.getGraphicsContext2D ( ).setFill ( Color.CHARTREUSE );
					mapView.getGraphicsContext2D ( ).fillRect(x, y, 10, 10);
				}
				else if (array [i][j] == '-')
				{
					mapView.getGraphicsContext2D ( ).setFill ( Color.DARKRED );
					mapView.getGraphicsContext2D ( ).fillRect(x, y, 10, 10);
				}
				else
				{
					mapView.getGraphicsContext2D ( ).setFill ( Color.WHITE);
					mapView.getGraphicsContext2D ( ).fillRect(x, y, 10, 10); 
				}
			}
		}
	}
	
	

	public void handleKeyEvents(KeyEvent e)
	{
		fsm.handleInput ( e );
		fsm.draw ( screen );
		mapView.getGraphicsContext2D ( ).clearRect ( 0, 0, 1200, 500 );
		draw ( screen.getPixels ( ) );
		

	}
	
	
	
	
	


	
}
