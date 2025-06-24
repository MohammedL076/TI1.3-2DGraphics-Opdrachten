import java.awt.*;
import java.awt.geom.*;
import java.nio.file.Path;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Spiral extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1680, 1050);
        canvas.getGraphicsContext2D().translate(canvas.getWidth()/2, canvas.getHeight()/2);
        canvas.getGraphicsContext2D().scale(1, -1);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Spiral");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        double scale = 10; // scale
        double n = 0.8; // wijd

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawLine(-1000, 0, 1000, 0);
        graphics.drawLine(0, -1000, 0, 1000);

        graphics.setColor(Color.BLUE);
        Path2D path = new Path2D.Double();

        // de som
        boolean first = true;
        for (double phi = 0; phi <= 40 * Math.PI; phi += 0.01) {
            double r = n * phi;
            double x = r * Math.cos(phi);
            double y = r * Math.sin(phi);

            // omzetten naar schermformaat
            double drawX = x * scale;
            double drawY = y * scale;

            // het tekenen
            if (first) {
                path.moveTo(drawX, drawY);
                first = false;
            } else {
                path.lineTo(drawX, drawY);
            }
        }
        graphics.draw(path);
    }

    public static void main(String[] args) {
        launch(Spiral.class);
    }

}
