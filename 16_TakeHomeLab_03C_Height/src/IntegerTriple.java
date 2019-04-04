import java.util.Comparator;

public class IntegerTriple implements Comparable<IntegerTriple> {
    Integer x, y, weight;


    public IntegerTriple(Integer x, Integer y, Integer weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(IntegerTriple o) {
        return Comparator.comparing(IntegerTriple::getX)
                .thenComparing(IntegerTriple::getY)
                .thenComparing(IntegerTriple::getWeight)
                .compare(this, o);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getWeight() {
        return weight;
    }


}
