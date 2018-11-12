
public class Screen
{
	private char[][] _pixels;
	public char[][] getPixels() { return _pixels; }
	

	
	
	public Screen(int width, int height) 
	{
		_pixels = new char[width][height];
		
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				_pixels[i][j] = ' '; 
			}
		}
	}
	

	
}
