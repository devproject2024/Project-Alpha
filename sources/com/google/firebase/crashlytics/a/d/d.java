package com.google.firebase.crashlytics.a.d;

import com.business.merchant_payments.utility.StringUtility;
import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.c.g;
import com.google.firebase.crashlytics.a.d.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f38352a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    private final File f38353b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38354c = 65536;

    /* renamed from: d  reason: collision with root package name */
    private c f38355d;

    class a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f38359a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38360b;

        a(byte[] bArr, int i2) {
            this.f38359a = bArr;
            this.f38360b = i2;
        }
    }

    d(File file) {
        this.f38353b = file;
    }

    public final void a(long j, String str) {
        f();
        if (this.f38355d != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i2 = this.f38354c / 4;
                if (str.length() > i2) {
                    str = AppConstants.DOTS + str.substring(str.length() - i2);
                }
                byte[] bytes = String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str.replaceAll("\r", " ").replaceAll(StringUtility.NEW_LINE, " ")}).getBytes(f38352a);
                this.f38355d.a(bytes, bytes.length);
                while (!this.f38355d.b() && this.f38355d.a() > this.f38354c) {
                    this.f38355d.c();
                }
            } catch (IOException unused) {
                b.a().a(6);
            }
        }
    }

    public final byte[] a() {
        a e2 = e();
        if (e2 == null) {
            return null;
        }
        byte[] bArr = new byte[e2.f38360b];
        System.arraycopy(e2.f38359a, 0, bArr, 0, e2.f38360b);
        return bArr;
    }

    public final String b() {
        byte[] a2 = a();
        if (a2 != null) {
            return new String(a2, f38352a);
        }
        return null;
    }

    private a e() {
        if (!this.f38353b.exists()) {
            return null;
        }
        f();
        c cVar = this.f38355d;
        if (cVar == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[cVar.a()];
        try {
            this.f38355d.a((c.C0630c) new c.C0630c() {
                public final void a(InputStream inputStream, int i2) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i2);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i2;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException unused) {
            b.a().a(6);
        }
        return new a(bArr, iArr[0]);
    }

    public final void c() {
        g.a((Closeable) this.f38355d);
        this.f38355d = null;
    }

    public final void d() {
        c();
        this.f38353b.delete();
    }

    private void f() {
        if (this.f38355d == null) {
            try {
                this.f38355d = new c(this.f38353b);
            } catch (IOException unused) {
                b a2 = b.a();
                new StringBuilder("Could not open log file: ").append(this.f38353b);
                a2.a(6);
            }
        }
    }
}
