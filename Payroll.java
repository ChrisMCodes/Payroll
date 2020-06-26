/**
 * Latest update: 2020-06-23
 * 
 * Purpose: Uses hard-coded data to calculate gross regular, overtime, and total pay for employees.
 * One array stores Employee IDs, another stores payroll data.
 * 
 */
public class Payroll {
  
  
  public static void main(String[] args) { 
    
    int employees[] = new int[6];
    double payroll[][] = new double[6][5];
    
    getID(employees); // populates employees with hardcoded employee IDs
    getPayroll(payroll); // harcoded hours worked and pay rates
    getPay(payroll); // calculates gross pay
    
    displayResults(employees, payroll); // displays results

  }
  
  /**
   * Method to populate employee IDs
   * */
  public static void getID(int[] employees) {
    
    // using employee IDs 100 - 600
    for (int i = 1; i <= employees.length; i++) {
      employees[i - 1] = i * 100;
    }
  }
  
  /**
   * Method to populate hours worked and payrates
   * */
  public static void getPayroll(double[][] payroll) {
    
    // initializing hardcoded data
    double hours[] = {50, 15, 48, 40, 40, 45};
    double rates[] = {25, 15, 27, 25, 23, 10}; 
  
    for (int i = 0; i < payroll.length; i++) {
      int j = 0;
      payroll[i][j] = hours[i];
      j++;
      payroll[i][j] = rates[i];
    }
  }
  
  /**
   * Loops through payroll array to calculate gross regular pay,
   * gross overtime pay (over 40 = 1.5*rate),
   * and total pay (regular + gross).
   * */
  public static void getPay(double[][] payroll) {
    
    // calculates gross regular and gross overtime pay
    for (int i = 0; i < payroll.length; i++) {
      double hours = payroll[i][0];
      double rate = payroll[i][1];
      double ft = 40; // used to calculate full time/overtime
      double ot = 1.5; // used to calculate overtime
      
      if (hours <= ft) {
        payroll[i][2] = hours * rate; // regular
        payroll[i][3] = 0; // overtime
        
      } else { // worked over 40 hours
        
        payroll[i][2] = ft * rate; // regular
        payroll[i][3] = (hours - ft) * rate * ot; //overtime
      
      }
      
    // calculates total pay
      payroll[i][4] = payroll[i][2] + payroll[i][3];
    }
  }
  
  /**
   * displays results
   * */
  public static void displayResults(int[] employees, double[][] payroll) {
    
    String header1 = "Employee      Hours        Pay        Regular       Overtime      Total";
    String header2 = "ID            Worked       Rate       Gross Pay     Gross Pay   Gross Pay";
    
    // prints headers
    System.out.println(header1);
    System.out.println(header2);
    System.out.println();
    
    for (int i = 0; i < employees.length; i++) {
      
      // prints employee id
      
      System.out.printf("%d   ", employees[i]);
      
      for (int j = 0; j < 5; j++) {
        
        // prints payroll array info
        
        System.out.printf("%13.2f", payroll[i][j]);
        
        if (j == 4) {
          
          System.out.println("\n");
        
        }
      
      }
    }
  
  }
}
