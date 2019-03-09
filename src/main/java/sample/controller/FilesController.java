package sample.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.preferences.AbstractController;
import sample.preferences.ElementController;

import java.awt.*;

public class FilesController extends AbstractController implements ElementController {
    public FilesController(Tab tab) {
        init(tab);
    }

    public void init(Tab tab) {
        System.out.println(tab);

    }
}
