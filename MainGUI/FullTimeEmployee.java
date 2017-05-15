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
public class FullTimeEmployee extends EmployeeInfo {

    public FullTimeEmployee() {
        this.yearlySalary = 0;
    }
    private double yearlySalary;            
    public FullTimeEmployee(int eNum, String fN, String lN, int sex, int workLocation, double deductionsRate, double yearlySalary) {
        super(eNum, fN, lN, sex, workLocation, deductionsRate);
        this.yearlySalary = yearlySalary;
    }

	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	
	public double calcNetAnnualIncome (){
		return yearlySalary * (1 - deductionsRate);
	}
}
