package c.a.a;

import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;

final class i {

    /* renamed from: b  reason: collision with root package name */
    private static i f5564b;

    /* renamed from: a  reason: collision with root package name */
    ConcurrentHashMap<String, Call> f5565a = new ConcurrentHashMap<>();

    private i() {
    }

    public static i a() {
        if (f5564b == null) {
            f5564b = new i();
        }
        return f5564b;
    }
}
