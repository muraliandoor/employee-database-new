/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGUI;

/**
 *
 * @author Bilaal
 */
public class PartTimeEmployee extends EmployeeInfo {

    //PTE specific attributes
    private double wage; //double storing value of wage
    private int numHours; //int storing number of hours worked per week
    private int numWeeks; //int storing number of weeks worked per year

    public PartTimeEmployee() {
        super();
        wage = 0;
        numHours = 0;
        numWeeks = 0;
    }

    public PartTimeEmployee(int eNum, String fN, String lN, int sex, int workLocation, double wage, double deductionsRate, int numHours, int numWeeks) {
        super(eNum, fN, lN, sex, workLocation, deductionsRate);
        this.wage = wage;
        this.numHours = numHours;
        this.numWeeks = numWeeks;
    }

    //getter and setter for hours per week
    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    //getter and setter for weeks per year
    public int getNumWeeks() {
        return numWeeks;
    }

    public void setNumWeeks(int numWeeks) {
        this.numWeeks = numWeeks;
    }

    public double calcAnnualIncome() {
        return wage * numHours * numWeeks;
    }

    public double calcNetAnnualIncome() {
        return wage * numHours * numWeeks * (1 - deductionsRate);
    }
}
