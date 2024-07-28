package com.google.gsonhtcfix.d;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.b.a.d;
import com.google.gsonhtcfix.b.e;
import com.google.gsonhtcfix.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f39779a = ")]}'\n".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public boolean f39780b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Reader f39781c;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f39782d = new char[TarConstants.EOF_BLOCK];

    /* renamed from: e  reason: collision with root package name */
    private int f39783e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f39784f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f39785g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f39786h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f39787i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;

    static {
        e.f39751a = new e() {
            public final void a(a aVar) throws IOException {
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    dVar.a(b.NAME);
                    Map.Entry entry = (Map.Entry) ((Iterator) dVar.g()).next();
                    dVar.f39655a.add(entry.getValue());
                    dVar.f39655a.add(new s((String) entry.getKey()));
                    return;
                }
                int a2 = aVar.f39787i;
                if (a2 == 0) {
                    a2 = aVar.g();
                }
                if (a2 == 13) {
                    int unused = aVar.f39787i = 9;
                } else if (a2 == 12) {
                    int unused2 = aVar.f39787i = 8;
                } else if (a2 == 14) {
                    int unused3 = aVar.f39787i = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + "  at line " + a.c(aVar) + " column " + aVar.s());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr[i2] = 6;
        if (reader != null) {
            this.f39781c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public void a() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 3) {
            a(1);
            this.f39787i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public void b() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 4) {
            this.n--;
            this.f39787i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public void c() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 1) {
            a(3);
            this.f39787i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public void d() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 2) {
            this.n--;
            this.f39787i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public boolean e() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public int g() throws IOException {
        int a2;
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int a3 = a(true);
            if (a3 != 44) {
                if (a3 == 59) {
                    t();
                } else if (a3 == 93) {
                    this.f39787i = 4;
                    return 4;
                } else {
                    throw b("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            this.m[this.n - 1] = 4;
            if (i3 == 5 && (a2 = a(true)) != 44) {
                if (a2 == 59) {
                    t();
                } else if (a2 == 125) {
                    this.f39787i = 2;
                    return 2;
                } else {
                    throw b("Unterminated object");
                }
            }
            int a4 = a(true);
            if (a4 == 34) {
                this.f39787i = 13;
                return 13;
            } else if (a4 == 39) {
                t();
                this.f39787i = 12;
                return 12;
            } else if (a4 != 125) {
                t();
                this.f39783e--;
                if (a((char) a4)) {
                    this.f39787i = 14;
                    return 14;
                }
                throw b("Expected name");
            } else if (i3 != 5) {
                this.f39787i = 2;
                return 2;
            } else {
                throw b("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int a5 = a(true);
            if (a5 != 58) {
                if (a5 == 61) {
                    t();
                    if (this.f39783e < this.f39784f || b(1)) {
                        char[] cArr = this.f39782d;
                        int i4 = this.f39783e;
                        if (cArr[i4] == '>') {
                            this.f39783e = i4 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.f39780b) {
                w();
            }
            this.m[this.n - 1] = 7;
        } else if (i3 == 7) {
            if (a(false) == -1) {
                this.f39787i = 17;
                return 17;
            }
            t();
            this.f39783e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int a6 = a(true);
        if (a6 == 34) {
            if (this.n == 1) {
                t();
            }
            this.f39787i = 9;
            return 9;
        } else if (a6 != 39) {
            if (!(a6 == 44 || a6 == 59)) {
                if (a6 == 91) {
                    this.f39787i = 3;
                    return 3;
                } else if (a6 != 93) {
                    if (a6 != 123) {
                        this.f39783e--;
                        if (this.n == 1) {
                            t();
                        }
                        int p = p();
                        if (p != 0) {
                            return p;
                        }
                        int q = q();
                        if (q != 0) {
                            return q;
                        }
                        if (a(this.f39782d[this.f39783e])) {
                            t();
                            this.f39787i = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.f39787i = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f39787i = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                t();
                this.f39783e--;
                this.f39787i = 7;
                return 7;
            }
            throw b("Unexpected value");
        } else {
            t();
            this.f39787i = 8;
            return 8;
        }
    }

    private int p() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.f39782d[this.f39783e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f39783e + i3 >= this.f39784f && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.f39782d[this.f39783e + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f39783e + length < this.f39784f || b(length + 1)) && a(this.f39782d[this.f39783e + length])) {
            return 0;
        }
        this.f39783e += length;
        this.f39787i = i2;
        return i2;
    }

    private int q() throws IOException {
        char c2;
        char[] cArr = this.f39782d;
        int i2 = this.f39783e;
        int i3 = 0;
        int i4 = this.f39784f;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i4) {
                if (i5 != cArr.length) {
                    if (!b(i5 + 1)) {
                        break;
                    }
                    i2 = this.f39783e;
                    i4 = this.f39784f;
                } else {
                    return i3;
                }
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i3 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i3 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i3 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i3 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i3 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            int i6 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                            boolean z3 = i6 > 0 || (i6 == 0 && j3 < j2);
                            j2 = j3;
                            z = z3 & z;
                        } else if (c3 == 3) {
                            i3 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i3 = 0;
                            c3 = 7;
                        }
                        i3 = 0;
                    }
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && (j2 != Long.MIN_VALUE || z2)) {
            if (!z2) {
                j2 = -j2;
            }
            this.j = j2;
            this.f39783e += i5;
            this.f39787i = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.k = i5;
            this.f39787i = 16;
            return 16;
        }
    }

    private boolean a(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        t();
        return false;
    }

    public String h() throws IOException {
        String str;
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 14) {
            str = r();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
        this.f39787i = 0;
        return str;
    }

    public String i() throws IOException {
        String str;
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 10) {
            str = r();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.l;
            this.l = null;
        } else if (i2 == 15) {
            str = Long.toString(this.j);
        } else if (i2 == 16) {
            str = new String(this.f39782d, this.f39783e, this.k);
            this.f39783e += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
        this.f39787i = 0;
        return str;
    }

    public boolean j() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 5) {
            this.f39787i = 0;
            return true;
        } else if (i2 == 6) {
            this.f39787i = 0;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
    }

    public void k() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 7) {
            this.f39787i = 0;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public double l() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 15) {
            this.f39787i = 0;
            return (double) this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f39782d, this.f39783e, this.k);
            this.f39783e += this.k;
        } else if (i2 == 8 || i2 == 9) {
            this.l = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.l = r();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
        this.f39787i = 11;
        double parseDouble = Double.parseDouble(this.l);
        if (this.f39780b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.l = null;
            this.f39787i = 0;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public long m() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 15) {
            this.f39787i = 0;
            return this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f39782d, this.f39783e, this.k);
            this.f39783e += this.k;
        } else if (i2 == 8 || i2 == 9) {
            this.l = b(i2 == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.l);
                this.f39787i = 0;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
        this.f39787i = 11;
        double parseDouble = Double.parseDouble(this.l);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.l = null;
            this.f39787i = 0;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.l + " at line " + (this.f39785g + 1) + " column " + s());
    }

    private String b(char c2) throws IOException {
        char[] cArr = this.f39782d;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = this.f39783e;
            int i3 = this.f39784f;
            int i4 = i2;
            while (true) {
                if (i4 < i3) {
                    int i5 = i4 + 1;
                    char c3 = cArr[i4];
                    if (c3 == c2) {
                        this.f39783e = i5;
                        sb.append(cArr, i2, (i5 - i2) - 1);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f39783e = i5;
                        sb.append(cArr, i2, (i5 - i2) - 1);
                        sb.append(v());
                        break;
                    } else {
                        if (c3 == 10) {
                            this.f39785g++;
                            this.f39786h = i5;
                        }
                        i4 = i5;
                    }
                } else {
                    sb.append(cArr, i2, i4 - i2);
                    this.f39783e = i4;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        t();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String r() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            r1 = 0
        L_0x0004:
            int r3 = r6.f39783e
            int r4 = r3 + r1
            int r5 = r6.f39784f
            if (r4 >= r5) goto L_0x004f
            char[] r4 = r6.f39782d
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005d
            r4 = 10
            if (r3 == r4) goto L_0x005d
            r4 = 12
            if (r3 == r4) goto L_0x005d
            r4 = 13
            if (r3 == r4) goto L_0x005d
            r4 = 32
            if (r3 == r4) goto L_0x005d
            r4 = 35
            if (r3 == r4) goto L_0x004b
            r4 = 44
            if (r3 == r4) goto L_0x005d
            r4 = 47
            if (r3 == r4) goto L_0x004b
            r4 = 61
            if (r3 == r4) goto L_0x004b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 58
            if (r3 == r4) goto L_0x005d
            r4 = 59
            if (r3 == r4) goto L_0x004b
            switch(r3) {
                case 91: goto L_0x005d;
                case 92: goto L_0x004b;
                case 93: goto L_0x005d;
                default: goto L_0x0048;
            }
        L_0x0048:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x004b:
            r6.t()
            goto L_0x005d
        L_0x004f:
            char[] r3 = r6.f39782d
            int r3 = r3.length
            if (r1 >= r3) goto L_0x005f
            int r3 = r1 + 1
            boolean r3 = r6.b((int) r3)
            if (r3 == 0) goto L_0x005d
            goto L_0x0004
        L_0x005d:
            r0 = r1
            goto L_0x0079
        L_0x005f:
            if (r2 != 0) goto L_0x0066
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L_0x0066:
            char[] r3 = r6.f39782d
            int r4 = r6.f39783e
            r2.append(r3, r4, r1)
            int r3 = r6.f39783e
            int r3 = r3 + r1
            r6.f39783e = r3
            r1 = 1
            boolean r1 = r6.b((int) r1)
            if (r1 != 0) goto L_0x0003
        L_0x0079:
            if (r2 != 0) goto L_0x0085
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f39782d
            int r3 = r6.f39783e
            r1.<init>(r2, r3, r0)
            goto L_0x0090
        L_0x0085:
            char[] r1 = r6.f39782d
            int r3 = r6.f39783e
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L_0x0090:
            int r2 = r6.f39783e
            int r2 = r2 + r0
            r6.f39783e = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.d.a.r():java.lang.String");
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f39782d;
        while (true) {
            int i2 = this.f39783e;
            int i3 = this.f39784f;
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f39783e = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.f39783e = i4;
                        v();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.f39785g++;
                            this.f39786h = i4;
                        }
                        i2 = i4;
                    }
                } else {
                    this.f39783e = i2;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    public int n() throws IOException {
        int i2 = this.f39787i;
        if (i2 == 0) {
            i2 = g();
        }
        if (i2 == 15) {
            long j2 = this.j;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.f39787i = 0;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + " at line " + (this.f39785g + 1) + " column " + s());
        }
        if (i2 == 16) {
            this.l = new String(this.f39782d, this.f39783e, this.k);
            this.f39783e += this.k;
        } else if (i2 == 8 || i2 == 9) {
            this.l = b(i2 == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.l);
                this.f39787i = 0;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + " at line " + (this.f39785g + 1) + " column " + s());
        }
        this.f39787i = 11;
        double parseDouble = Double.parseDouble(this.l);
        int i4 = (int) parseDouble;
        if (((double) i4) == parseDouble) {
            this.l = null;
            this.f39787i = 0;
            return i4;
        }
        throw new NumberFormatException("Expected an int but was " + this.l + " at line " + (this.f39785g + 1) + " column " + s());
    }

    public void close() throws IOException {
        this.f39787i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f39781c.close();
    }

    public void o() throws IOException {
        int i2;
        int i3 = 0;
        do {
            int i4 = this.f39787i;
            if (i4 == 0) {
                i4 = g();
            }
            if (i4 == 3) {
                a(1);
            } else if (i4 == 1) {
                a(3);
            } else {
                if (i4 == 4) {
                    this.n--;
                } else if (i4 == 2) {
                    this.n--;
                } else if (i4 == 14 || i4 == 10) {
                    while (true) {
                        i2 = 0;
                        while (true) {
                            int i5 = this.f39783e;
                            if (i5 + i2 < this.f39784f) {
                                char c2 = this.f39782d[i5 + i2];
                                if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (!(c2 == '/' || c2 == '=')) {
                                                if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.f39783e = i5 + i2;
                                if (!b(1)) {
                                }
                            }
                        }
                    }
                    t();
                    this.f39783e += i2;
                    this.f39787i = 0;
                } else if (i4 == 8 || i4 == 12) {
                    c('\'');
                    this.f39787i = 0;
                } else if (i4 == 9 || i4 == 13) {
                    c('\"');
                    this.f39787i = 0;
                } else {
                    if (i4 == 16) {
                        this.f39783e += this.k;
                    }
                    this.f39787i = 0;
                }
                i3--;
                this.f39787i = 0;
            }
            i3++;
            this.f39787i = 0;
        } while (i3 != 0);
    }

    private void a(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.m = iArr2;
        }
        int[] iArr3 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr3[i4] = i2;
    }

    private boolean b(int i2) throws IOException {
        int i3;
        char[] cArr = this.f39782d;
        int i4 = this.f39786h;
        int i5 = this.f39783e;
        this.f39786h = i4 - i5;
        int i6 = this.f39784f;
        if (i6 != i5) {
            this.f39784f = i6 - i5;
            System.arraycopy(cArr, i5, cArr, 0, this.f39784f);
        } else {
            this.f39784f = 0;
        }
        this.f39783e = 0;
        do {
            Reader reader = this.f39781c;
            int i7 = this.f39784f;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            this.f39784f += read;
            if (this.f39785g == 0 && (i3 = this.f39786h) == 0 && this.f39784f > 0 && cArr[0] == 65279) {
                this.f39783e++;
                this.f39786h = i3 + 1;
                i2++;
            }
        } while (this.f39784f < i2);
        return true;
    }

    /* access modifiers changed from: private */
    public int s() {
        return (this.f39783e - this.f39786h) + 1;
    }

    private int a(boolean z) throws IOException {
        char[] cArr = this.f39782d;
        int i2 = this.f39783e;
        int i3 = this.f39784f;
        while (true) {
            if (i2 == i3) {
                this.f39783e = i2;
                if (b(1)) {
                    i2 = this.f39783e;
                    i3 = this.f39784f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + (this.f39785g + 1) + " column " + s());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.f39785g++;
                this.f39786h = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.f39783e = i4;
                    if (i4 == i3) {
                        this.f39783e--;
                        boolean b2 = b(2);
                        this.f39783e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    t();
                    int i5 = this.f39783e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f39783e = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f39783e + 2;
                            i3 = this.f39784f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f39783e = i5 + 1;
                        u();
                        i2 = this.f39783e;
                        i3 = this.f39784f;
                    }
                } else if (c2 == '#') {
                    this.f39783e = i4;
                    t();
                    u();
                    i2 = this.f39783e;
                    i3 = this.f39784f;
                } else {
                    this.f39783e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void t() throws IOException {
        if (!this.f39780b) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void u() throws IOException {
        char c2;
        do {
            if (this.f39783e < this.f39784f || b(1)) {
                char[] cArr = this.f39782d;
                int i2 = this.f39783e;
                this.f39783e = i2 + 1;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.f39785g++;
                    this.f39786h = this.f39783e;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    private boolean a(String str) throws IOException {
        while (true) {
            int i2 = 0;
            if (this.f39783e + str.length() > this.f39784f && !b(str.length())) {
                return false;
            }
            char[] cArr = this.f39782d;
            int i3 = this.f39783e;
            if (cArr[i3] == 10) {
                this.f39785g++;
                this.f39786h = i3 + 1;
            } else {
                while (i2 < str.length()) {
                    if (this.f39782d[this.f39783e + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.f39783e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + (this.f39785g + 1) + " column " + s();
    }

    private char v() throws IOException {
        int i2;
        int i3;
        if (this.f39783e != this.f39784f || b(1)) {
            char[] cArr = this.f39782d;
            int i4 = this.f39783e;
            this.f39783e = i4 + 1;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.f39785g++;
                this.f39786h = this.f39783e;
            } else if (c2 == 'b') {
                return 8;
            } else {
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 == 'u') {
                    if (this.f39783e + 4 <= this.f39784f || b(4)) {
                        char c3 = 0;
                        int i5 = this.f39783e;
                        int i6 = i5 + 4;
                        while (i5 < i6) {
                            char c4 = this.f39782d[i5];
                            char c5 = (char) (c3 << 4);
                            if (c4 < '0' || c4 > '9') {
                                if (c4 >= 'a' && c4 <= 'f') {
                                    i2 = c4 - 'a';
                                } else if (c4 < 'A' || c4 > 'F') {
                                    throw new NumberFormatException("\\u" + new String(this.f39782d, this.f39783e, 4));
                                } else {
                                    i2 = c4 - 'A';
                                }
                                i3 = i2 + 10;
                            } else {
                                i3 = c4 - '0';
                            }
                            c3 = (char) (c5 + i3);
                            i5++;
                        }
                        this.f39783e += 4;
                        return c3;
                    }
                    throw b("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw b("Unterminated escape sequence");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + " at line " + (this.f39785g + 1) + " column " + s());
    }

    private void w() throws IOException {
        a(true);
        this.f39783e--;
        int i2 = this.f39783e;
        char[] cArr = f39779a;
        if (i2 + cArr.length <= this.f39784f || b(cArr.length)) {
            int i3 = 0;
            while (true) {
                char[] cArr2 = f39779a;
                if (i3 >= cArr2.length) {
                    this.f39783e += cArr2.length;
                    return;
                } else if (this.f39782d[this.f39783e + i3] == cArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    static /* synthetic */ int c(a aVar) {
        return aVar.f39785g + 1;
    }
}
