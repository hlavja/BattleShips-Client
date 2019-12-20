package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.java.app.*;

public class ControllerPlacingScene {
    public Button btn11;
    public Button btn21;
    public Button btn12;
    public Button btn22;
    public Button btn31;
    public Button btn32;
    public Button btn41;
    public Button btn43;
    public Button btn42;
    public Button btn51;
    public Button btn52;
    public Button btn53;
    public Button btn54;
    public Button btn44;
    public Button btn33;
    public Button btn34;
    public Button btn23;
    public Button btn24;
    public Button btn13;
    public Button btn14;
    public Button btn61;
    public Button btn62;
    public Button btn63;
    public Button btn64;
    public Button btn15;
    public Button btn35;
    public Button btn25;
    public Button btn45;
    public Button btn55;
    public Button btn65;
    public Button btn16;
    public Button btn26;
    public Button btn36;
    public Button btn46;
    public Button btn56;
    public Button btn66;
    public TextField statusTextField;
    public Button readyButton;
    public TextField shipsToPlace;
    public BorderPane gui;

    Game game = new Game();

    @FXML
    public void initialize(){
        GlobalVariables.setGame(game);
        statusTextField.setText("CONNECTED");
        ReceivingThread.setControllerPlacingScene(this);
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(2) + "04");
    }

    public void sendPlacing(ActionEvent actionEvent) {
        int messageSize = 2 + GlobalVariables.playerName.length() + 1 + GlobalVariables.gameName.length() + 1 + 36 + 1;

        StringBuilder grid = new StringBuilder();
        for (int i = 0; i < GameConfiguration.gridSize; i++){
            for (int j = 0; j < GameConfiguration.gridSize; j++){
                grid.append(game.myShipPanel[i][j]);
            }
        }

        readyButton.setDisable(true);
        System.out.println("Sending grid " + grid);
        GlobalVariables.getSendingThread().sendMessage(GlobalVariables.messagePattern(messageSize) + "08" + GlobalVariables.playerName + ";" + GlobalVariables.gameName + ";" + grid + ";");
    }

    public void placeShip11(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 1)) {
                btn11.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip21(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 1)) {
                btn21.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip12(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 2)) {
                btn12.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip22(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 2)) {
                btn22.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip31(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 1)) {
                btn31.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip32(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 2)) {
                btn32.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip41(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 1)) {
                btn41.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip43(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 3)) {
                btn43.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip42(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 2)) {
                btn42.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip51(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 1)) {
                btn51.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip52(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 2)) {
                btn52.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip53(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 3)) {
                btn53.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip54(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 4)) {
                btn54.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip44(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 4)) {
                btn44.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip33(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 3)) {
                btn33.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip34(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 4)) {
                btn34.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip23(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 3)) {
                btn23.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip24(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 4)) {
                btn24.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip13(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 3)) {
                btn13.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip14(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 4)) {
                btn14.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip61(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 1)) {
                btn61.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip62(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 2)) {
                btn61.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip63(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 3)) {
                btn63.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip64(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 4)) {
                btn64.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip15(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 5)) {
                btn15.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip35(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 5)) {
                btn35.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip25(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 5)) {
                btn25.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip45(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 5)) {
                btn45.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip55(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 5)) {
                btn55.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip65(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 5)) {
                btn65.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip16(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(1, 6)) {
                btn16.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip26(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(2, 6)) {
                btn26.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip36(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(3, 6)) {
                btn36.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip46(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(4, 6)) {
                btn46.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip56(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(5, 6)) {
                btn56.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }

    public void placeShip66(ActionEvent actionEvent) {
        if (game.getPlaceShip() > 0) {
            if (game.placeShip(6, 6)) {
                btn66.setStyle("-fx-background-image: url('/main/resources/img/ship2.jpg'); -fx-background-repeat: no-repeat;");
                shipsToPlace.setText(String.valueOf(game.getPlaceShip()));
                if (game.getPlaceShip() == 0) {
                    readyButton.setDisable(false);
                }
            }
        }
    }
}
