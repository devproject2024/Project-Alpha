package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Set;

public final class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f6753a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final l f6754b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f6755c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6756d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6757e;

    /* renamed from: f  reason: collision with root package name */
    private long f6758f;

    /* renamed from: g  reason: collision with root package name */
    private long f6759g;

    /* renamed from: h  reason: collision with root package name */
    private int f6760h;

    /* renamed from: i  reason: collision with root package name */
    private int f6761i;
    private int j;
    private int k;

    interface a {
    }

    private k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f6756d = j2;
        this.f6758f = j2;
        this.f6754b = lVar;
        this.f6755c = set;
        this.f6757e = new b();
    }

    public final synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f6754b.c(bitmap)) <= this.f6758f) {
                        if (this.f6755c.contains(bitmap.getConfig())) {
                            int c2 = this.f6754b.c(bitmap);
                            this.f6754b.a(bitmap);
                            this.j++;
                            this.f6759g += (long) c2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                new StringBuilder("Put bitmap in pool=").append(this.f6754b.b(bitmap));
                            }
                            b();
                            a(this.f6758f);
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Reject bitmap from pool, bitmap: ");
                        sb.append(this.f6754b.b(bitmap));
                        sb.append(", is mutable: ");
                        sb.append(bitmap.isMutable());
                        sb.append(", is allowed config: ");
                        sb.append(this.f6755c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        if (d2 == null) {
            return c(i2, i3, config);
        }
        d2.eraseColor(0);
        return d2;
    }

    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        return d2 == null ? c(i2, i3, config) : d2;
    }

    private static Bitmap c(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = f6753a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public final void a() {
        Log.isLoggable("LruBitmapPool", 3);
        a(0);
    }

    public final void a(int i2) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(this.f6758f / 2);
        }
    }

    private synchronized void a(long j2) {
        while (this.f6759g > j2) {
            Bitmap a2 = this.f6754b.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    c();
                }
                this.f6759g = 0;
                return;
            }
            this.f6759g -= (long) this.f6754b.c(a2);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                new StringBuilder("Evicting bitmap=").append(this.f6754b.b(a2));
            }
            b();
            a2.recycle();
        }
    }

    private void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }

    private void c() {
        StringBuilder sb = new StringBuilder("Hits=");
        sb.append(this.f6760h);
        sb.append(", misses=");
        sb.append(this.f6761i);
        sb.append(", puts=");
        sb.append(this.j);
        sb.append(", evictions=");
        sb.append(this.k);
        sb.append(", currentSize=");
        sb.append(this.f6759g);
        sb.append(", maxSize=");
        sb.append(this.f6758f);
        sb.append("\nStrategy=");
        sb.append(this.f6754b);
    }

    static final class b implements a {
        b() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(long r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x000c
            com.bumptech.glide.load.b.a.n r0 = new com.bumptech.glide.load.b.a.n
            r0.<init>()
            goto L_0x0011
        L_0x000c:
            com.bumptech.glide.load.b.a.c r0 = new com.bumptech.glide.load.b.a.c
            r0.<init>()
        L_0x0011:
            java.util.HashSet r2 = new java.util.HashSet
            android.graphics.Bitmap$Config[] r3 = android.graphics.Bitmap.Config.values()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r1) goto L_0x0026
            r1 = 0
            r2.add(r1)
        L_0x0026:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r1 < r3) goto L_0x0031
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            r2.remove(r1)
        L_0x0031:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r2)
            r4.<init>(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.k.<init>(long):void");
    }

    private synchronized Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap a2;
        if (Build.VERSION.SDK_INT >= 26) {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        a2 = this.f6754b.a(i2, i3, config != null ? config : f6753a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                new StringBuilder("Missing bitmap=").append(this.f6754b.b(i2, i3, config));
            }
            this.f6761i++;
        } else {
            this.f6760h++;
            this.f6759g -= (long) this.f6754b.c(a2);
            a2.setHasAlpha(true);
            if (Build.VERSION.SDK_INT >= 19) {
                a2.setPremultiplied(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            new StringBuilder("Get bitmap=").append(this.f6754b.b(i2, i3, config));
        }
        b();
        return a2;
    }
}
