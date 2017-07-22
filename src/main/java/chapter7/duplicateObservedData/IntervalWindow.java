package chapter7.duplicateObservedData;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;

public class IntervalWindow extends Frame implements Observer {

    private IntervalDomain _domain;
    TextField _startField;
    TextField _endField;
    TextField _lengthField;

    IntervalWindow() {
        this._domain = new IntervalDomain();
        this._domain.addObserver(this);
        update(_domain, null);
    }

    /**
     * This method updates the domain object.
     *
     * The infrastructure synchronizes GUI.
     *
     * This needs to be called immediately after focus is lost
     */
    public void update(Observable o, Object arg) {
        _startField.setText(_domain.getStart());
        _endField.setText(_domain.getEnd());
        _lengthField.setText(_domain.getLength());
    }

    String getEnd() {
        return _domain.getEnd();
    }

    String getStart() {
        return _domain.getStart();
    }

    String getLength() {
        return _domain.getLength();
    }

    void setEnd(String arg) {
        _domain.setEnd(arg);
    }

    void setStart(String arg) {
        _domain.setStart(arg);
    }

    void setLength(String arg) {
        _domain.setLength(arg);
    }


    class SymFocus extends FocusAdapter {

        public void focusLost(FocusEvent event) {
            Object object = event.getSource();
            if(object == _startField) {
                startFieldFocusLost(event);
            } else if (object == _endField) {
                endFieldFocusLost(event);
            } else if (object == _lengthField) {
                lengthFieldFocusLost(event);
            }
        }

        void startFieldFocusLost(FocusEvent event) {
            setStart(_startField.getText());
            if(isNotInteger(getStart())) {
                setStart("0");
            }
        }

        void endFieldFocusLost(FocusEvent event) {
            setEnd(_endField.getText());
            if(isNotInteger(getEnd())) {
                setEnd("0");
            }
        }

        void lengthFieldFocusLost(FocusEvent event) {
            setLength(_lengthField.getText());
            if(isNotInteger(getLength())) {
                setLength("0");
            }
        }

        boolean isNotInteger(String input) {
            try {
                Integer.parseInt( input );
                return false;
            } catch(NumberFormatException e ) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        new IntervalWindow();
    }
}
