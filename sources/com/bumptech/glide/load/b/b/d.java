package com.bumptech.glide.load.b.b;

import com.bumptech.glide.load.b.b.a;
import java.io.File;

public class d implements a.C0094a {

    /* renamed from: a  reason: collision with root package name */
    private final long f6779a = 262144000;

    /* renamed from: b  reason: collision with root package name */
    private final a f6780b;

    public interface a {
        File a();
    }

    public d(a aVar) {
        this.f6780b = aVar;
    }

    public final a a() {
        File a2 = this.f6780b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return new e(a2, this.f6779a);
        }
        return null;
    }
}
