/**
 * Created by frederik on 2/3/15.
 */
public class Value extends Node {
    String val;
    public Value(String in) {
        val = in;
    }

    @Override
    public String toString() {
        return '"' + val + '"';
    }
}
