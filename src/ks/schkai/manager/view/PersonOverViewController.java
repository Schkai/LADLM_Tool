package ks.schkai.manager.view;

/**
 * Created by Konstantin on 16.12.2015.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ks.schkai.manager.MainApp;
import ks.schkai.manager.model.Person;


public class PersonOverViewController {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> typColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label typLabel;
    @FXML
    private Label damageLabel;
    @FXML
    private Label paradeLabel;
    @FXML
    private Label specialLabel;

    private MainApp mainApp;

    /**
     * Constructor is called before initialize() method
     */

    public PersonOverViewController(){

    }

    /**
     * Initialize controller class. method is automatically called after the fxml file has been loaded
     */

    @FXML
    private void initialize(){
        //Initialize person table with two columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typColumn.setCellValueFactory(cellData -> cellData.getValue().typProperty());
    }

    /**
     * Called by main app to give a reference back to itself
     * @param mainApp
     */

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        //Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }



}