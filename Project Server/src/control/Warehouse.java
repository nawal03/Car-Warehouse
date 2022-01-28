package control;

import file.File;
import serializable.Car;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static List<Car> cars;

    static {
        cars= new ArrayList<>();
        File<Car> file= new File<>("src//file//cars.txt","src//file//cars.txt");
        file.read(cars);
    }

    synchronized public static List<Car> getCars(String regNum, String carMake, String carModel){
        List<Car> cars1= new ArrayList<>();
        for(Car car: cars){
            if((regNum.equals("") || car.getRegNum().equalsIgnoreCase(regNum))
                    && (carMake.equals("") || car.getCarMake().equalsIgnoreCase(carMake))
                    && (carModel.equals("") || car.getCarModel().equalsIgnoreCase(carModel))){
                cars1.add(car);
            }
        }
        return cars1;
    }

    synchronized public static boolean addCar(Car car){
        if(!car.isValid()) return false;
        for(Car car1 : cars){
            if(car1.getRegNum().equalsIgnoreCase(car.getRegNum())){
                return false;
            }
        }
        cars.add(car);
        return true;
    }

    synchronized public static boolean deleteCar(Car car){
        for(Car car1 : cars){
            if(car1.getRegNum().equalsIgnoreCase(car.getRegNum())){
                cars.remove(car1);
                return true;
            }
        }
        return false;
    }

    synchronized public static boolean editCar(Car car) {
        if(!car.isValid()) return false;
        for (Car car1 : cars){
            if(car1.getRegNum().equalsIgnoreCase(car.getRegNum())){
                car1.setCarMake(car.getCarMake());
                car1.setCarModel(car.getCarModel());
                car1.setColor1(car.getColor1());
                car1.setColor2(car.getColor2());
                car1.setColor3(car.getColor3());
                car1.setYearMade(car.getYearMade());
                car1.setPrice(car.getPrice());
                car1.setQuantity(car.getQuantity());
                car1.setCarImage(car.getCarImage());
                return true;
            }
        }
        return false;
    }

    synchronized public static boolean buyCar(Car car){
        for(Car car1: cars){
            if(car1.getRegNum().equalsIgnoreCase(car.getRegNum()) && Integer.parseInt(car1.getQuantity())>0){
                int newQuantity= Integer.parseInt(car1.getQuantity());
                newQuantity--;
                car1.setQuantity(Integer.toString(newQuantity));
                return true;
            }
        }
        return false;
    }
}
