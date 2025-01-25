// Private Inheriatance in JAVA

public class PrivateInheritance {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }

    private static class Parent {
        private void display() {
            System.out.println("Parent Display");
        }
    }

    private static class Child extends Parent {
        void display() {
            super.display();
            System.out.println("Child Display");
        }
    }
}
