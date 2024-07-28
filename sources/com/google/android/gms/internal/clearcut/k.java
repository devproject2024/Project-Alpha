package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import java.io.IOException;

final class k extends e<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Object f9417d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private String f9418e;

    /* renamed from: f  reason: collision with root package name */
    private T f9419f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ m f9420g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(n nVar, String str, Object obj, m mVar) {
        super(nVar, str, obj, (byte) 0);
        this.f9420g = mVar;
    }

    /* access modifiers changed from: protected */
    public final T a(SharedPreferences sharedPreferences) {
        try {
            return a(sharedPreferences.getString(this.f9323b, ""));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f9323b);
            if (valueOf.length() != 0) {
                "Invalid byte[] value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid byte[] value in SharedPreferences for ");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final T a(String str) {
        T t;
        try {
            synchronized (this.f9417d) {
                if (!str.equals(this.f9418e)) {
                    T a2 = this.f9420g.a(Base64.decode(str, 3));
                    this.f9418e = str;
                    this.f9419f = a2;
                }
                t = this.f9419f;
            }
            return t;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.f9323b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            return null;
        }
    }
}
