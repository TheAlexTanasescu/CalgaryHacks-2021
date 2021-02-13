
import javafx.application.Application;
import javafx.scene.canvas.Canvas;  // 
import javafx.scene.Scene; // The JavaFX Scene class is the container for all content.
import javafx.scene.Group;
import javafx.stage.Stage;  // The JavaFX Stage class is the top-level JavaFX container. 
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Game extends Application
{
	
	/** The Constant width. */
	private static final int width = 864;
	
	/** The Constant height. */
	private static final int height = 480;
	
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  Group root = new Group(); // root node for graphics or animation
   	  Scene scene = new Scene(root); // Each scene has a root node (e.g  a group or pane)

      Canvas canvas = new Canvas(400, 300);
      GraphicsContext gc = canvas.getGraphicsContext2D();
      
	  
	  gc.strokeOval(100, 50, 200, 200);
	  gc.fillOval(155, 100, 10, 20);
	  gc.fillOval(230, 100, 10, 20);
	  gc.strokeArc(150, 160, 100, 50, 180, 180, ArcType.CHORD);

      root.getChildren().add(canvas);
      primaryStage.setTitle("HappyFace in JavaFX");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
