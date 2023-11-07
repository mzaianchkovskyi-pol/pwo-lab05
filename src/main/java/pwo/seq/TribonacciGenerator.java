package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {
    public TribonacciGenerator() {
        super(); // Wywołaj konstruktor nadklasy
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public BigDecimal nextTerm() {
        // Wprowadź zmienną do śledzenia kierunku generowania
        boolean generateForward = true;

        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
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
                // Generuj wstecz
                current = f_3;
                f_1 = f_2;
                f_2 = f_3.subtract(f_1).subtract(f_2);
                f_3 = current;
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
