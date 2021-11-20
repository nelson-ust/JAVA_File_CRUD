import java.io.*;
public class Employee implements Serializable{
        int empno;
        String ename;
        int salary;
        Employee(int empno, String ename, int salary){
            this.empno = empno;
            this.ename =ename;
            this.salary = salary;
        }
        public String toString(){
            return empno+" "+ename+" "+salary;
        }
            
}

