public class Employee {
    String name;
    int id;
    double salary;
    private int age;

    public void details() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    // Getter and Setter
    public int getAge() { // Getter
        return age;
    }

    // public void setAge(int a) { // Setter
    //     age = a;
    // }
    
    // this Keyword
    public void setAge(int age) { // Setter
        this.age = age;
        // this keyword is used to refer to the current object
        // used to differentiate between class instance variable and method parameter
    }

    public void change() {
        salary = 100000;
    }
}
