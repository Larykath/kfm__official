package sample.preferences;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.awt.*;

public class AbstractController {

   public static HBox hBox;

    public ObservableList childsFromRootList;

    public AbstractController(Node node) {
        hBox = (HBox) node;
    }

    public AbstractController() {
    }

    public ObservableList getChildsFromRootList() {
        return childsFromRootList;
    }

    public void setChildsFromRootList(ObservableList childsFromRootList) {
        this.childsFromRootList = childsFromRootList;
    }

    public HBox gethBox() {
        return hBox;
    }
}
