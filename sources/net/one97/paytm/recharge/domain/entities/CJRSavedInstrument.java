package net.one97.paytm.recharge.domain.entities;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class CJRSavedInstrument extends IJRPaytmDataModel {
    @b(a = "authModes")
    private ArrayList<String> authModes;
    @b(a = "cardDetails")
    private CJRCardDetails cardDetails;
    @b(a = "channelCode")
    private String channelCode;
    @b(a = "displayName")
    private String displayName;
    @b(a = "iconUrl")
    private String iconUrl;
    private boolean isSelected;
    @b(a = "issuingBank")
    private String issuingBank;

    public CJRSavedInstrument() {
        this((String) null, (String) null, (ArrayList) null, (String) null, (String) null, (CJRCardDetails) null, false, 127, (g) null);
    }

    public static /* synthetic */ CJRSavedInstrument copy$default(CJRSavedInstrument cJRSavedInstrument, String str, String str2, ArrayList<String> arrayList, String str3, String str4, CJRCardDetails cJRCardDetails, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRSavedInstrument.iconUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRSavedInstrument.issuingBank;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            arrayList = cJRSavedInstrument.authModes;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            str3 = cJRSavedInstrument.displayName;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = cJRSavedInstrument.channelCode;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            cJRCardDetails = cJRSavedInstrument.cardDetails;
        }
        CJRCardDetails cJRCardDetails2 = cJRCardDetails;
        if ((i2 & 64) != 0) {
            z = cJRSavedInstrument.isSelected;
        }
        return cJRSavedInstrument.copy(str, str5, arrayList2, str6, str7, cJRCardDetails2, z);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.issuingBank;
    }

    public final ArrayList<String> component3() {
        return this.authModes;
    }

    public final String component4() {
        return this.displayName;
    }

    public final String component5() {
        return this.channelCode;
    }

    public final CJRCardDetails component6() {
        return this.cardDetails;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    public final CJRSavedInstrument copy(String str, String str2, ArrayList<String> arrayList, String str3, String str4, CJRCardDetails cJRCardDetails, boolean z) {
        return new CJRSavedInstrument(str, str2, arrayList, str3, str4, cJRCardDetails, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRSavedInstrument) {
                CJRSavedInstrument cJRSavedInstrument = (CJRSavedInstrument) obj;
                if (k.a((Object) this.iconUrl, (Object) cJRSavedInstrument.iconUrl) && k.a((Object) this.issuingBank, (Object) cJRSavedInstrument.issuingBank) && k.a((Object) this.authModes, (Object) cJRSavedInstrument.authModes) && k.a((Object) this.displayName, (Object) cJRSavedInstrument.displayName) && k.a((Object) this.channelCode, (Object) cJRSavedInstrument.channelCode) && k.a((Object) this.cardDetails, (Object) cJRSavedInstrument.cardDetails)) {
                    if (this.isSelected == cJRSavedInstrument.isSelected) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.iconUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.issuingBank;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.authModes;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str3 = this.displayName;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelCode;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        CJRCardDetails cJRCardDetails = this.cardDetails;
        if (cJRCardDetails != null) {
            i2 = cJRCardDetails.hashCode();
        }
        int i3 = (hashCode5 + i2) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CJRSavedInstrument(iconUrl=" + this.iconUrl + ", issuingBank=" + this.issuingBank + ", authModes=" + this.authModes + ", displayName=" + this.displayName + ", channelCode=" + this.channelCode + ", cardDetails=" + this.cardDetails + ", isSelected=" + this.isSelected + ")";
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public final ArrayList<String> getAuthModes() {
        return this.authModes;
    }

    public final void setAuthModes(ArrayList<String> arrayList) {
        this.authModes = arrayList;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final CJRCardDetails getCardDetails() {
        return this.cardDetails;
    }

    public final void setCardDetails(CJRCardDetails cJRCardDetails) {
        this.cardDetails = cJRCardDetails;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSavedInstrument(java.lang.String r6, java.lang.String r7, java.util.ArrayList r8, java.lang.String r9, java.lang.String r10, net.one97.paytm.recharge.domain.entities.CJRCardDetails r11, boolean r12, int r13, kotlin.g.b.g r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r14 = r0
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r13 & 32
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r0 = r11
        L_0x002a:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0031
            r12 = 0
            r13 = 0
            goto L_0x0032
        L_0x0031:
            r13 = r12
        L_0x0032:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRSavedInstrument.<init>(java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, net.one97.paytm.recharge.domain.entities.CJRCardDetails, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public CJRSavedInstrument(String str, String str2, ArrayList<String> arrayList, String str3, String str4, CJRCardDetails cJRCardDetails, boolean z) {
        this.iconUrl = str;
        this.issuingBank = str2;
        this.authModes = arrayList;
        this.displayName = str3;
        this.channelCode = str4;
        this.cardDetails = cJRCardDetails;
        this.isSelected = z;
    }

    public final String getMaskCardNumber() {
        String str;
        String str2;
        String firstSixDigit;
        String firstSixDigit2;
        CJRCardDetails cJRCardDetails = this.cardDetails;
        String str3 = null;
        if (cJRCardDetails == null || (firstSixDigit2 = cJRCardDetails.getFirstSixDigit()) == null) {
            str = null;
        } else if (firstSixDigit2 != null) {
            str = firstSixDigit2.substring(0, 4);
            k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CJRCardDetails cJRCardDetails2 = this.cardDetails;
        if (TextUtils.isEmpty(cJRCardDetails2 != null ? cJRCardDetails2.getLastFourDigit() : null)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        CJRCardDetails cJRCardDetails3 = this.cardDetails;
        if (cJRCardDetails3 == null || (firstSixDigit = cJRCardDetails3.getFirstSixDigit()) == null) {
            str2 = null;
        } else if (firstSixDigit != null) {
            str2 = firstSixDigit.substring(0, 4);
            k.a((Object) str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        sb.append(str2);
        sb.append(" XXXX ");
        CJRCardDetails cJRCardDetails4 = this.cardDetails;
        if (cJRCardDetails4 != null) {
            str3 = cJRCardDetails4.getLastFourDigit();
        }
        sb.append(str3);
        return sb.toString();
    }

    public final String getLastFourDigits() {
        CJRCardDetails cJRCardDetails = this.cardDetails;
        String str = null;
        if (TextUtils.isEmpty(cJRCardDetails != null ? cJRCardDetails.getLastFourDigit() : null)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("XX ");
        CJRCardDetails cJRCardDetails2 = this.cardDetails;
        if (cJRCardDetails2 != null) {
            str = cJRCardDetails2.getLastFourDigit();
        }
        sb.append(str);
        return sb.toString();
    }
}
