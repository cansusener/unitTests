package assertJs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.groups.Tuple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CustomerListTest {

    @Test
    public void testList() throws Exception {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1, "cansu"));
        itemList.add(new Item(2, "ebru"));
        itemList.add(new Item(3, "sener"));

        assertThat(itemList)
                //xctracting() methodu her item içindeki name değerini alıp yeni bir liste oluşturuyor.
                // Ardından contains() ile bu name listesinin içinde ebru ve cansunun olduğunu öne sürüyoruz.
                .extracting("name")
                .contains("cansu", "ebru");

        assertThat(itemList)
                .extracting("name", "id")
                .contains(
                        tuple("cansu", 1),
                        tuple("sener", 3)
                );

        // extractProperty(“değişken”,”ait olduğu sınıf”).from(liste)
        assertThat(extractProperty("id", Integer.class).from(itemList)).containsExactly(1, 2, 3);
    }

    @Data
    @AllArgsConstructor
    static class Item {
        private Integer id;
        private String name;
    }
}
