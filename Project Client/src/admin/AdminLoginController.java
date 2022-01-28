package admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import toast.Toast;


public class AdminLoginController {
    private Main main;
    @FXML
    private TextField usernameText, passwordText;

    public void setMain(Main main){
        this.main=main;
    }

    public void reset(ActionEvent event) {
        usernameText.clear();
        passwordText.clear();
    }

    public void login(ActionEvent event) {
        if(ServerApproval.approveAdminLogin(usernameText.getText(),passwordText.getText())){
            Toast.makePositiveToast(main.getStage(), "Login Successful!!");
            main.showAdminHomePage();
        }
        else{
            Toast.makeNegativeToast(main.getStage(),"Login Failed!!");
        }
        usernameText.clear();
        passwordText.clear();
    }

    public void back(ActionEvent event) {
        main.showHomePage();
    }


}
