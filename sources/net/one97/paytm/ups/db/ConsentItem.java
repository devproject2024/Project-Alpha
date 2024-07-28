package net.one97.paytm.ups.db;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.google.gsonhtcfix.a.b;
import java.util.Date;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentItem {
    @b(a = "consentKey")
    private String consentKey;
    @b(a = "value")
    private String consentValue;
    @b(a = "syncTimestamp")
    private long syncTimestamp;
    @b(a = "syncedWithServer")
    private boolean syncedWithServer;
    @b(a = "verticalId")
    private String verticalId;

    public static /* synthetic */ ConsentItem copy$default(ConsentItem consentItem, String str, String str2, boolean z, String str3, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consentItem.consentKey;
        }
        if ((i2 & 2) != 0) {
            str2 = consentItem.consentValue;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            z = consentItem.syncedWithServer;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = consentItem.verticalId;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            j = consentItem.syncTimestamp;
        }
        return consentItem.copy(str, str4, z2, str5, j);
    }

    public final String component1() {
        return this.consentKey;
    }

    public final String component2() {
        return this.consentValue;
    }

    public final boolean component3() {
        return this.syncedWithServer;
    }

    public final String component4() {
        return this.verticalId;
    }

    public final long component5() {
        return this.syncTimestamp;
    }

    public final ConsentItem copy(String str, String str2, boolean z, String str3, long j) {
        k.c(str, "consentKey");
        k.c(str3, "verticalId");
        return new ConsentItem(str, str2, z, str3, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentItem)) {
            return false;
        }
        ConsentItem consentItem = (ConsentItem) obj;
        return k.a((Object) this.consentKey, (Object) consentItem.consentKey) && k.a((Object) this.consentValue, (Object) consentItem.consentValue) && this.syncedWithServer == consentItem.syncedWithServer && k.a((Object) this.verticalId, (Object) consentItem.verticalId) && this.syncTimestamp == consentItem.syncTimestamp;
    }

    public final int hashCode() {
        String str = this.consentKey;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consentValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.syncedWithServer;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.verticalId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((i3 + i2) * 31) + Long.valueOf(this.syncTimestamp).hashCode();
    }

    public ConsentItem(String str, String str2, boolean z, String str3, long j) {
        k.c(str, "consentKey");
        k.c(str3, "verticalId");
        this.consentKey = str;
        this.consentValue = str2;
        this.syncedWithServer = z;
        this.verticalId = str3;
        this.syncTimestamp = j;
    }

    public final String getConsentKey() {
        return this.consentKey;
    }

    public final void setConsentKey(String str) {
        k.c(str, "<set-?>");
        this.consentKey = str;
    }

    public final String getConsentValue() {
        return this.consentValue;
    }

    public final void setConsentValue(String str) {
        this.consentValue = str;
    }

    public final boolean getSyncedWithServer() {
        return this.syncedWithServer;
    }

    public final void setSyncedWithServer(boolean z) {
        this.syncedWithServer = z;
    }

    public final String getVerticalId() {
        return this.verticalId;
    }

    public final void setVerticalId(String str) {
        k.c(str, "<set-?>");
        this.verticalId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentItem(String str, String str2, boolean z, String str3, long j, int i2, g gVar) {
        this(str, str2, z, (i2 & 8) != 0 ? H5BridgeContext.INVALID_ID : str3, (i2 & 16) != 0 ? new Date().getTime() : j);
    }

    public final long getSyncTimestamp() {
        return this.syncTimestamp;
    }

    public final void setSyncTimestamp(long j) {
        this.syncTimestamp = j;
    }

    public final String toString() {
        return "Key Name " + this.consentKey + " Value = " + this.consentValue;
    }
}
