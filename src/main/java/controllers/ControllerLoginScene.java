package main.java.controllers;


import com.sun.security.auth.NTUserPrincipal;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.java.app.*;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ControllerLoginScene {

    @FXML
    public BorderPane gui;

    @FXML
    public TextField playerName;
    public Label title;
    public Button connectToServerBtn;
    public AnchorPane pane;

    @FXML
    private TextField serverIPAddress;

    @FXML
    private TextField serverPort;

    @FXML
    private TextField statusTextField;

    private SendingThread sendingThread;

    public void connectToServer(javafx.event.ActionEvent event){

        String name = playerName.getText();
        String ip = serverIPAddress.getText();
        String port = serverPort.getText();

        if(name.isEmpty()){
            InputValidate.showAlert("Name field is empty");
            return;
        }

        if (!InputValidate.validateIP(ip) || ip != null){
            InputValidate.showAlert("Input IP is not valid!");
            return;
        }

        if (!InputValidate.validatePort(port)){
            InputValidate.showAlert("Input port is not valid!");
            return;
        }

        Socket socket;

        try {
            socket = new Socket(ip, Integer.parseInt(port));
        } catch (IOException e) {
            InputValidate.showAlert("Server not running!");
            return;
        }

        statusTextField.setText("CONNECTED");
        //inicializace senderu a recieveru
        sendingThread = new SendingThread(socket);

        ReceivingThread receivingThread = new ReceivingThread(socket);
        receivingThread.setControllerLoginScene(this);
        receivingThread.start();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Client was connected to server at "+dtf.format(start));
        System.out.println("Server address: "+ serverIPAddress.getText()+" port: "+ serverPort.getText());

        GlobalVariables.setSendingThread(sendingThread);
        GlobalVariables.setReceivingThread(receivingThread);
        GlobalVariables.ipAddress = serverIPAddress.getText();
        GlobalVariables.port = serverPort.getText();
        GlobalVariables.connected = true;
        GlobalVariables.playerName = name;

        GlobalVariables.pingThread = new PingThread(GlobalVariables.ipAddress);
        GlobalVariables.pingThread.start();



        int messageSize = 2 + GlobalVariables.playerName.length();
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "01" + GlobalVariables.playerName);
        gui.setDisable(true);
        //Platform.runLater(() -> GlobalVariables.sceneChanger.changeToRoomScene());
    }


    public void initAfterGame(){
        statusTextField.setText("Connected");

    }

    @FXML
    public void initialize(){
        SceneChanger sceneChanger = new SceneChanger();
        gui.setStyle("-fx-background-image: url('/main/resources/img/background.png'); -fx-background-position: center center;");
        GlobalVariables.sceneChanger = sceneChanger;
      /*  if(GlobalVariables.playerOneRepeat && GlobalVariables.playerTwoRepeat){
            initAfterGame();
        }*/
    }

    public void showAlert(int i) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (i == 1){
            alert.setTitle("Server is crazy");
            alert.setContentText("Server is crazy!");
        }
        alert.setResizable(false);
    }
}
