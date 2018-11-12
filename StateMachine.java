import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
public class StateMachine {
	private Stack<State> state = new Stack<State>();
	private MainScreenController controller;
	
	public StateMachine() {
		
	}
	
	public State getCurrent()
	{
		return state.peek();
	}
	
	public State push(State item)
	{
		item.setStateMachine ( this );
		item.begin();
		state.push(item);
		return item;
	}
	
	public State pop()
	{
		State temp =  state.pop();
		temp.end();
		return temp;
	}
	public void update()
	{
		State temp = state.peek();
		temp.update();
		//System.out.println(temp.toString());
	}
	public void draw(Screen screen)
	{
		State temp = state.peek();
		temp.draw(screen);
		//System.out.println(temp.toString());
	}
	public String getCurrentText()
	{
		return state.peek().toString();
	}
	
	
	public void setMainScreenController (MainScreenController controller)
	{
		this.controller = controller;
	}

	public void handleInput(KeyEvent e) {
		System.out.println ( e.getCode ( ) );
		state.peek ( ).handleInput(e);
		
	
	}
}
