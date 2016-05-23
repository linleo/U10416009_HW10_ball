import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.security.SecureRandom;

public class Ball
{
	SecureRandom srand = new SecureRandom();
	double width, height;
	private double dx = 1, dy = 1;
	double x = srand.nextDouble() + srand.nextInt(700) + 50;
	double y = srand.nextDouble() + srand.nextInt(700) + 50;
	double radius = srand.nextInt(20) + 10;
	int ballColor = srand.nextInt(8);
	public Circle circle;
	
	Ball(double width, double height)
	{
		circle = new Circle(x, y, radius);
		this.width = width;
		this.height = height;
		
		if(ballColor == 0)
			circle.setFill(Color.RED);
		else if(ballColor == 1)
			circle.setFill(Color.BLUE);
		else if(ballColor == 2)
			circle.setFill(Color.BLACK);
		else if(ballColor == 3)
			circle.setFill(Color.GREEN);
		else if(ballColor == 4)
			circle.setFill(Color.YELLOW);
		else if(ballColor == 5)
			circle.setFill(Color.PINK);
		else if(ballColor == 6)
			circle.setFill(Color.PURPLE);
		else if(ballColor == 7)
			circle.setFill(Color.SKYBLUE);
	}
	
	protected void moveBall()
	{
		if (x < radius || x > width - radius) 
		{
			dx *= -1;
		}
		if (y < radius || y > height - radius) 
		{
			dy *= -1;
		}

		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);						
	}
	
	void reverse()
	{
		dx *= -1;
		dy *= -1;
	}
}
