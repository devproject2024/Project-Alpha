package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Type;

public enum ge {
    DOUBLE(0, gf.SCALAR, gr.DOUBLE),
    FLOAT(1, gf.SCALAR, gr.FLOAT),
    INT64(2, gf.SCALAR, gr.LONG),
    UINT64(3, gf.SCALAR, gr.LONG),
    INT32(4, gf.SCALAR, gr.INT),
    FIXED64(5, gf.SCALAR, gr.LONG),
    FIXED32(6, gf.SCALAR, gr.INT),
    BOOL(7, gf.SCALAR, gr.BOOLEAN),
    STRING(8, gf.SCALAR, gr.STRING),
    MESSAGE(9, gf.SCALAR, gr.MESSAGE),
    BYTES(10, gf.SCALAR, gr.BYTE_STRING),
    UINT32(11, gf.SCALAR, gr.INT),
    ENUM(12, gf.SCALAR, gr.ENUM),
    SFIXED32(13, gf.SCALAR, gr.INT),
    SFIXED64(14, gf.SCALAR, gr.LONG),
    SINT32(15, gf.SCALAR, gr.INT),
    SINT64(16, gf.SCALAR, gr.LONG),
    GROUP(17, gf.SCALAR, gr.MESSAGE),
    DOUBLE_LIST(18, gf.VECTOR, gr.DOUBLE),
    FLOAT_LIST(19, gf.VECTOR, gr.FLOAT),
    INT64_LIST(20, gf.VECTOR, gr.LONG),
    UINT64_LIST(21, gf.VECTOR, gr.LONG),
    INT32_LIST(22, gf.VECTOR, gr.INT),
    FIXED64_LIST(23, gf.VECTOR, gr.LONG),
    FIXED32_LIST(24, gf.VECTOR, gr.INT),
    BOOL_LIST(25, gf.VECTOR, gr.BOOLEAN),
    STRING_LIST(26, gf.VECTOR, gr.STRING),
    MESSAGE_LIST(27, gf.VECTOR, gr.MESSAGE),
    BYTES_LIST(28, gf.VECTOR, gr.BYTE_STRING),
    UINT32_LIST(29, gf.VECTOR, gr.INT),
    ENUM_LIST(30, gf.VECTOR, gr.ENUM),
    SFIXED32_LIST(31, gf.VECTOR, gr.INT),
    SFIXED64_LIST(32, gf.VECTOR, gr.LONG),
    SINT32_LIST(33, gf.VECTOR, gr.INT),
    SINT64_LIST(34, gf.VECTOR, gr.LONG),
    DOUBLE_LIST_PACKED(35, gf.PACKED_VECTOR, gr.DOUBLE),
    FLOAT_LIST_PACKED(36, gf.PACKED_VECTOR, gr.FLOAT),
    INT64_LIST_PACKED(37, gf.PACKED_VECTOR, gr.LONG),
    UINT64_LIST_PACKED(38, gf.PACKED_VECTOR, gr.LONG),
    INT32_LIST_PACKED(39, gf.PACKED_VECTOR, gr.INT),
    FIXED64_LIST_PACKED(40, gf.PACKED_VECTOR, gr.LONG),
    FIXED32_LIST_PACKED(41, gf.PACKED_VECTOR, gr.INT),
    BOOL_LIST_PACKED(42, gf.PACKED_VECTOR, gr.BOOLEAN),
    UINT32_LIST_PACKED(43, gf.PACKED_VECTOR, gr.INT),
    ENUM_LIST_PACKED(44, gf.PACKED_VECTOR, gr.ENUM),
    SFIXED32_LIST_PACKED(45, gf.PACKED_VECTOR, gr.INT),
    SFIXED64_LIST_PACKED(46, gf.PACKED_VECTOR, gr.LONG),
    SINT32_LIST_PACKED(47, gf.PACKED_VECTOR, gr.INT),
    SINT64_LIST_PACKED(48, gf.PACKED_VECTOR, gr.LONG),
    GROUP_LIST(49, gf.VECTOR, gr.MESSAGE),
    MAP(50, gf.MAP, gr.zzcml);
    
    private static final ge[] zzcky = null;
    private static final Type[] zzckz = null;
    private final int id;
    private final gr zzcku;
    private final gf zzckv;
    private final Class<?> zzckw;
    private final boolean zzckx;

    private ge(int i2, gf gfVar, gr grVar) {
        int i3;
        this.id = i2;
        this.zzckv = gfVar;
        this.zzcku = grVar;
        int i4 = gd.f9916a[gfVar.ordinal()];
        if (i4 == 1) {
            this.zzckw = grVar.zzvk();
        } else if (i4 != 2) {
            this.zzckw = null;
        } else {
            this.zzckw = grVar.zzvk();
        }
        boolean z = false;
        if (!(gfVar != gf.SCALAR || (i3 = gd.f9917b[grVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzckx = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i2;
        zzckz = new Type[0];
        ge[] values = values();
        zzcky = new ge[values.length];
        for (ge geVar : values) {
            zzcky[geVar.id] = geVar;
        }
    }
}
