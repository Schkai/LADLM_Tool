package ks.schkai.manager.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ks.schkai.manager.model.Person;

import java.awt.*;

/**
 * Dialog to edit persons or objects
 */


public class PersonEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField typField;
    @FXML
    private TextField damageField;
    @FXML
    private TextField paradeField;
    @FXML
    private TextField specialField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * automatic called inizialize function after fxml file has been loaded
     */
    @FXML
    private void initialize(){
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    /**
     * Sets person or object to be edited in dialog
     *
     * @param person
     */
    public void setPerson(Person person){
        this.person = person;

        nameField.setText(person.getName());
        typField.setText(person.getTyp());
        damageField.setText(person.getDamage());
        paradeField.setText(person.getParade());
        paradeField.setText(person.getSpecial());
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            person.setname(nameField.getText());
            person.setTyp(typField.getText());
            person.setDamage(damageField.getText());
            person.setParade(paradeField.getText());
            person.setSpecial(specialField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancle(){
        dialogStage.close();
    }


    /**
     * Validates user input
     * @return true if input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";


        if(nameField.getText() == null || nameField.getText().length() == 0){
            errorMessage += "No valid name!\n";
        }
        if(typField.getText() == null || typField.getText().length() == 0){
            errorMessage += "No valid type!\n";
        }
        if(damageField.getText() == null || damageField.getText().length() == 0){
            errorMessage += "No valid damage value!\n";
        }
        if(paradeField.getText() == null || paradeField.getText().length() == 0){
            errorMessage += "No valid parade value!\n";
        }
        if(specialField.getText() == null || specialField.getText().length() == 0){
            errorMessage += "No valid special entry!\n";
        }

        if(errorMessage.length() == 0){
            return true;
        } else{
            //Show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid entry");
            alert.setHeaderText("Please correct invalid entries");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }

    }


}
