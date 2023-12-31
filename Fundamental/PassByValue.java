// Formal parameters(Parameters) - defined during function/method definition.
// Actual parameters(Arguments) - passed during the function/method call in other Function.

// Pass by value / Call by value - the copy of the actual parameter is passed to the formal parameter.
// Pass by reference / Call by reference - the copy of the address (reference) of the actual parameter is passed to the formal parameter.

// java is always pass by value 

public class PassByValue {

    static void change(int a) { // a is formal parameter
        a = a + 1; // 11
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println("Before change: " + a); // 10
        change(a); // a is actual parameter
        System.out.println("After change: " + a); // 10


    }

}
