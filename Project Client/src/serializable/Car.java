package serializable;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    @Serial
    private final long SERIAL_IUD=1000000000;

    private String regNum;
    private String carMake;
    private String carModel;
    private String color1,color2,color3;
    private String yearMade;
    private String price;
    private String quantity;
    private CarImage carImage;

    public Car(String regNum, String carMake, String carModel, String color1, String color2, String color3, String yearMade, String price, String quantity, String imageDirectory) {
        this.regNum = regNum;
        this.carMake = carMake;
        this.carModel = carModel;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.yearMade = yearMade;
        this.price = price;
        this.quantity = quantity;
        this.carImage= new CarImage(imageDirectory);
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getYearMade() {
        return yearMade;
    }

    public void setYearMade(String yearMade) {
        this.yearMade = yearMade;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public CarImage getCarImage() {
        return carImage;
    }

    public void setCarImage(CarImage carImage) {
        this.carImage = carImage;
    }

    public boolean isValid(){

        if(this.regNum.isEmpty() || this.carMake.isEmpty() || this.carModel.isEmpty() || this.yearMade.isEmpty()|| this.price.isEmpty() || this.quantity.isEmpty() || this.carImage.getImageDirectory().isEmpty())
            return false;

        try{
            int yearMade=Integer.parseInt(this.yearMade);
            int price=Integer.parseInt(this.price);
            int quantity=Integer.parseInt(this.quantity);
            if( (yearMade <0 || yearMade>2020) || price<0 || quantity<0) throw new NumberFormatException();
        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return this.regNum+","
                +this.carMake+","
                +this.carModel+","
                +this.color1+","
                +this.color2+","
                +this.color3+","
                +this.yearMade+","
                +this.price+","
                +this.quantity+","
                +this.carImage.getImageDirectory();
    }
}
