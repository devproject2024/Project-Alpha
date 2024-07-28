package com.paytm.contactsSdk.models;

public final class MappingInfo {
    private final long bitCode;
    private final int columnNumber;

    public static /* synthetic */ MappingInfo copy$default(MappingInfo mappingInfo, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = mappingInfo.columnNumber;
        }
        if ((i3 & 2) != 0) {
            j = mappingInfo.bitCode;
        }
        return mappingInfo.copy(i2, j);
    }

    public final int component1() {
        return this.columnNumber;
    }

    public final long component2() {
        return this.bitCode;
    }

    public final MappingInfo copy(int i2, long j) {
        return new MappingInfo(i2, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MappingInfo)) {
            return false;
        }
        MappingInfo mappingInfo = (MappingInfo) obj;
        return this.columnNumber == mappingInfo.columnNumber && this.bitCode == mappingInfo.bitCode;
    }

    public final int hashCode() {
        return (Integer.valueOf(this.columnNumber).hashCode() * 31) + Long.valueOf(this.bitCode).hashCode();
    }

    public final String toString() {
        return "MappingInfo(columnNumber=" + this.columnNumber + ", bitCode=" + this.bitCode + ")";
    }

    public MappingInfo(int i2, long j) {
        this.columnNumber = i2;
        this.bitCode = j;
    }

    public final int getColumnNumber() {
        return this.columnNumber;
    }

    public final long getBitCode() {
        return this.bitCode;
    }
}
