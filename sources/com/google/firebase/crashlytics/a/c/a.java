package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.f.b;
import com.google.firebase.crashlytics.a.f.c;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f38148b = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a  reason: collision with root package name */
    protected final String f38149a;

    /* renamed from: c  reason: collision with root package name */
    private final c f38150c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.crashlytics.a.f.a f38151d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38152e;

    public a(String str, String str2, c cVar, com.google.firebase.crashlytics.a.f.a aVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (cVar != null) {
            this.f38152e = str;
            this.f38149a = !g.c(this.f38152e) ? f38148b.matcher(str2).replaceFirst(this.f38152e) : str2;
            this.f38150c = cVar;
            this.f38151d = aVar;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    public final b a() {
        return a(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public final b a(Map<String, String> map) {
        return c.a(this.f38151d, this.f38149a, map).a("User-Agent", "Crashlytics Android SDK/17.1.0").a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }
}
