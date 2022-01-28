package viewer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import serializable.Car;
import toast.Toast;

public class ViewerHomeController {

    private Main main;
    private ObservableList<Car> cars= FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Car, String> regNumColumn, carMakeColumn,carModelColumn, color1Column,color2Column,color3Column, yearMadeColumn, priceColumn,quantityColumn;
    @FXML
    private TextField regNumText,carMakeText, carModelText;

    public void initialize(){
        ServerApproval.getCars("","","", this.cars);

        tableView.setItems(this.cars);

        regNumColumn.setCellValueFactory(new PropertyValueFactory<>("regNum"));
        carMakeColumn.setCellValueFactory(new PropertyValueFactory<>("carMake"));
        carModelColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        color1Column.setCellValueFactory(new PropertyValueFactory<>("color1"));
        color2Column.setCellValueFactory(new PropertyValueFactory<>("color2"));
        color3Column.setCellValueFactory(new PropertyValueFactory<>("color3"));
        yearMadeColumn.setCellValueFactory(new PropertyValueFactory<>("yearMade"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    }

    public void setMain(Main main) {
        this.main = main;
    }



    public void refresh(ActionEvent event) {
        ServerApproval.getCars(regNumText.getText(),carMakeText.getText(),carModelText.getText(),this.cars);
    }

    public void back(ActionEvent event) {
        main.showHomePage();
    }

    public void buyCar(ActionEvent event) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        if(car==null) return;
        ServerApproval.getCars(regNumText.getText(),carMakeText.getText(),carModelText.getText(),this.cars);
        for(Car car1: cars){
            if(car1.getRegNum().equals(car.getRegNum()) && Integer.parseInt(car1.getQuantity()) >0){
                main.showViewerBuyCarPage(car);
                return;
            }
        }
        Toast.makeNegativeToast(main.getStage(),"Sorry! You can not buy the car.");
    }

    public void viewImage(ActionEvent event) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        if(car==null) return;
        ServerApproval.getCars(regNumText.getText(),carMakeText.getText(),carModelText.getText(),this.cars);
        for(Car car1: cars){
            if(car1.getRegNum().equals(car.getRegNum()) && Integer.parseInt(car1.getQuantity()) >0){
                main.showCarImageViewPage(car);
                return;
            }
        }
        Toast.makeNegativeToast(main.getStage(),"Sorry! You can not view the car.");
    }

    public void search(ActionEvent event) {
        ServerApproval.getCars(regNumText.getText(),carMakeText.getText(),carModelText.getText(),this.cars);
    }

    public void reset(ActionEvent event) {
        regNumText.clear();
        carMakeText.clear();
        carModelText.clear();
        carModelText.setDisable(true);
        carMakeText.setDisable(false);
        regNumText.setDisable(false);
        ServerApproval.getCars(regNumText.getText(),carMakeText.getText(),carModelText.getText(),this.cars);
    }

    public void regNumTextChanged(KeyEvent keyEvent) {
        if(regNumText.getText().isEmpty()) carMakeText.setDisable(false);
        else carMakeText.setDisable(true);
    }


    public void carMakeTextChanged(KeyEvent keyEvent) {
        if(carMakeText.getText().isEmpty()){
            carModelText.setText("");
            carModelText.setDisable(true);
            regNumText.setDisable(false);
        }
        else{
            carModelText.setDisable(false);
            regNumText.setDisable(true);
        }
    }
}

