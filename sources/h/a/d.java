package h.a;

public final class d extends b {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public d(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public final String getMessage() {
        c cVar = new c(this.fExpected, this.fActual);
        String message = super.getMessage();
        if (cVar.f46255a == null || cVar.f46256b == null || cVar.f46255a.equals(cVar.f46256b)) {
            return a.format(message, cVar.f46255a, cVar.f46256b);
        }
        cVar.f46257c = 0;
        int min = Math.min(cVar.f46255a.length(), cVar.f46256b.length());
        while (cVar.f46257c < min && cVar.f46255a.charAt(cVar.f46257c) == cVar.f46256b.charAt(cVar.f46257c)) {
            cVar.f46257c++;
        }
        int length = cVar.f46255a.length() - 1;
        int length2 = cVar.f46256b.length() - 1;
        while (length2 >= cVar.f46257c && length >= cVar.f46257c && cVar.f46255a.charAt(length) == cVar.f46256b.charAt(length2)) {
            length2--;
            length--;
        }
        cVar.f46258d = cVar.f46255a.length() - length;
        return a.format(message, cVar.a(cVar.f46255a), cVar.a(cVar.f46256b));
    }

    public final String getActual() {
        return this.fActual;
    }

    public final String getExpected() {
        return this.fExpected;
    }
}
