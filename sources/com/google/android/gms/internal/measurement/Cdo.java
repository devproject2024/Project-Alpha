package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.measurement.do  reason: invalid class name */
public enum Cdo {
    DOUBLE(0, dq.SCALAR, ei.DOUBLE),
    FLOAT(1, dq.SCALAR, ei.FLOAT),
    INT64(2, dq.SCALAR, ei.LONG),
    UINT64(3, dq.SCALAR, ei.LONG),
    INT32(4, dq.SCALAR, ei.INT),
    FIXED64(5, dq.SCALAR, ei.LONG),
    FIXED32(6, dq.SCALAR, ei.INT),
    BOOL(7, dq.SCALAR, ei.BOOLEAN),
    STRING(8, dq.SCALAR, ei.STRING),
    MESSAGE(9, dq.SCALAR, ei.MESSAGE),
    BYTES(10, dq.SCALAR, ei.BYTE_STRING),
    UINT32(11, dq.SCALAR, ei.INT),
    ENUM(12, dq.SCALAR, ei.ENUM),
    SFIXED32(13, dq.SCALAR, ei.INT),
    SFIXED64(14, dq.SCALAR, ei.LONG),
    SINT32(15, dq.SCALAR, ei.INT),
    SINT64(16, dq.SCALAR, ei.LONG),
    GROUP(17, dq.SCALAR, ei.MESSAGE),
    DOUBLE_LIST(18, dq.VECTOR, ei.DOUBLE),
    FLOAT_LIST(19, dq.VECTOR, ei.FLOAT),
    INT64_LIST(20, dq.VECTOR, ei.LONG),
    UINT64_LIST(21, dq.VECTOR, ei.LONG),
    INT32_LIST(22, dq.VECTOR, ei.INT),
    FIXED64_LIST(23, dq.VECTOR, ei.LONG),
    FIXED32_LIST(24, dq.VECTOR, ei.INT),
    BOOL_LIST(25, dq.VECTOR, ei.BOOLEAN),
    STRING_LIST(26, dq.VECTOR, ei.STRING),
    MESSAGE_LIST(27, dq.VECTOR, ei.MESSAGE),
    BYTES_LIST(28, dq.VECTOR, ei.BYTE_STRING),
    UINT32_LIST(29, dq.VECTOR, ei.INT),
    ENUM_LIST(30, dq.VECTOR, ei.ENUM),
    SFIXED32_LIST(31, dq.VECTOR, ei.INT),
    SFIXED64_LIST(32, dq.VECTOR, ei.LONG),
    SINT32_LIST(33, dq.VECTOR, ei.INT),
    SINT64_LIST(34, dq.VECTOR, ei.LONG),
    DOUBLE_LIST_PACKED(35, dq.PACKED_VECTOR, ei.DOUBLE),
    FLOAT_LIST_PACKED(36, dq.PACKED_VECTOR, ei.FLOAT),
    INT64_LIST_PACKED(37, dq.PACKED_VECTOR, ei.LONG),
    UINT64_LIST_PACKED(38, dq.PACKED_VECTOR, ei.LONG),
    INT32_LIST_PACKED(39, dq.PACKED_VECTOR, ei.INT),
    FIXED64_LIST_PACKED(40, dq.PACKED_VECTOR, ei.LONG),
    FIXED32_LIST_PACKED(41, dq.PACKED_VECTOR, ei.INT),
    BOOL_LIST_PACKED(42, dq.PACKED_VECTOR, ei.BOOLEAN),
    UINT32_LIST_PACKED(43, dq.PACKED_VECTOR, ei.INT),
    ENUM_LIST_PACKED(44, dq.PACKED_VECTOR, ei.ENUM),
    SFIXED32_LIST_PACKED(45, dq.PACKED_VECTOR, ei.INT),
    SFIXED64_LIST_PACKED(46, dq.PACKED_VECTOR, ei.LONG),
    SINT32_LIST_PACKED(47, dq.PACKED_VECTOR, ei.INT),
    SINT64_LIST_PACKED(48, dq.PACKED_VECTOR, ei.LONG),
    GROUP_LIST(49, dq.VECTOR, ei.MESSAGE),
    MAP(50, dq.MAP, ei.zza);
    
    private static final Cdo[] zzbe = null;
    private static final Type[] zzbf = null;
    private final ei zzaz;
    private final int zzba;
    private final dq zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    private Cdo(int i2, dq dqVar, ei eiVar) {
        int i3;
        this.zzba = i2;
        this.zzbb = dqVar;
        this.zzaz = eiVar;
        int i4 = ds.f10585a[dqVar.ordinal()];
        if (i4 == 1) {
            this.zzbc = eiVar.zza();
        } else if (i4 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = eiVar.zza();
        }
        boolean z = false;
        if (!(dqVar != dq.SCALAR || (i3 = ds.f10586b[eiVar.ordinal()]) == 1 || i3 == 2 || i3 == 3)) {
            z = true;
        }
        this.zzbd = z;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        int i2;
        zzbf = new Type[0];
        Cdo[] values = values();
        zzbe = new Cdo[values.length];
        for (Cdo doVar : values) {
            zzbe[doVar.zzba] = doVar;
        }
    }
}
