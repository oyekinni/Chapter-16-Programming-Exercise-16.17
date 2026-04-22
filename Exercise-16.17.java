import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise16_17 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // sliders control the text color and opacity
        Label text = new Label("JavaRX Colors");
        text.setFont(new Font("Times New Roman", 28));

        Slider red = new Slider(0, 255, 0);
        Slider green = new Slider(0, 255, 0);
        Slider blue = new Slider(0, 255, 0);
        Slider opacity = new Slider(0, 100, 100);

        Slider[] bars = {red, green, blue, opacity};

        for (Slider s : bars) {
            s.setShowTickLabels(true);
            s.setShowTickMarks(true);
            s.setMajorTickUnit(50);
            s.setBlockIncrement(1);
        }

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("Red"), 0, 0);
        pane.add(red, 1, 0);
        pane.add(new Label("Green"), 0, 1);
        pane.add(green, 1, 1);
        pane.add(new Label("Blue"), 0, 2);
        pane.add(blue, 1, 2);
        pane.add(new Label("Opacity"), 0, 3);
        pane.add(opacity, 1, 3);

        red.valueProperty().addListener(e -> {
            text.setTextFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
                    (int) blue.getValue(), opacity.getValue() / 100.0));
        });

        green.valueProperty().addListener(e -> {
            text.setTextFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
                    (int) blue.getValue(), opacity.getValue() / 100.0));
        });

        blue.valueProperty().addListener(e -> {
            text.setTextFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
                    (int) blue.getValue(), opacity.getValue() / 100.0));
        });

        opacity.valueProperty().addListener(e -> {
            text.setTextFill(Color.rgb((int) red.getValue(), (int) green.getValue(),
                    (int) blue.getValue(), opacity.getValue() / 100.0));
        });

        VBox root = new VBox(20);
        root.getChildren().addAll(text, pane);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
