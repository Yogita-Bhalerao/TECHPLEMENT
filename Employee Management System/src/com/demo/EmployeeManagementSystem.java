package com.demo;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeManagementSystem 
{
    private static final String FILE_PATH = "employees.txt";

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                	deleteEmployee();
                	break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addEmployee() 
    {
        try 
        {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee designation: ");
            String designation = scanner.nextLine();
            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(id, name, designation, salary);
            printWriter.println(employee.getId() + "," + employee.getName() + "," + employee.getDesignation() + "," + employee.getSalary());

            printWriter.close();
            System.out.println("Employee added successfully!");
        } 
        catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void viewEmployees() 
    {
        try 
        {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String designation = parts[2];
                double salary = Double.parseDouble(parts[3]);
                Employee employee = new Employee(id, name, designation, salary);
                System.out.println(employee);
            }

            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void updateEmployee()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter employee ID to update: ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine(); 

            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
               
                if (id == idToUpdate) 
                {
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new designation: ");
                    String newDesignation = scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();

                    writer.write(id + "," + newName + "," + newDesignation + "," + newSalary);
                    writer.newLine();
                    found = true;
                } 
                
                else 
                {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();

            if (!found) 
            {
                System.out.println("Employee not found with ID: " + idToUpdate);
                return;
            }

            if (!inputFile.delete()) 
            {
                System.out.println("Could not delete original file");
                return;
            }
            if (!tempFile.renameTo(inputFile)) 
            {
                System.out.println("Could not rename temporary file");
            } 
            else 
            {
                System.out.println("Employee updated successfully!");
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void searchEmployee() 
    {
        try 
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter employee ID to search: ");
            int idToSearch = scanner.nextInt();
            scanner.nextLine(); 

            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                if (id == idToSearch) 
                {

                	String name = parts[1];
                    String designation = parts[2];
                    double salary = Double.parseDouble(parts[3]);
                    System.out.println("Employee found:");
                    System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary);
                    found = true;
                    break;
                }
            }
            reader.close();

            if (!found) 
            {
                System.out.println("Employee not found with ID: " + idToSearch);
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void deleteEmployee() 
    {
        try 
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter employee ID to delete: ");
            int idToDelete = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                
                if (id == idToDelete) 
                {
                    found = true;
                }
                else 
                {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();

            if (!found) 
            {
                System.out.println("Employee not found with ID: " + idToDelete);
               
                if (!tempFile.delete()) 
                {
                    System.out.println("Error: Could not delete temporary file");
                }
                return;
            }

            if (!inputFile.delete())
            {
                System.out.println("Error: Could not delete original file");
                return;
            }
            if (!tempFile.renameTo(inputFile))
            {
                System.out.println("Error: Could not rename temporary file");
            } else {
                System.out.println("Employee deleted successfully!");
            }
        } catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    }