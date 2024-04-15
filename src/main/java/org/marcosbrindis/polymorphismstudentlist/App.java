package org.marcosbrindis.polymorphismstudentlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.marcosbrindis.polymorphismstudentlist.controller.MainController;
import org.marcosbrindis.polymorphismstudentlist.models.School;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        School school = new School();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainController mainController = fxmlLoader.getController();
        mainController.setSchool(school);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("");
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}