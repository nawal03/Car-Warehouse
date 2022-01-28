package network;

import control.AdminPanel;
import control.Warehouse;
import file.File;
import serializable.Car;
import serializable.Manufacturer;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable{
    private Thread thread;
    private String clientCount;
    private NetworkUtil networkUtil;
    private File<Car> carFile= new File<>("src//file//cars.txt","src//file//cars.txt");
    private File<Manufacturer> manufacturerFile= new File<>("src//file//manufacturers.txt","src//file//manufacturers.txt");
    public ClientHandler(Socket socket, String clientCount){
        this.networkUtil = new NetworkUtil(socket);
        this.clientCount=clientCount;
        this.thread= new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while (true){
            String command = null;
            command= (String) networkUtil.read();
            if(command==null) {
                networkUtil.closeConnection();
                List<ClientHandler> clients= Server.getClients();
                clients.remove(this);
                break;
            }
            else if(command.equals("login admin")){
                String admin= (String) networkUtil.read();
                String password=(String) networkUtil.read();
                if(admin.equalsIgnoreCase("admin") && password.equals("123")) networkUtil.write(true);
                else networkUtil.write(false);

            }
            else if(command.equals("get manufacturers")){
                networkUtil.write(AdminPanel.getManufacturers());
            }
            else if(command.equals("get users")){
                List<String> users= new ArrayList<>();
                List<ClientHandler> clients= Server.getClients();
                for(ClientHandler clientHandler: clients) users.add(clientHandler.toString());
                networkUtil.write(users);
            }
            else if(command.equals("add manufacturer")) {
                Manufacturer manufacturer= (Manufacturer) networkUtil.read();
                networkUtil.write(AdminPanel.addManufacturer(manufacturer));
            }
            else if(command.equals("delete manufacturer")){
                Manufacturer manufacturer= (Manufacturer) networkUtil.read();
                networkUtil.write(AdminPanel.deleteManufacturer(manufacturer));
            }
            else if(command.equals("login manufacturer")){
                Manufacturer manufacturer=  (Manufacturer) networkUtil.read();
                networkUtil.write(AdminPanel.approveManufacturerLogin(manufacturer));
            }
            else if(command.equals("get cars")){
                String regNum= (String) networkUtil.read();
                String carMake= (String) networkUtil.read();
                String carModel= (String) networkUtil.read();
                List<Car> carList = Warehouse.getCars(regNum,carMake,carModel);
                networkUtil.write(carList);
            }
            else if(command.equals("add car")){
                Car car= (Car) networkUtil.read();
                networkUtil.write(Warehouse.addCar(car));
            }
            else if(command.equals("delete car")){
                Car car= (Car) networkUtil.read();
                networkUtil.write(Warehouse.deleteCar(car));
            }
            else if(command.equals("edit car")){
                Car car= (Car) networkUtil.read();
                networkUtil.write(Warehouse.editCar(car));
            }
            else if(command.equals("buy car")){
                Car car= (Car) networkUtil.read();
                networkUtil.write(Warehouse.buyCar(car));
            }

            carFile.write(Warehouse.getCars("","",""));
            manufacturerFile.write(AdminPanel.getManufacturers());

        }

    }

    @Override
    public String toString() {
        return "Client : "+this.clientCount;
    }
}
