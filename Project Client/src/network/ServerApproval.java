package network;

import javafx.collections.ObservableList;
import serializable.Car;
import serializable.Manufacturer;

import java.util.List;

public class ServerApproval {
    private static NetworkUtil networkUtil;

    static {

        networkUtil= new NetworkUtil("localhost",5454);

    }

    public static boolean approveManufacturerLogin(Manufacturer manufacturer){
        networkUtil.write("login manufacturer");
        networkUtil.write(manufacturer);
        return (Boolean) networkUtil.read();
    }

    public static void getCars(String regNum, String carMake, String carModel, ObservableList<Car> cars){
        networkUtil.write("get cars");
        networkUtil.write(regNum);
        networkUtil.write(carMake);
        networkUtil.write(carModel);
        cars.remove(0,cars.size());
        List<Car> carList= (List<Car>) networkUtil.read();
        cars.addAll(carList);

    }

    public static boolean addCar(Car car){
        networkUtil.write("add car");
        networkUtil.write(car);
        return (boolean) networkUtil.read();
    }

    public static boolean deleteCar(Car car){
        networkUtil.write("delete car");
        networkUtil.write(car);
        return (boolean) networkUtil.read();
    }

    public static boolean editCar(Car car){
        networkUtil.write("edit car");
        networkUtil.write(car);
        return (boolean) networkUtil.read();
    }

    public static boolean buyCar(Car car) {
        networkUtil.write("buy car");
        networkUtil.write(car);
        return (boolean) networkUtil.read();
    }

    public static boolean addManufacturer(Manufacturer manufacturer){
        networkUtil.write("add manufacturer");
        networkUtil.write(manufacturer);
        return (boolean) networkUtil.read();
    }

    public static boolean deleteManufacturer(Manufacturer manufacturer) {
        networkUtil.write("delete manufacturer");
        networkUtil.write(manufacturer);
        return (boolean) networkUtil.read();
    }

    public static void getManufacturers(ObservableList<Manufacturer> manufacturers){
        networkUtil.write("get manufacturers");
        manufacturers.remove(0,manufacturers.size());
        List<Manufacturer> manufacturerList= (List<Manufacturer>) networkUtil.read();
        manufacturers.addAll(manufacturerList);
    }

    public static void getUsers(ObservableList<String> users){
        networkUtil.write("get users");
        users.remove(0,users.size());
        List<String> userList= (List<String>) networkUtil.read();
        users.addAll(userList);
    }

    public static boolean approveAdminLogin(String username, String password) {
        networkUtil.write("login admin");
        networkUtil.write(username);
        networkUtil.write(password);
        return (boolean) networkUtil.read();
    }
}
