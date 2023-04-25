package org.yum;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Bedtime {
    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter the name of the file you would like to read.");
            String name = scan.nextLine();
            FileInputStream myObj = new FileInputStream(name);
            Scanner myReader = new Scanner(myObj);
            int i = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
               // if(data.isBlank()){
               // System.out.print("");
              //  }
               // else if(!data.isBlank()) {
                    System.out.println(i + " " + data);
                    i++;
               // }
            }
            myReader.close();
        }
        catch(Exception e){
            e.getMessage();
            }




    }
}