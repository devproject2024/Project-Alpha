package kotlin.m;

public enum n implements f {
    IGNORE_CASE(2, 0, 2, (int) null),
    MULTILINE(8, 0, 2, (int) null),
    LITERAL(16, 0, 2, (int) null),
    UNIX_LINES(1, 0, 2, (int) null),
    COMMENTS(4, 0, 2, (int) null),
    DOT_MATCHES_ALL(32, 0, 2, (int) null),
    CANON_EQ(128, 0, 2, (int) null);
    
    private final int mask;
    private final int value;

    private n(int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    public final int getMask() {
        return this.mask;
    }

    public final int getValue() {
        return this.value;
    }
}
