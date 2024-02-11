// Access Modifiers - public, private, protected, default
// public - accessible from anywhere - all classes and packages
// private - accessible only within the class - same class
// protected - accessible within the package and outside the package through inheritance
// default - accessible only within the package - same package

public class AccessModifiers {

    public static class Student {
        public String name; // all classes and packages
        private int rollno; // same class
        protected double percent; // same package and outside the package through inheritance
        char grade; // same package

    }

    public static void main(String[] args) {

        Student s1 = new Student(); // Creating an object
        s1.name = "Deepak";
        s1.rollno = 223100;
        s1.percent = 95.5;
        s1.grade = 'A';

        Employee e1 = new Employee();
        e1.name = "Deepak";
        e1.id = 1001;
        e1.salary = 100000;
        // e1.age = 20; // Error: age has private access in Employee

        // Getter and Setter - Used to access private attributes
        // System.out.println(e1.getAge()); // 0 - default value
        e1.setAge(20);
        System.out.println(e1.getAge()); // 20


    }
}
