package com.nerunsmarts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("https://images.squarespace-cdn.com/content/v1/5d56a346839a3a000100fcda/1565961231827-2I2YZCLMEQQX6S69V8PN/pizzalandlogo.png");
        ImageView logo = new ImageView(image);
        StackPane root = new StackPane();
        root.getChildren().add(logo);

        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}