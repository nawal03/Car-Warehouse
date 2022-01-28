package serializable;

import java.io.*;

public class CarImage implements Serializable {
    @Serial
    private final long SERIAL_IUD=2000000000;

    private String imageDirectory;
    private byte [] byteArray;

    public CarImage(CarImage carImage){
        this.imageDirectory=carImage.imageDirectory;
        this.byteArray=carImage.byteArray;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.imageDirectory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            bos.write(this.byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public CarImage(String imageDirectory){
        this.imageDirectory=imageDirectory;
        File file= new File(imageDirectory);
        byteArray  = new byte [(int)file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        try {
            bis.read(byteArray,0,byteArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void restoreImage(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.imageDirectory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            bos.write(this.byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getImageDirectory() {
        restoreImage();
        return imageDirectory;
    }

}
