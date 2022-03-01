package assertJs;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerTest {

    List<String> names = new ArrayList<>(Arrays.asList("cansu", "ebru", "merve"));
    List<String> MyCities = new ArrayList<>(Arrays.asList("İstanbul", "Ankara", "İzmir"));
    List<String> MyCountries = new ArrayList<>(Arrays.asList("Turkey", "America", "Brazil"));

    @Test
    public void testString() throws Exception {
        String text1 = "Mersin";
        //AssertJ sayesinde akıcı şekilde methodlarımızı yazabiliyoruz
        assertThat(text1)
                //describedAs("hata mesajı!")
                .isEqualTo("Mersin")
                .startsWith("Mer")
                .endsWith("sin")
                .contains("er")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("cansu")
                .containsOnlyOnce("sin");


    }

    @Test
    public void testListNames() throws Exception {
        assertThat(names)
                .contains("ebru")
                .doesNotContain("pelin")
                .containsExactly("cansu", "ebru", "merve") //tam olarak içerdiği
                .doesNotHaveDuplicates(); //elemenlar tekrar etmemeli


    }

    @Test
    public void testList() throws Exception {
        List<String> cities = new ArrayList<>(Arrays.asList("İstanbul", "Ankara", "İzmir"));

        assertThat(cities)
                .doesNotContain("Mersin")
                .contains("İstanbul")
                .containsExactly("İstanbul", "Ankara", "İzmir")
                .doesNotHaveDuplicates();

        //AssertJ içinde kendi eşleştirme methodlarımızı yazabiliriz

        //Listede sadece sehirlerin old test et

        List<String> cities2 = new ArrayList<>(Arrays.asList("İstanbul", "Ankara", "İzmir"));
        assertThat(cities2)
                .have(MyCities());

        //Listede sadece ülkelerin old test et
        List<String> countries2 = new ArrayList<>(Arrays.asList("Turkey", "America", "Brazil"));
        assertThat(countries2)
                .have(MyCountries());
        //Listede 2 şehir 3 ülke olsun
        List<String> citiesAndCounties = new ArrayList<>(Arrays.asList("Turkey", "İstanbul", "America", "İzmir", "Brazil"));
        assertThat(citiesAndCounties)
                .haveExactly(2, MyCities())
                .haveExactly(3, MyCountries());

    }

    private Condition<? super String> MyCities() {
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return MyCities.contains(s);
            }
        };
    }

    private Condition<? super String> MyCountries() {
        return new Condition<String>() {
            @Override
            public boolean matches(String s) {
                return MyCountries.contains(s);
            }
        };
    }
}
