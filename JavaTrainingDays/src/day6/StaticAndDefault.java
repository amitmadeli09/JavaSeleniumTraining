package day6;

interface MyInterface {
    
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }

   
    default void defaultMethod() {
        System.out.println("This is a default method in the interface.");
    }

    
    void normalVoidMethod();  // public abstract method in interfaces
}

class MyClass implements MyInterface {

    
    public void normalVoidMethod() {
        System.out.println("This is the normal void method implemented in the class.");
    }

  
    public void classVoidMethod() {
        System.out.println("This is another void method inside the class.");
    }
}

public class StaticAndDefault {
    public static void main(String[] args) {
        
        MyInterface.staticMethod();

        MyClass obj = new MyClass(); //initialize object
 
        obj.defaultMethod();   //calling default method by taking parent properties
 
      //calling methods of that specific class
        obj.normalVoidMethod(); 

        obj.classVoidMethod();
    }
}