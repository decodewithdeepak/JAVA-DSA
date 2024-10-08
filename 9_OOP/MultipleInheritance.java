// Multiple inheritance in JAVA-
// ✽ Multiple inheritance is a feature in which a class can inherit properties of more than one class.
// ✽ JAVA does not support multiple inheritance with classes due to the Diamond Problem.
// ✽ However, multiple inheritance can be achieved using interfaces.
// ✽ A class can implement multiple interfaces.

public class MultipleInheritance {
    interface Animal {
        void eat(); // abstract methods
        void sleep();
    }

    interface Mammal {
        void run();
    }

    static class Dog implements Animal, Mammal {
        @Override // -> optional but recommended
        public void eat() {
            System.out.println("Dog is eating");
        }

        @Override
        public void sleep() {
            System.out.println("Dog is sleeping");
        }

        @Override
        public void run() {
            System.out.println("Dog is running");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sleep();
        d.run();
    }
}
