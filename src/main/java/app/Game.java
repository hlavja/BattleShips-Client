package main.java.app;

public class Game {
    /*
    0 - water; 1 - ship; 2 - fire; 3 - miss
     */
    public int[][] myShipPanel = new int[GameConfiguration.gridSize][GameConfiguration.gridSize];
    /*
    0 - water; 1 - fire; 2 - miss
     */
    public int[][] enemyShipPanel = new int[GameConfiguration.gridSize][GameConfiguration.gridSize];
    public int placeShip;
    public int myLives;
    public int enemyLives;

    public Game(){
        for (int i = 0; i < GameConfiguration.gridSize; i++) {
            for (int j = 0; j < GameConfiguration.gridSize; j++) {
                myShipPanel[i][j] = 0;
                enemyShipPanel[i][j] = 0;
            }
        }
        placeShip = GameConfiguration.playerShips;
        myLives = GameConfiguration.playerShips;
        enemyLives = GameConfiguration.playerShips;
    }

    public int getPlaceShip() {
        return placeShip;
    }

    public void setPlaceShip(int placeShip) {
        this.placeShip = placeShip;
    }

    public boolean placeShip(int x, int y){
        if (myShipPanel[x-1][y-1] == 0){
            myShipPanel[x-1][y-1] = 1;
            placeShip--;
            return true;
        } else {
            return false;
        }
    }

}
