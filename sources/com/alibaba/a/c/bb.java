package com.alibaba.a.c;

public enum bb {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue;
    
    private final int mask;

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i2, bb bbVar) {
        return (i2 & bbVar.getMask()) != 0;
    }

    public static int config(int i2, bb bbVar, boolean z) {
        if (z) {
            return i2 | bbVar.getMask();
        }
        return i2 & (~bbVar.getMask());
    }

    public static int of(bb[] bbVarArr) {
        if (bbVarArr == null) {
            return 0;
        }
        int i2 = 0;
        for (bb mask2 : bbVarArr) {
            i2 |= mask2.getMask();
        }
        return i2;
    }
}
