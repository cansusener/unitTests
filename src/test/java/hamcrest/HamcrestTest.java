package hamcrest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.AdditionalMatchers.or;

public class HamcrestTest {

    @Test
    public void testHamcrest() {
        String text1 = "Merhaba";
        String text2 = "cansu";

        Assert.assertEquals("Merhaba", text1);

        Assert.assertThat(text1, is(equalTo("Merhaba")));
        Assert.assertThat(text1, sameInstance("Merhaba"));
        Assert.assertThat(text1, is(containsString("Me")));
        //anyof ile birden fazla karşılaştırma
        Assert.assertThat(text1, anyOf(containsString("haba"), containsString("xx")));

        // anyOf ile koşullardan biri bile doğru ise pass alır.

        /* assertThat() içinde ilk parametre olarak neyi test etmek istediğimizi yazıyoruz.
         İkinci parametre olarak eşleştirme methodumuzu verdik.
         Eşleştirmeyi yaparken is() içinde yapıyoruz
         fakat bu is() okumayı kolaylaştırmak içindir.
         Kullanılması zorunlu değildir.
         Ardından equalTo(“Merhaba”) yazıyoruz.
         Gördüğünüz üzere assertEquals ile aynı işi yaptı ve iki değeri eşleştirdi.
          Bu işi yaparken daha okunaklı olmasını sağladı.
          “Text is equal to merhaba” gibi bir okunabilir bir yapıya getirdi.*/
    }

    @Test
    public void testList() {
        List<String> cities = new ArrayList<String>(Arrays.asList("İstanbul", "Ankara", "Mersin"));
        Assert.assertThat(cities, hasItem("İstanbul"));
        Assert.assertThat(cities, hasItems("İstanbul", "Mersin"));

        //allOf() ise “and(ve)” ile içindeki item’ları bağlar. İçindeki item’lardan herhangi biri yanlış olursa test başarısız olur
        Assert.assertThat(cities, allOf(hasItems("İstanbul", "Mersin"), not(hasItem("Hatay"))));
        //Assert.assertThat(cities, either(hasItems("İstanbul","Mersin"), or(hasItem("Hatay"))));
    }
}
