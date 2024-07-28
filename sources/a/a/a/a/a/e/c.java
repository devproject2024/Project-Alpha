package a.a.a.a.a.e;

import a.a.a.a.a.b.i;
import android.text.TextUtils;

public final class c {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(i iVar) {
        if (iVar.f704d) {
            throw new IllegalStateException("AdSession is finished");
        }
    }
}
