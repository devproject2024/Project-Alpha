package com.alibaba.a.b;

public enum c {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean;
    
    private final int mask;

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i2, c cVar) {
        return (i2 & cVar.getMask()) != 0;
    }

    public static int config(int i2, c cVar, boolean z) {
        if (z) {
            return i2 | cVar.getMask();
        }
        return i2 & (~cVar.getMask());
    }

    public static int of(c[] cVarArr) {
        if (cVarArr == null) {
            return 0;
        }
        int i2 = 0;
        for (c mask2 : cVarArr) {
            i2 |= mask2.getMask();
        }
        return i2;
    }
}
