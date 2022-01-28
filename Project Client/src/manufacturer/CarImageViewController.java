package manufacturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;
import serializable.Car;
import toast.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CarImageViewController {

    private Main main;
    private Car car;
    @FXML
    private ImageView imageView;
    @FXML
    private Label manufacturerNameLabel,regNumLabel,carMakeLabel,carModelLabel,colorsLabel, yearMadeLabel, priceLabel;

    public void setMain(Main main){
        this.main=main;
    }
    public void initialize(Car car,String manufacturerName){
        this.manufacturerNameLabel.setText(manufacturerName);
        this.regNumLabel.setText(car.getRegNum());
        this.carMakeLabel.setText(car.getCarMake());
        this.carModelLabel.setText(car.getCarModel());
        this.colorsLabel.setText(car.getColor1()+"/"+car.getColor2()+"/"+car.getColor3());
        this.yearMadeLabel.setText(car.getYearMade());
        this.priceLabel.setText(car.getPrice());
        try {
            FileInputStream fis = new FileInputStream(car.getCarImage().getImageDirectory());
            Image image= new Image(fis);
            this.imageView.setImage(image);
        } catch (FileNotFoundException e) {
            Toast.makeNegativeToast(main.getStage(), "Can not find the image!");
            main.showManufacturerHomePage(manufacturerNameLabel.getText());
            e.printStackTrace();
        }
    }
    public void back(ActionEvent event) {
        main.showManufacturerHomePage(manufacturerNameLabel.getText());
    }
}
