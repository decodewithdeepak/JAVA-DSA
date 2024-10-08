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