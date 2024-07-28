package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.Serializable;

public abstract class q<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final q<Integer> f3954b = new q<Integer>() {
        public final String a() {
            return "integer";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }

        public final /* synthetic */ Object a(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final q<Integer> f3955c = new q<Integer>() {
        public final String a() {
            return "reference";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final q<int[]> f3956d = new q<int[]>() {
        public final String a() {
            return "integer[]";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putIntArray(str, (int[]) obj);
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final q<Long> f3957e = new q<Long>() {
        public final String a() {
            return "long";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }

        public final /* synthetic */ Object a(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final q<long[]> f3958f = new q<long[]>() {
        public final String a() {
            return "long[]";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putLongArray(str, (long[]) obj);
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final q<Float> f3959g = new q<Float>() {
        public final String a() {
            return "float";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        }

        public final /* synthetic */ Object a(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final q<float[]> f3960h = new q<float[]>() {
        public final String a() {
            return "float[]";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putFloatArray(str, (float[]) obj);
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final q<Boolean> f3961i = new q<Boolean>() {
        public final String a() {
            return "boolean";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }

        public final /* synthetic */ Object a(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }
    };
    public static final q<boolean[]> j = new q<boolean[]>() {
        public final String a() {
            return "boolean[]";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }
    };
    public static final q<String> k = new q<String>() {
        public final /* bridge */ /* synthetic */ Object a(String str) {
            return str;
        }

        public final String a() {
            return "string";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }
    };
    public static final q<String[]> l = new q<String[]>() {
        public final String a() {
            return "string[]";
        }

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            bundle.putStringArray(str, (String[]) obj);
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final boolean f3962a;

    public abstract T a(Bundle bundle, String str);

    public abstract T a(String str);

    public abstract String a();

    public abstract void a(Bundle bundle, String str, T t);

    q(boolean z) {
        this.f3962a = z;
    }

    public String toString() {
        return a();
    }

    public static q<?> a(String str, String str2) {
        String str3;
        if (f3954b.a().equals(str)) {
            return f3954b;
        }
        if (f3956d.a().equals(str)) {
            return f3956d;
        }
        if (f3957e.a().equals(str)) {
            return f3957e;
        }
        if (f3958f.a().equals(str)) {
            return f3958f;
        }
        if (f3961i.a().equals(str)) {
            return f3961i;
        }
        if (j.a().equals(str)) {
            return j;
        }
        if (k.a().equals(str)) {
            return k;
        }
        if (l.a().equals(str)) {
            return l;
        }
        if (f3959g.a().equals(str)) {
            return f3959g;
        }
        if (f3960h.a().equals(str)) {
            return f3960h;
        }
        if (f3955c.a().equals(str)) {
            return f3955c;
        }
        if (str == null || str.isEmpty()) {
            return k;
        }
        try {
            if (!str.startsWith(AppUtility.CENTER_DOT) || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith("[]")) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new b(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new d(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new c(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new a(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new e(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [androidx.navigation.q<java.lang.Float>, androidx.navigation.q] */
    /* JADX WARNING: type inference failed for: r1v7, types: [androidx.navigation.q<java.lang.Long>, androidx.navigation.q] */
    /* JADX WARNING: type inference failed for: r1v8, types: [androidx.navigation.q<java.lang.Integer>, androidx.navigation.q] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        f3961i.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return f3961i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        f3957e.a(r1);
        r1 = f3957e;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        f3959g.a(r1);
        r1 = f3959g;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.navigation.q b(java.lang.String r1) {
        /*
            androidx.navigation.q<java.lang.Integer> r0 = f3954b     // Catch:{ IllegalArgumentException -> 0x0008 }
            r0.a((java.lang.String) r1)     // Catch:{ IllegalArgumentException -> 0x0008 }
            androidx.navigation.q<java.lang.Integer> r1 = f3954b     // Catch:{ IllegalArgumentException -> 0x0008 }
            return r1
        L_0x0008:
            androidx.navigation.q<java.lang.Long> r0 = f3957e     // Catch:{ IllegalArgumentException -> 0x0010 }
            r0.a((java.lang.String) r1)     // Catch:{ IllegalArgumentException -> 0x0010 }
            androidx.navigation.q<java.lang.Long> r1 = f3957e     // Catch:{ IllegalArgumentException -> 0x0010 }
            return r1
        L_0x0010:
            androidx.navigation.q<java.lang.Float> r0 = f3959g     // Catch:{ IllegalArgumentException -> 0x0018 }
            r0.a((java.lang.String) r1)     // Catch:{ IllegalArgumentException -> 0x0018 }
            androidx.navigation.q<java.lang.Float> r1 = f3959g     // Catch:{ IllegalArgumentException -> 0x0018 }
            return r1
        L_0x0018:
            androidx.navigation.q<java.lang.Boolean> r0 = f3961i     // Catch:{ IllegalArgumentException -> 0x0020 }
            r0.a((java.lang.String) r1)     // Catch:{ IllegalArgumentException -> 0x0020 }
            androidx.navigation.q<java.lang.Boolean> r1 = f3961i     // Catch:{ IllegalArgumentException -> 0x0020 }
            return r1
        L_0x0020:
            androidx.navigation.q<java.lang.String> r1 = k
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.q.b(java.lang.String):androidx.navigation.q");
    }

    static q a(Object obj) {
        if (obj instanceof Integer) {
            return f3954b;
        }
        if (obj instanceof int[]) {
            return f3956d;
        }
        if (obj instanceof Long) {
            return f3957e;
        }
        if (obj instanceof long[]) {
            return f3958f;
        }
        if (obj instanceof Float) {
            return f3959g;
        }
        if (obj instanceof float[]) {
            return f3960h;
        }
        if (obj instanceof Boolean) {
            return f3961i;
        }
        if (obj instanceof boolean[]) {
            return j;
        }
        if ((obj instanceof String) || obj == null) {
            return k;
        }
        if (obj instanceof String[]) {
            return l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new b(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new d(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new c(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new a(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new e(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    public static final class c<D> extends q<D> {
        private final Class<D> m;

        public c(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        public final void a(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            if (d2 == null || (d2 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d2);
            } else if (d2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d2);
            }
        }

        public final D a(Bundle bundle, String str) {
            return bundle.get(str);
        }

        public final D a(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public final String a() {
            return this.m.getName();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.m.equals(((c) obj).m);
        }

        public final int hashCode() {
            return this.m.hashCode();
        }
    }

    public static final class b<D extends Parcelable> extends q<D[]> {
        private final Class<D[]> m;

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.m.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        public b(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.m = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        public final String a() {
            return this.m.getName();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.m.equals(((b) obj).m);
        }

        public final int hashCode() {
            return this.m.hashCode();
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }
    }

    public static class e<D extends Serializable> extends q<D> {
        private final Class<D> m;

        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.m.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        public e(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        e(Class<D> cls, byte b2) {
            super(false);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        /* renamed from: c */
        public D a(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public String a() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.m.equals(((e) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }
    }

    public static final class a<D extends Enum> extends e<D> {
        private final Class<D> m;

        public a(Class<D> cls) {
            super(cls, (byte) 0);
            if (cls.isEnum()) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public D c(String str) {
            for (D d2 : (Enum[]) this.m.getEnumConstants()) {
                D d3 = (Enum) d2;
                if (d3.name().equals(str)) {
                    return d3;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.m.getName() + AppUtility.CENTER_DOT);
        }

        public final String a() {
            return this.m.getName();
        }
    }

    public static final class d<D extends Serializable> extends q<D[]> {
        private final Class<D[]> m;

        /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        public final /* synthetic */ void a(Bundle bundle, String str, Object obj) {
            ? r4 = (Serializable[]) obj;
            this.m.cast(r4);
            bundle.putSerializable(str, r4);
        }

        public d(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.m = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        public final String a() {
            return this.m.getName();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.m.equals(((d) obj).m);
        }

        public final int hashCode() {
            return this.m.hashCode();
        }

        public final /* synthetic */ Object a(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public final /* synthetic */ Object a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }
    }
}
