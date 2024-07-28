package net.one97.paytm.p2mNewDesign.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.Arrays;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SavedInstrumentsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "authModes")
    private String[] authModes;
    @b(a = "cardDetails")
    private CardDetailsV2 cardDetails;
    @b(a = "channelCode")
    private String channelCode;
    @b(a = "channelName")
    private String channelName;
    @b(a = "displayName")
    private String displayName;
    @b(a = "emiDetails")
    private EmiDetailsV2 emiDetails;
    @b(a = "hasLowSuccess")
    private HasLowSuccessV2 hasLowSuccess;
    @b(a = "iconUrl")
    private String iconUrl;
    @b(a = "isDisabled")
    private IsDisabledV2 isDisabled;
    @b(a = "isEmiAvailable")
    private boolean isEmiAvailable;
    @b(a = "issuingBank")
    private String issuingBank;
    @b(a = "issuingBankCode")
    private String issuingBankCode;
    @b(a = "maxAmount")
    private AmountV2 maxAmount;
    @b(a = "minAmount")
    private AmountV2 minAmount;
    @b(a = "oneClickSupported")
    private boolean oneClickSupported;
    @b(a = "priority")
    private String priority;
    @b(a = "selectedAuthMode")
    private String selectedAuthMode;

    public SavedInstrumentsV2() {
        this((String) null, (IsDisabledV2) null, (String) null, (EmiDetailsV2) null, (String) null, false, (String) null, (String) null, (String) null, (String[]) null, (HasLowSuccessV2) null, (CardDetailsV2) null, (AmountV2) null, (AmountV2) null, false, (String) null, (String) null, 131071, (g) null);
    }

    public static /* synthetic */ SavedInstrumentsV2 copy$default(SavedInstrumentsV2 savedInstrumentsV2, String str, IsDisabledV2 isDisabledV2, String str2, EmiDetailsV2 emiDetailsV2, String str3, boolean z, String str4, String str5, String str6, String[] strArr, HasLowSuccessV2 hasLowSuccessV2, CardDetailsV2 cardDetailsV2, AmountV2 amountV2, AmountV2 amountV22, boolean z2, String str7, String str8, int i2, Object obj) {
        SavedInstrumentsV2 savedInstrumentsV22 = savedInstrumentsV2;
        int i3 = i2;
        return savedInstrumentsV2.copy((i3 & 1) != 0 ? savedInstrumentsV22.selectedAuthMode : str, (i3 & 2) != 0 ? savedInstrumentsV22.isDisabled : isDisabledV2, (i3 & 4) != 0 ? savedInstrumentsV22.channelName : str2, (i3 & 8) != 0 ? savedInstrumentsV22.emiDetails : emiDetailsV2, (i3 & 16) != 0 ? savedInstrumentsV22.channelCode : str3, (i3 & 32) != 0 ? savedInstrumentsV22.oneClickSupported : z, (i3 & 64) != 0 ? savedInstrumentsV22.issuingBankCode : str4, (i3 & 128) != 0 ? savedInstrumentsV22.issuingBank : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? savedInstrumentsV22.iconUrl : str6, (i3 & 512) != 0 ? savedInstrumentsV22.authModes : strArr, (i3 & TarConstants.EOF_BLOCK) != 0 ? savedInstrumentsV22.hasLowSuccess : hasLowSuccessV2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? savedInstrumentsV22.cardDetails : cardDetailsV2, (i3 & 4096) != 0 ? savedInstrumentsV22.minAmount : amountV2, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? savedInstrumentsV22.maxAmount : amountV22, (i3 & 16384) != 0 ? savedInstrumentsV22.isEmiAvailable : z2, (i3 & 32768) != 0 ? savedInstrumentsV22.displayName : str7, (i3 & 65536) != 0 ? savedInstrumentsV22.priority : str8);
    }

    public final String component1() {
        return this.selectedAuthMode;
    }

    public final String[] component10() {
        return this.authModes;
    }

    public final HasLowSuccessV2 component11() {
        return this.hasLowSuccess;
    }

    public final CardDetailsV2 component12() {
        return this.cardDetails;
    }

    public final AmountV2 component13() {
        return this.minAmount;
    }

    public final AmountV2 component14() {
        return this.maxAmount;
    }

    public final boolean component15() {
        return this.isEmiAvailable;
    }

    public final String component16() {
        return this.displayName;
    }

    public final String component17() {
        return this.priority;
    }

    public final IsDisabledV2 component2() {
        return this.isDisabled;
    }

    public final String component3() {
        return this.channelName;
    }

    public final EmiDetailsV2 component4() {
        return this.emiDetails;
    }

    public final String component5() {
        return this.channelCode;
    }

    public final boolean component6() {
        return this.oneClickSupported;
    }

    public final String component7() {
        return this.issuingBankCode;
    }

    public final String component8() {
        return this.issuingBank;
    }

    public final String component9() {
        return this.iconUrl;
    }

    public final SavedInstrumentsV2 copy(String str, IsDisabledV2 isDisabledV2, String str2, EmiDetailsV2 emiDetailsV2, String str3, boolean z, String str4, String str5, String str6, String[] strArr, HasLowSuccessV2 hasLowSuccessV2, CardDetailsV2 cardDetailsV2, AmountV2 amountV2, AmountV2 amountV22, boolean z2, String str7, String str8) {
        return new SavedInstrumentsV2(str, isDisabledV2, str2, emiDetailsV2, str3, z, str4, str5, str6, strArr, hasLowSuccessV2, cardDetailsV2, amountV2, amountV22, z2, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SavedInstrumentsV2) {
                SavedInstrumentsV2 savedInstrumentsV2 = (SavedInstrumentsV2) obj;
                if (k.a((Object) this.selectedAuthMode, (Object) savedInstrumentsV2.selectedAuthMode) && k.a((Object) this.isDisabled, (Object) savedInstrumentsV2.isDisabled) && k.a((Object) this.channelName, (Object) savedInstrumentsV2.channelName) && k.a((Object) this.emiDetails, (Object) savedInstrumentsV2.emiDetails) && k.a((Object) this.channelCode, (Object) savedInstrumentsV2.channelCode)) {
                    if ((this.oneClickSupported == savedInstrumentsV2.oneClickSupported) && k.a((Object) this.issuingBankCode, (Object) savedInstrumentsV2.issuingBankCode) && k.a((Object) this.issuingBank, (Object) savedInstrumentsV2.issuingBank) && k.a((Object) this.iconUrl, (Object) savedInstrumentsV2.iconUrl) && k.a((Object) this.authModes, (Object) savedInstrumentsV2.authModes) && k.a((Object) this.hasLowSuccess, (Object) savedInstrumentsV2.hasLowSuccess) && k.a((Object) this.cardDetails, (Object) savedInstrumentsV2.cardDetails) && k.a((Object) this.minAmount, (Object) savedInstrumentsV2.minAmount) && k.a((Object) this.maxAmount, (Object) savedInstrumentsV2.maxAmount)) {
                        if (!(this.isEmiAvailable == savedInstrumentsV2.isEmiAvailable) || !k.a((Object) this.displayName, (Object) savedInstrumentsV2.displayName) || !k.a((Object) this.priority, (Object) savedInstrumentsV2.priority)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.selectedAuthMode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        IsDisabledV2 isDisabledV2 = this.isDisabled;
        int hashCode2 = (hashCode + (isDisabledV2 != null ? isDisabledV2.hashCode() : 0)) * 31;
        String str2 = this.channelName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        EmiDetailsV2 emiDetailsV2 = this.emiDetails;
        int hashCode4 = (hashCode3 + (emiDetailsV2 != null ? emiDetailsV2.hashCode() : 0)) * 31;
        String str3 = this.channelCode;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.oneClickSupported;
        if (z) {
            z = true;
        }
        int i3 = (hashCode5 + (z ? 1 : 0)) * 31;
        String str4 = this.issuingBankCode;
        int hashCode6 = (i3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.issuingBank;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.iconUrl;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String[] strArr = this.authModes;
        int hashCode9 = (hashCode8 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        HasLowSuccessV2 hasLowSuccessV2 = this.hasLowSuccess;
        int hashCode10 = (hashCode9 + (hasLowSuccessV2 != null ? hasLowSuccessV2.hashCode() : 0)) * 31;
        CardDetailsV2 cardDetailsV2 = this.cardDetails;
        int hashCode11 = (hashCode10 + (cardDetailsV2 != null ? cardDetailsV2.hashCode() : 0)) * 31;
        AmountV2 amountV2 = this.minAmount;
        int hashCode12 = (hashCode11 + (amountV2 != null ? amountV2.hashCode() : 0)) * 31;
        AmountV2 amountV22 = this.maxAmount;
        int hashCode13 = (hashCode12 + (amountV22 != null ? amountV22.hashCode() : 0)) * 31;
        boolean z2 = this.isEmiAvailable;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode13 + (z2 ? 1 : 0)) * 31;
        String str7 = this.displayName;
        int hashCode14 = (i4 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.priority;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode14 + i2;
    }

    public final String toString() {
        return "SavedInstrumentsV2(selectedAuthMode=" + this.selectedAuthMode + ", isDisabled=" + this.isDisabled + ", channelName=" + this.channelName + ", emiDetails=" + this.emiDetails + ", channelCode=" + this.channelCode + ", oneClickSupported=" + this.oneClickSupported + ", issuingBankCode=" + this.issuingBankCode + ", issuingBank=" + this.issuingBank + ", iconUrl=" + this.iconUrl + ", authModes=" + Arrays.toString(this.authModes) + ", hasLowSuccess=" + this.hasLowSuccess + ", cardDetails=" + this.cardDetails + ", minAmount=" + this.minAmount + ", maxAmount=" + this.maxAmount + ", isEmiAvailable=" + this.isEmiAvailable + ", displayName=" + this.displayName + ", priority=" + this.priority + ")";
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getSelectedAuthMode() {
        return this.selectedAuthMode;
    }

    public final IsDisabledV2 isDisabled() {
        return this.isDisabled;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final void setDisabled(IsDisabledV2 isDisabledV2) {
        this.isDisabled = isDisabledV2;
    }

    public final void setSelectedAuthMode(String str) {
        this.selectedAuthMode = str;
    }

    public final EmiDetailsV2 getEmiDetails() {
        return this.emiDetails;
    }

    public final void setEmiDetails(EmiDetailsV2 emiDetailsV2) {
        this.emiDetails = emiDetailsV2;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final boolean getOneClickSupported() {
        return this.oneClickSupported;
    }

    public final void setOneClickSupported(boolean z) {
        this.oneClickSupported = z;
    }

    public final String getIssuingBankCode() {
        return this.issuingBankCode;
    }

    public final void setIssuingBankCode(String str) {
        this.issuingBankCode = str;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String[] getAuthModes() {
        return this.authModes;
    }

    public final void setAuthModes(String[] strArr) {
        this.authModes = strArr;
    }

    public final HasLowSuccessV2 getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public final void setHasLowSuccess(HasLowSuccessV2 hasLowSuccessV2) {
        this.hasLowSuccess = hasLowSuccessV2;
    }

    public final CardDetailsV2 getCardDetails() {
        return this.cardDetails;
    }

    public final void setCardDetails(CardDetailsV2 cardDetailsV2) {
        this.cardDetails = cardDetailsV2;
    }

    public final AmountV2 getMinAmount() {
        return this.minAmount;
    }

    public final void setMinAmount(AmountV2 amountV2) {
        this.minAmount = amountV2;
    }

    public final AmountV2 getMaxAmount() {
        return this.maxAmount;
    }

    public final void setMaxAmount(AmountV2 amountV2) {
        this.maxAmount = amountV2;
    }

    public final boolean isEmiAvailable() {
        return this.isEmiAvailable;
    }

    public final void setEmiAvailable(boolean z) {
        this.isEmiAvailable = z;
    }

    public SavedInstrumentsV2(String str, IsDisabledV2 isDisabledV2, String str2, EmiDetailsV2 emiDetailsV2, String str3, boolean z, String str4, String str5, String str6, String[] strArr, HasLowSuccessV2 hasLowSuccessV2, CardDetailsV2 cardDetailsV2, AmountV2 amountV2, AmountV2 amountV22, boolean z2, String str7, String str8) {
        this.selectedAuthMode = str;
        this.isDisabled = isDisabledV2;
        this.channelName = str2;
        this.emiDetails = emiDetailsV2;
        this.channelCode = str3;
        this.oneClickSupported = z;
        this.issuingBankCode = str4;
        this.issuingBank = str5;
        this.iconUrl = str6;
        this.authModes = strArr;
        this.hasLowSuccess = hasLowSuccessV2;
        this.cardDetails = cardDetailsV2;
        this.minAmount = amountV2;
        this.maxAmount = amountV22;
        this.isEmiAvailable = z2;
        this.displayName = str7;
        this.priority = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SavedInstrumentsV2(java.lang.String r19, net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r20, java.lang.String r21, net.one97.paytm.p2mNewDesign.models.EmiDetailsV2 r22, java.lang.String r23, boolean r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String[] r28, net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2 r29, net.one97.paytm.p2mNewDesign.models.CardDetailsV2 r30, net.one97.paytm.p2mNewDesign.models.AmountV2 r31, net.one97.paytm.p2mNewDesign.models.AmountV2 r32, boolean r33, java.lang.String r34, java.lang.String r35, int r36, kotlin.g.b.g r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r25
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r26
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r27
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r28
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r29
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r30
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r31
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r32
        L_0x0072:
            r8 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0078
            r8 = 0
            goto L_0x007a
        L_0x0078:
            r8 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r8
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2.<init>(java.lang.String, net.one97.paytm.p2mNewDesign.models.IsDisabledV2, java.lang.String, net.one97.paytm.p2mNewDesign.models.EmiDetailsV2, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String[], net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2, net.one97.paytm.p2mNewDesign.models.CardDetailsV2, net.one97.paytm.p2mNewDesign.models.AmountV2, net.one97.paytm.p2mNewDesign.models.AmountV2, boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }
}
