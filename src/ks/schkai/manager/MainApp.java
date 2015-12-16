package ks.schkai.manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ks.schkai.manager.model.Person;
import ks.schkai.manager.view.PersonOverViewController;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     *  Data as an observable list of Persons.
     */

    private ObservableList<Person> personData = FXCollections.observableArrayList();


    /**
     * Constructor
     */

    public MainApp(){

        //Add sample data

        personData.add(new Person("AK-47", "Waffe"));
        personData.add(new Person("Messer", "Nahkampfwaffe"));
        personData.add(new Person("Wasser", "Nahrung"));
        personData.add(new Person("Dose Ravioli", "Nahrung"));
        personData.add(new Person("Batterie", "Verbrauch"));
        personData.add(new Person("AR-15", "Waffe"));
        personData.add(new Person("Obstler", "Nahrung"));
        personData.add(new Person("Telefon", "Verbrauch"));

    }

    /**
     * Returns data as obervable list of persons
     * @return
     */






    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("LADLM Tool");

        initRootLayout();

        showPersonOverview();
    }


    //Initializes the root Layout
    private void initRootLayout() {

        try {
            //Load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Show the scene with the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    //Show person overview inside the root layout
    private void showPersonOverview() {
        try {

            //Load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            //Set person overview into center of root layout
            rootLayout.setCenter(personOverview);

            //Give Controller access to the main app

            PersonOverViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public ObservableList<Person> getPersonData(){
        return personData;
    }


    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
