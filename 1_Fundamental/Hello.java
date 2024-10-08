// Notes 1: https://drive.google.com/file/d/165DVKf9e_tu2fTBXUnqO9tVb-nc0IVNY/view

public class Hello {
    //Everything in java is inside a class (except package)
    // public - access modifier (public, private, protected)
    // class - keyword used to create a class
    // Hello - name of the class
    public static void main(String[] args) {
        // public - access modifier
        // static - keyword used to create static method - method can be called without creating an object of the class
        // void - return type of the method
        // main - entry point of the program
        // String[] args - command line arguments - array of strings - args is the name of the array

        System.out.println("Hello World!");

        // System - class in java.lang package
        // out - object of PrintStream class
        // println - method of PrintStream class

        // Command to compile the code - javac Hello.java - Compiles the code and generates Hello.class file (bytecode) - javac is the java compiler
        // Command to run the code - java Hello - Runs the bytecode using JVM (Java Virtual Machine) - java is the java interpreter
    }

}