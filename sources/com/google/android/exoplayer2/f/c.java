package com.google.android.exoplayer2.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f32370a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f32371b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f32372c;

    /* renamed from: d  reason: collision with root package name */
    private long f32373d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32374e;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context) {
        super(false);
        this.f32370a = context.getAssets();
    }

    public final long a(l lVar) throws a {
        try {
            this.f32371b = lVar.f32395a;
            String path = this.f32371b.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            d();
            this.f32372c = this.f32370a.open(path, 1);
            if (this.f32372c.skip(lVar.f32400f) >= lVar.f32400f) {
                if (lVar.f32401g != -1) {
                    this.f32373d = lVar.f32401g;
                } else {
                    this.f32373d = (long) this.f32372c.available();
                    if (this.f32373d == 2147483647L) {
                        this.f32373d = -1;
                    }
                }
                this.f32374e = true;
                b(lVar);
                return this.f32373d;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j = this.f32373d;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i3 = (int) Math.min(j, (long) i3);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int read = this.f32372c.read(bArr, i2, i3);
        if (read != -1) {
            long j2 = this.f32373d;
            if (j2 != -1) {
                this.f32373d = j2 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f32373d == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public final Uri a() {
        return this.f32371b;
    }

    public final void c() throws a {
        this.f32371b = null;
        try {
            if (this.f32372c != null) {
                this.f32372c.close();
            }
            this.f32372c = null;
            if (this.f32374e) {
                this.f32374e = false;
                e();
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f32372c = null;
            if (this.f32374e) {
                this.f32374e = false;
                e();
            }
            throw th;
        }
    }
}
