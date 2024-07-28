package com.google.android.exoplayer2.f.a;

import java.io.File;
import java.io.IOException;

public interface a {
    g a() throws InterruptedException, C0544a;

    g b() throws C0544a;

    File c() throws C0544a;

    i d();

    /* renamed from: com.google.android.exoplayer2.f.a.a$a  reason: collision with other inner class name */
    public static class C0544a extends IOException {
        public C0544a(String str) {
            super(str);
        }

        public C0544a(Throwable th) {
            super(th);
        }

        public C0544a(String str, Throwable th) {
            super(str, th);
        }
    }
}
