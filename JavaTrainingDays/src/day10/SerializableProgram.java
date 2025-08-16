package day10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}

public class SerializableProgram {
    public static void main(String[] args) {

    	Employee employee = new Employee();
    	employee.setId(101);
    	employee.setName("Amit Madeli");

        try {
            // Ensure the directory exists: "C:\\Users\\Gme\\Desktop\\Wipro\\File3.txt"
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Gme\\Desktop\\Wipro\\File3.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(employee);

            objectOut.close();
            fileOut.close();   

            System.out.println("Serialized data written to file.");
        } catch (IOException e) {
            System.out.println("Error during serialization:");
            e.printStackTrace();
        }
    }
}