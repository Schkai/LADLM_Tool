package ks.schkai.manager.view;


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

        showPersonDetails(null);

        //Listen for selection changes and show details when changed
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));


    }

    /**
     * Called by main app to give a reference back to itself
     * @param mainApp is used for that
     */

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        //Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }


    /**
     * fill all text fields to show details about person or objective
     * if person is null, text fields are cleared
     *
     * @param person the person or null
     */

    private void showPersonDetails(Person person){
        if(person != null){
            //fill labels with info from person object
            nameLabel.setText(person.getName());
            typLabel.setText(person.getTyp());
            damageLabel.setText(person.getDamage());
            paradeLabel.setText(person.getParade());
            specialLabel.setText(person.getSpecial());
        } else {
            //person is null, remove every text
            nameLabel.setText("");
            typLabel.setText("");
            damageLabel.setText("");
            paradeLabel.setText("");
            specialLabel.setText("");
        }
    }

    /**
     * called when user click delete button
     */
    @FXML
    private void handleDeletePerson(){
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        personTable.getItems().remove(selectedIndex);
    }
    

}