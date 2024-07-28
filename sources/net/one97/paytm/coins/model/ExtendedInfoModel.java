package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public class ExtendedInfoModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "displayName")
    private String displayName;
    @b(a = "offerDeepLink")
    private String offerDeepLink;
    @b(a = "offerIconImage")
    private String offerIconImage;
    @b(a = "offerName")
    private String offerName;
    @b(a = "shortDescription")
    private String shortDescription;

    public ExtendedInfoModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public final String getOfferName() {
        return this.offerName;
    }

    public final void setOfferName(String str) {
        this.offerName = str;
    }

    public final String getOfferDeepLink() {
        return this.offerDeepLink;
    }

    public final void setOfferDeepLink(String str) {
        this.offerDeepLink = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getOfferIconImage() {
        return this.offerIconImage;
    }

    public final void setOfferIconImage(String str) {
        this.offerIconImage = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ExtendedInfoModel(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.ExtendedInfoModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final void setShortDescription(String str) {
        this.shortDescription = str;
    }

    public ExtendedInfoModel(String str, String str2, String str3, String str4, String str5) {
        this.offerName = str;
        this.offerDeepLink = str2;
        this.displayName = str3;
        this.offerIconImage = str4;
        this.shortDescription = str5;
    }
}
