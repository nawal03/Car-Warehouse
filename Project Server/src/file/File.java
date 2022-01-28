package file;
import serializable.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class File <ClassName>{
    private String inputFileName;
    private String outputFileName;

    public File(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }
    public void read(List<ClassName> list){
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            while (true) {
                line = br.readLine();
                if (line == null) break;
                String [] strings= line.split(",");
                if(inputFileName.equals("src//file//cars.txt")){
                    Car car= new Car(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],strings[8],strings[9]);
                    list.add((ClassName) car);
                }
                else if(inputFileName.equals("src//file//manufacturers.txt")){
                    Manufacturer manufacturer= new Manufacturer(strings[0],strings[1]);
                    list.add((ClassName) manufacturer);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void write(List<ClassName> list){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
            for(ClassName className: list){
                bw.write(className.toString()+'\n');
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
