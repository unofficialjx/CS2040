public abstract class AbstractSequence {
    long firstNumber;
    long ratio;
    int size;
    long[] sequence;


    public AbstractSequence(int size, long firstNumber, long ratio) {
        this.size = size;
        this.firstNumber = firstNumber;
        this.ratio = ratio;
        this.sequence = new long[this.size];
        this.sequence[0] = this.firstNumber;
    }

    abstract void calculateAndAppendToSequenceArray(int term);

    public void printSequence() {
        for (int i = 0; i < sequence.length - 1; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println(sequence[sequence.length - 1]);
    }
}
