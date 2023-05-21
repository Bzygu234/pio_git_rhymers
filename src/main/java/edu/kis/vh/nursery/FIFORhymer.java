package edu.kis.vh.nursery;

/**
 * Klasa FIFORhymer rozszerza klasę DefaultCountingOutRhymer i implementuje logikę
 * wyjmowania elementów z Rhymera w kolejności FIFO
 *
 * Zawiera atrybut temp typu DefaultCountingOutRhymer będący tymczasowym pomocniczym Rhymerem
 *
 * Zawiera metodę countOut
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Metoda countOut nie przyjmuje żadnych argumentów oraz zwraca wartość usuniętą z Rhymera w kolejności FIFO
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
