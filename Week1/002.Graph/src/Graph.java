import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Graph extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1680, 1050);
        canvas.getGraphicsContext2D().translate(canvas.getWidth()/2, canvas.getHeight()/2);
        canvas.getGraphicsContext2D().scale(1, -1);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Graph");
        primaryStage.show();
    }


    public void draw(FXGraphics2D graphics) {
        double scale = 50;


        graphics.setColor(Color.green);
        graphics.drawLine(-1000, 0, 1000, 0);  // x-as
        graphics.setColor(Color.red);
        graphics.drawLine(0, -1000, 0, 1000);  // y-as
        graphics.setColor(Color.blue);
        Path2D path = new Path2D.Double();

        for (double x = -10; x <= 10; x += 0.01) {
            double y = Math.pow(x, 3);
            double drawX = x * scale;
            double drawY = y * 0.01 * scale;

            if (x == -10) path.moveTo(drawX, drawY);
            else path.lineTo(drawX, drawY);
        }
        graphics.draw(path);
    }

    public static void main(String[] args) {
        launch(Graph.class);
    }

}
