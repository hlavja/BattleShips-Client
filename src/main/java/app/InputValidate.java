package main.java.app;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidate {


    public static void showAlert(String alertMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    public static boolean validateIP(String inputIP){
        if (inputIP == null || inputIP.isEmpty()){
            return false;
        }
        inputIP = inputIP.trim();

        if ((inputIP.length() < 7) || (inputIP.length() > 16)){
            return false;
        }
        Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(inputIP);
        return matcher.matches();
    }

    public static boolean validatePort(String inputPort){
        int port = Integer.parseInt(inputPort);
        return port >= 1 && port <= 65535;
    }


    public static boolean validateCoords(int x, int y) {
        return x >= 0 && x <= 5 && y >= 0 && y <= 5;
    }

    public static boolean checkSyncMessage(String[] message){
        return message.length == 77;
    }
}
