package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.g.h;
import java.io.File;
import java.io.IOException;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f38293a;

    /* renamed from: b  reason: collision with root package name */
    private final h f38294b;

    public m(String str, h hVar) {
        this.f38293a = str;
        this.f38294b = hVar;
    }

    public final boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException unused) {
            b a2 = b.a();
            new StringBuilder("Error creating marker: ").append(this.f38293a);
            a2.a(6);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final File b() {
        return new File(this.f38294b.a(), this.f38293a);
    }
}
