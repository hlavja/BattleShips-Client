package main.java.controllers;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import main.java.app.GameController;
import main.java.app.GlobalVariables;
import main.java.app.ReceivingThread;

import java.util.Optional;


public class ControllerGameScene {

    @FXML
    public BorderPane gui;

    @FXML
    public Button createRoomBtn;
    public Button refreshRoomBtn;
    public Button myBtn00;
    public GridPane myGridPane;
    public TextField numberOfMyShips;
    public TextField numberOfEnemyShips;
    public Button enemyBtn55;
    public Button enemyBtn54;
    public Button enemyBtn53;
    public Button enemyBtn52;
    public Button enemyBtn51;
    public Button enemyBtn50;
    public Button enemyBtn45;
    public Button enemyBtn44;
    public Button enemyBtn43;
    public Button enemyBtn42;
    public Button enemyBtn41;
    public Button enemyBtn40;
    public Button enemyBtn35;
    public Button enemyBtn33;
    public Button enemyBtn34;
    public Button enemyBtn32;
    public Button enemyBtn31;
    public Button enemyBtn30;
    public Button enemyBtn25;
    public Button enemyBtn24;
    public Button enemyBtn23;
    public Button enemyBtn22;
    public Button enemyBtn21;
    public Button enemyBtn20;
    public Button enemyBtn15;
    public Button enemyBtn14;
    public Button enemyBtn13;
    public Button enemyBtn12;
    public Button enemyBtn11;
    public Button enemyBtn10;
    public Button enemyBtn05;
    public Button enemyBtn04;
    public Button enemyBtn03;
    public Button enemyBtn02;
    public Button enemyBtn01;
    public Button enemyBtn00;
    public Button myBtn55;
    public Button myBtn54;
    public Button myBtn53;
    public Button myBtn52;
    public Button myBtn51;
    public Button myBtn50;
    public Button myBtn45;
    public Button myBtn44;
    public Button myBtn43;
    public Button myBtn42;
    public Button myBtn41;
    public Button myBtn40;
    public Button myBtn35;
    public Button myBtn34;
    public Button myBtn33;
    public Button myBtn32;
    public Button myBtn31;
    public Button myBtn30;
    public Button myBtn25;
    public Button myBtn24;
    public Button myBtn23;
    public Button myBtn22;
    public Button myBtn21;
    public Button myBtn20;
    public Button myBtn15;
    public Button myBtn14;
    public Button myBtn13;
    public Button myBtn12;
    public Button myBtn11;
    public Button myBtn10;
    public Button myBtn05;
    public Button myBtn04;
    public Button myBtn03;
    public Button myBtn02;
    public Button myBtn01;
    public GridPane enemyGridPane;
    public TextField statusText;
    public int messageSize;

    @FXML
    private TextField statusTextField;

    @FXML
    private ListView<String> list;
    private ObservableList<String> items = FXCollections.observableArrayList();
    public Button[][] myPanel = new Button[6][6];
    public Button[][] enemyPanel = new Button[6][6];
    GameController game;
    
    @FXML
    public void initialize(){
        messageSize = 2 + GlobalVariables.playerName.length() + 1 + GlobalVariables.gameName.length() + 1 + 1 + 1 + 1 + 1;
        initMyButtons();
        initEnemyButtons();
        game = GlobalVariables.getGame();
        updateMyPane();
        ReceivingThread.setControllerGameScene(this);
        numberOfMyShips.setText(String.valueOf(GlobalVariables.game.myLives));
        numberOfEnemyShips.setText(String.valueOf(GlobalVariables.game.enemyLives));
        setEnemyGridPaneDisable();
        //GlobalVariables.getReceivingThread().setControllerRoomPickerScene(this);
        //GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(2) + "04");
    }

    

