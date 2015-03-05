package com.company;

/**
 * Created by frederik on 3/5/15.
 */
public class Node {

    private Node rightSib;
    private Node leftmostSib;
    private Node leftmostChild;
    private Node parent;

    public Node makeSibling(Node y) {
        if (y == null) {
            throw new NullPointerException();
        }
        Node xsibs = this;
        while (xsibs.rightSib != null) {
            xsibs = xsibs.rightSib;
        }

        Node ysibs = y.leftmostSib;

        xsibs.rightSib = ysibs;
        ysibs.leftmostSib = xsibs.leftmostSib;
        ysibs.parent = xsibs.parent;
        while (ysibs.rightSib != null) {
            ysibs = ysibs.rightSib;
            ysibs.leftmostSib = xsibs.leftmostSib;
            ysibs.parent = xsibs.parent;
        }
        return ysibs;
    }

    public void adoptChilderen(Node y) {
        if (this.leftmostChild != null) {
            this.leftmostChild.makeSibling(y);
        } else {
            Node ysibs = y.leftmostSib;
            this.leftmostChild = ysibs;
            while (ysibs != null) {
                ysibs.parent = this;
                ysibs = ysibs.rightSib;
            }
        }
    }
}
