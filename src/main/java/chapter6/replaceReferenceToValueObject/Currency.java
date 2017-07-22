package chapter6.replaceReferenceToValueObject;

import java.util.Dictionary;
import java.util.Hashtable;

public class Currency {

    private String _code;

    public Currency(String code) {
        _code = code;
    }

    public String getCode() {
        return _code;
    }

    static Dictionary<String, Currency> _registry = new Hashtable<String, Currency>();

    static void loadCurrencies() {
        new Currency("USD").storeIntoRegistry();
    }

    void storeIntoRegistry() {
        _registry.put(this._code, this);
    }

    public static Currency getOrfactoryMethodForReference(String code) {
        return _registry.get(code);
    }

    public static Currency getOrfactoryMethodForValue(String code) {
        return new Currency(code);
    }

    public boolean equals(Object arg) {
        boolean check = arg instanceof Currency;
        if(!check) {
            return false;
        }
        Currency other = (Currency) arg;
        return _code.equals(other._code);
    }

    public int hashCode() {
        return _code.hashCode();
    }

}
