package chapter6.introduceLocalExtension;

import java.util.Date;

public class mfDateWrapper {
    Date _original;
    mfDateWrapper(String dateString) {
        _original = new Date(dateString);
    }
    mfDateWrapper(Date arg) {
        _original = arg;
    }
    Date nextDay() {
        return new Date(_original.getYear(), _original.getMonth(), _original.getDate() + 1);
    }

    public Date get_original() {
        return _original;
    }
}
