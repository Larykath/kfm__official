package sample.applicationContext;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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

    private Manager(ObservableList rawComponentList) {
        List<Tab> rawComponentList1 = ((TabPane) rawComponentList.get(0)).getTabs();
//        generalController = new AbstractController(this.rawComponentList.get(2));
        state = initControllers(rawComponentList1);
    }

    public static Manager getInstance(ObservableList componentList) {
        if (null == manager) {
            manager = new Manager(componentList);
            return manager;
        }

        return manager;
    }


    private boolean initControllers(List rawComponentList){
        int returnval = 0;

        List<Tab> componentList = rawComponentList;

        keys = new KeysController();
        messages = new MessagesController();

        if (componentList.get(0).getId().equals("keypass")){
            keys.init(componentList.get(1));
            returnval++;
        }

        if (componentList.get(1).getId().equals("pgp")){
            files = new FilesController(componentList.get(0));
            returnval++;
        }

        if (componentList.get(2).getId().equals("mail")){
            messages.init(componentList.get(2));
            returnval++;
        }


        return (returnval==3) ? true : false;
    }

    public boolean isState() {
        return state;
    }



}
