package com.company;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, NullPointerException {
        // write your code here
        ArrayList<String>files = new ArrayList<>();
        File folder = new File(args[0]);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".mp3")) {
               files.add(file.getPath());
            }
        }

        File f = new File(args[0] + "track.mp3");
        FileOutputStream fos = new FileOutputStream(f);
        for (String x:files){
            FileInputStream fis = new FileInputStream(x);
            byte[] bytes =new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fis.close();
        }
        fos.close();

    }

}
