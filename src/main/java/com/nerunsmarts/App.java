package com.nerunsmarts;

// holy shit this is a lot of imports

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// I used Maven build tools to set up the project, so I guess I ripped some code from them?? It was built into my IDE.
// also, this is the probably the hardest code to read that i've ever written. I am not sorry.
// also also this is just a shitty version of SwitfUI. Please let me use that next time lol cause then I can build for my iPhone.
// also also also i did this at 11:20 on Monday night and I guarantee I could get better formatting on literally any other graphics package. Or if I was allowed to have multiple screens and use my own layout.

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        // set up assets

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
        Label pizzaSizeLabel = new Label("Pizza Size:");
        Label pizzaToppingsLabel = new Label("Pizza Toppings:");
        ToggleGroup pizzaSize = new ToggleGroup();
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        small.setToggleGroup(pizzaSize);
        medium.setToggleGroup(pizzaSize);
        large.setToggleGroup(pizzaSize);
        ToggleGroup pizzaToppings = new ToggleGroup();
        CheckBox rainbows = new CheckBox("Rainbows");
        CheckBox hearts = new CheckBox("Hearts");
        CheckBox stars = new CheckBox("Stars");
        CheckBox clovers = new CheckBox("Clovers");
        CheckBox horseshoes = new CheckBox("Horseshoes");
        CheckBox redBalloons = new CheckBox("Red Balloons");
        Label customerInfoLabel = new Label("Customer Information:");
        Label commentsLabel = new Label("Comments:");
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField commentsTextField = new TextField();
        Button submit = new Button("Submit");

        // section below sets up h and v boxes for the layout

        VBox header = new VBox(10);
        HBox pizzaTypeContainer = new HBox(10);
        GridPane options = new GridPane();
        VBox pizzaSizeBox = new VBox(10);
        VBox pizzaToppingsBox1 = new VBox(10);
        VBox pizzaToppingsBox2 = new VBox(10);
        HBox optionsBox = new HBox();
        GridPane customerInfoPane = new GridPane();
        HBox firstName = new HBox(10);
        HBox lastName = new HBox(10);

        // this bit manages the children of the h and v boxes 

        pizzaToppingsBox1.getChildren().addAll(rainbows, stars, horseshoes);
        pizzaToppingsBox2.getChildren().addAll(hearts, clovers, redBalloons);
        optionsBox.getChildren().addAll(pizzaSizeBox, pizzaToppingsBox1, pizzaToppingsBox2);
        options.add(pizzaSizeLabel, 0, 0);
        options.add(pizzaToppingsLabel, 1, 0);
        pizzaSizeBox.getChildren().addAll(small, medium, large);
        pizzaTypeContainer.getChildren().addAll(new Label("Pizza Type: "), pizzaType);
        firstName.getChildren().addAll(new Label("First Name: "), firstNameTextField);
        lastName.getChildren().addAll(new Label("Last Name: "), lastNameTextField);
        customerInfoPane.add(customerInfoLabel, 0, 0);
        customerInfoPane.add(commentsLabel, 1, 0);
        customerInfoPane.add(firstName, 0, 1);
        customerInfoPane.add(lastName, 0, 2);
        customerInfoPane.add(commentsTextField, 1, 1);
        header.getChildren().addAll(welcome, logo, pizzaTypeContainer, options, optionsBox, customerInfoPane, submit);

        // this bit does alignment and padding

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        options.setAlignment(Pos.CENTER);
        options.setPadding(new Insets(20));
        options.setHgap(20);
        options.getColumnConstraints().addAll(column1, column2);
        customerInfoPane.getColumnConstraints().addAll(column1, column2);
        customerInfoPane.setPadding(new Insets(10));
        pizzaSizeBox.setPadding(new Insets(0, 50, 0, 50));
        pizzaToppingsBox1.setPadding(new Insets(0, 50, 0, 50));
        pizzaToppingsBox2.setPadding(new Insets(0, 50, 0, 50));
        optionsBox.setAlignment(Pos.CENTER);
        pizzaTypeContainer.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER);

        root.getChildren().add(header); // add the main vbox to the root

        Scene scene = new Scene(root, 640, 480); // set up scene

        primaryStage.setTitle("PizzaLand!");
        primaryStage.setScene(scene);
        primaryStage.show();

        // program logic (barely any lol)

        submit.setOnAction(event -> {
            System.out.println(firstNameTextField.getText() + " " + lastNameTextField.getText() + "\nordered a " + (getSelectedSizeToggle(pizzaSize)) + " " + pizzaType.getValue() + "\nwith toppings:\n" + (rainbows.isSelected() ? "Rainbows\n" : "") + (hearts.isSelected() ? "Hearts\n" : "") + (stars.isSelected() ? "Stars\n" : "") + (clovers.isSelected() ? "Clovers\n" : "") + (horseshoes.isSelected() ? "Horseshoes\n" : "") + (redBalloons.isSelected() ? "Red Balloons\n" : "") + "and comments:\n" + commentsTextField.getText());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String getSelectedSizeToggle(ToggleGroup group) {
        return ((RadioButton) group.getSelectedToggle()).getText();
    }
}