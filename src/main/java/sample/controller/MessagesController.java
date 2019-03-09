package sample.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import sample.preferences.AbstractController;
import sample.preferences.ElementController;

public class MessagesController extends AbstractController implements ElementController {
    public MessagesController( ) {
    }

    public void init(Tab tab) {
        System.out.println(tab);
    }
}