    public void resetGame(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                GlobalVariables.game.enemyShipPanel[i][j] = 0;
                GlobalVariables.game.myShipPanel[i][j] = 0;
            }
        }
        GlobalVariables.game.enemyLives = 6;
        GlobalVariables.game.myLives = 6;
        GlobalVariables.game.placeShip = 6;
    }

    public void updateEnemyPane(int result, int x, int y) {
        if (result == 1) {
            GlobalVariables.game.enemyShipPanel[x][y] = 1;
            enemyPanel[x][y].setStyle("-fx-background-image: url('/main/resources/img/fire.png'); -fx-background-repeat: no-repeat; -fx-background-position: 10px center;");
            enemyPanel[x][y].getStyleClass().add("enemy-disable");
        } else if (result == 2) {
            GlobalVariables.game.enemyShipPanel[x][y] = 0;
            enemyPanel[x][y].setStyle("-fx-background-image: url('/main/resources/img/miss.png'); -fx-background-repeat: no-repeat;");
            enemyPanel[x][y].getStyleClass().add("enemy-disable");
        }
    }

    public void updateMyPane() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (game.myShipPanel[i][j] == 1){
                    myPanel[i][j].setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                } else if (game.myShipPanel[i][j] == 2){
                    myPanel[i][j].setStyle("-fx-background-image: url('/main/resources/img/fire.png'); -fx-background-repeat: no-repeat;");
                } else if (game.myShipPanel[i][j] == 3){
                    myPanel[i][j].setStyle("-fx-background-image: url('/main/resources/img/miss.png'); -fx-background-repeat: no-repeat;");
                } else {
                    myPanel[i][j].setStyle("-fx-background-image: url('/main/resources/img/bg_button.jpg'); -fx-background-repeat: no-repeat;");
                }
            }
        }
    }

    private void initEnemyButtons() {
        enemyPanel[0][0] = enemyBtn00;
        enemyPanel[0][1] = enemyBtn01;
        enemyPanel[0][2] = enemyBtn02;
        enemyPanel[0][3] = enemyBtn03;
        enemyPanel[0][4] = enemyBtn04;
        enemyPanel[0][5] = enemyBtn05;
        enemyPanel[1][0] = enemyBtn10;
        enemyPanel[1][1] = enemyBtn11;
        enemyPanel[1][2] = enemyBtn12;
        enemyPanel[1][3] = enemyBtn13;
        enemyPanel[1][4] = enemyBtn14;
        enemyPanel[1][5] = enemyBtn15;
        enemyPanel[2][0] = enemyBtn20;
        enemyPanel[2][1] = enemyBtn21;
        enemyPanel[2][2] = enemyBtn22;
        enemyPanel[2][3] = enemyBtn23;
        enemyPanel[2][4] = enemyBtn24;
        enemyPanel[2][5] = enemyBtn25;
        enemyPanel[3][0] = enemyBtn30;
        enemyPanel[3][1] = enemyBtn31;
        enemyPanel[3][2] = enemyBtn32;
        enemyPanel[3][3] = enemyBtn33;
        enemyPanel[3][4] = enemyBtn34;
        enemyPanel[3][5] = enemyBtn35;
        enemyPanel[4][0] = enemyBtn40;
        enemyPanel[4][1] = enemyBtn41;
        enemyPanel[4][2] = enemyBtn42;
        enemyPanel[4][3] = enemyBtn43;
        enemyPanel[4][4] = enemyBtn44;
        enemyPanel[4][5] = enemyBtn45;
        enemyPanel[5][0] = enemyBtn50;
        enemyPanel[5][1] = enemyBtn51;
        enemyPanel[5][2] = enemyBtn52;
        enemyPanel[5][3] = enemyBtn53;
        enemyPanel[5][4] = enemyBtn54;
        enemyPanel[5][5] = enemyBtn55;
    }

    private void initMyButtons() {
        myPanel[0][0] = myBtn00;
        myPanel[0][1] = myBtn01;
        myPanel[0][2] = myBtn02;
        myPanel[0][3] = myBtn03;
        myPanel[0][4] = myBtn04;
        myPanel[0][5] = myBtn05;
        myPanel[1][0] = myBtn10;
        myPanel[1][1] = myBtn11;
        myPanel[1][2] = myBtn12;
        myPanel[1][3] = myBtn13;
        myPanel[1][4] = myBtn14;
        myPanel[1][5] = myBtn15;
        myPanel[2][0] = myBtn20;
        myPanel[2][1] = myBtn21;
        myPanel[2][2] = myBtn22;
        myPanel[2][3] = myBtn23;
        myPanel[2][4] = myBtn24;
        myPanel[2][5] = myBtn25;
        myPanel[3][0] = myBtn30;
        myPanel[3][1] = myBtn31;
        myPanel[3][2] = myBtn32;
        myPanel[3][3] = myBtn33;
        myPanel[3][4] = myBtn34;
        myPanel[3][5] = myBtn35;
        myPanel[4][0] = myBtn40;
        myPanel[4][1] = myBtn41;
        myPanel[4][2] = myBtn42;
        myPanel[4][3] = myBtn43;
        myPanel[4][4] = myBtn44;
        myPanel[4][5] = myBtn45;
        myPanel[5][0] = myBtn50;
        myPanel[5][1] = myBtn51;
        myPanel[5][2] = myBtn52;
        myPanel[5][3] = myBtn53;
        myPanel[5][4] = myBtn54;
        myPanel[5][5] = myBtn55;
    }

    public void setEnemyGridPaneEnable() {
        updateLives();
        enemyGridPane.setDisable(false);
    }

    private void setEnemyGridPaneDisable() {
        updateLives();
        enemyGridPane.setDisable(true);
    }

    private void updateLives() {
        numberOfMyShips.setText(String.valueOf(GlobalVariables.game.myLives));
        numberOfEnemyShips.setText(String.valueOf(GlobalVariables.game.enemyLives));
    }

    public void fire00(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire01(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire02(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire03(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire04(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire05(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";0;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire10(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire11(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire12(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire13(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire14(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire15(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";1;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire20(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire21(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire22(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire23(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire24(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire25(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";2;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire30(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire31(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire32(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire33(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire34(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire35(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";3;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire40(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire41(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire42(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire43(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire44(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire45(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";4;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire50(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;0;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire51(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;1;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire52(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;2;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire53(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;3;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire54(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;4;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void fire55(ActionEvent actionEvent) {
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "10" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";5;5;");
        enemyBtn00.getStyleClass().add("enemy-disable");
        setEnemyGridPaneDisable();
    }

    public void showAlert(int i) {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (i == 0){
            alert.setTitle("LOST");
        } else {
            alert.setTitle("WON");
        }
        alert.setResizable(false);
        GlobalVariables.setAlert(alert);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()){
            if(result.get() == ButtonType.CANCEL){
                int size = 2 + GlobalVariables.gameName.length();
                GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(size) + "06" + GlobalVariables.gameName);
            } else if (result.get() == ButtonType.OK){
                //GlobalVariables.playerRepeat = true;
                int size = 2 + GlobalVariables.playerName.length() + 1 + GlobalVariables.gameName.length() + 1;
                GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(size) + "12" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";");
                GlobalVariables.playerRepeat = true;
            }
        }

   }
}
