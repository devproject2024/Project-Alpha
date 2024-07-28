package com.squareup.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final String f33753a;

    /* renamed from: b  reason: collision with root package name */
    final String f33754b;

    /* renamed from: c  reason: collision with root package name */
    final String f33755c;

    /* renamed from: d  reason: collision with root package name */
    boolean f33756d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33757e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33758f;

    /* renamed from: g  reason: collision with root package name */
    boolean f33759g;

    /* renamed from: h  reason: collision with root package name */
    boolean f33760h;

    /* renamed from: i  reason: collision with root package name */
    boolean f33761i;
    boolean j;
    public a k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    C0554b s;
    e t;
    d u;
    List<String> v;

    /* renamed from: com.squareup.a.b$b  reason: collision with other inner class name */
    public enum C0554b {
        LEFT("left"),
        CENTER("center"),
        RIGHT("right");
        
        final String value;

        private C0554b(String str) {
            this.value = str;
        }
    }

    public enum e {
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom");
        
        final String value;

        private e(String str) {
            this.value = str;
        }
    }

    public enum d {
        TOP_LEFT("top-left"),
        BOTTOM_RIGHT("bottom-right");
        
        final String value;

        private d(String str) {
            this.value = str;
        }
    }

    public enum c {
        GIF("gif"),
        JPEG("jpeg"),
        PNG("png"),
        WEBP("webp");
        
        final String value;

        private c(String str) {
            this.value = str;
        }
    }

    public enum a {
        NORMAL("fit-in"),
        FULL("full-fit-in"),
        ADAPTIVE("adaptive-fit-in");
        
        final String value;

        private a(String str) {
            this.value = str;
        }
    }

    b(String str, String str2, String str3) {
        this.f33754b = str;
        this.f33755c = str2;
        this.f33753a = str3;
    }

    public final b a(int i2, int i3) {
        if (i2 < 0 && i2 != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Width must be a positive number.");
        } else if (i3 < 0 && i3 != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Height must be a positive number.");
        } else if (i2 == 0 && i3 == 0) {
            throw new IllegalArgumentException("Both width and height must not be zero.");
        } else {
            this.f33757e = true;
            this.l = i2;
            this.m = i3;
            return this;
        }
    }

    public final b a(String... strArr) {
        if (strArr.length != 0) {
            if (this.v == null) {
                this.v = new ArrayList(strArr.length);
            }
            for (String str : strArr) {
                if (str == null || str.length() == 0) {
                    throw new IllegalArgumentException("Filter must not be blank.");
                }
                this.v.add(str);
            }
            return this;
        }
        throw new IllegalArgumentException("You must provide at least one filter.");
    }

    public final String a() {
        return this.f33755c == null ? b() : c();
    }

    private String b() {
        return this.f33754b + "unsafe/" + d();
    }

    private String c() {
        if (this.f33755c != null) {
            boolean z = this.f33760h;
            StringBuilder d2 = d();
            String str = this.f33755c;
            String a2 = c.a(z ? c.b(d2, str) : c.a(d2, str));
            CharSequence charSequence = d2;
            if (z) {
                charSequence = this.f33753a;
            }
            return this.f33754b + a2 + "/" + charSequence;
        }
        throw new IllegalStateException("Cannot build safe URL without a key.");
    }

    public final String toString() {
        return a();
    }

    private StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        if (this.f33759g) {
            sb.append("trim");
            if (this.u != null) {
                sb.append(AppConstants.COLON);
                sb.append(this.u.value);
                if (this.r > 0) {
                    sb.append(AppConstants.COLON);
                    sb.append(this.r);
                }
            }
            sb.append("/");
        }
        if (this.f33756d) {
            sb.append(this.o);
            sb.append("x");
            sb.append(this.n);
            sb.append(AppConstants.COLON);
            sb.append(this.q);
            sb.append("x");
            sb.append(this.p);
            sb.append("/");
        }
        if (this.f33757e) {
            a aVar = this.k;
            if (aVar != null) {
                sb.append(aVar.value);
                sb.append("/");
            }
            if (this.f33761i) {
                sb.append("-");
            }
            int i2 = this.l;
            if (i2 == Integer.MIN_VALUE) {
                sb.append("orig");
            } else {
                sb.append(i2);
            }
            sb.append("x");
            if (this.j) {
                sb.append("-");
            }
            int i3 = this.m;
            if (i3 == Integer.MIN_VALUE) {
                sb.append("orig");
            } else {
                sb.append(i3);
            }
            if (this.f33758f) {
                sb.append("/smart");
            } else {
                if (this.s != null) {
                    sb.append("/");
                    sb.append(this.s.value);
                }
                if (this.t != null) {
                    sb.append("/");
                    sb.append(this.t.value);
                }
            }
            sb.append("/");
        }
        if (this.v != null) {
            sb.append("filters");
            for (String append : this.v) {
                sb.append(AppConstants.COLON);
                sb.append(append);
            }
            sb.append("/");
        }
        sb.append(this.f33760h ? c.a(this.f33753a) : this.f33753a);
        return sb;
    }

    public static String a(c cVar) {
        if (cVar != null) {
            return "format(" + cVar.value + ")";
        }
        throw new IllegalArgumentException("You must specify an image format.");
    }
}
