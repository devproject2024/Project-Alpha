package kotlin.m;

final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final l f47994a;

    /* renamed from: b  reason: collision with root package name */
    public static final o f47995b = new o();

    static {
        String concat = "[eE][+-]?".concat("(\\p{Digit}+)");
        f47994a = new l("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("(" + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + concat + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + concat + ")?)|((" + ("(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')') + ")[pP][+-]?" + "(\\p{Digit}+)" + ')') + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private o() {
    }
}
