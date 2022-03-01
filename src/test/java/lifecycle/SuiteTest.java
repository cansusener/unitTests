package lifecycle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit ile istediğimiz testleri “Suite” halinde yani grup halinde çalıştırma

/*
*
* @RunWith(Suite.class) eki ile bu sınıfı bir grup olarak çalıştırmasını belirtmiş oluyoruz.
*  Ardından @Suite.SuiteClasses({}) içinde liste halinde çalıştırmak istediğimiz test sınıflarını veriyoruz.
*  Burada test sınıflarını verdiğimiz sıraya göre çalıştır*/
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AssertTest.class,
        LifeCycleTest.class,
})
public class SuiteTest {
//JUnit ile istediğimiz testleri “Suite” halinde yani grup halinde çalıştırır
}
