package com.alibaba.a.b;

import com.alibaba.a.a;
import com.alibaba.a.d;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class e implements d, Closeable {
    protected static final char[] n = ("\"" + a.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static boolean[] o;
    protected static final int[] p = new int[103];
    private static final Map<String, Integer> q;
    private static final ThreadLocal<SoftReference<char[]>> r = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    protected int f6230a;

    /* renamed from: b  reason: collision with root package name */
    protected int f6231b;

    /* renamed from: c  reason: collision with root package name */
    protected int f6232c = a.DEFAULT_PARSER_FEATURE;

    /* renamed from: d  reason: collision with root package name */
    protected char f6233d;

    /* renamed from: e  reason: collision with root package name */
    protected int f6234e;

    /* renamed from: f  reason: collision with root package name */
    protected int f6235f;

    /* renamed from: g  reason: collision with root package name */
    protected char[] f6236g;

    /* renamed from: h  reason: collision with root package name */
    protected int f6237h;

    /* renamed from: i  reason: collision with root package name */
    protected int f6238i;
    protected boolean j;
    protected Calendar k = null;
    public int l = 0;
    protected Map<String, Integer> m = q;

    private static boolean e(char c2) {
        return c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8;
    }

    public abstract String a(int i2, int i3);

    public abstract String a(int i2, int i3, int i4, j jVar);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, int i3, char[] cArr);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, char[] cArr, int i3);

    public abstract char b(int i2);

    public abstract int c(int i2);

    public abstract char f();

    public abstract String l();

    public abstract String u();

    public abstract boolean x();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("null", 8);
        hashMap.put("new", 9);
        hashMap.put("true", 6);
        hashMap.put("false", 7);
        hashMap.put("undefined", 23);
        q = hashMap;
        boolean[] zArr = new boolean[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        o = zArr;
        zArr[32] = true;
        boolean[] zArr2 = o;
        zArr2[10] = true;
        zArr2[13] = true;
        zArr2[9] = true;
        zArr2[12] = true;
        zArr2[8] = true;
        for (int i2 = 48; i2 <= 57; i2++) {
            p[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            p[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            p[i4] = (i4 - 65) + 10;
        }
    }

    public e() {
        SoftReference softReference = r.get();
        if (softReference != null) {
            this.f6236g = (char[]) softReference.get();
            r.set((Object) null);
        }
        if (this.f6236g == null) {
            this.f6236g = new char[64];
        }
    }

    public final void d() {
        this.f6237h = 0;
        while (true) {
            this.f6231b = this.f6234e;
            char c2 = this.f6233d;
            if (c2 == '\"') {
                m();
                return;
            } else if (c2 == ',') {
                f();
                this.f6230a = 16;
                return;
            } else if (c2 < '0' || c2 > '9') {
                char c3 = this.f6233d;
                if (c3 == '-') {
                    h();
                    return;
                }
                if (!(c3 == 12 || c3 == 13 || c3 == ' ')) {
                    if (c3 == ':') {
                        f();
                        this.f6230a = 17;
                        return;
                    } else if (c3 == '[') {
                        f();
                        this.f6230a = 14;
                        return;
                    } else if (c3 == ']') {
                        f();
                        this.f6230a = 15;
                        return;
                    } else if (c3 != 'f') {
                        if (c3 != 'n') {
                            if (c3 == '{') {
                                f();
                                this.f6230a = 12;
                                return;
                            } else if (c3 == '}') {
                                f();
                                this.f6230a = 13;
                                return;
                            } else if (c3 != 'S') {
                                if (c3 != 'T') {
                                    if (c3 != 't') {
                                        if (c3 != 'u') {
                                            switch (c3) {
                                                case 8:
                                                case 9:
                                                case 10:
                                                    break;
                                                default:
                                                    switch (c3) {
                                                        case '\'':
                                                            if (a(c.AllowSingleQuotes)) {
                                                                this.f6238i = this.f6234e;
                                                                this.j = false;
                                                                while (true) {
                                                                    char f2 = f();
                                                                    if (f2 == '\'') {
                                                                        this.f6230a = 4;
                                                                        f();
                                                                        return;
                                                                    } else if (f2 == 26) {
                                                                        throw new d("unclosed single-quote string");
                                                                    } else if (f2 == '\\') {
                                                                        if (!this.j) {
                                                                            this.j = true;
                                                                            int i2 = this.f6237h;
                                                                            char[] cArr = this.f6236g;
                                                                            if (i2 > cArr.length) {
                                                                                char[] cArr2 = new char[(i2 * 2)];
                                                                                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                                                                                this.f6236g = cArr2;
                                                                            }
                                                                            a(this.f6238i + 1, this.f6237h, this.f6236g);
                                                                        }
                                                                        char f3 = f();
                                                                        if (f3 == '\"') {
                                                                            d('\"');
                                                                        } else if (f3 != '\'') {
                                                                            if (f3 != 'F') {
                                                                                if (f3 == '\\') {
                                                                                    d('\\');
                                                                                } else if (f3 == 'b') {
                                                                                    d(8);
                                                                                } else if (f3 != 'f') {
                                                                                    if (f3 == 'n') {
                                                                                        d(10);
                                                                                    } else if (f3 == 'r') {
                                                                                        d(13);
                                                                                    } else if (f3 != 'x') {
                                                                                        switch (f3) {
                                                                                            case '/':
                                                                                                d('/');
                                                                                                break;
                                                                                            case '0':
                                                                                                d(0);
                                                                                                break;
                                                                                            case '1':
                                                                                                d(1);
                                                                                                break;
                                                                                            case '2':
                                                                                                d(2);
                                                                                                break;
                                                                                            case '3':
                                                                                                d(3);
                                                                                                break;
                                                                                            case '4':
                                                                                                d(4);
                                                                                                break;
                                                                                            case '5':
                                                                                                d(5);
                                                                                                break;
                                                                                            case '6':
                                                                                                d(6);
                                                                                                break;
                                                                                            case '7':
                                                                                                d(7);
                                                                                                break;
                                                                                            default:
                                                                                                switch (f3) {
                                                                                                    case 't':
                                                                                                        d(9);
                                                                                                        break;
                                                                                                    case 'u':
                                                                                                        d((char) Integer.parseInt(new String(new char[]{f(), f(), f(), f()}), 16));
                                                                                                        break;
                                                                                                    case 'v':
                                                                                                        d(11);
                                                                                                        break;
                                                                                                    default:
                                                                                                        this.f6233d = f3;
                                                                                                        throw new d("unclosed single-quote string");
                                                                                                }
                                                                                        }
                                                                                    } else {
                                                                                        char f4 = f();
                                                                                        char f5 = f();
                                                                                        int[] iArr = p;
                                                                                        d((char) ((iArr[f4] * 16) + iArr[f5]));
                                                                                    }
                                                                                }
                                                                            }
                                                                            d(12);
                                                                        } else {
                                                                            d('\'');
                                                                        }
                                                                    } else if (!this.j) {
                                                                        this.f6237h++;
                                                                    } else {
                                                                        int i3 = this.f6237h;
                                                                        char[] cArr3 = this.f6236g;
                                                                        if (i3 == cArr3.length) {
                                                                            d(f2);
                                                                        } else {
                                                                            this.f6237h = i3 + 1;
                                                                            cArr3[i3] = f2;
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                throw new d("Feature.AllowSingleQuotes is false");
                                                            }
                                                        case '(':
                                                            f();
                                                            this.f6230a = 10;
                                                            return;
                                                        case ')':
                                                            f();
                                                            this.f6230a = 11;
                                                            return;
                                                        default:
                                                            if (!x()) {
                                                                new Object[1][0] = String.valueOf(this.f6233d);
                                                                this.f6230a = 1;
                                                                f();
                                                                return;
                                                            } else if (this.f6230a != 20) {
                                                                this.f6230a = 20;
                                                                int i4 = this.f6235f;
                                                                this.f6234e = i4;
                                                                this.f6231b = i4;
                                                                return;
                                                            } else {
                                                                throw new d("EOF error");
                                                            }
                                                    }
                                            }
                                        } else if (c3 == 'u') {
                                            f();
                                            if (this.f6233d == 'n') {
                                                f();
                                                if (this.f6233d == 'd') {
                                                    f();
                                                    if (this.f6233d == 'e') {
                                                        f();
                                                        if (this.f6233d == 'f') {
                                                            f();
                                                            if (this.f6233d == 'i') {
                                                                f();
                                                                if (this.f6233d == 'n') {
                                                                    f();
                                                                    if (this.f6233d == 'e') {
                                                                        f();
                                                                        if (this.f6233d == 'd') {
                                                                            f();
                                                                            char c4 = this.f6233d;
                                                                            if (c4 == ' ' || c4 == ',' || c4 == '}' || c4 == ']' || c4 == 10 || c4 == 13 || c4 == 9 || c4 == 26 || c4 == 12 || c4 == 8) {
                                                                                this.f6230a = 23;
                                                                                return;
                                                                            }
                                                                            throw new d("scan false error");
                                                                        }
                                                                        throw new d("error parse false");
                                                                    }
                                                                    throw new d("error parse false");
                                                                }
                                                                throw new d("error parse false");
                                                            }
                                                            throw new d("error parse false");
                                                        }
                                                        throw new d("error parse false");
                                                    }
                                                    throw new d("error parse false");
                                                }
                                                throw new d("error parse false");
                                            }
                                            throw new d("error parse false");
                                        } else {
                                            throw new d("error parse false");
                                        }
                                    } else if (c3 == 't') {
                                        f();
                                        if (this.f6233d == 'r') {
                                            f();
                                            if (this.f6233d == 'u') {
                                                f();
                                                if (this.f6233d == 'e') {
                                                    f();
                                                    char c5 = this.f6233d;
                                                    if (c5 == ' ' || c5 == ',' || c5 == '}' || c5 == ']' || c5 == 10 || c5 == 13 || c5 == 9 || c5 == 26 || c5 == 12 || c5 == 8 || c5 == ':') {
                                                        this.f6230a = 6;
                                                        return;
                                                    }
                                                    throw new d("scan true error");
                                                }
                                                throw new d("error parse true");
                                            }
                                            throw new d("error parse true");
                                        }
                                        throw new d("error parse true");
                                    } else {
                                        throw new d("error parse true");
                                    }
                                } else if (c3 == 'T') {
                                    f();
                                    if (this.f6233d == 'r') {
                                        f();
                                        if (this.f6233d == 'e') {
                                            f();
                                            if (this.f6233d == 'e') {
                                                f();
                                                if (this.f6233d == 'S') {
                                                    f();
                                                    if (this.f6233d == 'e') {
                                                        f();
                                                        if (this.f6233d == 't') {
                                                            f();
                                                            char c6 = this.f6233d;
                                                            if (c6 == ' ' || c6 == 10 || c6 == 13 || c6 == 9 || c6 == 12 || c6 == 8 || c6 == '[' || c6 == '(') {
                                                                this.f6230a = 22;
                                                                return;
                                                            }
                                                            throw new d("scan set error");
                                                        }
                                                        throw new d("error parse true");
                                                    }
                                                    throw new d("error parse true");
                                                }
                                                throw new d("error parse true");
                                            }
                                            throw new d("error parse true");
                                        }
                                        throw new d("error parse true");
                                    }
                                    throw new d("error parse true");
                                } else {
                                    throw new d("error parse true");
                                }
                            } else if (c3 == 'S') {
                                f();
                                if (this.f6233d == 'e') {
                                    f();
                                    if (this.f6233d == 't') {
                                        f();
                                        char c7 = this.f6233d;
                                        if (c7 == ' ' || c7 == 10 || c7 == 13 || c7 == 9 || c7 == 12 || c7 == 8 || c7 == '[' || c7 == '(') {
                                            this.f6230a = 21;
                                            return;
                                        }
                                        throw new d("scan set error");
                                    }
                                    throw new d("error parse true");
                                }
                                throw new d("error parse true");
                            } else {
                                throw new d("error parse true");
                            }
                        } else if (c3 == 'n') {
                            f();
                            char c8 = this.f6233d;
                            if (c8 == 'u') {
                                f();
                                if (this.f6233d == 'l') {
                                    f();
                                    if (this.f6233d == 'l') {
                                        f();
                                        char c9 = this.f6233d;
                                        if (c9 == ' ' || c9 == ',' || c9 == '}' || c9 == ']' || c9 == 10 || c9 == 13 || c9 == 9 || c9 == 26 || c9 == 12 || c9 == 8) {
                                            this.f6230a = 8;
                                            return;
                                        }
                                        throw new d("scan true error");
                                    }
                                    throw new d("error parse true");
                                }
                                throw new d("error parse true");
                            } else if (c8 == 'e') {
                                f();
                                if (this.f6233d == 'w') {
                                    f();
                                    char c10 = this.f6233d;
                                    if (c10 == ' ' || c10 == ',' || c10 == '}' || c10 == ']' || c10 == 10 || c10 == 13 || c10 == 9 || c10 == 26 || c10 == 12 || c10 == 8) {
                                        this.f6230a = 9;
                                        return;
                                    }
                                    throw new d("scan true error");
                                }
                                throw new d("error parse w");
                            } else {
                                throw new d("error parse e");
                            }
                        } else {
                            throw new d("error parse null or new");
                        }
                    } else if (c3 == 'f') {
                        f();
                        if (this.f6233d == 'a') {
                            f();
                            if (this.f6233d == 'l') {
                                f();
                                if (this.f6233d == 's') {
                                    f();
                                    if (this.f6233d == 'e') {
                                        f();
                                        char c11 = this.f6233d;
                                        if (c11 == ' ' || c11 == ',' || c11 == '}' || c11 == ']' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 26 || c11 == 12 || c11 == 8 || c11 == ':') {
                                            this.f6230a = 7;
                                            return;
                                        }
                                        throw new d("scan false error");
                                    }
                                    throw new d("error parse false");
                                }
                                throw new d("error parse false");
                            }
                            throw new d("error parse false");
                        }
                        throw new d("error parse false");
                    } else {
                        throw new d("error parse false");
                    }
                }
                f();
            } else {
                h();
                return;
            }
        }
    }

    public final void a(int i2) {
        this.f6237h = 0;
        while (true) {
            if (i2 == 2) {
                char c2 = this.f6233d;
                if (c2 < '0' || c2 > '9') {
                    char c3 = this.f6233d;
                    if (c3 == '\"') {
                        this.f6231b = this.f6234e;
                        m();
                        return;
                    } else if (c3 == '[') {
                        this.f6230a = 14;
                        f();
                        return;
                    } else if (c3 == '{') {
                        this.f6230a = 12;
                        f();
                        return;
                    }
                } else {
                    this.f6231b = this.f6234e;
                    h();
                    return;
                }
            } else if (i2 == 4) {
                char c4 = this.f6233d;
                if (c4 == '\"') {
                    this.f6231b = this.f6234e;
                    m();
                    return;
                } else if (c4 < '0' || c4 > '9') {
                    char c5 = this.f6233d;
                    if (c5 == '[') {
                        this.f6230a = 14;
                        f();
                        return;
                    } else if (c5 == '{') {
                        this.f6230a = 12;
                        f();
                        return;
                    }
                } else {
                    this.f6231b = this.f6234e;
                    h();
                    return;
                }
            } else if (i2 == 12) {
                char c6 = this.f6233d;
                if (c6 == '{') {
                    this.f6230a = 12;
                    f();
                    return;
                } else if (c6 == '[') {
                    this.f6230a = 14;
                    f();
                    return;
                }
            } else if (i2 != 18) {
                if (i2 != 20) {
                    switch (i2) {
                        case 14:
                            char c7 = this.f6233d;
                            if (c7 == '[') {
                                this.f6230a = 14;
                                f();
                                return;
                            } else if (c7 == '{') {
                                this.f6230a = 12;
                                f();
                                return;
                            }
                            break;
                        case 15:
                            if (this.f6233d == ']') {
                                this.f6230a = 15;
                                f();
                                return;
                            }
                            break;
                        case 16:
                            char c8 = this.f6233d;
                            if (c8 == ',') {
                                this.f6230a = 16;
                                f();
                                return;
                            } else if (c8 == '}') {
                                this.f6230a = 13;
                                f();
                                return;
                            } else if (c8 == ']') {
                                this.f6230a = 15;
                                f();
                                return;
                            } else if (c8 == 26) {
                                this.f6230a = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.f6233d == 26) {
                    this.f6230a = 20;
                    return;
                }
            } else {
                while (e(this.f6233d)) {
                    f();
                }
                char c9 = this.f6233d;
                if (c9 == '_' || Character.isLetter(c9)) {
                    this.f6238i = this.f6234e - 1;
                    this.j = false;
                    do {
                        this.f6237h++;
                        f();
                    } while (Character.isLetterOrDigit(this.f6233d));
                    Integer num = this.m.get(l());
                    if (num != null) {
                        this.f6230a = num.intValue();
                        return;
                    } else {
                        this.f6230a = 18;
                        return;
                    }
                } else {
                    d();
                    return;
                }
            }
            char c10 = this.f6233d;
            if (c10 == ' ' || c10 == 10 || c10 == 13 || c10 == 9 || c10 == 12 || c10 == 8) {
                f();
            } else {
                d();
                return;
            }
        }
    }

    public final void o() {
        z();
    }

    private void z() {
        this.f6237h = 0;
        while (true) {
            char c2 = this.f6233d;
            if (c2 == ':') {
                f();
                d();
                return;
            } else if (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8) {
                f();
            } else {
                throw new d("not match : - " + this.f6233d);
            }
        }
    }

    public final int a() {
        return this.f6230a;
    }

    public final String b() {
        return g.a(this.f6230a);
    }

    public final int i() {
        return this.f6231b;
    }

    public final int r() {
        return this.f6234e;
    }

    private String A() {
        if (a(c.InitStringFieldAsEmpty)) {
            return "";
        }
        return null;
    }

    public final Number j() throws NumberFormatException {
        long j2;
        long j3;
        boolean z = false;
        if (this.f6238i == -1) {
            this.f6238i = 0;
        }
        int i2 = this.f6238i;
        int i3 = this.f6237h + i2;
        char c2 = ' ';
        char b2 = b(i3 - 1);
        if (b2 == 'B') {
            i3--;
            c2 = 'B';
        } else if (b2 == 'L') {
            i3--;
            c2 = 'L';
        } else if (b2 == 'S') {
            i3--;
            c2 = 'S';
        }
        if (b(this.f6238i) == '-') {
            j2 = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j2 = -9223372036854775807L;
        }
        if (i2 < i3) {
            j3 = (long) (-p[b(i2)]);
            i2++;
        } else {
            j3 = 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            int i5 = p[b(i2)];
            if (j3 < -922337203685477580L) {
                return new BigInteger(u());
            }
            long j4 = j3 * 10;
            int i6 = i4;
            long j5 = (long) i5;
            if (j4 < j2 + j5) {
                return new BigInteger(u());
            }
            j3 = j4 - j5;
            i2 = i6;
        }
        if (!z) {
            long j6 = -j3;
            if (j6 > 2147483647L || c2 == 'L') {
                return Long.valueOf(j6);
            }
            if (c2 == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i2 <= this.f6238i + 1) {
            throw new NumberFormatException(u());
        } else if (j3 < -2147483648L || c2 == 'L') {
            return Long.valueOf(j3);
        } else {
            if (c2 == 'S') {
                return Short.valueOf((short) ((int) j3));
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) ((int) j3));
            }
            return Integer.valueOf((int) j3);
        }
    }

    public final void p() {
        z();
    }

    public final float w() {
        return Float.parseFloat(u());
    }

    public final boolean a(c cVar) {
        return c.isEnabled(this.f6232c, cVar);
    }

    public final char e() {
        return this.f6233d;
    }

    public final String a(j jVar) {
        c();
        char c2 = this.f6233d;
        if (c2 == '\"') {
            return a(jVar, '\"');
        }
        if (c2 == '\'') {
            if (a(c.AllowSingleQuotes)) {
                return a(jVar, '\'');
            }
            throw new d("syntax error");
        } else if (c2 == '}') {
            f();
            this.f6230a = 13;
            return null;
        } else if (c2 == ',') {
            f();
            this.f6230a = 16;
            return null;
        } else if (c2 == 26) {
            this.f6230a = 20;
            return null;
        } else if (a(c.AllowUnQuotedFieldNames)) {
            return b(jVar);
        } else {
            throw new d("syntax error");
        }
    }

    public final String a(j jVar, char c2) {
        String str;
        this.f6238i = this.f6234e;
        this.f6237h = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            char f2 = f();
            if (f2 == c2) {
                this.f6230a = 4;
                if (!z) {
                    int i3 = this.f6238i;
                    str = a(i3 == -1 ? 0 : i3 + 1, this.f6237h, i2, jVar);
                } else {
                    str = jVar.a(this.f6236g, this.f6237h, i2);
                }
                this.f6237h = 0;
                f();
                return str;
            } else if (f2 == 26) {
                throw new d("unclosed.str");
            } else if (f2 == '\\') {
                if (!z) {
                    int i4 = this.f6237h;
                    char[] cArr = this.f6236g;
                    if (i4 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i4 <= length) {
                            i4 = length;
                        }
                        char[] cArr2 = new char[i4];
                        char[] cArr3 = this.f6236g;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.f6236g = cArr2;
                    }
                    a(this.f6238i + 1, this.f6236g, this.f6237h);
                    z = true;
                }
                char f3 = f();
                if (f3 == '\"') {
                    i2 = (i2 * 31) + 34;
                    d('\"');
                } else if (f3 != '\'') {
                    if (f3 != 'F') {
                        if (f3 == '\\') {
                            i2 = (i2 * 31) + 92;
                            d('\\');
                        } else if (f3 == 'b') {
                            i2 = (i2 * 31) + 8;
                            d(8);
                        } else if (f3 != 'f') {
                            if (f3 == 'n') {
                                i2 = (i2 * 31) + 10;
                                d(10);
                            } else if (f3 == 'r') {
                                i2 = (i2 * 31) + 13;
                                d(13);
                            } else if (f3 != 'x') {
                                switch (f3) {
                                    case '/':
                                        i2 = (i2 * 31) + 47;
                                        d('/');
                                        break;
                                    case '0':
                                        i2 = (i2 * 31) + f3;
                                        d(0);
                                        break;
                                    case '1':
                                        i2 = (i2 * 31) + f3;
                                        d(1);
                                        break;
                                    case '2':
                                        i2 = (i2 * 31) + f3;
                                        d(2);
                                        break;
                                    case '3':
                                        i2 = (i2 * 31) + f3;
                                        d(3);
                                        break;
                                    case '4':
                                        i2 = (i2 * 31) + f3;
                                        d(4);
                                        break;
                                    case '5':
                                        i2 = (i2 * 31) + f3;
                                        d(5);
                                        break;
                                    case '6':
                                        i2 = (i2 * 31) + f3;
                                        d(6);
                                        break;
                                    case '7':
                                        i2 = (i2 * 31) + f3;
                                        d(7);
                                        break;
                                    default:
                                        switch (f3) {
                                            case 't':
                                                i2 = (i2 * 31) + 9;
                                                d(9);
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{f(), f(), f(), f()}), 16);
                                                i2 = (i2 * 31) + parseInt;
                                                d((char) parseInt);
                                                break;
                                            case 'v':
                                                i2 = (i2 * 31) + 11;
                                                d(11);
                                                break;
                                            default:
                                                this.f6233d = f3;
                                                throw new d("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char f4 = f();
                                this.f6233d = f4;
                                char f5 = f();
                                this.f6233d = f5;
                                int[] iArr = p;
                                char c3 = (char) ((iArr[f4] * 16) + iArr[f5]);
                                i2 = (i2 * 31) + c3;
                                d(c3);
                            }
                        }
                    }
                    i2 = (i2 * 31) + 12;
                    d(12);
                } else {
                    i2 = (i2 * 31) + 39;
                    d('\'');
                }
            } else {
                i2 = (i2 * 31) + f2;
                if (!z) {
                    this.f6237h++;
                } else {
                    int i5 = this.f6237h;
                    char[] cArr4 = this.f6236g;
                    if (i5 == cArr4.length) {
                        d(f2);
                    } else {
                        this.f6237h = i5 + 1;
                        cArr4[i5] = f2;
                    }
                }
            }
        }
    }

    public final void g() {
        this.f6237h = 0;
    }

    public final String b(j jVar) {
        boolean[] zArr = com.alibaba.a.d.d.f6360b;
        int i2 = this.f6233d;
        if (i2 >= zArr.length || zArr[i2]) {
            boolean[] zArr2 = com.alibaba.a.d.d.f6361c;
            this.f6238i = this.f6234e;
            this.f6237h = 1;
            while (true) {
                char f2 = f();
                if (f2 < zArr2.length && !zArr2[f2]) {
                    break;
                }
                i2 = (i2 * 31) + f2;
                this.f6237h++;
            }
            this.f6233d = b(this.f6234e);
            this.f6230a = 18;
            if (this.f6237h == 4 && i2 == 3392903 && b(this.f6238i) == 'n' && b(this.f6238i + 1) == 'u' && b(this.f6238i + 2) == 'l' && b(this.f6238i + 3) == 'l') {
                return null;
            }
            return a(this.f6238i, this.f6237h, i2, jVar);
        }
        throw new d("illegal identifier : " + this.f6233d);
    }

    public final void m() {
        this.f6238i = this.f6234e;
        this.j = false;
        while (true) {
            char f2 = f();
            if (f2 == '\"') {
                this.f6230a = 4;
                this.f6233d = f();
                return;
            } else if (f2 == 26) {
                throw new d("unclosed string : ".concat(String.valueOf(f2)));
            } else if (f2 == '\\') {
                if (!this.j) {
                    this.j = true;
                    int i2 = this.f6237h;
                    char[] cArr = this.f6236g;
                    if (i2 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i2 <= length) {
                            i2 = length;
                        }
                        char[] cArr2 = new char[i2];
                        char[] cArr3 = this.f6236g;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.f6236g = cArr2;
                    }
                    a(this.f6238i + 1, this.f6237h, this.f6236g);
                }
                char f3 = f();
                if (f3 == '\"') {
                    d('\"');
                } else if (f3 != '\'') {
                    if (f3 != 'F') {
                        if (f3 == '\\') {
                            d('\\');
                        } else if (f3 == 'b') {
                            d(8);
                        } else if (f3 != 'f') {
                            if (f3 == 'n') {
                                d(10);
                            } else if (f3 == 'r') {
                                d(13);
                            } else if (f3 != 'x') {
                                switch (f3) {
                                    case '/':
                                        d('/');
                                        break;
                                    case '0':
                                        d(0);
                                        break;
                                    case '1':
                                        d(1);
                                        break;
                                    case '2':
                                        d(2);
                                        break;
                                    case '3':
                                        d(3);
                                        break;
                                    case '4':
                                        d(4);
                                        break;
                                    case '5':
                                        d(5);
                                        break;
                                    case '6':
                                        d(6);
                                        break;
                                    case '7':
                                        d(7);
                                        break;
                                    default:
                                        switch (f3) {
                                            case 't':
                                                d(9);
                                                break;
                                            case 'u':
                                                d((char) Integer.parseInt(new String(new char[]{f(), f(), f(), f()}), 16));
                                                break;
                                            case 'v':
                                                d(11);
                                                break;
                                            default:
                                                this.f6233d = f3;
                                                throw new d("unclosed string : ".concat(String.valueOf(f3)));
                                        }
                                }
                            } else {
                                char f4 = f();
                                char f5 = f();
                                int[] iArr = p;
                                d((char) ((iArr[f4] * 16) + iArr[f5]));
                            }
                        }
                    }
                    d(12);
                } else {
                    d('\'');
                }
            } else if (!this.j) {
                this.f6237h++;
            } else {
                int i3 = this.f6237h;
                char[] cArr4 = this.f6236g;
                if (i3 == cArr4.length) {
                    d(f2);
                } else {
                    this.f6237h = i3 + 1;
                    cArr4[i3] = f2;
                }
            }
        }
    }

    public final Calendar y() {
        return this.k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n() {
        /*
            r8 = this;
            int r0 = r8.f6238i
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L_0x0008
            r8.f6238i = r1
        L_0x0008:
            int r0 = r8.f6238i
            int r2 = r8.f6237h
            int r2 = r2 + r0
            char r3 = r8.b((int) r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x001e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r0 + 1
            r3 = 1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0025
        L_0x001e:
            r3 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r3 = 0
            r4 = -2147483647(0xffffffff80000001, float:-1.4E-45)
        L_0x0025:
            if (r0 >= r2) goto L_0x0033
            int[] r1 = p
            int r6 = r0 + 1
            char r0 = r8.b((int) r0)
            r0 = r1[r0]
            int r1 = -r0
        L_0x0032:
            r0 = r6
        L_0x0033:
            if (r0 >= r2) goto L_0x006d
            int r6 = r0 + 1
            char r0 = r8.b((int) r0)
            r7 = 76
            if (r0 == r7) goto L_0x006c
            r7 = 83
            if (r0 == r7) goto L_0x006c
            r7 = 66
            if (r0 == r7) goto L_0x006c
            int[] r7 = p
            r0 = r7[r0]
            r7 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            if (r1 < r7) goto L_0x0062
            int r1 = r1 * 10
            int r7 = r4 + r0
            if (r1 < r7) goto L_0x0058
            int r1 = r1 - r0
            goto L_0x0032
        L_0x0058:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r8.u()
            r0.<init>(r1)
            throw r0
        L_0x0062:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r8.u()
            r0.<init>(r1)
            throw r0
        L_0x006c:
            r0 = r6
        L_0x006d:
            if (r3 == 0) goto L_0x007f
            int r2 = r8.f6238i
            int r2 = r2 + r5
            if (r0 <= r2) goto L_0x0075
            return r1
        L_0x0075:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r8.u()
            r0.<init>(r1)
            throw r0
        L_0x007f:
            int r0 = -r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.e.n():int");
    }

    public void close() {
        char[] cArr = this.f6236g;
        if (cArr.length <= 8192) {
            r.set(new SoftReference(cArr));
        }
        this.f6236g = null;
    }

    public final boolean t() {
        if (this.f6237h == 4 && b(this.f6238i + 1) == '$' && b(this.f6238i + 2) == 'r' && b(this.f6238i + 3) == 'e' && b(this.f6238i + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final String c(char c2) {
        boolean z = false;
        this.l = 0;
        char b2 = b(this.f6234e + 0);
        if (b2 == 'n') {
            if (b(this.f6234e + 1) != 'u' || b(this.f6234e + 1 + 1) != 'l' || b(this.f6234e + 1 + 2) != 'l') {
                this.l = -1;
                return null;
            } else if (b(this.f6234e + 4) == c2) {
                this.f6234e += 4;
                f();
                this.l = 3;
                return null;
            } else {
                this.l = -1;
                return null;
            }
        } else if (b2 != '\"') {
            this.l = -1;
            return A();
        } else {
            int i2 = this.f6234e + 1;
            int c3 = c(i2);
            if (c3 != -1) {
                String a2 = a(this.f6234e + 1, c3 - i2);
                int i3 = this.f6234e + 1;
                while (true) {
                    if (i3 >= c3) {
                        break;
                    } else if (b(i3) == '\\') {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    this.l = -1;
                    return A();
                }
                int i4 = this.f6234e;
                int i5 = (c3 - (i4 + 1)) + 1 + 1;
                int i6 = i5 + 1;
                if (b(i4 + i5) == c2) {
                    this.f6234e += i6 - 1;
                    f();
                    this.l = 3;
                    return a2;
                }
                this.l = -1;
                return a2;
            }
            throw new d("unclosed str");
        }
    }

    public final int b(char c2) {
        int i2;
        char b2;
        this.l = 0;
        char b3 = b(this.f6234e + 0);
        if (b3 < '0' || b3 > '9') {
            this.l = -1;
            return 0;
        }
        int i3 = p[b3];
        int i4 = 1;
        while (true) {
            i2 = i4 + 1;
            b2 = b(this.f6234e + i4);
            if (b2 >= '0' && b2 <= '9') {
                i3 = (i3 * 10) + p[b2];
                i4 = i2;
            }
        }
        if (b2 == '.') {
            this.l = -1;
            return 0;
        } else if (i3 < 0) {
            this.l = -1;
            return 0;
        } else if (b2 == c2) {
            this.f6234e += i2 - 1;
            f();
            this.l = 3;
            this.f6230a = 16;
            return i3;
        } else {
            this.l = -1;
            return i3;
        }
    }

    public final long a(char c2) {
        int i2;
        char b2;
        this.l = 0;
        char b3 = b(this.f6234e + 0);
        if (b3 < '0' || b3 > '9') {
            this.l = -1;
            return 0;
        }
        long j2 = (long) p[b3];
        int i3 = 1;
        while (true) {
            i2 = i3 + 1;
            b2 = b(this.f6234e + i3);
            if (b2 >= '0' && b2 <= '9') {
                j2 = (j2 * 10) + ((long) p[b2]);
                i3 = i2;
            }
        }
        if (b2 == '.') {
            this.l = -1;
            return 0;
        } else if (j2 < 0) {
            this.l = -1;
            return 0;
        } else if (b2 == c2) {
            this.f6234e += i2 - 1;
            f();
            this.l = 3;
            this.f6230a = 16;
            return j2;
        } else {
            this.l = -1;
            return j2;
        }
    }

    public final boolean q() {
        int i2 = 0;
        while (true) {
            char b2 = b(i2);
            if (b2 == 26) {
                return true;
            }
            if (!e(b2)) {
                return false;
            }
            i2++;
        }
    }

    public final void c() {
        while (true) {
            char c2 = this.f6233d;
            boolean[] zArr = o;
            if (c2 < zArr.length && zArr[c2]) {
                f();
            } else {
                return;
            }
        }
    }

    private void d(char c2) {
        int i2 = this.f6237h;
        char[] cArr = this.f6236g;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f6236g = cArr2;
        }
        char[] cArr3 = this.f6236g;
        int i3 = this.f6237h;
        this.f6237h = i3 + 1;
        cArr3[i3] = c2;
    }

    public final void h() {
        this.f6238i = this.f6234e;
        if (this.f6233d == '-') {
            this.f6237h++;
            f();
        }
        while (true) {
            char c2 = this.f6233d;
            if (c2 < '0' || c2 > '9') {
                boolean z = false;
            } else {
                this.f6237h++;
                f();
            }
        }
        boolean z2 = false;
        if (this.f6233d == '.') {
            this.f6237h++;
            f();
            while (true) {
                char c3 = this.f6233d;
                if (c3 < '0' || c3 > '9') {
                    z2 = true;
                } else {
                    this.f6237h++;
                    f();
                }
            }
            z2 = true;
        }
        char c4 = this.f6233d;
        if (c4 == 'L') {
            this.f6237h++;
            f();
        } else if (c4 == 'S') {
            this.f6237h++;
            f();
        } else if (c4 == 'B') {
            this.f6237h++;
            f();
        } else {
            if (c4 == 'F') {
                this.f6237h++;
                f();
            } else if (c4 == 'D') {
                this.f6237h++;
                f();
            } else if (c4 == 'e' || c4 == 'E') {
                this.f6237h++;
                f();
                char c5 = this.f6233d;
                if (c5 == '+' || c5 == '-') {
                    this.f6237h++;
                    f();
                }
                while (true) {
                    char c6 = this.f6233d;
                    if (c6 < '0' || c6 > '9') {
                        char c7 = this.f6233d;
                    } else {
                        this.f6237h++;
                        f();
                    }
                }
                char c72 = this.f6233d;
                if (c72 == 'D' || c72 == 'F') {
                    this.f6237h++;
                    f();
                }
            }
            z2 = true;
        }
        if (z2) {
            this.f6230a = 3;
        } else {
            this.f6230a = 2;
        }
    }

    public final long s() throws NumberFormatException {
        long j2;
        boolean z;
        long j3;
        int i2;
        int i3 = this.f6238i;
        int i4 = this.f6237h + i3;
        if (b(i3) == '-') {
            j2 = Long.MIN_VALUE;
            i3++;
            z = true;
        } else {
            j2 = -9223372036854775807L;
            z = false;
        }
        if (i3 < i4) {
            j3 = (long) (-p[b(i3)]);
            i3++;
        } else {
            j3 = 0;
        }
        while (true) {
            if (i3 >= i4) {
                break;
            }
            i2 = i3 + 1;
            char b2 = b(i3);
            if (b2 == 'L' || b2 == 'S' || b2 == 'B') {
                i3 = i2;
            } else {
                int i5 = p[b2];
                if (j3 >= -922337203685477580L) {
                    long j4 = j3 * 10;
                    long j5 = (long) i5;
                    if (j4 >= j2 + j5) {
                        j3 = j4 - j5;
                        i3 = i2;
                    } else {
                        throw new NumberFormatException(u());
                    }
                } else {
                    throw new NumberFormatException(u());
                }
            }
        }
        i3 = i2;
        if (!z) {
            return -j3;
        }
        if (i3 > this.f6238i + 1) {
            return j3;
        }
        throw new NumberFormatException(u());
    }

    public final Number a(boolean z) {
        char b2 = b((this.f6238i + this.f6237h) - 1);
        if (b2 == 'F') {
            return Float.valueOf(Float.parseFloat(u()));
        }
        if (b2 == 'D') {
            return Double.valueOf(Double.parseDouble(u()));
        }
        if (z) {
            return k();
        }
        return Double.valueOf(Double.parseDouble(u()));
    }

    public final BigDecimal k() {
        return new BigDecimal(u());
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Enum<?> a(java.lang.Class<?> r10, com.alibaba.a.b.j r11, char r12) {
        /*
            r9 = this;
            r0 = 0
            r9.l = r0
            int r1 = r9.f6234e
            int r1 = r1 + r0
            char r1 = r9.b((int) r1)
            r2 = 3
            r3 = -1
            r4 = 0
            r5 = 1
            r6 = 110(0x6e, float:1.54E-43)
            if (r1 != r6) goto L_0x0050
            int r11 = r9.f6234e
            int r11 = r11 + r5
            char r11 = r9.b((int) r11)
            r0 = 117(0x75, float:1.64E-43)
            if (r11 != r0) goto L_0x004d
            int r11 = r9.f6234e
            int r11 = r11 + r5
            int r11 = r11 + r5
            char r11 = r9.b((int) r11)
            r0 = 108(0x6c, float:1.51E-43)
            if (r11 != r0) goto L_0x004d
            int r11 = r9.f6234e
            int r11 = r11 + r5
            int r11 = r11 + 2
            char r11 = r9.b((int) r11)
            if (r11 != r0) goto L_0x004d
            int r11 = r9.f6234e
            int r11 = r11 + 4
            char r11 = r9.b((int) r11)
            if (r11 != r12) goto L_0x004a
            int r11 = r9.f6234e
            int r11 = r11 + 4
            r9.f6234e = r11
            r9.f()
            r9.l = r2
            goto L_0x0056
        L_0x004a:
            r9.l = r3
            goto L_0x0056
        L_0x004d:
            r9.l = r3
            goto L_0x0056
        L_0x0050:
            r6 = 34
            if (r1 == r6) goto L_0x0058
            r9.l = r3
        L_0x0056:
            r11 = r4
            goto L_0x0095
        L_0x0058:
            r0 = 1
            r1 = 0
        L_0x005a:
            int r7 = r9.f6234e
            int r8 = r0 + 1
            int r7 = r7 + r0
            char r0 = r9.b((int) r7)
            if (r0 != r6) goto L_0x008b
            int r0 = r9.f6234e
            int r6 = r0 + 0
            int r6 = r6 + r5
            int r0 = r0 + r8
            int r0 = r0 - r6
            int r0 = r0 - r5
            java.lang.String r11 = r9.a(r6, r0, r1, r11)
            int r0 = r9.f6234e
            int r1 = r8 + 1
            int r0 = r0 + r8
            char r0 = r9.b((int) r0)
            if (r0 != r12) goto L_0x0088
            int r12 = r9.f6234e
            int r1 = r1 - r5
            int r12 = r12 + r1
            r9.f6234e = r12
            r9.f()
            r9.l = r2
            goto L_0x0095
        L_0x0088:
            r9.l = r3
            goto L_0x0095
        L_0x008b:
            int r1 = r1 * 31
            int r1 = r1 + r0
            r7 = 92
            if (r0 != r7) goto L_0x009d
            r9.l = r3
            goto L_0x0056
        L_0x0095:
            if (r11 != 0) goto L_0x0098
            return r4
        L_0x0098:
            java.lang.Enum r10 = java.lang.Enum.valueOf(r10, r11)
            return r10
        L_0x009d:
            r0 = r8
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.e.a(java.lang.Class, com.alibaba.a.b.j, char):java.lang.Enum");
    }
}
