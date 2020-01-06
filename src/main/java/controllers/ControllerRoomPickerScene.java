package main.java.controllers;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import main.java.app.*;

import java.util.Arrays;
import java.util.Optional;


public class ControllerRoomPickerScene {

    @FXML
    public BorderPane gui;

    @FXML
    public Button createRoomBtn;
    public Button refreshRoomBtn;

    @FXML
    private TextField statusTextField;

    @FXML
    private ListView<String> list;
    private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        statusTextField.setText("CONNECTED");
        GlobalVariables.getReceivingThread().setControllerRoomPickerScene(this);
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(2) + "04");
    }

    public void createGame() {
        statusTextField.setText("Looking for an opponent");
        GlobalVariables.setGameName(GlobalVariables.playerName);
        int messageSize = 2 + GlobalVariables.playerName.length() + 1;
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "03" + GlobalVariables.playerName + ";");
        ReceivingThread.getControllerRoomPickerScene().gui.setDisable(true);
    }

    public void refreshRooms() {
        GlobalVariables.getSendingThread().sendMessage("00204");
    }

    public void showAlert(int i) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (i == 1){
            alert.setTitle("Cant create room");
            alert.setContentText("Room already exists!");
        }
        if (i == 2){
            alert.setTitle("Cant join room");
            alert.setContentText("Room error!");
        }
        alert.setResizable(false);
    }

    @FXML
    public void fillList(){

            list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            String[] roomsSplit = GlobalVariables.rooms.split(",");
            items.clear();
            items.addAll(Arrays.asList(roomsSplit));
            list.setItems(items);
            list.setOnMouseClicked(click -> {
                if (click.getClickCount() == 2) {
                    //Use ListView's getSelected Item
                    String currentItemSelected = list.getSelectionModel()
                            .getSelectedItem();
                    //use this to do whatever you want to. Open Link etc.
                    int messageSize = 2 + GlobalVariables.playerName.length() + 1 + currentItemSelected.length() + 1;
                    GlobalVariables.setGameName(currentItemSelected);
                    GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "05" + GlobalVariables.playerName + ";" + currentItemSelected + ";");
                }
            });
    }
}
