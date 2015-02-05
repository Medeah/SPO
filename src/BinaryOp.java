/**
 * Created by frederik on 2/3/15.
 */
public class BinaryOp extends Node  {
    public Node Left;
    public Node Right;

    BinaryOp(Node left, Node right) {
        Left = left;
        Right = right;
    }
}
