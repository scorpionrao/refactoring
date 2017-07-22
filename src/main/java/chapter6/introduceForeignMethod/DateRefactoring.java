package chapter6.introduceForeignMethod;

import java.util.Date;

public class DateRefactoring {

    Date previousEnd;
    Date newStart;

    DateRefactoring(Date previousEnd) {
        this.previousEnd = previousEnd;
        this.newStart = nextDay();
    }

    private Date nextDay() {
        return new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
    }

    public Date getPreviousEnd() {
        return previousEnd;
    }

    public Date getNewStart() {
        return newStart;
    }
}
