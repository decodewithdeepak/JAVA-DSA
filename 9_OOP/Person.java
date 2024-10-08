// Aggregation -In aggregation, the contained objects can exist independently.

// ✽ A weaker form of association where one class is a part of another class, but both can exist independently. 
// ✽ Relationship where the child can exist independently of the parent.
// ✽ Represents a "Has-A" relationship with shared ownership.
// ✽ Unidirectional association.


// Aggregation Example: Person has an Address
// Person has an Address, but the address can exist independently.

class Address { // Contained class
    String city;
    
    Address(String city) {
        this.city = city;
    }
}

class Person { // Container class
    String name;
    Address address; // Aggregation
    
    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    void showDetails() {
        System.out.println(name + " lives in " + address.city);
    }

    public static void main(String[] args) {
        Address addr = new Address("Gurgaon");
        Person prsn = new Person("Deepak", addr);
        prsn.showDetails(); // Output: Deepak lives in Gurgaon
    }
}
