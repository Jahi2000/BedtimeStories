package org.yum;

import java.io.BufferedReader;
import java.io.FileReader;

public class Employee {

    private String employeeId;
    private String name;
    private String hoursWorked;
    private String payRate;

    Employee(String employeeId, String name, String hoursWorked, String payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate =payRate;
    }

    public Double getGrossPay(){

        return Double.parseDouble(this.payRate) * Double.parseDouble(this.hoursWorked);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(String hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public static void main(String [] args){

        try {
            FileReader theFileWeWantToWorkWith = new FileReader("employees.csv");
            BufferedReader theFileFromTheHDD = new BufferedReader(theFileWeWantToWorkWith);

            //Read the first line to throw it away because its the header row that describes the columns
            theFileFromTheHDD.readLine();

            String theLine;

            // while there are lines in the file we have not processed keep looping over the lines in the file
            while ( ( theLine = theFileFromTheHDD.readLine() ) != null  ) {

                String[] linePieces = theLine.split("\\|");
                Employee T = new Employee(linePieces[0],linePieces[1],linePieces[2],linePieces[3]);

                System.out.printf("id: %s - name: %s - pay rate: $%.2f\n",  T.getEmployeeId(),T.getName() , T.getGrossPay());


            }
            theFileFromTheHDD.close();
        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
