import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class House extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1024, 768);
        FXGraphics2D graphics = new FXGraphics2D(canvas.getGraphicsContext2D());
        draw(graphics, 275, 700, 275, 415); // linkerzijde
        draw(graphics, 915, 700, 915, 415); // rechterzijde
        draw(graphics, 275, 700, 915, 700); // onderzijde
        draw(graphics, 275, 415, 915, 415); // bovenzijde
        draw(graphics, 275, 415, 595, 250); // linkerkant dak
        draw(graphics, 915, 415, 595, 250); // rechterkant dak
        draw(graphics, 325, 550, 425, 550); // bovenkant deur
        draw(graphics, 325, 550, 325, 700); // linkerzijde
        draw(graphics, 425, 550, 425, 700); // rechterzijde
        draw(graphics, 550, 475, 850, 475); // bovenkant raam
        draw(graphics, 550, 475, 550, 575); // linkerzijde
        draw(graphics, 850, 475, 850, 575); // rechterzijde
        draw(graphics, 550, 575, 850, 575); // onderzijde

        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("House");
        primaryStage.show();
    }

    public void draw(FXGraphics2D graphics, int x1, int y1, int x2, int y2) {
       graphics.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        launch(House.class);
    }
}
