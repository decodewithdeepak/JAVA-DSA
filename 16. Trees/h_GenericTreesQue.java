// 

import java.util.*;

public class h_GenericTreesQue {

    // Node class of a generic tree
    public static class Node {
        int data;
        ArrayList<Node> child;

        Node (int data) {
            this.data = data;
            child = new ArrayList<>();
        }
    }

}
