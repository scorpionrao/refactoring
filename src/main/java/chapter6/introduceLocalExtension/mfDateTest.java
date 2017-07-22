package chapter6.introduceLocalExtension;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class mfDateTest {

    @Test
    public void testSubclassExample() {
        mfDateSub dateSub = new mfDateSub(new Date());
        Assert.assertNotNull(dateSub);
        Assert.assertTrue(dateSub.nextDay().after(dateSub));
    }

    @Test
    public void testWrapperclassExample() {
        mfDateWrapper dateWrapper = new mfDateWrapper(new Date());
        Assert.assertNotNull(dateWrapper);
        Assert.assertTrue(dateWrapper.nextDay().after(dateWrapper.get_original()));
    }
}
