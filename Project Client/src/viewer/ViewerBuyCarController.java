package viewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import serializable.Car;
import toast.Toast;

public class ViewerBuyCarController {

    private Car car;
    private Main main;
    @FXML
    private TextField nameText;
    @FXML
    private Label regNumLabel,carMakeLabel,colorsLabel,carModelLabel, yearMadeLabel, priceLabel;

    public void setMain(Main main) {
        this.main = main;
    }

    public void initialize(Car car){
        this.car = car;
        this.regNumLabel.setText(car.getRegNum());
        this.carMakeLabel.setText(car.getCarMake());
        this.carModelLabel.setText(car.getCarModel());
        this.colorsLabel.setText(car.getColor1()+"/"+car.getColor2()+"/"+car.getColor3());
        this.yearMadeLabel.setText(car.getYearMade());
        this.priceLabel.setText(car.getPrice());
    }

    public void confirm(ActionEvent event) {
        if(nameText.getText().isEmpty()){
            Toast.makeNegativeToast((Stage) regNumLabel.getScene().getWindow(),"Please fill up your name.");
            return;
        }
        if(ServerApproval.buyCar(car)){
            Toast.makePositiveToast(main.getStage(), "Congratulation, "+nameText.getText()+"!!! You have bought the car : "+car.getRegNum());
            main.showViewerHomePage();
        }
        else{
            Toast.makeNegativeToast(main.getStage(),"Sorry! You can not buy this car.");
            main.showViewerHomePage();
        }
    }

    public void cancel(ActionEvent event) {
        main.showViewerHomePage();
    }
}
