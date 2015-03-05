package com.company;

/**
 * Created by frederik on 3/5/15.
 */
public class OperatorNode extends Node {
    private Operator _o;
    public Operator o () {
        return _o;
    }
    public OperatorNode(Operator o) {
        _o = o;
    }
}
