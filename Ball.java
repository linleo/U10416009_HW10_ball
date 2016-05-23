import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.security.SecureRandom;

public class Ball
{
	SecureRandom srand = new SecureRandom();
	//data field
	private double dx = 1, dy = 1;
	double x = srand.nextDouble() + srand.nextInt(700) + 50;
	double y = srand.nextDouble() + srand.nextInt(700) + 50;
	double radius = srand.nextInt(20) + 10;
	int ballColor = srand.nextInt(8);
	public Circle circle;
	boolean flag = false;
	long startTime;
	
	//constructor
	Ball()
	{
		circle = new Circle(x, y, radius);
		
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
	
	//move ball
	protected void moveBall(double width, double height)
	{
		if (System.currentTimeMillis() - startTime > 200)
			flag = false;
			
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
	
	//to let ball reverse
	void reverse()
	{
		if (flag)
			return;
		dx *= -1;
		dy *= -1;
		flag = true;
		startTime = System.currentTimeMillis();
	}
}
