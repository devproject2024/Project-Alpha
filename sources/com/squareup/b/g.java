package com.squareup.b;

import com.squareup.b.h;
import com.squareup.b.m;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class g {
    public static final n u = new n((Class<?>[]) new Class[0]);

    /* renamed from: a  reason: collision with root package name */
    private transient boolean f16057a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f16058b;
    transient m v;
    protected transient int w = 0;

    public enum a {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);
        
        public static final Comparator<a> ORDER_BY_NAME = null;
        private static final Map<String, a> TYPES_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<a>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((a) obj).name().compareTo(((a) obj2).name());
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            TYPES_BY_NAME = linkedHashMap;
            linkedHashMap.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put("string", STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put("message", MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put("float", FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        private a(int i2) {
            this.value = i2;
        }

        public final int value() {
            return this.value;
        }

        public final q wireType() {
            switch (this) {
                case INT32:
                case INT64:
                case UINT32:
                case UINT64:
                case SINT32:
                case SINT64:
                case BOOL:
                case ENUM:
                    return q.VARINT;
                case FIXED32:
                case SFIXED32:
                case FLOAT:
                    return q.FIXED32;
                case FIXED64:
                case SFIXED64:
                case DOUBLE:
                    return q.FIXED64;
                case STRING:
                case BYTES:
                case MESSAGE:
                    return q.LENGTH_DELIMITED;
                default:
                    throw new AssertionError("No wiretype for datatype ".concat(String.valueOf(this)));
            }
        }

        public static a of(String str) {
            return TYPES_BY_NAME.get(str);
        }
    }

    public enum b {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        
        public static final Comparator<b> ORDER_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<b>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((b) obj).name().compareTo(((b) obj2).name());
                }
            };
        }

        private b(int i2) {
            this.value = i2;
        }

        public final int value() {
            return this.value;
        }

        public final boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public final boolean isPacked() {
            return this == PACKED;
        }
    }

    protected g() {
    }

    public final int a() {
        if (!this.f16057a) {
            this.f16058b = u.a(getClass()).a(this);
            this.f16057a = true;
        }
        return this.f16058b;
    }

    public final int b() {
        m mVar = this.v;
        int i2 = 0;
        if (mVar == null) {
            return 0;
        }
        if (mVar.f16081a != null) {
            for (Map.Entry next : mVar.f16081a.entrySet()) {
                for (m.a a2 : (List) next.getValue()) {
                    i2 = i2 + p.b(((Integer) next.getKey()).intValue()) + a2.a();
                }
            }
        }
        return i2;
    }

    protected static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public String toString() {
        h<M> a2 = u.a(getClass());
        StringBuilder sb = new StringBuilder();
        sb.append(a2.f16060a.getSimpleName());
        sb.append("{");
        String str = "";
        for (T t : a2.f16061b.f16077a) {
            Object a3 = h.a(this, (h.a) t);
            if (a3 != null) {
                sb.append(str);
                sb.append(t.f16067b);
                sb.append("=");
                if (t.f16072g) {
                    a3 = "██";
                }
                sb.append(a3);
                str = ", ";
            }
        }
        if (this instanceof c) {
            c cVar = (c) this;
            sb.append(str);
            sb.append("{extensions=");
            sb.append(cVar.f16045a == null ? "{}" : cVar.f16045a.toString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    public final void a(int i2, long j) {
        try {
            c().a(i2, Long.valueOf(j));
        } catch (IOException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final m c() {
        if (this.v == null) {
            this.v = new m();
        }
        return this.v;
    }

    public final void d() {
        a<?> b2 = u.b(getClass());
        try {
            int size = b2.f16038a.size();
            StringBuilder sb = null;
            String str = "";
            for (int i2 = 0; i2 < size; i2++) {
                Field field = b2.f16038a.get(i2);
                if (field.get(this) == null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    sb.append("\n  ");
                    sb.append(field.getName());
                }
            }
            if (sb == null) {
                b2.a(this);
                return;
            }
            throw new IllegalStateException("Required field" + str + " not set:" + sb);
        } catch (IllegalAccessException unused) {
            throw new AssertionError("Unable to access required fields");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int i2 = 0;
        while (i2 < declaredFields.length) {
            try {
                Field field = declaredFields[i2];
                field.setAccessible(true);
                if (((k) field.getAnnotation(k.class)) == null) {
                    i2++;
                } else {
                    field.get(obj);
                    field.get(this);
                    return false;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.w;
        if (i2 != 0) {
            return i2;
        }
        Field[] declaredFields = getClass().getDeclaredFields();
        int i3 = i2;
        int i4 = 0;
        while (i4 < declaredFields.length) {
            try {
                Field field = declaredFields[i4];
                int i5 = 1;
                field.setAccessible(true);
                if (((k) field.getAnnotation(k.class)) != null) {
                    Object obj = field.get(this);
                    if (i4 == 0) {
                        i3 += obj != null ? obj.hashCode() : 0;
                    } else {
                        int i6 = i3 * 37;
                        if (obj != null) {
                            i5 = obj.hashCode();
                        }
                        i3 = i6 + i5;
                    }
                }
                i4++;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
        this.w = i3;
        return i3;
    }
}
