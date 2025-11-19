package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CanvasDemo extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 200);

        //canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            System.out.println("Key press: " + keyCode);
            System.out.println("-----");
            System.out.println("Char: " + event.getCharacter());
            System.out.println("Text: " + event.getText());
            System.out.println("Type: " + event.getEventType());
        });

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            System.out.println("X: " + x + ", Y: " + y);
        });

        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            System.out.println("X: " + x + ", Y: " + y);

            double ballX1 = 10.0;
            double ballY1 = 10.0;
            double ballX2 = 40.0;
            double ballY2 = 40.0;

            if (
                    x >= ballX1 && x <= ballX2 &&
                            y >= ballY1 && y <= ballY2
            ) {
                System.out.println("Mouse inside the ball");
            }
        });

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PALEVIOLETRED);
        gc.fillOval(10, 10, 30, 30);

        gc.moveTo(0, 0);
        gc.lineTo(100, 100);

        //gc.moveTo(100, 100);
        gc.lineTo(10, 50);

        //gc.moveTo(20, 50);
        gc.lineTo(150, 10);


        gc.stroke();        // this is needed to actually draw the line


        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 200, 200);
        stage.setTitle("Canvas Demo");
        stage.setScene(scene);
        stage.show();

    }
}
