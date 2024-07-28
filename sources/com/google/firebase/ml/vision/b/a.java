package com.google.firebase.ml.vision.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.ek;
import com.google.android.gms.internal.firebase_ml.el;
import com.google.android.gms.vision.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ek f39095a = ek.a();

    /* renamed from: b  reason: collision with root package name */
    private volatile Bitmap f39096b;

    /* renamed from: c  reason: collision with root package name */
    private volatile ByteBuffer f39097c;

    /* renamed from: d  reason: collision with root package name */
    private volatile b f39098d;

    /* renamed from: e  reason: collision with root package name */
    private volatile b f39099e;

    /* renamed from: f  reason: collision with root package name */
    private volatile byte[] f39100f;

    /* renamed from: g  reason: collision with root package name */
    private final long f39101g;

    public static a a(byte[] bArr, b bVar) {
        return new a(bArr, bVar);
    }

    public static a a(Bitmap bitmap) {
        return new a(bitmap);
    }

    public static a a(Context context, Uri uri) throws IOException {
        s.a(context, (Object) "Please provide a valid Context");
        s.a(uri, (Object) "Please provide a valid imageUri");
        el.a();
        return new a(el.a(context.getContentResolver(), uri));
    }

    private a(ByteBuffer byteBuffer, b bVar) {
        this.f39101g = SystemClock.elapsedRealtime();
        this.f39097c = (ByteBuffer) s.a(byteBuffer);
        this.f39098d = (b) s.a(bVar);
    }

    private a(byte[] bArr, b bVar) {
        this(ByteBuffer.wrap((byte[]) s.a(bArr)), bVar);
    }

    private a(Bitmap bitmap) {
        this.f39101g = SystemClock.elapsedRealtime();
        this.f39096b = (Bitmap) s.a(bitmap);
    }

    private final Bitmap b() {
        if (this.f39096b != null) {
            return this.f39096b;
        }
        synchronized (this) {
            if (this.f39096b == null) {
                byte[] c2 = c();
                int i2 = 0;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c2, 0, c2.length);
                if (this.f39098d != null) {
                    int i3 = this.f39098d.f39104c;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            i2 = 90;
                        } else if (i3 == 2) {
                            i2 = AppConstants.READ_TIME_OUT;
                        } else if (i3 == 3) {
                            i2 = 270;
                        } else {
                            StringBuilder sb = new StringBuilder(29);
                            sb.append("Invalid rotation: ");
                            sb.append(i3);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    if (i2 != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate((float) i2);
                        decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                    }
                }
                this.f39096b = decodeByteArray;
            }
        }
        return this.f39096b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] c() {
        /*
            r3 = this;
            byte[] r0 = r3.f39100f
            if (r0 == 0) goto L_0x0007
            byte[] r0 = r3.f39100f
            return r0
        L_0x0007:
            monitor-enter(r3)
            byte[] r0 = r3.f39100f     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0010
            byte[] r0 = r3.f39100f     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0010:
            java.nio.ByteBuffer r0 = r3.f39097c     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x004a
            java.nio.ByteBuffer r0 = r3.f39097c     // Catch:{ all -> 0x0056 }
            byte[] r0 = com.google.android.gms.internal.firebase_ml.ek.a((java.nio.ByteBuffer) r0)     // Catch:{ all -> 0x0056 }
            com.google.firebase.ml.vision.b.b r1 = r3.f39098d     // Catch:{ all -> 0x0056 }
            int r1 = r1.f39105d     // Catch:{ all -> 0x0056 }
            r2 = 17
            if (r1 == r2) goto L_0x0034
            r2 = 842094169(0x32315659, float:1.0322389E-8)
            if (r1 != r2) goto L_0x002c
            byte[] r0 = com.google.android.gms.internal.firebase_ml.ek.a((byte[]) r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0034
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = "Must be one of: IMAGE_FORMAT_NV21, IMAGE_FORMAT_YV12"
            r0.<init>(r1)     // Catch:{ all -> 0x0056 }
            throw r0     // Catch:{ all -> 0x0056 }
        L_0x0034:
            com.google.firebase.ml.vision.b.b r1 = r3.f39098d     // Catch:{ all -> 0x0056 }
            int r1 = r1.f39102a     // Catch:{ all -> 0x0056 }
            com.google.firebase.ml.vision.b.b r2 = r3.f39098d     // Catch:{ all -> 0x0056 }
            int r2 = r2.f39103b     // Catch:{ all -> 0x0056 }
            byte[] r0 = com.google.android.gms.internal.firebase_ml.ek.a(r0, r1, r2)     // Catch:{ all -> 0x0056 }
            com.google.firebase.ml.vision.b.b r1 = r3.f39098d     // Catch:{ all -> 0x0056 }
            int r1 = r1.f39104c     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0048
            r3.f39100f = r0     // Catch:{ all -> 0x0056 }
        L_0x0048:
            monitor-exit(r3)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x004a:
            android.graphics.Bitmap r0 = r3.b()     // Catch:{ all -> 0x0056 }
            byte[] r0 = com.google.android.gms.internal.firebase_ml.ek.a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0056 }
            r3.f39100f = r0     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)     // Catch:{ all -> 0x0056 }
            return r0
        L_0x0056:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0056 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.b.a.c():byte[]");
    }

    public final synchronized b a() {
        int i2 = 1;
        s.b(true, "Can't restrict to bitmap-only and NV21 byte buffer-only");
        if (this.f39099e == null) {
            b.a aVar = new b.a();
            if (this.f39097c != null) {
                ByteBuffer byteBuffer = this.f39097c;
                int i3 = this.f39098d.f39102a;
                int i4 = this.f39098d.f39103b;
                int i5 = this.f39098d.f39105d;
                int i6 = 842094169;
                if (i5 == 17) {
                    i6 = 17;
                } else if (i5 != 842094169) {
                    i6 = 0;
                }
                aVar.a(byteBuffer, i3, i4, i6);
                int i7 = this.f39098d.f39104c;
                if (i7 == 0) {
                    i2 = 0;
                } else if (i7 != 1) {
                    if (i7 == 2) {
                        i2 = 2;
                    } else if (i7 == 3) {
                        i2 = 3;
                    } else {
                        StringBuilder sb = new StringBuilder(29);
                        sb.append("Invalid rotation: ");
                        sb.append(i7);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                aVar.b(i2);
            } else {
                aVar.a(b());
            }
            aVar.a(this.f39101g);
            this.f39099e = aVar.a();
        }
        return this.f39099e;
    }
}
