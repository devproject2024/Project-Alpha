package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6712a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f6713b;

    /* renamed from: c  reason: collision with root package name */
    private T f6714c;

    /* access modifiers changed from: protected */
    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public final void c() {
    }

    public l(ContentResolver contentResolver, Uri uri) {
        this.f6713b = contentResolver;
        this.f6712a = uri;
    }

    public final void a(f fVar, d.a<? super T> aVar) {
        try {
            this.f6714c = a(this.f6712a, this.f6713b);
            aVar.a(this.f6714c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.a((Exception) e2);
        }
    }

    public final void b() {
        T t = this.f6714c;
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
