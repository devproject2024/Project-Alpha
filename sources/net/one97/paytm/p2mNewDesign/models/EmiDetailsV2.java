package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class EmiDetailsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "channelCode")
    private String channelCode;
    @b(a = "channelName")
    private String channelName;
    @b(a = "emiChannelInfos")
    private ArrayList<EmiChannelInfosV2> emiChannelInfos;
    @b(a = "hasLowSuccess")
    private HasLowSuccessV2 hasLowSuccess;
    @b(a = "iconUrl")
    private String iconUrl;
    @b(a = "isDisabled")
    private IsDisabledV2 isDisabled;

    public EmiDetailsV2() {
        this((IsDisabledV2) null, (String) null, (ArrayList) null, (String) null, (String) null, (HasLowSuccessV2) null, 63, (g) null);
    }

    public final IsDisabledV2 isDisabled() {
        return this.isDisabled;
    }

    public final void setDisabled(IsDisabledV2 isDisabledV2) {
        this.isDisabled = isDisabledV2;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final ArrayList<EmiChannelInfosV2> getEmiChannelInfos() {
        return this.emiChannelInfos;
    }

    public final void setEmiChannelInfos(ArrayList<EmiChannelInfosV2> arrayList) {
        this.emiChannelInfos = arrayList;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public EmiDetailsV2(IsDisabledV2 isDisabledV2, String str, ArrayList<EmiChannelInfosV2> arrayList, String str2, String str3, HasLowSuccessV2 hasLowSuccessV2) {
        this.isDisabled = isDisabledV2;
        this.channelName = str;
        this.emiChannelInfos = arrayList;
        this.channelCode = str2;
        this.iconUrl = str3;
        this.hasLowSuccess = hasLowSuccessV2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EmiDetailsV2(net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r6, java.lang.String r7, java.util.ArrayList r8, java.lang.String r9, java.lang.String r10, net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2 r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.EmiDetailsV2.<init>(net.one97.paytm.p2mNewDesign.models.IsDisabledV2, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2, int, kotlin.g.b.g):void");
    }

    public final HasLowSuccessV2 getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public final void setHasLowSuccess(HasLowSuccessV2 hasLowSuccessV2) {
        this.hasLowSuccess = hasLowSuccessV2;
    }
}
