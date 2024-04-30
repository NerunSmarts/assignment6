package com.nerunsmarts;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    private ImageView imageView;

    @FXML
    public void initialize() {
        Image logo = null;
        try {
            logo = new Image("https://images.squarespace-cdn.com/content/v1/5d56a346839a3a000100fcda/1565961231827-2I2YZCLMEQQX6S69V8PN/pizzalandlogo.png");
        } catch (Exception e) {
            System.out.println("Error! Image inaccesible!");
        }
        if (logo == null) {
            System.out.println("fuck");
        }
        imageView = new ImageView(logo);
        imageView.setImage(logo);
        System.out.println("PrimaryController initialized");
    }

    public void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
