import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroScreenController
{
	@FXML private Text content; 
	@FXML private BorderPane root; 
	public void initialize()
	{
		
		
		
		content.setText (  "You are standing in the middle of the Irikol Forest, the only home you've ever known." 
				+"\nA sweet melody drifts to your ears, and you're compelled to follow it. As you close in on the sound," 
				+"\nyou are stopped by a wall of flame that sprouts up in front of you." 
				+"\nThe heat is so intense it causes you to take a few steps back, and you fall on your back. "
				+"\nA MAN looms into your view, his cruel black eyes boring into your very soul as he looks down on you." 
				+"\nYou do not know the man, but the sight of his face fills you with a fear that takes your breath."
				+"\n"
				+"\nVOYA: player.getName() WAKE UP! THE GAIA TREE WANTS TO SPEAK WITH YOU!!"
				+"\n"
				+"\nYou awaken, and you see a FAIRY, frantically circling your head, desperately trying to get your attention." 
				+"\nYou sit up on your bed, listening intently to the fairy."
				+"\n"
				+"\nVOYA: Aren't you happy player.getName()? You finally have a fairy! My name is VOYA, and I will guide you!"
				+"\n"
				+"\nShe's right. Every other forest child of the Irikol Forest has a fairy guide with them." 
				+"\nYou were the only one without one, until now. You follow VOYA through Irikol Village, "
				+"\nand all the other forest children wave and call out to you from their cozy treehouses. "
				+"\nYou hop on the stepping stones of the lake, and you run into ODIM. ODIM has never liked you, for some reason."
				+"\n"
				+"\nODIM: Where do you think you're going? You can't go see the Gaia Tree!" 
				+"\nYou don't even have a sword!"
				+"\n"
				+"\nYou try to reason with him, but he refuses to let you through."
				+"\n"
				+"\nVOYA: I guess we had better go find a sword...ODIM is right," 
				+"\nthe path to reach the Gaia Tree is dangerous, you'll need something to protect yourself."); 
	}
	
	
	public void handleStart (ActionEvent event) throws IOException
	{
		FXMLLoader rootloader = new FXMLLoader ( getClass ( ).getResource ( "MainScreen.fxml" ) );
		root = (BorderPane) rootloader.load ( );

		Stage main = (Stage) ( ( (Node) event.getSource ( ) ).getScene ( ).getWindow ( ) );

		Scene mainScene = new Scene ( root );
		main.setScene ( mainScene );
		main.show ( );
	}


}
