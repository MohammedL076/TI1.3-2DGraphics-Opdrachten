import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Spirograph extends Application {
    private TextField v1;
    private TextField v2;
    private TextField v3;
    private TextField v4;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(1680, 1050);
        VBox mainBox = new VBox();
        HBox topBar = new HBox();
        mainBox.getChildren().add(topBar);
        mainBox.getChildren().add(new Group(canvas));

        topBar.getChildren().add(v1 = new TextField("300"));
        topBar.getChildren().add(v2 = new TextField("1"));
        topBar.getChildren().add(v3 = new TextField("300"));
        topBar.getChildren().add(v4 = new TextField("10"));

        v1.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v2.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v3.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));
        v4.textProperty().addListener(e -> draw(new FXGraphics2D(canvas.getGraphicsContext2D())));

        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(mainBox));
        primaryStage.setTitle("Spirograph");
        primaryStage.show();
    }

    public void draw(FXGraphics2D graphics) {
        graphics.setTransform(new AffineTransform());
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1680, 1050);
        graphics.translate(840, 525);
        graphics.scale(1, -1);
        graphics.setColor(Color.BLUE);

        double a = Double.parseDouble(v1.getText());
        double b = Double.parseDouble(v2.getText());
        double c = Double.parseDouble(v3.getText());
        double d = Double.parseDouble(v4.getText());

        Path2D path = new Path2D.Double();
        boolean first = true;

        for (double phi = 0; phi < Math.PI * 50; phi += 0.01) {
            double x = a * Math.cos(b * phi) + c * Math.cos(d * phi);
            double y = a * Math.sin(b * phi) + c * Math.sin(d * phi);

            if (first) {
                path.moveTo(x, y);
                first = false;
            } else {
                path.lineTo(x, y);
            }
        }
        float hue = 0.6f;
        graphics.setColor(Color.getHSBColor(hue, 1f, 1f));

        graphics.draw(path);
    }
    public static void main(String[] args) {
        launch(Spirograph.class);
    }
}
