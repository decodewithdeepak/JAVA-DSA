// Aggregation -

// ✽ Aggregation is a relationship where one class (container) contains references to another class (contained) and the contained class can exist independently of the container class.
// ✽ This indicates a weaker form of association between the classes.
// ✽ Represents a "Has-A" relationship with shared ownership.
// ✽ Unidirectional association.


// Aggregation Example: Person has an Address
// Person class has an Address, but the Address can exist independently of the Person.

class Address { // Contained class OR Component class
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
