package androidx.core.d;

public final class j extends RuntimeException {
    public j() {
        this((String) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
