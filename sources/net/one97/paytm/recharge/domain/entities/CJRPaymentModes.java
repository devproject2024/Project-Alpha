package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPaymentModes extends IJRPaytmDataModel {
    private CJRFetchBalanceResponse availableBalance;
    @b(a = "displayName")
    private String displayName;
    private boolean isInsufficientBalance;
    private boolean isSelected;
    @b(a = "payChannelOptions")
    private ArrayList<CJRPayChannelOptions> payChannelOptions;
    @b(a = "paymentMode")
    private String paymentMode;

    public CJRPaymentModes() {
        this((String) null, (String) null, (ArrayList) null, false, (CJRFetchBalanceResponse) null, false, 63, (g) null);
    }

    public static /* synthetic */ CJRPaymentModes copy$default(CJRPaymentModes cJRPaymentModes, String str, String str2, ArrayList<CJRPayChannelOptions> arrayList, boolean z, CJRFetchBalanceResponse cJRFetchBalanceResponse, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRPaymentModes.displayName;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRPaymentModes.paymentMode;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            arrayList = cJRPaymentModes.payChannelOptions;
        }
        ArrayList<CJRPayChannelOptions> arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            z = cJRPaymentModes.isSelected;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            cJRFetchBalanceResponse = cJRPaymentModes.availableBalance;
        }
        CJRFetchBalanceResponse cJRFetchBalanceResponse2 = cJRFetchBalanceResponse;
        if ((i2 & 32) != 0) {
            z2 = cJRPaymentModes.isInsufficientBalance;
        }
        return cJRPaymentModes.copy(str, str3, arrayList2, z3, cJRFetchBalanceResponse2, z2);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.paymentMode;
    }

    public final ArrayList<CJRPayChannelOptions> component3() {
        return this.payChannelOptions;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final CJRFetchBalanceResponse component5() {
        return this.availableBalance;
    }

    public final boolean component6() {
        return this.isInsufficientBalance;
    }

    public final CJRPaymentModes copy(String str, String str2, ArrayList<CJRPayChannelOptions> arrayList, boolean z, CJRFetchBalanceResponse cJRFetchBalanceResponse, boolean z2) {
        return new CJRPaymentModes(str, str2, arrayList, z, cJRFetchBalanceResponse, z2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRPaymentModes) {
                CJRPaymentModes cJRPaymentModes = (CJRPaymentModes) obj;
                if (k.a((Object) this.displayName, (Object) cJRPaymentModes.displayName) && k.a((Object) this.paymentMode, (Object) cJRPaymentModes.paymentMode) && k.a((Object) this.payChannelOptions, (Object) cJRPaymentModes.payChannelOptions)) {
                    if ((this.isSelected == cJRPaymentModes.isSelected) && k.a((Object) this.availableBalance, (Object) cJRPaymentModes.availableBalance)) {
                        if (this.isInsufficientBalance == cJRPaymentModes.isInsufficientBalance) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.displayName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paymentMode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<CJRPayChannelOptions> arrayList = this.payChannelOptions;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        CJRFetchBalanceResponse cJRFetchBalanceResponse = this.availableBalance;
        if (cJRFetchBalanceResponse != null) {
            i2 = cJRFetchBalanceResponse.hashCode();
        }
        int i4 = (i3 + i2) * 31;
        boolean z2 = this.isInsufficientBalance;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "CJRPaymentModes(displayName=" + this.displayName + ", paymentMode=" + this.paymentMode + ", payChannelOptions=" + this.payChannelOptions + ", isSelected=" + this.isSelected + ", availableBalance=" + this.availableBalance + ", isInsufficientBalance=" + this.isInsufficientBalance + ")";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final ArrayList<CJRPayChannelOptions> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public final void setPayChannelOptions(ArrayList<CJRPayChannelOptions> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final CJRFetchBalanceResponse getAvailableBalance() {
        return this.availableBalance;
    }

    public final void setAvailableBalance(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        this.availableBalance = cJRFetchBalanceResponse;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPaymentModes(java.lang.String r5, java.lang.String r6, java.util.ArrayList r7, boolean r8, net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse r9, boolean r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r11 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001d
            r3 = 0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r9
        L_0x0024:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002a
            r11 = 0
            goto L_0x002b
        L_0x002a:
            r11 = r10
        L_0x002b:
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r3
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRPaymentModes.<init>(java.lang.String, java.lang.String, java.util.ArrayList, boolean, net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isInsufficientBalance() {
        return this.isInsufficientBalance;
    }

    public final void setInsufficientBalance(boolean z) {
        this.isInsufficientBalance = z;
    }

    public CJRPaymentModes(String str, String str2, ArrayList<CJRPayChannelOptions> arrayList, boolean z, CJRFetchBalanceResponse cJRFetchBalanceResponse, boolean z2) {
        this.displayName = str;
        this.paymentMode = str2;
        this.payChannelOptions = arrayList;
        this.isSelected = z;
        this.availableBalance = cJRFetchBalanceResponse;
        this.isInsufficientBalance = z2;
    }
}
