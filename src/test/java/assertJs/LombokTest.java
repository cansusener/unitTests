package assertJs;

import org.junit.Test;

public class LombokTest {


    @Test
    public void testLombok() throws Exception {
        Gift gift = Gift.builder().name("cansu").surname("sener").hello("hello").build();
        System.out.println(gift.toString());
    }
}
