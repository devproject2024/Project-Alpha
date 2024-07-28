package com.google.firebase.crashlytics.a.i.a;

import com.google.firebase.crashlytics.a.i.a.c;
import java.io.File;
import java.util.Map;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final File f38621a;

    public final String b() {
        return null;
    }

    public final File d() {
        return null;
    }

    public final Map<String, String> f() {
        return null;
    }

    public b(File file) {
        this.f38621a = file;
    }

    public final String c() {
        return this.f38621a.getName();
    }

    public final File[] e() {
        return this.f38621a.listFiles();
    }

    public final c.a g() {
        return c.a.NATIVE;
    }

    public final void a() {
        for (File file : this.f38621a.listFiles()) {
            com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
            new StringBuilder("Removing native report file at ").append(file.getPath());
            a2.a(3);
            file.delete();
        }
        com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
        new StringBuilder("Removing native report directory at ").append(this.f38621a);
        a3.a(3);
        this.f38621a.delete();
    }
}
