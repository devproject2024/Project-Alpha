package com.google.android.exoplayer2.f;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class aa extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f32347a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f32348b;

    /* renamed from: c  reason: collision with root package name */
    private AssetFileDescriptor f32349c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f32350d;

    /* renamed from: e  reason: collision with root package name */
    private long f32351e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32352f;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(IOException iOException) {
            super(iOException);
        }
    }

    public aa(Context context) {
        super(false);
        this.f32347a = context.getResources();
    }

    public final long a(l lVar) throws a {
        try {
            this.f32348b = lVar.f32395a;
            if (TextUtils.equals("rawresource", this.f32348b.getScheme())) {
                int parseInt = Integer.parseInt(this.f32348b.getLastPathSegment());
                d();
                this.f32349c = this.f32347a.openRawResourceFd(parseInt);
                this.f32350d = new FileInputStream(this.f32349c.getFileDescriptor());
                this.f32350d.skip(this.f32349c.getStartOffset());
                if (this.f32350d.skip(lVar.f32400f) >= lVar.f32400f) {
                    long j = -1;
                    if (lVar.f32401g != -1) {
                        this.f32351e = lVar.f32401g;
                    } else {
                        long length = this.f32349c.getLength();
                        if (length != -1) {
                            j = length - lVar.f32400f;
                        }
                        this.f32351e = j;
                    }
                    this.f32352f = true;
                    b(lVar);
                    return this.f32351e;
                }
                throw new EOFException();
            }
            throw new a("URI must use scheme rawresource");
        } catch (NumberFormatException unused) {
            throw new a("Resource identifier must be an integer.");
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j = this.f32351e;
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
        int read = this.f32350d.read(bArr, i2, i3);
        if (read != -1) {
            long j2 = this.f32351e;
            if (j2 != -1) {
                this.f32351e = j2 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f32351e == -1) {
            return -1;
        } else {
            throw new a((IOException) new EOFException());
        }
    }

    public final Uri a() {
        return this.f32348b;
    }

    public final void c() throws a {
        this.f32348b = null;
        try {
            if (this.f32350d != null) {
                this.f32350d.close();
            }
            this.f32350d = null;
            try {
                if (this.f32349c != null) {
                    this.f32349c.close();
                }
                this.f32349c = null;
                if (this.f32352f) {
                    this.f32352f = false;
                    e();
                }
            } catch (IOException e2) {
                throw new a(e2);
            } catch (Throwable th) {
                this.f32349c = null;
                if (this.f32352f) {
                    this.f32352f = false;
                    e();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new a(e3);
        } catch (Throwable th2) {
            this.f32350d = null;
            try {
                if (this.f32349c != null) {
                    this.f32349c.close();
                }
                this.f32349c = null;
                if (this.f32352f) {
                    this.f32352f = false;
                    e();
                }
                throw th2;
            } catch (IOException e4) {
                throw new a(e4);
            } catch (Throwable th3) {
                this.f32349c = null;
                if (this.f32352f) {
                    this.f32352f = false;
                    e();
                }
                throw th3;
            }
        }
    }
}
