// Method chaining is a technique in which multiple methods are called in a single statement.

public class MethodChaining {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.setValue(10).incrementValue().displayValue(); // Method chaining
    }
}

class MyClass {
    private int value;

    public MyClass setValue(int value) {
        this.value = value;
        return this;
    }

    public MyClass incrementValue() {
        value++;
        return this;
    }

    public void displayValue() {
        System.out.println("Value: " + value);
    }
}