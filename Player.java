
public class Player extends Entity 
{
	//private Inventory  inventory;
	
	
	public void draw(Screen screen)
	{
		char [] [] array = screen.getPixels ( );
		array [x] [y]= 'P';
		
	}
}