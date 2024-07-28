package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class SubWalletDetailV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "balance")
    private String balance;
    @b(a = "displayName")
    private String displayName;
    @b(a = "imageUrl")
    private String imageUrl;

    public SubWalletDetailV2() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ SubWalletDetailV2 copy$default(SubWalletDetailV2 subWalletDetailV2, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subWalletDetailV2.displayName;
        }
        if ((i2 & 2) != 0) {
            str2 = subWalletDetailV2.balance;
        }
        if ((i2 & 4) != 0) {
            str3 = subWalletDetailV2.imageUrl;
        }
        return subWalletDetailV2.copy(str, str2, str3);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.balance;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final SubWalletDetailV2 copy(String str, String str2, String str3) {
        return new SubWalletDetailV2(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubWalletDetailV2)) {
            return false;
        }
        SubWalletDetailV2 subWalletDetailV2 = (SubWalletDetailV2) obj;
        return k.a((Object) this.displayName, (Object) subWalletDetailV2.displayName) && k.a((Object) this.balance, (Object) subWalletDetailV2.balance) && k.a((Object) this.imageUrl, (Object) subWalletDetailV2.imageUrl);
    }

    public final int hashCode() {
        String str = this.displayName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.balance;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageUrl;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SubWalletDetailV2(displayName=" + this.displayName + ", balance=" + this.balance + ", imageUrl=" + this.imageUrl + ")";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubWalletDetailV2(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public SubWalletDetailV2(String str, String str2, String str3) {
        this.displayName = str;
        this.balance = str2;
        this.imageUrl = str3;
    }
}
