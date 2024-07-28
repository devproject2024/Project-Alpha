package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class q {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(obj, (byte) 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f8863a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f8864b;

        private a(Object obj) {
            this.f8864b = s.a(obj);
            this.f8863a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f8863a;
            String str2 = (String) s.a(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f8864b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f8863a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.f8863a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        /* synthetic */ a(Object obj, byte b2) {
            this(obj);
        }
    }
}
