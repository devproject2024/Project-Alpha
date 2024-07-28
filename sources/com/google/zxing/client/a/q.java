package com.google.zxing.client.a;

public abstract class q {
    public final r q;

    public abstract String a();

    protected q(r rVar) {
        this.q = rVar;
    }

    public final String toString() {
        return a();
    }

    public static void a(String str, StringBuilder sb) {
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append(str);
        }
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String a2 : strArr) {
                a(a2, sb);
            }
        }
    }
}
