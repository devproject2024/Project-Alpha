package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f6688a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f6689b;

    /* renamed from: c  reason: collision with root package name */
    private T f6690c;

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public final void c() {
    }

    public b(AssetManager assetManager, String str) {
        this.f6689b = assetManager;
        this.f6688a = str;
    }

    public final void a(f fVar, d.a<? super T> aVar) {
        try {
            this.f6690c = a(this.f6689b, this.f6688a);
            aVar.a(this.f6690c);
        } catch (IOException e2) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.a((Exception) e2);
        }
    }

    public final void b() {
        T t = this.f6690c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    public final a d() {
        return a.LOCAL;
    }
}
