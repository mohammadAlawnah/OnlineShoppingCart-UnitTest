package onlineshopping.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ProductTest.class,
    CustomerTest.class,
    CartItemTest.class,
    ShoppingCartTest.class
})
public class TestSuite {

}
