package chapter6.replaceTempWithQuery;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by rgonugunta on 7/19/17.
 */
public class SampleTest {

    @Test
    public void testBasePriceCalculator() {
        Sample sample = new Sample(0, 0.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(0.0, equalTo(basePrice));
    }

    @Test
    public void testZeroQuantity() {
        Sample sample = new Sample(0, 5.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(0.0, equalTo(basePrice));
    }

    @Test
    public void testZeroBasePrice() {
        Sample sample = new Sample(5, 0.0);
        double basePrice = sample.basePrice();
        Assert.assertThat(0.0, equalTo(basePrice));
    }

    @Test
    public void testValidBasePriceSingleQuantity() {
        Sample sample = new Sample(1, 100.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(95.0, equalTo(basePrice));
    }

    @Test
    public void testValidBasePriceMultipleQuantities() {
        Sample sample = new Sample(2, 100.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(190.0, equalTo(basePrice));
    }

    @Test
    public void testBulkQuantity() {
        Sample sample = new Sample(1000, 1.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(950.0, equalTo(basePrice));
    }

    @Test
    public void testHeavySizeQuantity() {
        Sample sample = new Sample(2000, 1.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(1960.0, equalTo(basePrice));
    }

    @Test
    public void testBulkItemPrice() {
        Sample sample = new Sample(1, 1000.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(950.0, equalTo(basePrice));
    }

    @Test
    public void testHeavySizeItemPrice() {
        Sample sample = new Sample(1, 2000.0);
        double basePrice = sample.getBasePrice();
        Assert.assertThat(1960.0, equalTo(basePrice));
    }
}
