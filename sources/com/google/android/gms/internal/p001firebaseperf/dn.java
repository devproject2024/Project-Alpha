package com.google.android.gms.internal.p001firebaseperf;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-perf.dn  reason: invalid package */
public enum dn {
    DOUBLE(0, dp.SCALAR, ea.DOUBLE),
    FLOAT(1, dp.SCALAR, ea.FLOAT),
    INT64(2, dp.SCALAR, ea.LONG),
    UINT64(3, dp.SCALAR, ea.LONG),
    INT32(4, dp.SCALAR, ea.INT),
    FIXED64(5, dp.SCALAR, ea.LONG),
    FIXED32(6, dp.SCALAR, ea.INT),
    BOOL(7, dp.SCALAR, ea.BOOLEAN),
    STRING(8, dp.SCALAR, ea.STRING),
    MESSAGE(9, dp.SCALAR, ea.MESSAGE),
    BYTES(10, dp.SCALAR, ea.BYTE_STRING),
    UINT32(11, dp.SCALAR, ea.INT),
    ENUM(12, dp.SCALAR, ea.ENUM),
    SFIXED32(13, dp.SCALAR, ea.INT),
    SFIXED64(14, dp.SCALAR, ea.LONG),
    SINT32(15, dp.SCALAR, ea.INT),
    SINT64(16, dp.SCALAR, ea.LONG),
    GROUP(17, dp.SCALAR, ea.MESSAGE),
    DOUBLE_LIST(18, dp.VECTOR, ea.DOUBLE),
    FLOAT_LIST(19, dp.VECTOR, ea.FLOAT),
    INT64_LIST(20, dp.VECTOR, ea.LONG),
    UINT64_LIST(21, dp.VECTOR, ea.LONG),
    INT32_LIST(22, dp.VECTOR, ea.INT),
    FIXED64_LIST(23, dp.VECTOR, ea.LONG),
    FIXED32_LIST(24, dp.VECTOR, ea.INT),
    BOOL_LIST(25, dp.VECTOR, ea.BOOLEAN),
    STRING_LIST(26, dp.VECTOR, ea.STRING),
    MESSAGE_LIST(27, dp.VECTOR, ea.MESSAGE),
    BYTES_LIST(28, dp.VECTOR, ea.BYTE_STRING),
    UINT32_LIST(29, dp.VECTOR, ea.INT),
    ENUM_LIST(30, dp.VECTOR, ea.ENUM),
    SFIXED32_LIST(31, dp.VECTOR, ea.INT),
    SFIXED64_LIST(32, dp.VECTOR, ea.LONG),
    SINT32_LIST(33, dp.VECTOR, ea.INT),
    SINT64_LIST(34, dp.VECTOR, ea.LONG),
    DOUBLE_LIST_PACKED(35, dp.PACKED_VECTOR, ea.DOUBLE),
    FLOAT_LIST_PACKED(36, dp.PACKED_VECTOR, ea.FLOAT),
    INT64_LIST_PACKED(37, dp.PACKED_VECTOR, ea.LONG),
    UINT64_LIST_PACKED(38, dp.PACKED_VECTOR, ea.LONG),
    INT32_LIST_PACKED(39, dp.PACKED_VECTOR, ea.INT),
    FIXED64_LIST_PACKED(40, dp.PACKED_VECTOR, ea.LONG),
    FIXED32_LIST_PACKED(41, dp.PACKED_VECTOR, ea.INT),
    BOOL_LIST_PACKED(42, dp.PACKED_VECTOR, ea.BOOLEAN),
    UINT32_LIST_PACKED(43, dp.PACKED_VECTOR, ea.INT),
    ENUM_LIST_PACKED(44, dp.PACKED_VECTOR, ea.ENUM),
    SFIXED32_LIST_PACKED(45, dp.PACKED_VECTOR, ea.INT),
    SFIXED64_LIST_PACKED(46, dp.PACKED_VECTOR, ea.LONG),
    SINT32_LIST_PACKED(47, dp.PACKED_VECTOR, ea.INT),
    SINT64_LIST_PACKED(48, dp.PACKED_VECTOR, ea.LONG),
    GROUP_LIST(49, dp.VECTOR, ea.MESSAGE),
    MAP(50, dp.MAP, ea.zzrt);
    
    private static final dn[] zzqj = null;
    private static final Type[] zzqk = null;
    private final int id;
    private final ea zzqf;
    private final dp zzqg;
    private final Class<?> zzqh;
    private final boolean zzqi;

    private dn(int i2, dp dpVar, ea eaVar) {
        int i3;
        this.id = i2;
        this.zzqg = dpVar;
        this.zzqf = eaVar;
        int i4 = dm.f9562a[dpVar.ordinal()];
        if (i4 == 1) {
            this.zzqh = eaVar.zzhz();
        } else if (i4 != 2) {
            this.zzqh = null;
        } else {
            this.zzqh = eaVar.zzhz();
        }
        boolean z = false;
        if (!(dpVar != dp.SCALAR || (i3 = dm.f9563b[eaVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzqi = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i2;
        zzqk = new Type[0];
        dn[] values = values();
        zzqj = new dn[values.length];
        for (dn dnVar : values) {
            zzqj[dnVar.id] = dnVar;
        }
    }
}
