package lifecycle;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {
    @Test
    public void assertionTest() {

        //Dummy d1 = null;
        //Dummy d2 = new Dummy(5);
        //Dummy d1=new Dummy(5);
        //Dummy d2=new Dummy(5);

        //assertNull("obje bos", d1);
        //assertNotNull("obje bos degıl", d2);

        //assertTrue(d1 == null);
        //assertTrue(d2 != null);
        //assertFalse(d1 != null);
        //assertEquals(d1,d2);
        //


        //assertArrayEquals() ile verilen iki array nesnemizin birbirine eşit olup olmadığını kontrol eder :
        String[] array1 = new String[]{"1", "2"};
        String[] array2 = new String[]{"1", "4"};
        assertArrayEquals(array1,array2);
    }

    public static class Dummy {
        private int id;

        public Dummy(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            return this.id == ((Dummy) obj).getId();

        }
    }
}
