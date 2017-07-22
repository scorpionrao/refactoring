package chapter6.introduceLocalExtension;

import java.util.Date;

public class mfDateSub extends Date {

    mfDateSub(String dateString) {
        super(dateString);
    }

    mfDateSub(Date arg) {
        super(arg.getTime());
    }

    Date nextDay() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }
}
