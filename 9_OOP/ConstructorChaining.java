// Constructor Chaining is the process of calling one constructor from another constructor with respect to current object.

public class ConstructorChaining {
    public static void main(String[] args) {
        new Child();
    }
}

class Parent {
    Parent() {
        System.out.println("Parent class constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child class constructor");
    }
}