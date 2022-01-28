package admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import serializable.Manufacturer;
import toast.Toast;



public class AdminHomeController {

    private Main main;
    private ObservableList<Manufacturer> manufacturers= FXCollections.observableArrayList();
    private ObservableList<String> users=FXCollections.observableArrayList();

    @FXML
    private TextField usernameText, passwordText;
    @FXML
    ListView<Manufacturer> manufacturerList;
    @FXML
    ListView<String> userList;
    @FXML
    Label totalLabel;

    public void setMain(Main main) {
        this.main=main;
    }

    public void initialize(){
        manufacturerList.setItems(manufacturers);
        userList.setItems(users);

        ServerApproval.getManufacturers(this.manufacturers);
        ServerApproval.getUsers(this.users);

        totalLabel.setText(Integer.toString(this.users.size()));

    }

    public void addManufacturer(ActionEvent event) {
        if(usernameText.getText().isEmpty() || passwordText.getText().isEmpty()){
            Toast.makeNegativeToast(main.getStage(), "Manufacturer Add Failed! Please add all the credentials.");
            return;
        }
        Manufacturer manufacturer=new Manufacturer(usernameText.getText(),passwordText.getText());
        if(ServerApproval.addManufacturer(manufacturer)){
            manufacturers.add(manufacturer);
            Toast.makePositiveToast(main.getStage(),"Manufacturer Added Successfully!");
        }
        else{
            Toast.makeNegativeToast(main.getStage(), "Manufacturer Add Failed! Username should be unique.");
        }
        usernameText.clear();
        passwordText.clear();

    }

    public void deleteManufacturer(ActionEvent event) {
        Manufacturer manufacturer= manufacturerList.getSelectionModel().getSelectedItem();
        if(manufacturer==null) return;
        if(ServerApproval.deleteManufacturer(manufacturer)){
            manufacturers.remove(manufacturer);
            Toast.makePositiveToast(main.getStage(),"Manufacturer Deleted Successfully!");
        }
        else{
            Toast.makeNegativeToast(main.getStage(), "Manufacturer Already Deleted!");
        }
    }

    public void logout(ActionEvent event) {
        main.showAdminLoginPage();
    }

    public void refresh(ActionEvent event) {
        ServerApproval.getManufacturers(this.manufacturers);
        ServerApproval.getUsers(this.users);

        totalLabel.setText(Integer.toString(this.users.size()));

    }

}
