import java.util.*;
import java.io.*;
class EmployeeDemo{
    public static void main(String[] args) throws Exception{
        int choice = -1;
        Scanner input =new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        File file = new File("employee.txt");
        ArrayList<Employee> empList =new ArrayList<Employee>();
        ObjectOutputStream oos= null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            empList = (ArrayList<Employee>)ois.readObject();
        }
        do{

          System.out.println("1-Insert");
          System.out.println("2-Display");
          System.out.println("3-Search");
          System.out.println("4-Delete");
          System.out.println("5-Update");
          System.out.println("6-Sort By Employee No - On Screen");
          System.out.println("0-Exit");
          System.out.print("Enter Your Choice : ");
          choice =input.nextInt();

          switch(choice){
              case 1:
                  System.out.println("How many employee do you want to add : ");
                  int n =input.nextInt();
                  for(int i =0; i<n; i++){
                      System.out.print("Enter Employee No: ");
                      int empno =input.nextInt();

                      System.out.print("Enter Employee Firstname: ");
                      String fname = s.nextLine();

                      System.out.print("Enter Employee Lastname: ");
                      String lname = s.nextLine();

                      System.out.print("Enter Employee salary : ");
                      double salary =input.nextDouble();

                      empList.add(new Employee(empno,fname,lname,salary));
                   
                  }
                  oos =new ObjectOutputStream(new FileOutputStream(file));
                  oos.writeObject(empList);
                  oos.close();
              break; 
              case 2:
                   if(file.isFile()){
                       ois = new ObjectInputStream(new FileInputStream(file));
                       empList = (ArrayList<Employee>)ois.readObject();
                       ois.close();
                    
                       System.out.println("----------------------------------");
                       li = empList.listIterator();
                       while(li.hasNext())
                           System.out.println(li.next());
                       System.out.println("----------------------------------");
                  }else{
                      System.out.println("File does not exist....");
                  }
              break;  
              case 3:
                   if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        empList = (ArrayList<Employee>)ois.readObject();
                        ois.close();

                        boolean found =false;
                        System.out.println("Enter employee code to Search: ");
                        int empno = input .nextInt();
                        System.out.println("----------------------------------");
                        li = empList.listIterator();
                        while(li.hasNext()){
                            Employee e = (Employee)li.next();
                            if(e.empno == empno){
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if(!found)
                            System.out.println("Record Not Found!!!");
                         System.out.println("----------------------------------");
                   }else{
                       System.out.println("Sorry, File does not exist...");
                   }
              break; 
              case 4:
                   if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        empList = (ArrayList<Employee>)ois.readObject();
                        ois.close();

                        boolean found =false;
                        System.out.println("Enter employee code to Delete: ");
                        int empno = input .nextInt();
                        System.out.println("----------------------------------");
                        li = empList.listIterator();
                        while(li.hasNext()){
                            Employee e = (Employee)li.next();
                            if(e.empno == empno){
                                li.remove();
                                found = true;
                            }
                        }
                        if(found){
                            oos =new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(empList);
                            oos.close();
                            System.out.println("Record Deleted Sucessfully!!!");
                        }
                        else{
                            System.out.println("Record Not Found!!!");
                        }   
                        System.out.println("----------------------------------");
                   }else{
                       System.out.println("Sorry, File does not exist...");
                   }
              break; 
              case 5:
                   if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        empList = (ArrayList<Employee>)ois.readObject();
                        ois.close();

                        boolean found =false;
                        System.out.println("Enter employee code to Update: ");
                        int empno = input .nextInt();
                        System.out.println("----------------------------------");
                        li = empList.listIterator();
                        while(li.hasNext()){
                            Employee e = (Employee)li.next();
                            if(e.empno == empno){
                                System.out.println("Enter New Employee Firstname : ");
                                String fname = s.nextLine();

                                System.out.println("Enter New Employee Lastname : ");
                                String lname = s.nextLine();

                                System.out.println("Enter new Salary : ");
                                int sal = input.nextInt();
                                li.set(new Employee(empno,fname,lname,sal));
                                found = true;
                            }
                        }
                        if(found){
                            oos =new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(empList);
                            oos.close();
                            System.out.println("Employee Record Updated Sucessfully!!!");
                        }
                        else{
                            System.out.println("Record Not Found!!!");
                        }   
                        System.out.println("----------------------------------");
                   }else{
                       System.out.println("Sorry, File does not exist...");
                   }
              break; 
              case 6:
                   if(file.isFile()){
                       ois = new ObjectInputStream(new FileInputStream(file));
                       empList = (ArrayList<Employee>)ois.readObject();
                       ois.close();
                       
                       Collections.sort(empList,new Comparator<Employee>(){
                           public int compare(Employee emp, Employee emp2){
                               return emp.empno - emp2.empno;
                           }
                       });

                       System.out.println("----------------------------------");
                       li = empList.listIterator();
                       while(li.hasNext())
                           System.out.println(li.next());
                       System.out.println("----------------------------------");
                  }else{
                      System.out.println("File does not exist....");
                  }
              break;
          }
        }while(choice !=0);
    }
}