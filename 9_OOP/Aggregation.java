// Aggregation -In aggregation, the contained objects can exist independently.

// ✽ A weaker form of association where one class is a part of another class, but both can exist independently. 
// ✽ Relationship where the child can exist independently of the parent.
// ✽ Represents a "Has-A" relationship with shared ownership.
// ✽ Unidirectional association.


// Aggregation Example: Person has an Address
// Person has an Address, but the address can exist independently.

public class Aggregation {
    public static void main(String[] args) {
        Address addr = new Address("New York");
        Person prsn = new Person("John", addr);
        prsn.showDetails(); // Output: John lives in New York
    }
}