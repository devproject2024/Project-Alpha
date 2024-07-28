package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Action extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "icon_url")
    private String iconUrl;
    @b(a = "label")
    private String label;
    @b(a = "name")
    private String name;
    @b(a = "type")
    private String type;
    @b(a = "ui_control")
    private String uiControl;
    @b(a = "urlParams")
    private UrlParams urlParams;

    public Action() {
        this((String) null, (String) null, (String) null, (String) null, (UrlParams) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ Action copy$default(Action action, String str, String str2, String str3, String str4, UrlParams urlParams2, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = action.label;
        }
        if ((i2 & 2) != 0) {
            str2 = action.name;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = action.uiControl;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = action.type;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            urlParams2 = action.urlParams;
        }
        UrlParams urlParams3 = urlParams2;
        if ((i2 & 32) != 0) {
            str5 = action.iconUrl;
        }
        return action.copy(str, str6, str7, str8, urlParams3, str5);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.uiControl;
    }

    public final String component4() {
        return this.type;
    }

    public final UrlParams component5() {
        return this.urlParams;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final Action copy(String str, String str2, String str3, String str4, UrlParams urlParams2, String str5) {
        return new Action(str, str2, str3, str4, urlParams2, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return k.a((Object) this.label, (Object) action.label) && k.a((Object) this.name, (Object) action.name) && k.a((Object) this.uiControl, (Object) action.uiControl) && k.a((Object) this.type, (Object) action.type) && k.a((Object) this.urlParams, (Object) action.urlParams) && k.a((Object) this.iconUrl, (Object) action.iconUrl);
    }

    public final int hashCode() {
        String str = this.label;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uiControl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        UrlParams urlParams2 = this.urlParams;
        int hashCode5 = (hashCode4 + (urlParams2 != null ? urlParams2.hashCode() : 0)) * 31;
        String str5 = this.iconUrl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "Action(label=" + this.label + ", name=" + this.name + ", uiControl=" + this.uiControl + ", type=" + this.type + ", urlParams=" + this.urlParams + ", iconUrl=" + this.iconUrl + ")";
    }

    public Action(String str, String str2, String str3, String str4, UrlParams urlParams2, String str5) {
        this.label = str;
        this.name = str2;
        this.uiControl = str3;
        this.type = str4;
        this.urlParams = urlParams2;
        this.iconUrl = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Action(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, net.one97.paytm.p2mNewDesign.entity.mlv.UrlParams r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.Action.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.UrlParams, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUiControl() {
        return this.uiControl;
    }

    public final UrlParams getUrlParams() {
        return this.urlParams;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUiControl(String str) {
        this.uiControl = str;
    }

    public final void setUrlParams(UrlParams urlParams2) {
        this.urlParams = urlParams2;
    }
}
