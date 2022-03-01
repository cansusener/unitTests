import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ParametreTest {

    private HesapMakinesi hesapMakinesi = new HesapMakinesi();

    @Test
    //vermek istediğimiz parametreler
    @Parameters({"10,2,20", "10,5,50"})
    public void testMetreKareHesapla(int en, int boy, int toplamMetreKare) throws Exception {
        //assertEquals(20,hesapMakinesi.metreKareHesapla(10,2));
        //assertEquals(50,hesapMakinesi.metreKareHesapla(10,5));
        assertEquals(toplamMetreKare, hesapMakinesi.metreKareHesapla(en, boy));

    } //burada bi sorun oldu
}
