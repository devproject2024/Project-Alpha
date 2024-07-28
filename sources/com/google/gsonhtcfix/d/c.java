package com.google.gsonhtcfix.d;

import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f39788a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f39789b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39790c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39791d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39792e;

    /* renamed from: f  reason: collision with root package name */
    private final Writer f39793f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f39794g = new int[32];

    /* renamed from: h  reason: collision with root package name */
    private int f39795h = 0;

    /* renamed from: i  reason: collision with root package name */
    private String f39796i;
    private String j;
    private String k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f39788a[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f39788a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f39789b = strArr2;
        strArr2[60] = "\\u003c";
        String[] strArr3 = f39789b;
        strArr3[62] = "\\u003e";
        strArr3[38] = "\\u0026";
        strArr3[61] = "\\u003d";
        strArr3[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.j = AppConstants.COLON;
        this.f39792e = true;
        if (writer != null) {
            this.f39793f = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f39796i = null;
            this.j = AppConstants.COLON;
            return;
        }
        this.f39796i = str;
        this.j = ": ";
    }

    public c a() throws IOException {
        g();
        return a(1, "[");
    }

    public c b() throws IOException {
        return a(1, 2, "]");
    }

    public c c() throws IOException {
        g();
        return a(3, "{");
    }

    public c d() throws IOException {
        return a(3, 5, "}");
    }

    private c a(int i2, String str) throws IOException {
        b(true);
        a(i2);
        this.f39793f.write(str);
        return this;
    }

    private c a(int i2, int i3, String str) throws IOException {
        int f2 = f();
        if (f2 != i3 && f2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.k == null) {
            this.f39795h--;
            if (f2 == i3) {
                h();
            }
            this.f39793f.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.k);
        }
    }

    private void a(int i2) {
        int i3 = this.f39795h;
        int[] iArr = this.f39794g;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f39794g = iArr2;
        }
        int[] iArr3 = this.f39794g;
        int i4 = this.f39795h;
        this.f39795h = i4 + 1;
        iArr3[i4] = i2;
    }

    private int f() {
        int i2 = this.f39795h;
        if (i2 != 0) {
            return this.f39794g[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int i2) {
        this.f39794g[this.f39795h - 1] = i2;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.k != null) {
            throw new IllegalStateException();
        } else if (this.f39795h != 0) {
            this.k = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private void g() throws IOException {
        if (this.k != null) {
            i();
            d(this.k);
            this.k = null;
        }
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        g();
        b(false);
        d(str);
        return this;
    }

    public c e() throws IOException {
        if (this.k != null) {
            if (this.f39792e) {
                g();
            } else {
                this.k = null;
                return this;
            }
        }
        b(false);
        this.f39793f.write("null");
        return this;
    }

    public c a(boolean z) throws IOException {
        g();
        b(false);
        this.f39793f.write(z ? "true" : "false");
        return this;
    }

    public c a(long j2) throws IOException {
        g();
        b(false);
        this.f39793f.write(Long.toString(j2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        g();
        String obj = number.toString();
        if (this.f39790c || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            b(false);
            this.f39793f.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
    }

    public void flush() throws IOException {
        if (this.f39795h != 0) {
            this.f39793f.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() throws IOException {
        this.f39793f.close();
        int i2 = this.f39795h;
        if (i2 > 1 || (i2 == 1 && this.f39794g[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f39795h = 0;
    }

    private void d(String str) throws IOException {
        String str2;
        String[] strArr = this.f39791d ? f39789b : f39788a;
        this.f39793f.write("\"");
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
                this.f39793f.write(str, i2, i3 - i2);
            }
            this.f39793f.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f39793f.write(str, i2, length - i2);
        }
        this.f39793f.write("\"");
    }

    private void h() throws IOException {
        if (this.f39796i != null) {
            this.f39793f.write(StringUtility.NEW_LINE);
            int i2 = this.f39795h;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f39793f.write(this.f39796i);
            }
        }
    }

    private void i() throws IOException {
        int f2 = f();
        if (f2 == 5) {
            this.f39793f.write(44);
        } else if (f2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        h();
        b(4);
    }

    private void b(boolean z) throws IOException {
        int f2 = f();
        if (f2 == 1) {
            b(2);
            h();
        } else if (f2 == 2) {
            this.f39793f.append(',');
            h();
        } else if (f2 != 4) {
            if (f2 != 6) {
                if (f2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f39790c) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            if (this.f39790c || z) {
                b(7);
                return;
            }
            throw new IllegalStateException("JSON must start with an array or an object.");
        } else {
            this.f39793f.append(this.j);
            b(5);
        }
    }
}
