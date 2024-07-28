package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Type;

public enum ba {
    DOUBLE(0, bc.SCALAR, bp.DOUBLE),
    FLOAT(1, bc.SCALAR, bp.FLOAT),
    INT64(2, bc.SCALAR, bp.LONG),
    UINT64(3, bc.SCALAR, bp.LONG),
    INT32(4, bc.SCALAR, bp.INT),
    FIXED64(5, bc.SCALAR, bp.LONG),
    FIXED32(6, bc.SCALAR, bp.INT),
    BOOL(7, bc.SCALAR, bp.BOOLEAN),
    STRING(8, bc.SCALAR, bp.STRING),
    MESSAGE(9, bc.SCALAR, bp.MESSAGE),
    BYTES(10, bc.SCALAR, bp.BYTE_STRING),
    UINT32(11, bc.SCALAR, bp.INT),
    ENUM(12, bc.SCALAR, bp.ENUM),
    SFIXED32(13, bc.SCALAR, bp.INT),
    SFIXED64(14, bc.SCALAR, bp.LONG),
    SINT32(15, bc.SCALAR, bp.INT),
    SINT64(16, bc.SCALAR, bp.LONG),
    GROUP(17, bc.SCALAR, bp.MESSAGE),
    DOUBLE_LIST(18, bc.VECTOR, bp.DOUBLE),
    FLOAT_LIST(19, bc.VECTOR, bp.FLOAT),
    INT64_LIST(20, bc.VECTOR, bp.LONG),
    UINT64_LIST(21, bc.VECTOR, bp.LONG),
    INT32_LIST(22, bc.VECTOR, bp.INT),
    FIXED64_LIST(23, bc.VECTOR, bp.LONG),
    FIXED32_LIST(24, bc.VECTOR, bp.INT),
    BOOL_LIST(25, bc.VECTOR, bp.BOOLEAN),
    STRING_LIST(26, bc.VECTOR, bp.STRING),
    MESSAGE_LIST(27, bc.VECTOR, bp.MESSAGE),
    BYTES_LIST(28, bc.VECTOR, bp.BYTE_STRING),
    UINT32_LIST(29, bc.VECTOR, bp.INT),
    ENUM_LIST(30, bc.VECTOR, bp.ENUM),
    SFIXED32_LIST(31, bc.VECTOR, bp.INT),
    SFIXED64_LIST(32, bc.VECTOR, bp.LONG),
    SINT32_LIST(33, bc.VECTOR, bp.INT),
    SINT64_LIST(34, bc.VECTOR, bp.LONG),
    DOUBLE_LIST_PACKED(35, bc.PACKED_VECTOR, bp.DOUBLE),
    FLOAT_LIST_PACKED(36, bc.PACKED_VECTOR, bp.FLOAT),
    INT64_LIST_PACKED(37, bc.PACKED_VECTOR, bp.LONG),
    UINT64_LIST_PACKED(38, bc.PACKED_VECTOR, bp.LONG),
    INT32_LIST_PACKED(39, bc.PACKED_VECTOR, bp.INT),
    FIXED64_LIST_PACKED(40, bc.PACKED_VECTOR, bp.LONG),
    FIXED32_LIST_PACKED(41, bc.PACKED_VECTOR, bp.INT),
    BOOL_LIST_PACKED(42, bc.PACKED_VECTOR, bp.BOOLEAN),
    UINT32_LIST_PACKED(43, bc.PACKED_VECTOR, bp.INT),
    ENUM_LIST_PACKED(44, bc.PACKED_VECTOR, bp.ENUM),
    SFIXED32_LIST_PACKED(45, bc.PACKED_VECTOR, bp.INT),
    SFIXED64_LIST_PACKED(46, bc.PACKED_VECTOR, bp.LONG),
    SINT32_LIST_PACKED(47, bc.PACKED_VECTOR, bp.INT),
    SINT64_LIST_PACKED(48, bc.PACKED_VECTOR, bp.LONG),
    GROUP_LIST(49, bc.VECTOR, bp.MESSAGE),
    MAP(50, bc.MAP, bp.zzkx);
    
    private static final ba[] zzjb = null;
    private static final Type[] zzjc = null;
    private final int id;
    private final bp zzix;
    private final bc zziy;
    private final Class<?> zziz;
    private final boolean zzja;

    static {
        int i2;
        zzjc = new Type[0];
        ba[] values = values();
        zzjb = new ba[values.length];
        for (ba baVar : values) {
            zzjb[baVar.id] = baVar;
        }
    }

    private ba(int i2, bc bcVar, bp bpVar) {
        int i3;
        this.id = i2;
        this.zziy = bcVar;
        this.zzix = bpVar;
        int i4 = bb.f9177a[bcVar.ordinal()];
        this.zziz = (i4 == 1 || i4 == 2) ? bpVar.zzbq() : null;
        boolean z = false;
        if (!(bcVar != bc.SCALAR || (i3 = bb.f9178b[bpVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzja = z;
    }

    public final int id() {
        return this.id;
    }
}
