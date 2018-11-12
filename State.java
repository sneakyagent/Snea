import javafx.scene.input.KeyEvent;

public class State {
	private StateMachine _fsm;
	
	public void setStateMachine(StateMachine fsm) { _fsm = fsm; }
	
	
	public void begin() {}
	public void update() {}
	public void draw(Screen screen) {}
	public void end() {}


	public void handleInput( KeyEvent e )
	{
		
	}
}
