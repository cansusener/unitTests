package lifecycle;

import org.junit.Ignore;
import org.junit.Test;


@Ignore // tüm class i yok sayar
public class IgnoreTest {
//JUnit içindeki bir testi veya test methodunu kullanmak istemediğimizde silmemize
// veya comment yapmamıza gerek yok.
// JUnit içindeki ignore annotation’unu kullanarak test sınıfı veya methodunu “yok saymasını” sağlayabiliriz.


    @Test
    public void testHello() throws Exception{
        System.out.println("hello");
    }

    @Test
    @Ignore("bu test edilmeyecek!")
    public void testHello2() throws Exception{
        System.out.println("hello 2");
    }

    // tüm class’ı yok sayabilmek için @Ignore annotation’unu class tanımından önce yazıyoruz
}
