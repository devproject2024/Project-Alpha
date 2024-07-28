package androidx.work;

import java.util.List;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5503a = l.a("InputMerger");

    public abstract e a(List<e> list);

    public static j a(String str) {
        try {
            return (j) Class.forName(str).newInstance();
        } catch (Exception e2) {
            l.a();
            new Throwable[1][0] = e2;
            return null;
        }
    }
}
