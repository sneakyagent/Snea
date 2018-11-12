
public class Enemy extends Entity
{
	public void draw(Screen screen)
	{
		char [] [] array = screen.getPixels ( );
		array [x] [y]= 'E';
		
	}
}
