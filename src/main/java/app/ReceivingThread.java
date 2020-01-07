package main.java.app;

import main.java.controllers.*;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static main.java.app.GlobalVariables.playerRepeat;

public class ReceivingThread extends Thread {


    public static ControllerLoginScene controllerLoginScene;
    private final Socket socket;
    private boolean isRunning = false;
    private static ControllerRoomPickerScene controllerRoomPickerScene;
    private static ControllerPlacingScene controllerPlacingScene;
    private static ControllerGameScene controllerGameScene;


    public static ControllerGameScene getControllerGameScene() {
        return controllerGameScene;
    }

    public static void setControllerGameScene(ControllerGameScene controllerGameScene) {
        ReceivingThread.controllerGameScene = controllerGameScene;
    }


    public static ControllerPlacingScene getControllerPlacingScene() {
        return controllerPlacingScene;
    }

    public static void setControllerPlacingScene(ControllerPlacingScene controllerPlacingScene) {
        ReceivingThread.controllerPlacingScene = controllerPlacingScene;
    }




    public ReceivingThread(Socket socket) {
        this.socket = socket;
    }

    public static ControllerLoginScene getControllerLoginScene() {
        return controllerLoginScene;
    }

    public void setControllerLoginScene(ControllerLoginScene controllerLoginScene) {
        ReceivingThread.controllerLoginScene = controllerLoginScene;
    }

    public static ControllerRoomPickerScene getControllerRoomPickerScene() {
        return controllerRoomPickerScene;
    }

    public void setControllerRoomPickerScene(ControllerRoomPickerScene controllerRoomPickerScene) {
        ReceivingThread.controllerRoomPickerScene = controllerRoomPickerScene;
    }

