import java.awt.*;
import java.awt.geom.*;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import sun.java2d.loops.FillRect;

public class Moon extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Moon");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }

    public void draw(FXGraphics2D graphics) {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());

        // midden zoeken
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;

        GeneralPath path = new GeneralPath();

        path.moveTo(centerX - 115, centerY - 135);
        // buitenkant van de maan
        path.curveTo(centerX + 115, centerY - 135, centerX + 115, centerY + 135, centerX - 115, centerY + 135);
        // binnnekant van de maan
        path.curveTo(centerX + 15, centerY + 135, centerX + 15, centerY - 135, centerX - 115, centerY - 135);

        graphics.setColor(Color.BLACK);
        graphics.fill(path);
        graphics.draw(path);
    }


    public static void main(String[] args)
    {
        launch(Moon.class);
    }
}
