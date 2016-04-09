public abstract class Number {
    abstract void mathOp();

    void traverse(Number[] arr) {
        for (Number n : arr) {
            n.mathOp();
        }
    }
}
