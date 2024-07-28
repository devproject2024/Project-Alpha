package com.google.android.exoplayer2.f;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class t extends e {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f32455a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f32456b;

    /* renamed from: c  reason: collision with root package name */
    private long f32457c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32458d;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public t() {
        super(false);
    }

    public final long a(l lVar) throws a {
        try {
            this.f32456b = lVar.f32395a;
            d();
            this.f32455a = new RandomAccessFile(lVar.f32395a.getPath(), "r");
            this.f32455a.seek(lVar.f32400f);
            this.f32457c = lVar.f32401g == -1 ? this.f32455a.length() - lVar.f32400f : lVar.f32401g;
            if (this.f32457c >= 0) {
                this.f32458d = true;
                b(lVar);
                return this.f32457c;
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
        long j = this.f32457c;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.f32455a.read(bArr, i2, (int) Math.min(j, (long) i3));
            if (read > 0) {
                this.f32457c -= (long) read;
                a(read);
            }
            return read;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public final Uri a() {
        return this.f32456b;
    }

    public final void c() throws a {
        this.f32456b = null;
        try {
            if (this.f32455a != null) {
                this.f32455a.close();
            }
            this.f32455a = null;
            if (this.f32458d) {
                this.f32458d = false;
                e();
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f32455a = null;
            if (this.f32458d) {
                this.f32458d = false;
                e();
            }
            throw th;
        }
    }
}
