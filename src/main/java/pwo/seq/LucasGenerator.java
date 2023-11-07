package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {
    public LucasGenerator() {
        super(); // Wywołaj konstruktor nadklasy
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }

        // Wprowadź zmienne do śledzenia kierunku generowania
        boolean generateForward = true;

        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(2);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;

        // Jeśli osiągnięto maksymalny indeks, zmień kierunek na generowanie wstecz
        if (lastIndex > 100) {
            generateForward = false;
        }

        if (!generateForward) {
            if (lastIndex < 99) {
                current = f_1.subtract(f_2);
                f_1 = f_2;
                f_2 = current;
            } else if (lastIndex == 99) {
                current = new BigDecimal(2);
            } else {
                current = new BigDecimal(0);
            }

            lastIndex--;
        }

        return current;
    }
}
