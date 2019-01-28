import org.junit.Test;

import static org.junit.Assert.*;

public class StringComparisonTest {

    @Test
    public void compareReturnsCorrectValue() {

        int value1 = StringComparison.compare("aAa", "AAa");

        assertEquals(0, value1);

        int value2 = StringComparison.compare("zAz", "zAa");

        assertEquals(2, value2);

        int value3 = StringComparison.compare("aBcDeF", "FeDcBa");

        assertEquals(1, value3);


    }
}