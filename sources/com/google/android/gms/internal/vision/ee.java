package com.google.android.gms.internal.vision;

import java.lang.reflect.Type;

public enum ee {
    DOUBLE(0, eg.SCALAR, ew.DOUBLE),
    FLOAT(1, eg.SCALAR, ew.FLOAT),
    INT64(2, eg.SCALAR, ew.LONG),
    UINT64(3, eg.SCALAR, ew.LONG),
    INT32(4, eg.SCALAR, ew.INT),
    FIXED64(5, eg.SCALAR, ew.LONG),
    FIXED32(6, eg.SCALAR, ew.INT),
    BOOL(7, eg.SCALAR, ew.BOOLEAN),
    STRING(8, eg.SCALAR, ew.STRING),
    MESSAGE(9, eg.SCALAR, ew.MESSAGE),
    BYTES(10, eg.SCALAR, ew.BYTE_STRING),
    UINT32(11, eg.SCALAR, ew.INT),
    ENUM(12, eg.SCALAR, ew.ENUM),
    SFIXED32(13, eg.SCALAR, ew.INT),
    SFIXED64(14, eg.SCALAR, ew.LONG),
    SINT32(15, eg.SCALAR, ew.INT),
    SINT64(16, eg.SCALAR, ew.LONG),
    GROUP(17, eg.SCALAR, ew.MESSAGE),
    DOUBLE_LIST(18, eg.VECTOR, ew.DOUBLE),
    FLOAT_LIST(19, eg.VECTOR, ew.FLOAT),
    INT64_LIST(20, eg.VECTOR, ew.LONG),
    UINT64_LIST(21, eg.VECTOR, ew.LONG),
    INT32_LIST(22, eg.VECTOR, ew.INT),
    FIXED64_LIST(23, eg.VECTOR, ew.LONG),
    FIXED32_LIST(24, eg.VECTOR, ew.INT),
    BOOL_LIST(25, eg.VECTOR, ew.BOOLEAN),
    STRING_LIST(26, eg.VECTOR, ew.STRING),
    MESSAGE_LIST(27, eg.VECTOR, ew.MESSAGE),
    BYTES_LIST(28, eg.VECTOR, ew.BYTE_STRING),
    UINT32_LIST(29, eg.VECTOR, ew.INT),
    ENUM_LIST(30, eg.VECTOR, ew.ENUM),
    SFIXED32_LIST(31, eg.VECTOR, ew.INT),
    SFIXED64_LIST(32, eg.VECTOR, ew.LONG),
    SINT32_LIST(33, eg.VECTOR, ew.INT),
    SINT64_LIST(34, eg.VECTOR, ew.LONG),
    DOUBLE_LIST_PACKED(35, eg.PACKED_VECTOR, ew.DOUBLE),
    FLOAT_LIST_PACKED(36, eg.PACKED_VECTOR, ew.FLOAT),
    INT64_LIST_PACKED(37, eg.PACKED_VECTOR, ew.LONG),
    UINT64_LIST_PACKED(38, eg.PACKED_VECTOR, ew.LONG),
    INT32_LIST_PACKED(39, eg.PACKED_VECTOR, ew.INT),
    FIXED64_LIST_PACKED(40, eg.PACKED_VECTOR, ew.LONG),
    FIXED32_LIST_PACKED(41, eg.PACKED_VECTOR, ew.INT),
    BOOL_LIST_PACKED(42, eg.PACKED_VECTOR, ew.BOOLEAN),
    UINT32_LIST_PACKED(43, eg.PACKED_VECTOR, ew.INT),
    ENUM_LIST_PACKED(44, eg.PACKED_VECTOR, ew.ENUM),
    SFIXED32_LIST_PACKED(45, eg.PACKED_VECTOR, ew.INT),
    SFIXED64_LIST_PACKED(46, eg.PACKED_VECTOR, ew.LONG),
    SINT32_LIST_PACKED(47, eg.PACKED_VECTOR, ew.INT),
    SINT64_LIST_PACKED(48, eg.PACKED_VECTOR, ew.LONG),
    GROUP_LIST(49, eg.VECTOR, ew.MESSAGE),
    MAP(50, eg.MAP, ew.zzxo);
    
    private static final ee[] zzvt = null;
    private static final Type[] zzvu = null;
    private final int id;
    private final ew zzvp;
    private final eg zzvq;
    private final Class<?> zzvr;
    private final boolean zzvs;

    private ee(int i2, eg egVar, ew ewVar) {
        int i3;
        this.id = i2;
        this.zzvq = egVar;
        this.zzvp = ewVar;
        int i4 = ed.f11083a[egVar.ordinal()];
        if (i4 == 1) {
            this.zzvr = ewVar.zzgv();
        } else if (i4 != 2) {
            this.zzvr = null;
        } else {
            this.zzvr = ewVar.zzgv();
        }
        boolean z = false;
        if (!(egVar != eg.SCALAR || (i3 = ed.f11084b[ewVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzvs = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i2;
        zzvu = new Type[0];
        ee[] values = values();
        zzvt = new ee[values.length];
        for (ee eeVar : values) {
            zzvt[eeVar.id] = eeVar;
        }
    }
}
