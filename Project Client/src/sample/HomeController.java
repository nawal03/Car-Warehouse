package sample;

import javafx.event.ActionEvent;

public class HomeController {
    private Main main;

    public void setMain(Main main){
        this.main=main;
    }

    public void adminButtonClicked(ActionEvent event) {
        main.showAdminLoginPage();
    }

    public void manufacturerButtonClicked(ActionEvent event) {
        main.showManufacturerLoginPage();
    }

    public void viewerButtonClicked(ActionEvent event) {
        main.showViewerHomePage();
    }
}
