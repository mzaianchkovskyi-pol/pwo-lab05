package pwo.seq;

import java.math.BigDecimal;

public class FibonacciGenerator extends Generator {
    private boolean generateForward = true;

    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
        generateForward = true; // Reset the direction to forward
    }

    @Override
    public BigDecimal nextTerm() {
        if (generateForward) {
            if (lastIndex > 1) {
                current = f_1.add(f_2);
                f_2 = f_1;
                f_1 = current;
            } else if (lastIndex == 1) {
                current = new BigDecimal(1);
            } else {
                current = new BigDecimal(0);
            }

            lastIndex++;

            // Check if we should switch to generating backward
            if (lastIndex > 100) {
                generateForward = false;
            }
        } else {
            // Generate backward (from 100 to 0)
            if (lastIndex < 99) {
                current = f_1.subtract(f_2);
                f_1 = f_2;
                f_2 = current;
            } else if (lastIndex == 99) {
                current = new BigDecimal(1);
            } else {
                current = new BigDecimal(0);
            }

            lastIndex--;
        }

        return current;
    }
}