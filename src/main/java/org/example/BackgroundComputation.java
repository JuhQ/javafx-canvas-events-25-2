package org.example;
import javafx.application.Platform;

public class BackgroundComputation {
    private PlatformRunLaterDemo gui;

    public BackgroundComputation(PlatformRunLaterDemo gui) {
        this.gui = gui;
    }

    public void startComputation() {
        new Thread(() -> {
            try {
                // This represents a long-running computation
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> gui.updateButtonText());
            //Platform.runLater(() -> gui.updateButtonText()); // safe way to update GUI
        }).start();
    }
}