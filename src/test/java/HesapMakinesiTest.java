import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HesapMakinesiTest {

    @Test
    public void testTopla() {
        HesapMakinesi hesapMakinesi = new HesapMakinesi();
        int sayi1 = 5;
        int sayi2 = 19;

        int toplam = hesapMakinesi.topla(sayi1, sayi2);

        assertEquals(24, toplam);
    }

    @Test
    public void testCikart() {
        HesapMakinesi hesapMakinesi = new HesapMakinesi();

        assertEquals(14, (hesapMakinesi.cikart(14, 0)));
    }
}
