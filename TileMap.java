import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TileMap {
	private char[][] _tiles;
	private char[][] _buffer;
	private int _width;
	private int _height;

	
	public int getWidth() { return _width; }
	public int getHeight() { return _height; }
	
	public TileMap(int width, int height) {
		_width = width;
		_height = height;

		
		
		_tiles = new char[width][height];
		_buffer = new char[width][height];
		for (int i = 0; i < _width; i++) {
			for (int j = 0; j < _height; j++) {
				_tiles[i][j] = _buffer[i][j] = ' ';
			}
		}
	}
	
	public void setTile(int x, int y, char value) {
		_tiles[x][y] = value;
	}
	
	public char getTile(int x, int y) {
		return _tiles[x][y];
	}
	
	/**
	 * Randomly fills the map with fillPct of walls
	 * @param fillPct
	 */
	public void fillRandom(int fillPct) {
		Random rng = new Random();
		
		for(int i = 0; i < _width; i++) {
			for(int j = 0; j < _height; j++) {
				_tiles[i][j] = ( rng.nextInt(101) <= fillPct ? '*' : ' ' );
			}
		}
	}
	
	public void fillRect(int x, int y, int width, int height, char value) {
		for(int i = x; i < x + width; i++) {
			for(int j = y; j < y + height; j++) {
				setTile(i, j, value);
			}
		}
	}
	
	public void smoothMap(int iterations, int numNeighbors) {
		for(int k = 0; k < iterations; k++) {
			for(int i = 1; i < _width - 1; i++) {
				for(int j = 1; j < _height - 1; j++) {
					int neighbors = countNeighbors(i, j);
					_buffer[i][j] = (neighbors <= numNeighbors ? ' ' : '*');
				}
			}
			swapBuffer();
		}
	}
	
	public void draw(Screen screen) {
		for(int i = 0; i < _width; i++) {
			for(int j = 0; j < _height; j++) {
				screen.getPixels()[i][j] = _tiles[i][j];
			}
		}
	}
	
	private int countNeighbors(int x, int y) {
		int numNeighbors = 0;
		for(int i = x - 1; i <= x + 1; i++) {
			for(int j = y - 1; j <= y + 1; j++) {
				if(_tiles[i][j] != ' ')
					numNeighbors++;
			}
		}
		
		return numNeighbors;
	}
	
	private void swapBuffer() {
		char[][] oldTiles = _tiles;
		_tiles = _buffer;
		_buffer = oldTiles;
	}
}