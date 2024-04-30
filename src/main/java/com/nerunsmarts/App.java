package com.nerunsmarts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// I used Maven build tools to set up the project, so I guess I ripped some code from them?? It was built into my IDE.

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("https://images.squarespace-cdn.com/content/v1/5d56a346839a3a000100fcda/1565961231827-2I2YZCLMEQQX6S69V8PN/pizzalandlogo.png");
        Label welcome = new Label("Welcome to PizzaLand!");
        welcome.setStyle("-fx-font-weight: bold; -fx-font-size: 30px;");
        welcome.setTextFill(Color.PURPLE);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(150);
        logo.setPreserveRatio(true);
        StackPane root = new StackPane();
        ComboBox<String> pizzaType = new ComboBox<>();
        pizzaType.getItems().addAll("Plain", "Seafood", "Vegetarian", "Bacon", "Hawaiian", "Uni's Electric Rainbow Signature Pizza");

        VBox header = new VBox(10);
        HBox pizzaTypeContainer = new HBox(10);
        pizzaTypeContainer.getChildren().addAll(new Label("Pizza Type: "), pizzaType);
        pizzaTypeContainer.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.getChildren().addAll(welcome, logo, pizzaTypeContainer);
        header.setAlignment(Pos.CENTER);
        root.getChildren().add(header);

        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}