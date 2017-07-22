package chapter7.duplicateObservedData;

import java.util.Observable;

public class IntervalDomain extends Observable {

    private String _end = "0";
    private String _start = "0";
    private String _length = "0";

    void calculateLength() {
        try {
            int start = Integer.parseInt(getStart());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            setLength(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number format error - " + e.getMessage());
        }
    }

    void calculateEnd() {
        try {
            int start = Integer.parseInt(getStart());
            int length = Integer.parseInt(getLength());
            int end = start + length;
            setEnd(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number format error - " + e.getMessage());
        }
    }

    String getEnd() {
        return _end;
    }

    void setEnd(String arg) {
        _end = arg;
        calculateLength();
        setChanged();
        notifyObservers();
    }

    String getStart() {
        return _end;
    }

    void setStart(String arg) {
        _start = arg;
        calculateLength();
        setChanged();
        notifyObservers();
    }

    String getLength() {
        return _length;
    }

    void setLength(String arg) {
        _length = arg;
        calculateEnd();
        setChanged();
        notifyObservers();
    }
}
