package androidx.browser.trusted;

import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final d f1937a;

    public static c a(String str, PackageManager packageManager) {
        List<byte[]> a2 = b.a(str, packageManager);
        if (a2 == null) {
            return null;
        }
        try {
            return new c(d.a(str, a2));
        } catch (IOException unused) {
            return null;
        }
    }

    public c(d dVar) {
        this.f1937a = dVar;
    }

    public final boolean b(String str, PackageManager packageManager) {
        return b.a(str, packageManager, this.f1937a);
    }
}
