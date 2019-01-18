import controllers.LoginScreenController;
import entities.Address;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import parameters.ParameterProvider;

import java.io.IOException;
import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        Address test = restTemplate.getForObject("http://localhost:8080/test", Address.class);
//
//        Address testowy = new Address();
//        testowy.setCity("Poznań");
//        testowy.setStreet("Królowej Jadwigi");
//        testowy.setHouseNumber("25");
//        testowy.setLocalNumber("5");
//        testowy.setPostCode("60-811");
//
//        restTemplate.postForObject("http://localhost:8080/testb",testowy,Address.class);
//    }
//}

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader innerLoader = new FXMLLoader(getClass().getResource("views/LoginScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);
        try {
            Stage stage = new Stage();
            Parent innerRoot = innerLoader.load();
            //TODO AS - SETTING ALL REQUIRED OBJECTS
            LoginScreenController loginScreenController = innerLoader.getController();
//            loginScreenController.setClient(client);

            stage.setTitle(ParameterProvider.WINDOW_TITLE);
            Scene scene = new Scene(innerRoot, 800, 500);
            stage.setScene(scene);
            stage.setMaximized(true);
            loginScreenController.setStage(stage);
            loginScreenController.setScene(scene);
            stage.show();

//            Platform.runLater(loginScreenController.thread::start);
//            loginScreenController.thread.start();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Stage is closing2");
                    loginScreenController.checkConnection=Boolean.FALSE;
                }
            });

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Main(String[] args) {
        launch(args);
    }
}
