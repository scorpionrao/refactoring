package chapter6.replaceTempWithQuery;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class BasePriceTest {

    @Test
    public void testBasePrice() {
        BasePrice sample = new BasePrice(0, 0.0);
        Assert.assertThat(0.0, equalTo(sample.basePrice()));
    }

    @Test
    public void testZeroQuantity() {
        BasePrice sample = new BasePrice(0, 5.0);
        Assert.assertThat(0.0, equalTo(sample.getBasePrice()));
    }

    @Test
    public void testZeroItemPrice() {
        BasePrice sample = new BasePrice(5, 0.0);
        Assert.assertThat(0.0, equalTo(sample.basePrice()));
    }

    @Test
    public void testValidBasePriceSingleQuantity() {
        BasePrice sample = new BasePrice(1, 100.0);
        Assert.assertThat(100.0, equalTo(sample.basePrice()));
    }

    @Test
    public void testValidBasePriceMultipleQuantities() {
        BasePrice sample = new BasePrice(2, 100.0);
        Assert.assertThat(200.0, equalTo(sample.basePrice()));
    }

    @Test
    public void testDiscountFactorBoundaryPrice() {
        BasePrice sample = new BasePrice(1, 1000.0);
        Assert.assertThat(0.95, equalTo(sample.discountFactor()));
    }

    @Test
    public void testDiscountFactorBeyondBoundaryPrice() {
        BasePrice sample = new BasePrice(1, 1001.0);
        Assert.assertThat(0.98, equalTo(sample.discountFactor()));
    }

    @Test
    public void testDiscountFactorBoundaryQuantity() {
        BasePrice sample = new BasePrice(1000, 1.0);
        Assert.assertThat(0.95, equalTo(sample.discountFactor()));
    }

    @Test
    public void testDiscountFactorBeyondBoundaryQuantity() {
        BasePrice sample = new BasePrice(1001, 1.0);
        Assert.assertThat(0.98, equalTo(sample.discountFactor()));
    }

    @Test
    public void testGetBasePrice() {
        BasePrice sample = new BasePrice(1, 1.0);
        Assert.assertThat(0.95, equalTo(sample.getBasePrice()));
    }

    @Test
    public void testGetBasePriceBoundary() {
        BasePrice sample = new BasePrice(1000, 1.0);
        Assert.assertThat(950.0, equalTo(sample.getBasePrice()));
    }

    @Test
    public void testGetBasePriceBeyondBoundary() {
        BasePrice sample = new BasePrice(2000, 1.0);
        Assert.assertThat(1960.0, equalTo(sample.getBasePrice()));
    }

}