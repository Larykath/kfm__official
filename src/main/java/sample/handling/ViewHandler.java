package sample.handling;

import com.sun.javafx.scene.shape.PathUtils;
import com.sun.javafx.stage.StageHelper;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controller.FilesController;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ViewHandler {
    private static ViewHandler ourInstance = new ViewHandler();
    private Stage currentStage;
    private Stage firstStage;
    private Stage lastStage;

    Map<String, Stage> viewMap;

    public static ViewHandler getInstance() {
        return ourInstance;
    }

    private ViewHandler() {
    }


    public void init(Stage firstStage){
        viewMap = new HashMap();
        this.firstStage = firstStage;

        if (viewMap.entrySet().isEmpty()){
            viewMap.put(firstStage.getTitle(),firstStage);
            currentStage = firstStage;

        }

        createAllStages();

    }

    private void createAllStages() {

    }

    public void openNewStage(Stage stageToChangeTo) throws IOException {
        if (null != stageToChangeTo) {
            if (stageToChangeTo.equals(firstStage)) {

            } else if (!currentStage.equals(stageToChangeTo)){
                currentStage = stageToChangeTo;
                stageToChangeTo.show();
            }
        }

    }

//        Parent parent = FXMLLoader.load((getClass().getResource("/fxml/keyCreate.fxml")));
//        Stage secondaryStage = new Stage();
//        Scene tmpSceene = new Scene(parent, 0 , 0);
//        secondaryStage.setScene(tmpSceene);
//        secondaryStage.show();

    public void openNewStage(Stage stageToChangeTo, Scene sceneToChangeToo){

    }

}
