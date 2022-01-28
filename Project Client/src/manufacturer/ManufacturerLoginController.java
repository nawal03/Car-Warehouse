package manufacturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import serializable.Manufacturer;
import toast.Toast;


public class ManufacturerLoginController {
    private Main main;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void setMain(Main main){
        this.main=main;
    }

    public void reset(ActionEvent event) {
        username.clear();
        password.clear();
    }

    public void login(ActionEvent event) {
        Manufacturer manufacturer= new Manufacturer(username.getText(),password.getText());
        if(ServerApproval.approveManufacturerLogin(manufacturer)){
            Toast.makePositiveToast(main.getStage(),"Login Successful!!");
            main.showManufacturerHomePage(username.getText());
        }
        else{
            Toast.makeNegativeToast(main.getStage(),"Login Failed!!");
        }
        username.clear();
        password.clear();
    }

    public void back(ActionEvent event) {
        main.showHomePage();
    }
}
