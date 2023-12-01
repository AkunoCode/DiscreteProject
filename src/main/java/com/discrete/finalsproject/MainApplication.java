package com.discrete.finalsproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("FXMLs/Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Statify (Discrete Final Project)");
        // set icon
        stage.getIcons().add(new javafx.scene.image.Image(MainApplication.class.getResourceAsStream("Assets/Icon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}