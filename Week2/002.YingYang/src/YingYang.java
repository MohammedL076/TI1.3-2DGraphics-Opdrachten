import java.awt.*;
import java.awt.geom.*;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

public class YingYang extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Ying Yang");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }

    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());

        graphics.setColor(Color.black);
        Ellipse2D.Double circle1 = new Ellipse2D.Double(150,100,200,200);
        graphics.draw(circle1);

        Arc2D.Double arc1 = new Arc2D.Double(150,100,200,200,270,180,Arc2D.OPEN);
        graphics.fill(arc1);

        graphics.setColor(Color.white);
        Ellipse2D.Double circle2 = new Ellipse2D.Double(200,100,100,100);
        graphics.fill(circle2);

        graphics.setColor(Color.black);
        Ellipse2D.Double circle3 = new Ellipse2D.Double(200,200,100,100);
        graphics.fill(circle3);

        graphics.setColor(Color.black);
        Ellipse2D.Double circle4 = new Ellipse2D.Double(240,130,30,30);
        graphics.fill(circle4);

        graphics.setColor(Color.white);
        Ellipse2D.Double circle5 = new Ellipse2D.Double(240,230,30,30);
        graphics.fill(circle5);
    }

    public static void main(String[] args)
    {
        launch(YingYang.class);
    }

}
