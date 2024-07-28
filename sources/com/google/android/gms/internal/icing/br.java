package com.google.android.gms.internal.icing;

import java.lang.reflect.Type;

public enum br {
    DOUBLE(0, bt.SCALAR, cf.DOUBLE),
    FLOAT(1, bt.SCALAR, cf.FLOAT),
    INT64(2, bt.SCALAR, cf.LONG),
    UINT64(3, bt.SCALAR, cf.LONG),
    INT32(4, bt.SCALAR, cf.INT),
    FIXED64(5, bt.SCALAR, cf.LONG),
    FIXED32(6, bt.SCALAR, cf.INT),
    BOOL(7, bt.SCALAR, cf.BOOLEAN),
    STRING(8, bt.SCALAR, cf.STRING),
    MESSAGE(9, bt.SCALAR, cf.MESSAGE),
    BYTES(10, bt.SCALAR, cf.BYTE_STRING),
    UINT32(11, bt.SCALAR, cf.INT),
    ENUM(12, bt.SCALAR, cf.ENUM),
    SFIXED32(13, bt.SCALAR, cf.INT),
    SFIXED64(14, bt.SCALAR, cf.LONG),
    SINT32(15, bt.SCALAR, cf.INT),
    SINT64(16, bt.SCALAR, cf.LONG),
    GROUP(17, bt.SCALAR, cf.MESSAGE),
    DOUBLE_LIST(18, bt.VECTOR, cf.DOUBLE),
    FLOAT_LIST(19, bt.VECTOR, cf.FLOAT),
    INT64_LIST(20, bt.VECTOR, cf.LONG),
    UINT64_LIST(21, bt.VECTOR, cf.LONG),
    INT32_LIST(22, bt.VECTOR, cf.INT),
    FIXED64_LIST(23, bt.VECTOR, cf.LONG),
    FIXED32_LIST(24, bt.VECTOR, cf.INT),
    BOOL_LIST(25, bt.VECTOR, cf.BOOLEAN),
    STRING_LIST(26, bt.VECTOR, cf.STRING),
    MESSAGE_LIST(27, bt.VECTOR, cf.MESSAGE),
    BYTES_LIST(28, bt.VECTOR, cf.BYTE_STRING),
    UINT32_LIST(29, bt.VECTOR, cf.INT),
    ENUM_LIST(30, bt.VECTOR, cf.ENUM),
    SFIXED32_LIST(31, bt.VECTOR, cf.INT),
    SFIXED64_LIST(32, bt.VECTOR, cf.LONG),
    SINT32_LIST(33, bt.VECTOR, cf.INT),
    SINT64_LIST(34, bt.VECTOR, cf.LONG),
    DOUBLE_LIST_PACKED(35, bt.PACKED_VECTOR, cf.DOUBLE),
    FLOAT_LIST_PACKED(36, bt.PACKED_VECTOR, cf.FLOAT),
    INT64_LIST_PACKED(37, bt.PACKED_VECTOR, cf.LONG),
    UINT64_LIST_PACKED(38, bt.PACKED_VECTOR, cf.LONG),
    INT32_LIST_PACKED(39, bt.PACKED_VECTOR, cf.INT),
    FIXED64_LIST_PACKED(40, bt.PACKED_VECTOR, cf.LONG),
    FIXED32_LIST_PACKED(41, bt.PACKED_VECTOR, cf.INT),
    BOOL_LIST_PACKED(42, bt.PACKED_VECTOR, cf.BOOLEAN),
    UINT32_LIST_PACKED(43, bt.PACKED_VECTOR, cf.INT),
    ENUM_LIST_PACKED(44, bt.PACKED_VECTOR, cf.ENUM),
    SFIXED32_LIST_PACKED(45, bt.PACKED_VECTOR, cf.INT),
    SFIXED64_LIST_PACKED(46, bt.PACKED_VECTOR, cf.LONG),
    SINT32_LIST_PACKED(47, bt.PACKED_VECTOR, cf.INT),
    SINT64_LIST_PACKED(48, bt.PACKED_VECTOR, cf.LONG),
    GROUP_LIST(49, bt.VECTOR, cf.MESSAGE),
    MAP(50, bt.MAP, cf.zzkv);
    
    private static final br[] zzji = null;
    private static final Type[] zzjj = null;
    private final int id;
    private final cf zzje;
    private final bt zzjf;
    private final Class<?> zzjg;
    private final boolean zzjh;

    private br(int i2, bt btVar, cf cfVar) {
        int i3;
        this.id = i2;
        this.zzjf = btVar;
        this.zzje = cfVar;
        int i4 = bu.f10103a[btVar.ordinal()];
        if (i4 == 1) {
            this.zzjg = cfVar.zzca();
        } else if (i4 != 2) {
            this.zzjg = null;
        } else {
            this.zzjg = cfVar.zzca();
        }
        boolean z = false;
        if (!(btVar != bt.SCALAR || (i3 = bu.f10104b[cfVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzjh = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i2;
        zzjj = new Type[0];
        br[] values = values();
        zzji = new br[values.length];
        for (br brVar : values) {
            zzji[brVar.id] = brVar;
        }
    }
}
