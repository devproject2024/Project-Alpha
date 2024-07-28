package com.bumptech.glide.load.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f7034c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f7035d;

    j(Map<String, List<i>> map) {
        this.f7034c = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> a() {
        if (this.f7035d == null) {
            synchronized (this) {
                if (this.f7035d == null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : this.f7034c.entrySet()) {
                        String a2 = a((List) next.getValue());
                        if (!TextUtils.isEmpty(a2)) {
                            hashMap.put(next.getKey(), a2);
                        }
                    }
                    this.f7035d = Collections.unmodifiableMap(hashMap);
                }
            }
        }
        return this.f7035d;
    }

    private static String a(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f7034c + '}';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f7034c.equals(((j) obj).f7034c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7034c.hashCode();
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f7041a;

        b(String str) {
            this.f7041a = str;
        }

        public final String a() {
            return this.f7041a;
        }

        public final String toString() {
            return "StringHeaderFactory{value='" + this.f7041a + '\'' + '}';
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f7041a.equals(((b) obj).f7041a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f7041a.hashCode();
        }
    }

    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        private static final String f7036c;

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, List<i>> f7037d;

        /* renamed from: a  reason: collision with root package name */
        boolean f7038a = true;

        /* renamed from: b  reason: collision with root package name */
        Map<String, List<i>> f7039b = f7037d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7040e = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = property.charAt(i2);
                    if ((charAt > 31 || charAt == 9) && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            f7036c = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f7036c)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f7036c)));
            }
            f7037d = Collections.unmodifiableMap(hashMap);
        }
    }
}
