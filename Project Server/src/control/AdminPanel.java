package control;

import file.File;
import serializable.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class AdminPanel {
    private static List<Manufacturer> manufacturers;

    static{
        manufacturers= new ArrayList<>();
        File<Manufacturer> file= new File("src//file//manufacturers.txt","src//file//manufacturers.txt");
        file.read(manufacturers);
    }

    synchronized public static List<Manufacturer> getManufacturers(){
        return manufacturers;
    }

    synchronized public static boolean addManufacturer(Manufacturer manufacturer){
        if(manufacturer.getUsername().isEmpty() || manufacturer.getPassword().isEmpty()) return false;
        for (Manufacturer manufacturer1: manufacturers){
            if(manufacturer1.getUsername().equalsIgnoreCase(manufacturer.getUsername())) return false;
        }
        manufacturers.add(manufacturer);
        return true;
    }

    synchronized public static boolean deleteManufacturer(Manufacturer manufacturer){
        for (Manufacturer manufacturer1 : manufacturers){
            if(manufacturer1.getUsername().equalsIgnoreCase(manufacturer.getUsername())){
                manufacturers.remove(manufacturer1);
                return true;
            }
        }
        return false;
    }

    synchronized public static boolean approveManufacturerLogin(Manufacturer manufacturer){
        for (Manufacturer manufacturer1: manufacturers){
            if(manufacturer1.getUsername().equalsIgnoreCase(manufacturer.getUsername()) && manufacturer1.getPassword().equals(manufacturer.getPassword())) return true;
        }
        return false;
    }

}
