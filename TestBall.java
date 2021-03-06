import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class TestBall extends Application 
{
	@Override 
	public void start(Stage primaryStage) 
	{
		BallPane ballPane = new BallPane();
		
		//new ten ball
		for (int i = 0; i < 10; i++)
			ballPane.newBall();
	
		//mouse pressed to pause
		ballPane.setOnMousePressed(e -> ballPane.pause());
		//mouse released to play
		ballPane.setOnMouseReleased(e -> ballPane.play());
  
		ballPane.setOnKeyPressed(e -> {
			//press UP key to increase speed
			if (e.getCode() == KeyCode.UP) 
			{
				ballPane.increaseSpeed();
			}
			//press DOWN key to ecrease speed
			else if (e.getCode() == KeyCode.DOWN) 
			{
				ballPane.decreaseSpeed();
			}
		});

		Scene scene = new Scene(ballPane, 800, 800);
		primaryStage.setTitle("Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
    
		ballPane.requestFocus();
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
