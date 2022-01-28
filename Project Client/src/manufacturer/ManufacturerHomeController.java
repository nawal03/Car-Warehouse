package manufacturer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import network.ServerApproval;
import sample.Main;
import serializable.Car;
import serializable.CarImage;
import toast.Toast;

import java.io.File;


public class ManufacturerHomeController {
    private Main main;
    private ObservableList<Car> cars= FXCollections.observableArrayList();
    @FXML
    private Label manufacturerNameLabel;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Car, String> regNumColumn, carMakeColumn,carModelColumn, color1Column,color2Column,color3Column, yearMadeColumn, priceColumn,quantityColumn;
    @FXML
    private TextField regNumText,carMakeText, carModelText, color1Text, color2Text, color3Text, yearMadeText, priceText, quantityText;
    @FXML
    private Label imageDirectoryLabel;

    public void setMain(Main main) {
        this.main = main;
    }
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerNameLabel.setText(manufacturerName);
    }

    public void initialize(){
        ServerApproval.getCars("","","", this.cars);

        tableView.setItems(this.cars);

        regNumColumn.setCellValueFactory(new PropertyValueFactory<>("regNum"));
        carMakeColumn.setCellValueFactory(new PropertyValueFactory<>("carMake"));
        carMakeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        carModelColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        carModelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        color1Column.setCellValueFactory(new PropertyValueFactory<>("color1"));
        color1Column.setCellFactory(TextFieldTableCell.forTableColumn());
        color2Column.setCellValueFactory(new PropertyValueFactory<>("color2"));
        color2Column.setCellFactory(TextFieldTableCell.forTableColumn());
        color3Column.setCellValueFactory(new PropertyValueFactory<>("color3"));
        color3Column.setCellFactory(TextFieldTableCell.forTableColumn());
        yearMadeColumn.setCellValueFactory(new PropertyValueFactory<>("yearMade"));
        yearMadeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void editCarMakeColumn(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getCarMake();
        car.setCarMake((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(), "Edit Failed! Please refresh the page.");
            car.setCarMake(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editCarModelColumn(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getCarModel();
        car.setCarModel((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(), "Edit Failed! Please refresh the page.");
            car.setCarModel(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editColor1Column(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getColor1();
        car.setColor1((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(), "Edit Failed! Please refresh the page.");
            car.setColor1(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editColor2Column(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getColor2();
        car.setColor2((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(),"Edit Failed! Please refresh the page.");
            car.setColor2(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editColor3Column(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getColor3();
        car.setColor3((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(),"Edit Failed! Please refresh the page.");
            car.setColor3(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editYearMadeColumn(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getYearMade();
        car.setYearMade((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(),"Edit Failed! Please refresh the page.");
            car.setYearMade(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editPriceColumn(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getPrice();
        car.setPrice((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(),"Edit Failed! Please refresh the page.");
            car.setPrice(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editQuantityColumn(TableColumn.CellEditEvent cellEditEvent) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        String oldValue= car.getQuantity();
        car.setQuantity((String) cellEditEvent.getNewValue());
        if(!ServerApproval.editCar(car)){
            Toast.makeNegativeToast(main.getStage(),"Edit Failed! Please refresh the page.");
            car.setQuantity(oldValue);
            ServerApproval.getCars("","","",cars);
        }
    }

    public void editImage(ActionEvent event) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        if(car==null) return;
        FileChooser fileChooser= new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.bmp"));
        File selectedFile= fileChooser.showOpenDialog(null);
        try{
            car.setCarImage(new CarImage(selectedFile.getAbsolutePath()));
            if(!ServerApproval.editCar(car)){
                Toast.makeNegativeToast(main.getStage(),"Image Edit Failed!");
                ServerApproval.getCars("","","",this.cars);
            }
        }catch (Exception e){
            Toast.makeNegativeToast(main.getStage(),"Image Edit Failed!");
            return;
        }
        Toast.makePositiveToast(main.getStage(), "Car Image Edited Successfully!");
    }

    public void viewImage(ActionEvent event) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        if(car==null) return;
        ServerApproval.getCars("","","",this.cars);
        for(Car car1: cars){
            if(car1.getRegNum().equals(car.getRegNum()) && Integer.parseInt(car1.getQuantity()) >0){
                main.showCarImageViewPage(car,manufacturerNameLabel.getText());
                return;
            }
        }
        Toast.makeNegativeToast(main.getStage(),"Sorry! You can not view the car.");
    }

    public void addImage(ActionEvent event) {
        FileChooser fileChooser= new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.bmp")
        );
        File selectedFile= fileChooser.showOpenDialog(null);
        try{
            imageDirectoryLabel.setText(selectedFile.getAbsolutePath());
            Toast.makePositiveToast(main.getStage(), "Car Image Added Successfully!");

        }catch (Exception e){
            Toast.makeNegativeToast(main.getStage(),"Please Choose a file.");
        }
    }

    public void addCar(ActionEvent event) {
        if(imageDirectoryLabel.getText().isEmpty()){
            Toast.makeNegativeToast(main.getStage(), "Oops! Registration Number should be unique and all necessary fileds should be filled up properly.");
            regNumText.clear();
            carMakeText.clear();
            carModelText.clear();
            color1Text.clear();
            color2Text.clear();
            color3Text.clear();
            yearMadeText.clear();
            priceText.clear();
            quantityText.clear();
            imageDirectoryLabel.setText("");
            return;
        }
        Car car= new Car(
                regNumText.getText(), carMakeText.getText(), carModelText.getText(),
                color1Text.getText(),color2Text.getText(),color3Text.getText(),
                yearMadeText.getText(), priceText.getText(), quantityText.getText(),
                imageDirectoryLabel.getText()
        );
        if(ServerApproval.addCar(car)){
            Toast.makePositiveToast(main.getStage(),"Car Successfully Added!");
            this.cars.add(car);
        }
        else{
            Toast.makeNegativeToast(main.getStage(), "Oops! Registration Number should be unique and all necessary fileds should be filled up properly.");
        }
        regNumText.clear();
        carMakeText.clear();
        carModelText.clear();
        color1Text.clear();
        color2Text.clear();
        color3Text.clear();
        yearMadeText.clear();
        priceText.clear();
        quantityText.clear();
        imageDirectoryLabel.setText("");
    }

    public void deleteCar(ActionEvent event) {
        Car car= (Car) tableView.getSelectionModel().getSelectedItem();
        if(car==null) return;
        if(ServerApproval.deleteCar(car)){
            ObservableList<Car>  allCars,carSelected;
            carSelected= tableView.getSelectionModel().getSelectedItems();
            allCars=tableView.getItems();
            try {
                carSelected.forEach(allCars::remove);
            }catch (Exception e){
                e.getStackTrace();
            }
            Toast.makePositiveToast(main.getStage(),"Car Successfully Deleted!!");
        }
        else{
            Toast.makeNegativeToast(main.getStage(), "Oops! Car Delete Failed!");
            ServerApproval.getCars("","","",this.cars);

        }
    }

    public void logout(ActionEvent event) {
        main.showManufacturerLoginPage();
    }

    public void refresh(ActionEvent event) {
        ServerApproval.getCars("","","",this.cars);
    }
}
