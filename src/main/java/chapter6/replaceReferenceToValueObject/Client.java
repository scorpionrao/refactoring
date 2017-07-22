package chapter6.replaceReferenceToValueObject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Client {

    @BeforeClass
    public static void setUp() {
        Currency.loadCurrencies();
    }

    @Test
    public void testExistingCodeUsingReferenceConcept() {
        String code = "USD";
        Currency currency = Currency.getOrfactoryMethodForReference(code);
        Assert.assertNotNull(currency);
        Assert.assertTrue(code.equals(currency.getCode()));
    }

    @Test
    public void testExistingCodeMultipleCallsUsingReferenceConcept() {
        String code = "USD";
        Currency currency1 = Currency.getOrfactoryMethodForReference(code);
        Assert.assertNotNull(currency1);
        Currency currency2 = Currency.getOrfactoryMethodForReference(code);
        Assert.assertNotNull(currency2);
        Assert.assertTrue(currency1.equals(currency2));
        Assert.assertTrue(currency1.getCode().equals(currency2.getCode()));
    }

    @Test
    public void testNonExistingCodeUsingReferenceConcept() {
        String code = "INR";
        Currency actualCode = Currency.getOrfactoryMethodForReference(code);
        Assert.assertNull(actualCode);
    }

    @Test
    public void testExistingCodeUsingValueConcept() {
        String code = "INR";
        Currency currency = Currency.getOrfactoryMethodForValue(code);
        Assert.assertNotNull(currency);
        Assert.assertTrue(code.equals(currency.getCode()));
    }

    @Test
    public void testExistingCodeMultipleCallsUsingValueConcept() {
        String code = "INR";
        Currency currency1 = Currency.getOrfactoryMethodForValue(code);
        Assert.assertNotNull(currency1);
        Currency currency2 = Currency.getOrfactoryMethodForValue(code);
        Assert.assertNotNull(currency2);
        // uses overriding equals method instead of reference
        Assert.assertTrue(currency1.equals(currency2));
        Assert.assertTrue(currency1.getCode().equals(currency2.getCode()));
    }

}
