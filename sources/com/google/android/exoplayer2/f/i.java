package com.google.android.exoplayer2.f;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface i {

    public interface a {
        i a();
    }

    int a(byte[] bArr, int i2, int i3) throws IOException;

    long a(l lVar) throws IOException;

    Uri a();

    void a(ad adVar);

    Map<String, List<String>> b();

    void c() throws IOException;

    /* renamed from: com.google.android.exoplayer2.f.i$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$b(i _this) {
            return Collections.emptyMap();
        }
    }
}
