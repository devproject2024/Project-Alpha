package com.airbnb.lottie.e.a;

import i.d;
import i.e;
import i.f;
import i.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

public abstract class c implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f6003g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f6004a;

    /* renamed from: b  reason: collision with root package name */
    int[] f6005b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f6006c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f6007d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f6008e;

    /* renamed from: f  reason: collision with root package name */
    boolean f6009f;

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract int a(a aVar) throws IOException;

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract boolean e() throws IOException;

    public abstract b f() throws IOException;

    public abstract String g() throws IOException;

    public abstract void h() throws IOException;

    public abstract String i() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract double k() throws IOException;

    public abstract int l() throws IOException;

    public abstract void m() throws IOException;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f6003g[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f6003g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static c a(e eVar) {
        return new e(eVar);
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int i3 = this.f6004a;
        int[] iArr = this.f6005b;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f6005b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f6006c;
                this.f6006c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f6007d;
                this.f6007d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new a("Nesting too deep at " + n());
            }
        }
        int[] iArr3 = this.f6005b;
        int i4 = this.f6004a;
        this.f6004a = i4 + 1;
        iArr3[i4] = i2;
    }

    /* access modifiers changed from: package-private */
    public final b a(String str) throws b {
        throw new b(str + " at path " + n());
    }

    public final String n() {
        return d.a(this.f6004a, this.f6005b, this.f6006c, this.f6007d);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f6010a;

        /* renamed from: b  reason: collision with root package name */
        final o f6011b;

        private a(String[] strArr, o oVar) {
            this.f6010a = strArr;
            this.f6011b = oVar;
        }

        public static a a(String... strArr) {
            try {
                f[] fVarArr = new f[strArr.length];
                i.c cVar = new i.c();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c.a(cVar, strArr[i2]);
                    cVar.g();
                    fVarArr[i2] = cVar.p();
                }
                return new a((String[]) strArr.clone(), o.a(fVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static /* synthetic */ void a(d dVar, String str) throws IOException {
        String str2;
        String[] strArr = f6003g;
        dVar.j(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                dVar.b(str, i2, i3);
            }
            dVar.b(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            dVar.b(str, i2, length);
        }
        dVar.j(34);
    }
}
