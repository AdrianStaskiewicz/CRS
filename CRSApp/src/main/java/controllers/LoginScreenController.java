package controllers;

import errors.ErrorCode;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.Getter;
import lombok.Setter;
import services.ConnectionService;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class LoginScreenController {

    @FXML
    private AnchorPane notificationBackground;

    @FXML
    private Label notificationMessage;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button remindPasswordButton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    private Boolean connectionStatus;
    public Boolean checkConnection;

    public Thread thread = new Thread() {
        public void run() {
            ConnectionService connectionService = new ConnectionService();
            checkConnection=Boolean.TRUE;
            while (checkConnection) {

                if (!connectionService.checkConnection()) {
                    connectionStatus = Boolean.FALSE;
                    displayError(ErrorCode.C000);
                } else {
                    connectionStatus = Boolean.TRUE;
                    clearError();
                }
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @FXML
    public void initialize() {
        thread.start();

//        ConnectionService connectionService = new ConnectionService();
//        if (!connectionService.checkConnection()) {
//            connectionStatus=Boolean.FALSE;
//            displayError(ErrorCode.C000);
//        }
    }

    @FXML
    void onLoginButtonClick() throws InterruptedException {

        if (connectionStatus) {
            FXMLLoader innerLoader = new FXMLLoader();
            innerLoader.setLocation(this.getClass().getResource("/views/MainScreen.fxml"));

//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);
            try {
                Parent innerRoot = innerLoader.load();
                MainScreenController mainScreenController = innerLoader.getController();
//            mainScreenController.setClient(client);
//            mainScreenController.setLocalDatabase(localDatabase);
//            stage.setTitle("PasswordsManager 1.0.0");
//            Scene scene = new Scene()
                scene.setRoot(innerRoot);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();

                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        System.out.println("Stage is closing");
                        checkConnection = Boolean.FALSE;
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
        }
    }

    @FXML
    void onRemindPasswordClick() {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/MainScreen.fxml"));

//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);
        try {
//            stage
            Parent innerRoot = innerLoader.load();
            MainScreenController mainScreenController = innerLoader.getController();
//            mainScreenController.setClient(client);
//            mainScreenController.setLocalDatabase(localDatabase);
//            stage.setTitle("PasswordsManager 1.0.0");
//            Scene scene = new Scene()
            scene.setRoot(innerRoot);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
//            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayError(String msg) {
        notificationBackground.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        notificationMessage.setText(ErrorCode.C000);
        notificationMessage.setTextFill(Color.WHITE);
        notificationBackground.setVisible(Boolean.TRUE);
    }

    public void clearError() {
        notificationBackground.setVisible(Boolean.FALSE);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
