package sample.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.crypto.KeyGenerator;
import sample.handling.ViewHandler;
import sample.preferences.AbstractController;
import sample.preferences.ElementController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class KeysController implements ElementController {
    Tab manageTab;
    Tab createTab;

    private ListView<SimpleObjectProperty> keyListView;
    private ListView createListView;

    public KeysController() {
    }

    public void init(Tab tab) {
        this.manageTab = tab;
//        System.out.println();
//        keyListView = getKeyListView();
        test();

    }

    public ListView<SimpleObjectProperty> getKeyListView() {
        if (null == keyListView) {
            AnchorPane anchorPane= (AnchorPane) manageTab.getContent();
            System.out.println(anchorPane.getChildren());
//            Tab tmpTab = (Tab) tabPanel.getTabs();
//            SplitPane splitPane = (SplitPane) tabPanel.getTabs().get(0).getContent();
//            AnchorPane anchorPane = (AnchorPane) splitPane.getItems().get(0);
//            ObservableList observableList = anchorPane.getChildren();
//            ListView listView = (ListView) observableList.get(0);
//            return listView;
        }

        return keyListView;
    }

    public void test() {
        AbstractController.hBox.getChildren().get(0).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                ObservableList newObservableList;
                SimpleObjectProperty simpleObjectProperty = new SimpleObjectProperty();
                simpleObjectProperty.setValue("Test");

                if (keyListView.getItems().isEmpty()) {
                    newObservableList = FXCollections.observableArrayList(simpleObjectProperty);
                } else {
                    newObservableList = keyListView.getItems();
                    newObservableList.add(simpleObjectProperty);
                }
                keyListView.setItems(newObservableList);
                try {
                    openKeyCreateWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void openKeyCreateWindow() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        final VBox vBox = FXMLLoader.load((getClass().getResource("/fxml/pgpGeneratorForm.fxml")));
        Stage secondaryStage = new Stage();
        Scene tmpSceene = new Scene(vBox, 0, 0);
        vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

            }
        });
        secondaryStage.setScene(tmpSceene);
        ViewHandler.getInstance().openNewStage(secondaryStage);
    }

    public void handleButtonActionGenerateExport(ActionEvent event) {

        System.out.println("hat geklappt");
    }

    public void handleButtonActionGenerateClose(ActionEvent event) {

        System.out.println("hat geklappt");
    }

    public void handleButtonActionGenerateNew(ActionEvent event) {
        try {
            KeyGenerator generator = KeyGenerator.getNewKeyPair(512);
            System.out.println(generator.getKeyPair());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void handleButtonActionGenerateImport(ActionEvent event) {

        System.out.println("hat geklappt");
    }

}
