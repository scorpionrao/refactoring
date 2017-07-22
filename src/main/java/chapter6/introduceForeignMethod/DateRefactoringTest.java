package chapter6.introduceForeignMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateRefactoringTest {

    @Test
    public void test1() {
        DateRefactoring refactoring = new DateRefactoring(new Date());
        Assert.assertNotNull(refactoring);
        Assert.assertNotNull(refactoring.getNewStart());
        Assert.assertNotNull(refactoring.getPreviousEnd());
        Assert.assertTrue(refactoring.getNewStart().after(refactoring.getPreviousEnd()));
    }
}
