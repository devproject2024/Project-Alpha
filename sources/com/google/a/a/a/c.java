package com.google.a.a.a;

import com.google.a.a.c.a.a;
import com.google.a.a.c.a.b;
import com.google.a.a.c.k;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c extends k {

    /* renamed from: a  reason: collision with root package name */
    private static final b f7472a = new com.google.a.a.c.a.c("=&-_.!~*'()@:$,;/?:", false);

    /* renamed from: b  reason: collision with root package name */
    private String f7473b;

    /* renamed from: c  reason: collision with root package name */
    private String f7474c;

    /* renamed from: d  reason: collision with root package name */
    private String f7475d;

    /* renamed from: e  reason: collision with root package name */
    private int f7476e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f7477f;

    /* renamed from: g  reason: collision with root package name */
    private String f7478g;

    public c() {
        this.f7476e = -1;
    }

    public c(String str) {
        this(b(str));
    }

    public c(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private c(String str, String str2, int i2, String str3, String str4, String str5, String str6) {
        ArrayList arrayList;
        String str7;
        this.f7476e = -1;
        this.f7473b = str.toLowerCase();
        this.f7474c = str2;
        this.f7476e = i2;
        String str8 = null;
        if (str3 == null || str3.length() == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            boolean z = true;
            int i3 = 0;
            while (z) {
                int indexOf = str3.indexOf(47, i3);
                boolean z2 = indexOf != -1;
                if (z2) {
                    str7 = str3.substring(i3, indexOf);
                } else {
                    str7 = str3.substring(i3);
                }
                arrayList.add(a.b(str7));
                i3 = indexOf + 1;
                z = z2;
            }
        }
        this.f7477f = arrayList;
        this.f7478g = str4 != null ? a.b(str4) : null;
        if (str5 != null) {
            u.a(str5, (Object) this);
        }
        this.f7475d = str6 != null ? a.b(str6) : str8;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof c)) {
            return false;
        }
        return a().equals(((c) obj).toString());
    }

    public final String toString() {
        return a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public c clone() {
        c cVar = (c) super.clone();
        List<String> list = this.f7477f;
        if (list != null) {
            cVar.f7477f = new ArrayList(list);
        }
        return cVar;
    }

    public final String a() {
        return d() + e();
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) com.google.a.a.b.a.a.a.a.c.a(this.f7473b));
        sb.append("://");
        String str = this.f7475d;
        if (str != null) {
            sb.append(a.d(str));
            sb.append('@');
        }
        sb.append((String) com.google.a.a.b.a.a.a.a.c.a(this.f7474c));
        int i2 = this.f7476e;
        if (i2 != -1) {
            sb.append(':');
            sb.append(i2);
        }
        return sb.toString();
    }

    private String e() {
        StringBuilder sb = new StringBuilder();
        if (this.f7477f != null) {
            a(sb);
        }
        a(entrySet(), sb);
        String str = this.f7478g;
        if (str != null) {
            sb.append('#');
            sb.append(f7472a.a(str));
        }
        return sb.toString();
    }

    private void a(StringBuilder sb) {
        int size = this.f7477f.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.f7477f.get(i2);
            if (i2 != 0) {
                sb.append('/');
            }
            if (str.length() != 0) {
                sb.append(a.c(str));
            }
        }
    }

    private static void a(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        for (Map.Entry next : set) {
            Object value = next.getValue();
            if (value != null) {
                String e2 = a.e((String) next.getKey());
                if (value instanceof Collection) {
                    for (Object a2 : (Collection) value) {
                        z = a(z, sb, e2, a2);
                    }
                } else {
                    z = a(z, sb, e2, value);
                }
            }
        }
    }

    private static boolean a(boolean z, StringBuilder sb, String str, Object obj) {
        if (z) {
            z = false;
            sb.append('?');
        } else {
            sb.append('&');
        }
        sb.append(str);
        String e2 = a.e(obj.toString());
        if (e2.length() != 0) {
            sb.append('=');
            sb.append(e2);
        }
        return z;
    }

    private static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final URL a(String str) {
        try {
            return new URL(b(a()), str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final /* bridge */ /* synthetic */ k a(String str, Object obj) {
        return (c) super.a(str, obj);
    }
}
