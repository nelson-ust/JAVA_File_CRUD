import java.io.*;
public class Employee implements Serializable{
        int empno;
        String fname;
        String lname;
        double salary;
        Employee(int empno, String fname,String lname , double salary){
            this.empno = empno;
            this.fname =fname;
            this.lname = lname;
            this.salary = salary;
        }
        public String toString(){
            return empno+" "+fname+" "+lname+" "+salary;
        }
            
}

