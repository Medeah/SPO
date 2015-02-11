/**
 * Created by frederik on 2/3/15.
 */
public class Hello {

    public static void main(String[] args) {
        Node øv = new Times(new Plus(new Var(new Value("a")), new Var(new Value("n"))), new Int(new Value("1")));
        traverse(øv);
        System.out.println();

        for (String t : readString("a + n *  * fdf df 1")) {
            System.out.println(t);
        }

    }

    private static void traverse(Node root) {
        if (root instanceof BinaryOp) {
            traverse(((BinaryOp) root).Left);
            System.out.print(" " + root + " ");
            traverse(((BinaryOp) root).Right);
        } else if (root instanceof UnaryOp) {
            System.out.print(((UnaryOp) root).Child + " " + root);
        } else if (root instanceof Value) {
            System.out.print(((Value) root).val);
        } else {
            System.out.println("kno");
        }
    }

    private static String[] readString (String inp) {
        return inp.split("\\s+");
    }
}