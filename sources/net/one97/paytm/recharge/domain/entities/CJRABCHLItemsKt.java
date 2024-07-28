package net.one97.paytm.recharge.domain.entities;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.recharge.domain.entities.CJRABCHLItems;

public final class CJRABCHLItemsKt {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getCategoryId(net.one97.paytm.recharge.domain.entities.CJRABCHLItems r5) {
        /*
            java.lang.String r0 = "$this$getCategoryId"
            kotlin.g.b.k.c(r5, r0)
            r0 = 0
            r1 = 0
            net.one97.paytm.recharge.domain.entities.CJRABCHLItems$CJRABCHLCategoryWeights r2 = r5.getMetadata$recharge_automatic_release()     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            if (r2 == 0) goto L_0x0020
            java.util.ArrayList r2 = r2.getCategoryWeights$recharge_automatic_release()     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            if (r2 == 0) goto L_0x0020
            java.lang.Object r2 = r2.get(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            net.one97.paytm.recharge.domain.entities.CJRABCHLItems$CJRABCHLMetadata r2 = (net.one97.paytm.recharge.domain.entities.CJRABCHLItems.CJRABCHLMetadata) r2     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.getCategoryId$recharge_automatic_release()     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 1
            if (r3 == 0) goto L_0x002d
            int r3 = r3.length()
            if (r3 != 0) goto L_0x002e
        L_0x002d:
            r0 = 1
        L_0x002e:
            if (r0 != 0) goto L_0x0032
            r5 = r2
            goto L_0x005f
        L_0x0032:
            java.lang.String r0 = r5.getUrl$recharge_automatic_release()
            if (r0 == 0) goto L_0x005e
            java.lang.String r5 = r5.getUrl$recharge_automatic_release()
            if (r5 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r2 = "/"
            int r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String) r2, kotlin.m.p.d(r5))
            int r5 = r5 + r4
            if (r0 == 0) goto L_0x0056
            java.lang.String r5 = r0.substring(r5)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            goto L_0x005f
        L_0x0056:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r5.<init>(r0)
            throw r5
        L_0x005e:
            r5 = r1
        L_0x005f:
            if (r5 == 0) goto L_0x006d
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x006a }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ NumberFormatException -> 0x006a }
            goto L_0x006d
        L_0x006a:
            java.lang.String r5 = ""
            goto L_0x006e
        L_0x006d:
            r5 = r1
        L_0x006e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRABCHLItemsKt.getCategoryId(net.one97.paytm.recharge.domain.entities.CJRABCHLItems):java.lang.String");
    }

    public static final CJRHomePageItem createRechargeItem(CJRABCHLItems cJRABCHLItems) {
        k.c(cJRABCHLItems, "$this$createRechargeItem");
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.mUrl = cJRABCHLItems.getUrl$recharge_automatic_release();
        cJRHomePageItem.mUrlInfo = cJRABCHLItems.getUrlInfo$recharge_automatic_release();
        cJRHomePageItem.setCategoryId(getCategoryId(cJRABCHLItems));
        cJRHomePageItem.mImageUrl = cJRABCHLItems.getImageUrl$recharge_automatic_release();
        cJRHomePageItem.mUrlInfo = cJRABCHLItems.getUrlInfo$recharge_automatic_release();
        cJRHomePageItem.mUrlType = cJRABCHLItems.getUrlType$recharge_automatic_release();
        cJRHomePageItem.mUrl = cJRABCHLItems.getUrl$recharge_automatic_release();
        CJRABCHLItems.CJRABCHLLabel layout$recharge_automatic_release = cJRABCHLItems.getLayout$recharge_automatic_release();
        cJRHomePageItem.setLabel(layout$recharge_automatic_release != null ? layout$recharge_automatic_release.getLabel$recharge_automatic_release() : null);
        cJRHomePageItem.mName = cJRABCHLItems.getName$recharge_automatic_release();
        cJRHomePageItem.mseourl = cJRABCHLItems.getSeoUrl$recharge_automatic_release();
        cJRHomePageItem.setSource(cJRABCHLItems.getSource$recharge_automatic_release());
        return cJRHomePageItem;
    }
}
