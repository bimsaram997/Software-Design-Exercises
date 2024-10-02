package com.mycompany.fitnesstracker;


import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
          FitnessModel model = new FitnessModel();
        FitnessView view = new FitnessView(model);

        // Call view's initialize method before creating the controller
        view.initialize(stage);

        // Now create the controller after the view is properly initialized
        FitnessController controller = new FitnessController(model, view, stage);
    }
    
     

    public static void main(String[] args) {
        launch();
    }
}
