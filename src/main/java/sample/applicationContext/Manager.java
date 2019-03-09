package sample.applicationContext;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import sample.controller.FilesController;
import sample.controller.KeysController;
import sample.controller.MessagesController;
import sample.preferences.AbstractController;

import java.util.List;

public class Manager {

    private static Manager manager;

    private final boolean state;
    private KeysController keys;
    private FilesController files;
    private MessagesController messages;
    private AbstractController generalController;

    private final List<Node> rawComponentList;

    private Manager(ObservableList rawComponentList) {
        this.rawComponentList = rawComponentList;
        generalController = new AbstractController(this.rawComponentList.get(2));
        state = init(this.rawComponentList);
    }

    public static Manager getInstance(ObservableList componentList) {
        if (null == manager) {
            manager = new Manager(componentList);
            return manager;
        }

        return manager;
    }


    private boolean init(List rawComponentList){
        int returnval = 0;

        TabPane tabPane = (TabPane) rawComponentList.get(1);
        List<Tab> componentList = tabPane.getTabs();

        keys = new KeysController();
        messages = new MessagesController();

        if (componentList.get(0).getId().equals("0")){
            keys.init(componentList.get(0));
            returnval++;
        }

        if (componentList.get(1).getId().equals("1")){
            files = new FilesController(componentList.get(1));
            returnval++;
        }

        if (componentList.get(2).getId().equals("2")){
            messages.init(componentList.get(2));
            returnval++;
        }


        return (returnval==3) ? true : false;
    }

    public boolean isState() {
        return state;
    }



}
