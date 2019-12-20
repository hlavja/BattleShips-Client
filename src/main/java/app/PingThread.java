package main.java.app;

import main.java.controllers.SceneChanger;
import javafx.application.Platform;

public class PingThread extends Thread {

    final String ipAddress;
    boolean threadActive = false;

    public PingThread(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public static boolean pingServer(String ipAddress) {
        String command;
        try{
        if (System.getProperty("os.name").startsWith("Windows")){
            command = "ping -n 1 " + ipAddress;
        } else {
            command = "ping -c 1 " + ipAddress;
        }

        Process commandLine = Runtime.getRuntime().exec(command);
        commandLine.waitFor();

        return commandLine.exitValue() == 0;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void run(){
        threadActive = true;

        while (threadActive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!pingServer(ipAddress)){
                Platform.runLater(() -> InputValidate.showAlert("Lost connection with server!"));
                setGuiDisable(SceneChanger.currentScene);
            } else if (pingServer(ipAddress)){
                GlobalVariables.getSendingThread().sendMessage("");
            }
        }
    }

    private void setGuiDisable(int currentScene) {
        //TODO
        switch (currentScene){
            case 1: ReceivingThread.getControllerLoginScene().gui.setDisable(true);
            break;

            case 2:     ReceivingThread.getControllerRoomPickerScene().gui.setDisable(true);
                break;

            case 3:     ReceivingThread.getControllerPlacingScene().gui.setDisable(true);
                break;

            default:    System.out.println("Error: disable invalid scene!");
        }
    }

    public void close() {
    }
}
