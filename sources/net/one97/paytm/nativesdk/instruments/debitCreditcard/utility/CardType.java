package net.one97.paytm.nativesdk.instruments.debitCreditcard.utility;

import java.util.regex.Pattern;

public enum CardType {
    UNKNOWN,
    VISA("^4[0-9]{12}(?:[0-9]{3}){0,2}$"),
    MASTERCARD("^(?:5[1-5]|2(?!2([01]|20)|7(2[1-9]|3))[2-7])\\d{14}$"),
    AMERICAN_EXPRESS("^3[47][0-9]{13}$"),
    DINERS_CLUB("^3(?:0[0-5]\\d|095|6\\d{0,2}|[89]\\d{2})\\d{12,15}$"),
    DISCOVER("^6(?:011|[45][0-9]{2})[0-9]{12}$"),
    JCB("^(?:2131|1800|35\\d{3})\\d{11}$"),
    MAESTRO("^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$"),
    CHINA_UNION_PAY("^62[0-9]{14,17}$");
    
    private Pattern pattern;

    private CardType(String str) {
        this.pattern = Pattern.compile(str);
    }

    public static CardType detect(String str) {
        if (str == null || str.length() <= 0) {
            return UNKNOWN;
        }
        for (CardType cardType : values()) {
            Pattern pattern2 = cardType.pattern;
            if (pattern2 != null && pattern2.matcher(str).matches()) {
                return cardType;
            }
        }
        return UNKNOWN;
    }
}
