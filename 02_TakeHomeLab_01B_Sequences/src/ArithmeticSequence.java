public class ArithmeticSequence extends AbstractSequence {

    public ArithmeticSequence(int size, long firstNumber, long ratio) {
        super(size, firstNumber, ratio);
    }

    @Override
    void calculateAndAppendToSequenceArray(int term) {
        int index = term - 1;
        if (index == 0) return;

        sequence[index] = sequence[index - 1] + ratio;
    }

}
