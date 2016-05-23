import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.*;

public class BallPane extends Pane 
{
	private Timeline animation;
	ArrayList<Ball> ballList = new ArrayList<>();

	//constructor
	BallPane() 
	{
		animation = new Timeline(
		new KeyFrame(Duration.millis(50), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	//play
	public void play() 
	{
		animation.play();
	}

	//pause
	public void pause()
	{
		animation.pause();
	}

	//increase speed
	public void increaseSpeed() 
	{
		animation.setRate(animation.getRate() + 1);
	}
	
	//decrease speed
	public void decreaseSpeed() 
	{
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
	}

	public DoubleProperty rateProperty() 
	{
		return animation.rateProperty();
	}	
	
	//create a new ball
	void newBall()
	{
		Ball ball = new Ball();
		ballList.add(ball);
		getChildren().add(ball.circle);
	}
	
	//to call all ball's moveBall method
	void moveBall()
	{
		for (int i = 0; i < ballList.size(); i++)
		{
			ballList.get(i).moveBall(getWidth(), getHeight());
			for (int j = 0; j < ballList.size(); j++)
			{
				if (i == j)
					continue;
				double disOfCenter = Math.sqrt(Math.pow(ballList.get(i).circle.getCenterX()- ballList.get(j).circle.getCenterX(), 2) + Math.pow(ballList.get(i).circle.getCenterY() - ballList.get(j).circle.getCenterY(), 2));
				double sumOfRadius = ballList.get(i).circle.getRadius() + ballList.get(j).circle.getRadius();
				if (disOfCenter <= sumOfRadius)
				{
					ballList.get(i).reverse();
					ballList.get(j).reverse();
				}
			}
		}
	}
}
