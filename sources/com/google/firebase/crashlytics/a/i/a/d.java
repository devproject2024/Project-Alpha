package com.google.firebase.crashlytics.a.i.a;

import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.i.a.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final File f38622a;

    /* renamed from: b  reason: collision with root package name */
    private final File[] f38623b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f38624c;

    public d(File file) {
        this(file, Collections.emptyMap());
    }

    public d(File file, Map<String, String> map) {
        this.f38622a = file;
        this.f38623b = new File[]{file};
        this.f38624c = new HashMap(map);
    }

    public final File d() {
        return this.f38622a;
    }

    public final File[] e() {
        return this.f38623b;
    }

    public final Map<String, String> f() {
        return Collections.unmodifiableMap(this.f38624c);
    }

    public final void a() {
        b a2 = b.a();
        new StringBuilder("Removing report at ").append(this.f38622a.getPath());
        a2.a(3);
        this.f38622a.delete();
    }

    public final c.a g() {
        return c.a.JAVA;
    }

    public final String b() {
        return this.f38622a.getName();
    }

    public final String c() {
        String name = this.f38622a.getName();
        return name.substring(0, name.lastIndexOf(46));
    }
}
