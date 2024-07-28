package com.paytm.contactsSdk.models.responses.Search;

public final class ExtendedInfo {
    private final long ownerId;

    public static /* synthetic */ ExtendedInfo copy$default(ExtendedInfo extendedInfo, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = extendedInfo.ownerId;
        }
        return extendedInfo.copy(j);
    }

    public final long component1() {
        return this.ownerId;
    }

    public final ExtendedInfo copy(long j) {
        return new ExtendedInfo(j);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ExtendedInfo) && this.ownerId == ((ExtendedInfo) obj).ownerId;
        }
        return true;
    }

    public final int hashCode() {
        return Long.valueOf(this.ownerId).hashCode();
    }

    public final String toString() {
        return "ExtendedInfo(ownerId=" + this.ownerId + ")";
    }

    public ExtendedInfo(long j) {
        this.ownerId = j;
    }

    public final long getOwnerId() {
        return this.ownerId;
    }
}
