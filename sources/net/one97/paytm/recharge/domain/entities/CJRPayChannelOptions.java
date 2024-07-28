package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPayChannelOptions extends IJRPaytmDataModel {
    @b(a = "channelCode")
    private String channelCode;
    @b(a = "channelName")
    private String channelName;
    @b(a = "iconUrl")
    private String iconUrl;
    @b(a = "mandateAuthMode")
    private ArrayList<String> mandateAuthMode;
    @b(a = "mandateMode")
    private String mandateMode;

    public CJRPayChannelOptions() {
        this((String) null, (ArrayList) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CJRPayChannelOptions copy$default(CJRPayChannelOptions cJRPayChannelOptions, String str, ArrayList<String> arrayList, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRPayChannelOptions.mandateMode;
        }
        if ((i2 & 2) != 0) {
            arrayList = cJRPayChannelOptions.mandateAuthMode;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i2 & 4) != 0) {
            str2 = cJRPayChannelOptions.channelCode;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = cJRPayChannelOptions.channelName;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = cJRPayChannelOptions.iconUrl;
        }
        return cJRPayChannelOptions.copy(str, arrayList2, str5, str6, str4);
    }

    public final String component1() {
        return this.mandateMode;
    }

    public final ArrayList<String> component2() {
        return this.mandateAuthMode;
    }

    public final String component3() {
        return this.channelCode;
    }

    public final String component4() {
        return this.channelName;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final CJRPayChannelOptions copy(String str, ArrayList<String> arrayList, String str2, String str3, String str4) {
        return new CJRPayChannelOptions(str, arrayList, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPayChannelOptions)) {
            return false;
        }
        CJRPayChannelOptions cJRPayChannelOptions = (CJRPayChannelOptions) obj;
        return k.a((Object) this.mandateMode, (Object) cJRPayChannelOptions.mandateMode) && k.a((Object) this.mandateAuthMode, (Object) cJRPayChannelOptions.mandateAuthMode) && k.a((Object) this.channelCode, (Object) cJRPayChannelOptions.channelCode) && k.a((Object) this.channelName, (Object) cJRPayChannelOptions.channelName) && k.a((Object) this.iconUrl, (Object) cJRPayChannelOptions.iconUrl);
    }

    public final int hashCode() {
        String str = this.mandateMode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<String> arrayList = this.mandateAuthMode;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str2 = this.channelCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelName;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.iconUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CJRPayChannelOptions(mandateMode=" + this.mandateMode + ", mandateAuthMode=" + this.mandateAuthMode + ", channelCode=" + this.channelCode + ", channelName=" + this.channelName + ", iconUrl=" + this.iconUrl + ")";
    }

    public final String getMandateMode() {
        return this.mandateMode;
    }

    public final void setMandateMode(String str) {
        this.mandateMode = str;
    }

    public final ArrayList<String> getMandateAuthMode() {
        return this.mandateAuthMode;
    }

    public final void setMandateAuthMode(ArrayList<String> arrayList) {
        this.mandateAuthMode = arrayList;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPayChannelOptions(java.lang.String r5, java.util.ArrayList r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions.<init>(java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public CJRPayChannelOptions(String str, ArrayList<String> arrayList, String str2, String str3, String str4) {
        this.mandateMode = str;
        this.mandateAuthMode = arrayList;
        this.channelCode = str2;
        this.channelName = str3;
        this.iconUrl = str4;
    }
}
