public class Methods {
    public static void main(String[] args){

        // leason 15 , how to call a method

        hello(); // calling a method

        // leason 16 , method with parameter
        sayHello("Igo");
        

    }

    // leason 14 -  create a method

    static void hello(){
        System.out.println("Hello World!.");
    }

    // leason 16 - Method with parameter
    static void sayHello(String name){
        System.out.println("Hello " + name + " is great have you here");
    }

    // leason 17 - Method with multi parameters

    static void newPeople(String name, int age){
        System.out.println("The " + name + " got " + age + " years old");
    }
}
