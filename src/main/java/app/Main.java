package main.java.app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    private static Stage guiStage;

    public static Stage getStage(){
        return guiStage;
    }

    @FXML
    private TextField serverIPAddress;

    @FXML
    private TextField serverPort;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //init first scene
		String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/scenes/loginScene.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/main/resources/scenes/placingScene.fxml"));
        primaryStage.setTitle("Bottle Ships");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
        guiStage = primaryStage;

        //client log file
        File file = new File("client.log");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        //System.setOut(ps);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Client launched at " + dtf.format(start));

        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            LocalDateTime end = LocalDateTime.now();
            System.out.println("Client was terminated at " + dtf.format(end));
            if(GlobalVariables.pingThread != null){
                if (GlobalVariables.pingThread.threadActive){
                    GlobalVariables.pingThread.close();
                }
            }
            if (GlobalVariables.connected){
                GlobalVariables.getReceivingThread().disconnectClient();
            }
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
