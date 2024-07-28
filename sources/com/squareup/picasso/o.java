package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public final class o implements d {

    /* renamed from: b  reason: collision with root package name */
    final LruCache<String, a> f45427b;

    public o(Context context) {
        this(ai.b(context));
    }

    private o(int i2) {
        this.f45427b = new LruCache<String, a>(i2) {
            /* access modifiers changed from: protected */
            public final /* bridge */ /* synthetic */ int sizeOf(Object obj, Object obj2) {
                return ((a) obj2).f45430b;
            }
        };
    }

    public final Bitmap a(String str) {
        a aVar = this.f45427b.get(str);
        if (aVar != null) {
            return aVar.f45429a;
        }
        return null;
    }

    public final void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int a2 = ai.a(bitmap);
        if (a2 > this.f45427b.maxSize()) {
            this.f45427b.remove(str);
        } else {
            this.f45427b.put(str, new a(bitmap, a2));
        }
    }

    public final int a() {
        return this.f45427b.size();
    }

    public final int b() {
        return this.f45427b.maxSize();
    }

    public final void b(String str) {
        for (String next : this.f45427b.snapshot().keySet()) {
            if (next.startsWith(str) && next.length() > str.length() && next.charAt(str.length()) == 10) {
                this.f45427b.remove(next);
            }
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f45429a;

        /* renamed from: b  reason: collision with root package name */
        final int f45430b;

        a(Bitmap bitmap, int i2) {
            this.f45429a = bitmap;
            this.f45430b = i2;
        }
    }
}
