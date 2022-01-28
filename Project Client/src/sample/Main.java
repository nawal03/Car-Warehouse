package sample;

import admin.AdminHomeController;
import admin.AdminLoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manufacturer.ManufacturerLoginController;
import manufacturer.ManufacturerHomeController;
import network.ServerApproval;
import serializable.Car;
import viewer.ViewerBuyCarController;
import viewer.ViewerHomeController;


import java.io.IOException;
public class Main extends Application {
    private Stage stage;

    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage=primaryStage;
        new ServerApproval();
        this.showHomePage();
    }

    public void showHomePage(){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HomeController controller= loader.getController();
        controller.setMain(this);

        stage.setTitle("Home");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }
    public void showManufacturerLoginPage(){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("manufacturer//manufacturerlogin.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ManufacturerLoginController controller= loader.getController();
        controller.setMain(this);

        stage.setTitle("Manufacturer Login");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }

    public void showManufacturerHomePage(String manufacturerName){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("manufacturer//manufacturerhome.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ManufacturerHomeController controller= loader.getController();
        controller.setMain(this);
        controller.setManufacturerName(manufacturerName);
        stage.setTitle("Manufacturer Home");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }

    public void showCarImageViewPage(Car car, String manufacturerName){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("manufacturer//carimageview.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        manufacturer.CarImageViewController controller= loader.getController();
        controller.setMain(this);
        controller.initialize(car, manufacturerName);
        stage.setTitle("Car Image View");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }

    public void showViewerHomePage(){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("viewer//viewerhome.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewerHomeController controller= loader.getController();
        controller.setMain(this);
        stage.setTitle("Viewer Home");
        stage.setScene(new Scene(root, 756, 550));
        stage.show();
    }

    public void showCarImageViewPage(Car car){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("viewer//carimageview.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewer.CarImageViewController controller= loader.getController();
        controller.setMain(this);
        controller.initialize(car);
        stage.setTitle("Car Image View");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }
    public void showViewerBuyCarPage(Car car){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("viewer//viewerbuycar.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewerBuyCarController controller= loader.getController();
        controller.setMain(this);
        controller.initialize(car);
        stage.setTitle("Car Buy");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }
    public void showAdminHomePage(){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("admin//adminhome.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminHomeController controller= loader.getController();
        controller.setMain(this);
        stage.setTitle("Admin Home");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }

    public  void showAdminLoginPage(){
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("admin//adminlogin.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminLoginController controller= loader.getController();
        controller.setMain(this);
        stage.setTitle("Admin Login");
        stage.setScene(new Scene(root, 750, 550));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
