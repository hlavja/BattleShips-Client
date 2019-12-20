package main.java.app;

import main.java.controllers.*;

public class GlobalVariables {
    public static boolean playerOneRepeat = false;

    public static boolean playerTwoRepeat = false;

    public static boolean turn = false;

    public static GameController game = null;

    public static SendingThread sendingThread = null;

    public static ReceivingThread receivingThread = null;

    public static boolean connected = false;

    public static String playerName = null;

    public static String ipAddress = null;

    public static String port = null;

    public static String rooms = null;

    public static SceneChanger sceneChanger = null;

    public static PingThread pingThread = null;

    public static String gameName = null;

    public static String getOpponentName() {
        return opponentName;
    }

    public static void setOpponentName(String opponentName) {
        GlobalVariables.opponentName = opponentName;
    }

    public static String opponentName = null;

    public static String messagePattern(int messageSize) {
        String pattern;
        if (messageSize < 10){
            pattern = "00" + messageSize;
        } else if(messageSize < 100){
            pattern = "0" + messageSize;
        } else {
            pattern = "" + messageSize;
        }
        return pattern;
    }

    public static String getGameName() {
        return gameName;
    }

    public static void setGameName(String gameName) {
        GlobalVariables.gameName = gameName;
    }

    public static void setGame(GameController game){
        GlobalVariables.game = game;
    }

    public static GameController getGame(){
        return GlobalVariables.game;
    }

    public static SendingThread getSendingThread() {
        return sendingThread;
    }

    public static void setSendingThread(SendingThread sendingThread) {
        GlobalVariables.sendingThread = sendingThread;
    }

    public static ReceivingThread getReceivingThread() {
        return receivingThread;
    }

    public static void setReceivingThread(ReceivingThread receivingThread) {
        GlobalVariables.receivingThread = receivingThread;
    }
}
