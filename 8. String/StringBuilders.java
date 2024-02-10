// Problems with String - Immutability, Interning, Poor performance

// JAVA StringBuilder Class - Used to create mutable (modifiable) string
// Important constructors: StringBuilder(), StringBuilder(String str), StringBuilder(int capacity)

public class StringBuilders {
    public static void main(String[] args) {
        // StringBuilder str = new StringBuilder(); // empty string - default capacity is 16
        StringBuilder str = new StringBuilder("Hello");
        System.out.println(str); // Hello
        System.out.println(str.length()); // 5
        System.out.println(str.capacity()); // 21

        // Taking input from the user
        // StringBuilder str = new StringBuilder(sc.next()); // reads only one word
        // StringBuilder str = new StringBuilder(sc.nextLine()); // reads the whole line
        
        // setCharAt(idx, ch) method - replaces the character at the specified index
        str.setCharAt(2, 'y');
        System.out.println(str); // Heylo

        // append(ch) method - appends the specified character to the end
        str.append(" Decoders");
        System.out.println(str); // Heylo Decoders
        str.append(10);
        System.out.println(str); // Heylo Decoders10

        // insert(idx, ch) method - inserts the specified character at the specified index
        str.insert(14, ' ');
        System.out.println(str); // Heylo Decoders 10
        str.insert(14, " Welcome");
        System.out.println(str); // Heylo Decoders Welcome 10

        // deleteCharAt(idx) method - deletes the character at the specified index
        str.deleteCharAt(2);
        System.out.println(str); // Helo Decoders Welcome 10

        // delete(i, j) method - deletes the characters from index i to j-1
        str.delete(0, 5);
        System.out.println(str); // Decoders Welcome 10

        // reverse() method - reverses the string
        str.reverse();
        System.out.println(str); // 01 emocleW sredoced
        str.reverse();
        System.out.println(str); // Decoders Welcome 10

        // capacity() method - returns the size of the internal character array
        System.out.println(str.length()); // 19
        System.out.println(str.capacity()); // 44

        // toString() method - converts the StringBuilder to String
        String s = str.toString();
        System.out.println(s); // Decoders Welcome 10




    }

}
