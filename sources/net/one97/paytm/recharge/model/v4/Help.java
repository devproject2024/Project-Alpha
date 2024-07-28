package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Help implements IJRDataModel {
    @b(a = "button_label")
    private final String buttonLabel;
    @b(a = "button_url")
    private final String buttonUrl;
    @b(a = "description")
    private final String description;
    @b(a = "description1")
    private final String description1;
    @b(a = "description2")
    private final String description2;
    @b(a = "title")
    private final String title;

    public Help() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ Help copy$default(Help help, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = help.title;
        }
        if ((i2 & 2) != 0) {
            str2 = help.description;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = help.description1;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = help.description2;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = help.buttonLabel;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = help.buttonUrl;
        }
        return help.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.description1;
    }

    public final String component4() {
        return this.description2;
    }

    public final String component5() {
        return this.buttonLabel;
    }

    public final String component6() {
        return this.buttonUrl;
    }

    public final Help copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new Help(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Help)) {
            return false;
        }
        Help help = (Help) obj;
        return k.a((Object) this.title, (Object) help.title) && k.a((Object) this.description, (Object) help.description) && k.a((Object) this.description1, (Object) help.description1) && k.a((Object) this.description2, (Object) help.description2) && k.a((Object) this.buttonLabel, (Object) help.buttonLabel) && k.a((Object) this.buttonUrl, (Object) help.buttonUrl);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description1;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description2;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.buttonLabel;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.buttonUrl;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "Help(title=" + this.title + ", description=" + this.description + ", description1=" + this.description1 + ", description2=" + this.description2 + ", buttonLabel=" + this.buttonLabel + ", buttonUrl=" + this.buttonUrl + ")";
    }

    public Help(String str, String str2, String str3, String str4, String str5, String str6) {
        this.title = str;
        this.description = str2;
        this.description1 = str3;
        this.description2 = str4;
        this.buttonLabel = str5;
        this.buttonUrl = str6;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescription1() {
        return this.description1;
    }

    public final String getDescription2() {
        return this.description2;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Help(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.Help.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getButtonUrl() {
        return this.buttonUrl;
    }
}
