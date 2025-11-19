package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlatformRunLaterDemo extends Application {
    private int counter = 0;
    private Button button;

    @Override
    public void start(Stage stage) {
        button = new Button("0");
        BackgroundComputation computation = new BackgroundComputation(this);
        button.setOnAction(event -> computation.startComputation());

        VBox root = new VBox();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    public synchronized void updateButtonText() {
        counter++;
        String counterText = Integer.toString(counter);
        button.setText(counterText);
    }

}