package com.example.solosgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class SoilCorrection extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SoilCorrectionLauncher.class.getResource("Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Soil Correction");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}