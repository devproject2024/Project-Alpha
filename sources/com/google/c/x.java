package com.google.c;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum x {
    DOUBLE(0, a.SCALAR, ae.DOUBLE),
    FLOAT(1, a.SCALAR, ae.FLOAT),
    INT64(2, a.SCALAR, ae.LONG),
    UINT64(3, a.SCALAR, ae.LONG),
    INT32(4, a.SCALAR, ae.INT),
    FIXED64(5, a.SCALAR, ae.LONG),
    FIXED32(6, a.SCALAR, ae.INT),
    BOOL(7, a.SCALAR, ae.BOOLEAN),
    STRING(8, a.SCALAR, ae.STRING),
    MESSAGE(9, a.SCALAR, ae.MESSAGE),
    BYTES(10, a.SCALAR, ae.BYTE_STRING),
    UINT32(11, a.SCALAR, ae.INT),
    ENUM(12, a.SCALAR, ae.ENUM),
    SFIXED32(13, a.SCALAR, ae.INT),
    SFIXED64(14, a.SCALAR, ae.LONG),
    SINT32(15, a.SCALAR, ae.INT),
    SINT64(16, a.SCALAR, ae.LONG),
    GROUP(17, a.SCALAR, ae.MESSAGE),
    DOUBLE_LIST(18, a.VECTOR, ae.DOUBLE),
    FLOAT_LIST(19, a.VECTOR, ae.FLOAT),
    INT64_LIST(20, a.VECTOR, ae.LONG),
    UINT64_LIST(21, a.VECTOR, ae.LONG),
    INT32_LIST(22, a.VECTOR, ae.INT),
    FIXED64_LIST(23, a.VECTOR, ae.LONG),
    FIXED32_LIST(24, a.VECTOR, ae.INT),
    BOOL_LIST(25, a.VECTOR, ae.BOOLEAN),
    STRING_LIST(26, a.VECTOR, ae.STRING),
    MESSAGE_LIST(27, a.VECTOR, ae.MESSAGE),
    BYTES_LIST(28, a.VECTOR, ae.BYTE_STRING),
    UINT32_LIST(29, a.VECTOR, ae.INT),
    ENUM_LIST(30, a.VECTOR, ae.ENUM),
    SFIXED32_LIST(31, a.VECTOR, ae.INT),
    SFIXED64_LIST(32, a.VECTOR, ae.LONG),
    SINT32_LIST(33, a.VECTOR, ae.INT),
    SINT64_LIST(34, a.VECTOR, ae.LONG),
    DOUBLE_LIST_PACKED(35, a.PACKED_VECTOR, ae.DOUBLE),
    FLOAT_LIST_PACKED(36, a.PACKED_VECTOR, ae.FLOAT),
    INT64_LIST_PACKED(37, a.PACKED_VECTOR, ae.LONG),
    UINT64_LIST_PACKED(38, a.PACKED_VECTOR, ae.LONG),
    INT32_LIST_PACKED(39, a.PACKED_VECTOR, ae.INT),
    FIXED64_LIST_PACKED(40, a.PACKED_VECTOR, ae.LONG),
    FIXED32_LIST_PACKED(41, a.PACKED_VECTOR, ae.INT),
    BOOL_LIST_PACKED(42, a.PACKED_VECTOR, ae.BOOLEAN),
    UINT32_LIST_PACKED(43, a.PACKED_VECTOR, ae.INT),
    ENUM_LIST_PACKED(44, a.PACKED_VECTOR, ae.ENUM),
    SFIXED32_LIST_PACKED(45, a.PACKED_VECTOR, ae.INT),
    SFIXED64_LIST_PACKED(46, a.PACKED_VECTOR, ae.LONG),
    SINT32_LIST_PACKED(47, a.PACKED_VECTOR, ae.INT),
    SINT64_LIST_PACKED(48, a.PACKED_VECTOR, ae.LONG),
    GROUP_LIST(49, a.VECTOR, ae.MESSAGE),
    MAP(50, a.MAP, ae.VOID);
    
    private static final Type[] EMPTY_TYPES = null;
    private static final x[] VALUES = null;
    private final a collection;
    private final Class<?> elementType;
    private final int id;
    private final ae javaType;
    private final boolean primitiveScalar;

    static {
        int i2;
        EMPTY_TYPES = new Type[0];
        x[] values = values();
        VALUES = new x[values.length];
        for (x xVar : values) {
            VALUES[xVar.id] = xVar;
        }
    }

    private x(int i2, a aVar, ae aeVar) {
        int i3;
        this.id = i2;
        this.collection = aVar;
        this.javaType = aeVar;
        int i4 = AnonymousClass1.f37930a[aVar.ordinal()];
        if (i4 == 1) {
            this.elementType = aeVar.getBoxedType();
        } else if (i4 != 2) {
            this.elementType = null;
        } else {
            this.elementType = aeVar.getBoxedType();
        }
        boolean z = false;
        if (!(aVar != a.SCALAR || (i3 = AnonymousClass1.f37931b[aeVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.primitiveScalar = z;
    }

    /* renamed from: com.google.c.x$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37930a = null;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f37931b = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
                com.google.c.ae[] r0 = com.google.c.ae.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37931b = r0
                r0 = 1
                int[] r1 = f37931b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.c.ae r2 = com.google.c.ae.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f37931b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.c.ae r3 = com.google.c.ae.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f37931b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.c.ae r4 = com.google.c.ae.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.google.c.x$a[] r3 = com.google.c.x.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f37930a = r3
                int[] r3 = f37930a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.google.c.x$a r4 = com.google.c.x.a.MAP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f37930a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.google.c.x$a r3 = com.google.c.x.a.VECTOR     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f37930a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.google.c.x$a r1 = com.google.c.x.a.SCALAR     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.x.AnonymousClass1.<clinit>():void");
        }
    }

    public final int id() {
        return this.id;
    }

    public final ae getJavaType() {
        return this.javaType;
    }

    public final boolean isPacked() {
        return a.PACKED_VECTOR.equals(this.collection);
    }

    public final boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public final boolean isScalar() {
        return this.collection == a.SCALAR;
    }

    public final boolean isList() {
        return this.collection.isList();
    }

    public final boolean isMap() {
        return this.collection == a.MAP;
    }

    public final boolean isValidForField(Field field) {
        if (a.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public static x forId(int i2) {
        if (i2 < 0) {
            return null;
        }
        x[] xVarArr = VALUES;
        if (i2 >= xVarArr.length) {
            return null;
        }
        return xVarArr[i2];
    }

    private static Type getGenericSuperList(Class<?> cls) {
        for (Type type : cls.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                if (List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
            return genericSuperclass;
        }
        return null;
    }

    private static Type getListParameter(Class<?> cls, Type[] typeArr) {
        Class<? super Object> cls2;
        boolean z;
        while (true) {
            int i2 = 0;
            Class<? super Object> cls3 = cls;
            if (cls3 != List.class) {
                Type genericSuperList = getGenericSuperList(cls3);
                if (!(genericSuperList instanceof ParameterizedType)) {
                    typeArr = EMPTY_TYPES;
                    Class<? super Object>[] interfaces = cls3.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i2 >= length) {
                            cls2 = cls3.getSuperclass();
                            break;
                        }
                        Class<? super Object> cls4 = interfaces[i2];
                        if (List.class.isAssignableFrom(cls4)) {
                            cls2 = cls4;
                            break;
                        }
                        i2++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperList;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                        Type type = actualTypeArguments[i3];
                        if (type instanceof TypeVariable) {
                            TypeVariable[] typeParameters = cls3.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= typeParameters.length) {
                                        z = false;
                                        break;
                                    } else if (type == typeParameters[i4]) {
                                        actualTypeArguments[i3] = typeArr[i4];
                                        z = true;
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (!z) {
                                    throw new RuntimeException("Unable to find replacement for ".concat(String.valueOf(type)));
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    typeArr = actualTypeArguments;
                    cls2 = (Class) parameterizedType.getRawType();
                }
                cls3 = cls2;
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    enum a {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean isList;

        private a(boolean z) {
            this.isList = z;
        }

        public final boolean isList() {
            return this.isList;
        }
    }
}
