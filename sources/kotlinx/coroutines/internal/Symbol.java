package kotlinx.coroutines.internal;

public final class Symbol {
    private final String symbol;

    public Symbol(String str) {
        this.symbol = str;
    }

    public final String toString() {
        return this.symbol;
    }
}
