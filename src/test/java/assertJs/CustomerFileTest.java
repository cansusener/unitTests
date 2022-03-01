package assertJs;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

public class CustomerFileTest {


    @Test
    public void testFile() {
        File file = new File("src/main/resources/text.txt");
        assertThat(file)
                .exists() //böylebidosya varmı
                .canRead() //okunabılır mı
                .canWrite() //yazilabilir mi
                .hasName("text.txt")
                .hasExtension("txt");

        //assertThat(contentOf(file)) yapısıyla ise dosyanın içeriğine assertion’lar atıyoruz.
        assertThat(contentOf(file))
                .startsWith("cansu");
    }

}
