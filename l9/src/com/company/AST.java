package com.company;

import java.util.Iterator;
import java.util.List;

/**
 * Created by frederik on 3/5/15.
 */
public class AST {
    static public Node makeNode() {
        return new Node();
    }
    static public Node makeNode(int n) {
        return new IntNode(n);
    }

    /*static public Node makeNode(Symbol s) {
        return new
    }*/

    static public OperatorNode makeNode(Operator o) {
        return new OperatorNode(o);
    }

    static void makeFamily (Operator op, Iterable<Node> kids) {
        Node par = makeNode(op);
        Iterator<Node> kidarator = kids.iterator();
        Node current = null;
        while (kidarator.hasNext()) {
            if (current == null) {
                current = kidarator.next();
            } else {
                Node next = kidarator.next();
                current.makeSibling(next);
                current = next;
            }
        }
        par.adoptChilderen(current);
    }
}
