package main.java.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.java.app.*;

import java.io.IOException;

public class SceneChanger {

    public static int currentScene = 1;

    public void changeToLoginScene() {
        Parent scene = null;
        try {
            scene = FXMLLoader.load(getClass().getResource("/main/resources/scenes/loginScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert scene != null;
        Scene viewScene = new Scene(scene);
        Main.getStage().setScene(viewScene);
        currentScene = 1;
    }

    public void changeToRoomScene() {
        Parent scene = null;
        try {
            scene = FXMLLoader.load(getClass().getResource("/main/resources/scenes/roomScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert scene != null;
        Scene viewScene = new Scene(scene);
        Main.getStage().setScene(viewScene);
        currentScene = 2;
    }

    public void changeToPlacingScene() {
        Parent scene = null;
        try {
            scene = FXMLLoader.load(getClass().getResource("/main/resources/scenes/placingScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert scene != null;
        Scene viewScene = new Scene(scene);
        Main.getStage().setScene(viewScene);
        currentScene = 3;
    }

    public void changeToGameScene() {
        Parent scene = null;
        try {
            scene = FXMLLoader.load(getClass().getResource("/main/resources/scenes/gameScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert scene != null;
        Scene viewScene = new Scene(scene);
        Main.getStage().setScene(viewScene);
        currentScene = 4;
    }
}
