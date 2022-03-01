package lifecycle;

import org.junit.*;

//J-UNIT
public class LifeCycleTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test başı 1 kere çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test sonu 1 kere çalışır");
    }

    @Before
    public void setUp() {
        System.out.println("Her method oncesi calısır");
    }

    @Test
    public void testHelloWord() {
        System.out.println("1.test");
    }

    @Test
    public void testHelloWord2() {
        System.out.println("2.test");
    }

    @After
    public void tearDown() {
        System.out.println("Her method sonrası calısır");
    }
    // TestNG’de sıralı testler oluşturmak için @Test(priority=1) gibi bir kullanım vardır.
    // JUnit 5 için ise @Order(1)

}