    @Override
    public void run() {
        isRunning = true;
        int wrongMessage = 0;
        try {
            //char[] inputArray = new char[5000];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (isRunning) {
                String message = bufferedReader.readLine();

                if (message == null) {
                    System.out.println("Lost connection to server!");
                    Platform.runLater(() -> InputValidate.showAlert("Lost connection to server!"));
                    Thread.sleep(2000);
                    GlobalVariables.connected = false;
                    socket.close();
                    isRunning = false;
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToLoginScene());
                    break;
                }
                System.out.println("From server: " + message);
                //String tmp = new String(inputArray);
                String[] command = message.split(";");
                if (command.length > 0 && !command[0].equals("ping")){
                    System.out.println("From server: " + message);
                }

                //response for server ping
                if (command[0].equals("ping")){
                    wrongMessage = 0;
                    GlobalVariables.getSendingThread().sendMessage("00214");
                } else if (command[0].equals("rooms")){ //parse rooms response
                    if (command.length > 1){
                        GlobalVariables.rooms = command[1];
                        Platform.runLater(() ->controllerRoomPickerScene.fillList());
                    } else {
                        Platform.runLater(() ->controllerRoomPickerScene.clearList());
                    }
                } else if (command[0].equals("joinERR")){ //if waiting for opponent placing
                    //GlobalVariables.setOpponentName(command[1]);
                    Platform.runLater(() -> controllerRoomPickerScene.showAlert(2));
                } else if (command[0].equals("roomERR")){ //if waiting for opponent placing
                    //GlobalVariables.setOpponentName(command[1]);
                    Platform.runLater(() -> controllerRoomPickerScene.showAlert(1));
                } else if (command[0].equals("joined")){ //if successfully joined room
                    //if (GlobalVariables.getGameName().equals(command[1])){
                        //GlobalVariables.setOpponentName(command[2]);
                        Platform.runLater(() -> GlobalVariables.sceneChanger.changeToPlacingScene());
                   // }
                } else if (command[0].equals("prepareGame")){ //if room has two players
                    //GlobalVariables.setOpponentName(command[1]);
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToPlacingScene());
                } else if (command[0].equals("place")){  //if waiting for opponent placing
                    //GlobalVariables.setOpponentName(command[1]);
                    Platform.runLater(() -> controllerPlacingScene.statusTextField.setText("Waiting for opponent placing!"));
                } else if (command[0].equals("gamestart")){ //start game
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToGameScene());
                    if (command.length == 2 && command[1].equals("0")){
                        GlobalVariables.turn = true;
                        Platform.runLater(() -> controllerGameScene.setEnemyGridPaneEnable());
                        Platform.runLater(() -> controllerGameScene.statusText.setText("YOUR TURN"));
                    }
                } else if (command[0].equals("my")){ //response for my shoot
                    if (command.length == 3){
                        String[] coords = command[2].split(",");
                        int x = Integer.parseInt(coords[0]) ;
                        int y = Integer.parseInt(coords[1]);
                        if (InputValidate.validateCoords(x, y)) {
                            switch (command[1]) {
                                case "miss":
                                    Platform.runLater(() -> controllerGameScene.updateEnemyPane(2, Integer.parseInt(coords[0]), Integer.parseInt(coords[1])));
                                    Platform.runLater(() -> controllerGameScene.statusText.setText("ENEMY TURN"));
                                    GlobalVariables.turn = false;
                                    break;
                                case "shot":
                                    Platform.runLater(() -> controllerGameScene.updateEnemyPane(1, Integer.parseInt(coords[0]), Integer.parseInt(coords[1])));
                                    Platform.runLater(() -> controllerGameScene.statusText.setText("ENEMY TURN"));
                                    GlobalVariables.game.enemyLives--;
                                    GlobalVariables.turn = false;
                                    break;
                                case "already":
                                    //disconnectClient();
                                    break;
                            }
                        } else {
                            //disconnectClient();
                        }
                    } else {
                       // disconnectClient();
                    }
                } else if (command[0].equals("enemy")){ //response for enemy shooting
                    if (command.length == 3){
                        String[] coords = command[2].split(",");
                        int x = Integer.parseInt(coords[0]) ;
                        int y = Integer.parseInt(coords[1]);
                        if (InputValidate.validateCoords(x, y)){
                            if (command[1].equals("sink")){
                                Platform.runLater(() -> controllerGameScene.statusText.setText("Your TURN"));
                                Platform.runLater(() -> controllerGameScene.setEnemyGridPaneEnable());
                                GlobalVariables.game.myShipPanel[x][y] = 2;
                                Platform.runLater(() -> controllerGameScene.updateMyPane());
                                GlobalVariables.game.myLives--;
                            } else if (command[1].equals("miss")){
                                Platform.runLater(() -> controllerGameScene.statusText.setText("Your TURN"));
                                Platform.runLater(() -> controllerGameScene.setEnemyGridPaneEnable());
                                GlobalVariables.game.myShipPanel[x][y] = 3;
                                Platform.runLater(() -> controllerGameScene.updateMyPane());
                            }

                        }  else {
                            //disconnectClient();
                        }
                    } else {
                        //disconnectClient();
                    }
                } else if (command[0].equals("activePlacing")){
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToPlacingScene());
                    GlobalVariables.opponentName = command[1];
                } else if (command[0].equals("activeGame")){
                    GlobalVariables.opponentName = command[1];
                    GlobalVariables.game = new GameController();
                    GlobalVariables.game.initializeMyPane(command[2]);
                    GlobalVariables.game.initializeEnemyPane(command[3]);
                    if (command[4].equals("1")){
                        Platform.runLater(() -> controllerGameScene.statusText.setText("Your turn!"));
                        Platform.runLater(() -> controllerGameScene.setEnemyGridPaneEnable());
                    } else if (command[4].equals("0")){
                        Platform.runLater(() -> controllerGameScene.statusText.setText("Enemy turn!"));
                        Platform.runLater(() -> controllerGameScene.setEnemyGridPaneDisable());
                    }
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToGameScene());
                    //send game state (activeGame;roomname;myplacing;enemyplacing;turn\n)

                } else if (command[0].equals("logged")){
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToRoomScene());
                } else if (command[0].equals("won")){
                    if (command.length == 2 && command[1].equals("ping")) {
                        Platform.runLater(() -> controllerGameScene.showAlert(3));
                    } else {
                        Platform.runLater(() ->controllerGameScene.showAlert(1));
                    }
                } else if (command[0].equals("lost")){
                    Platform.runLater(() ->controllerGameScene.showAlert(0));
                } else if (command[0].equals("nickTaken")){
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToLoginScene());
                    disconnectClient();
                } else if (playerRepeat){
                    if (command[0].equals("repeat")){
                        GlobalVariables.waitingTime = 0;
                        Platform.runLater(() -> controllerGameScene.resetGame());
                        Platform.runLater(() -> GlobalVariables.sceneChanger.changeToPlacingScene());
                    } else if (GlobalVariables.waitingTime < GameConfiguration.waitForOpponent){
                        GlobalVariables.waitingTime++;
                    } else if (GlobalVariables.waitingTime == GameConfiguration.waitForOpponent){
                        Platform.runLater(() -> GlobalVariables.sceneChanger.changeToRoomScene());
                        //send endGame
                        //GlobalVariables.getSendingThread().sendMessage("00214");
                    }

                } else if (command[0].equals("endGame")){
                    //if (GlobalVariables.getAlert().isShowing()){
                    //    GlobalVariables.getAlert().hide();
                    //}
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToRoomScene());
                } else if (command[0].equals("roomCreat")){

                } else if (wrongMessage > 3){
                    System.out.println("Hovno sem spadne");
                    Platform.runLater(() -> GlobalVariables.sceneChanger.changeToLoginScene());
                    disconnectClient();
                } else {
                    wrongMessage++;
                }
            }
        } catch (IOException | InterruptedException g){
            System.out.println("Receiver: IE");
            }
    }

    public void disconnectClient() {
        try {
            System.out.println("Client disconnected! Server is not consistent!");
            Platform.runLater(() -> InputValidate.showAlert("Disconnecting from server! Server is not consistent!"));
            Thread.sleep(2000);
            GlobalVariables.connected = false;
            socket.close();
            isRunning = false;
            Platform.runLater(() -> GlobalVariables.sceneChanger.changeToLoginScene());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
