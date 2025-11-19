package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VirtualPet extends Application {
    private static final double SIZE = 200;
    private double imageX = 0;
    private double imageY = 0;
    GraphicsContext gc;
    Image image;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(SIZE, SIZE);
        image = new Image("javafx-cat.jpeg");

        gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, imageX, imageY);

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();

            gc.clearRect(0, 0, SIZE, SIZE);
            drawImage(x, y);
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, SIZE, SIZE);
        stage.setTitle("Canvas Demo");
        stage.setScene(scene);
        stage.show();
    }

    private void drawImage(double x, double y) {
        double w = image.getWidth();
        double h = image.getHeight();

        if (x - w > imageX) {
            imageX++;
        }
        if (x < imageX) {
            imageX--;
        }
        if (y - h > imageY) {
            imageY++;
        }
        if (y < imageY) {
            imageY--;
        }


        gc.clearRect(0, 0, SIZE, SIZE);
        gc.drawImage(image, imageX, imageY);

    }
}
