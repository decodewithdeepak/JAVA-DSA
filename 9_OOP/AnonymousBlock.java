// Anonymous block - Block inside a class without a name that is executed every time an object is created

public class AnonymousBlock {

    static class Student {
        String name;
        int rollno;
        double percent;

        // Anonymous block
        {
            System.out.println("Anonymous block");
        }

        Student(String name, int rollno, double percent) {
            this.name = name;
            this.rollno = rollno;
            this.percent = percent;
        }

    }

    public static void main(String[] args) {
        
        Student s1 = new Student("Deepak", 223100, 90.5);
        System.out.println(s1.name + " " + s1.rollno + " " + s1.percent);

        Student s2 = new Student("Divya", 223101, 95.5);
        System.out.println(s2.name + " " + s2.rollno + " " + s2.percent);
    }
    
}
