package sample.applicationContext;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.handling.ViewHandler;
import sample.preferences.Kfm_types;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/KFM-Manager.fxml"));
        final ObservableList componentList = root.getChildrenUnmodifiable();
        System.out.println(componentList);
        Manager manager = Manager.getInstance(componentList);

        if (manager.isState() == true) {

            primaryStage.setScene(new Scene(root, 0, 0));
            primaryStage.show();
            ViewHandler.getInstance().init(primaryStage);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
