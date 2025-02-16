package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // using the .fxml file
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/icy-lake.fxml"));

        // setting the background color
        root.setStyle("-fx-background-color: #ADD8E6;");

        // setting the title and scene
        stage.setTitle("Icy Lake Environment");
        stage.setScene(new Scene(root));

        // showing the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}