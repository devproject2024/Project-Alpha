package h.a;

public class b extends AssertionError {
    private static final long serialVersionUID = 1;

    private static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public b() {
    }

    public b(String str) {
        super(defaultString(str));
    }
}
