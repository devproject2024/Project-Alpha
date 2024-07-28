package net.one97.paytm.recharge.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class m {
    private CJRAggsItem a(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        List list;
        k.c(cJRUtilityVariantV2, "variant");
        String filterName = cJRUtilityVariantV2.getFilterName();
        String displayName = cJRUtilityVariantV2.getDisplayName();
        CJRUtilityFilterAttributesV2 attributes = cJRUtilityVariantV2.getAttributes();
        String bbpsLogoURL = attributes != null ? attributes.getBbpsLogoURL() : null;
        CJRUtilityFilterAttributesV2 attributes2 = cJRUtilityVariantV2.getAttributes();
        String description = attributes2 != null ? attributes2.getDescription() : null;
        CJRUtilityFilterAttributesV2 attributes3 = cJRUtilityVariantV2.getAttributes();
        String image_url = attributes3 != null ? attributes3.getImage_url() : null;
        CJRUtilityFilterAttributesV2 attributes4 = cJRUtilityVariantV2.getAttributes();
        String schedulable = attributes4 != null ? attributes4.getSchedulable() : null;
        CJRUtilityFilterAttributesV2 attributes5 = cJRUtilityVariantV2.getAttributes();
        String label = attributes5 != null ? attributes5.getLabel() : null;
        CJRUtilityFilterAttributesV2 attributes6 = cJRUtilityVariantV2.getAttributes();
        String minAndroidVersion = attributes6 != null ? attributes6.getMinAndroidVersion() : null;
        String filterName2 = cJRUtilityVariantV2.getFilterName();
        List<CJRUtilityVariantV2> variants = cJRUtilityVariantV2.getVariants();
        if (variants != null) {
            Iterable<CJRUtilityVariantV2> iterable = variants;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (CJRUtilityVariantV2 cJRUtilityVariantV22 : iterable) {
                k.a((Object) cJRUtilityVariantV22, "it");
                arrayList.add(a(cJRUtilityVariantV22));
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        CJRUtilityFilterAttributesV2 attributes7 = cJRUtilityVariantV2.getAttributes();
        return new CJRAggsItem(bbpsLogoURL, image_url, (String) null, filterName, displayName, (String) null, (String) null, label, (String) null, description, (String) null, (String) null, (String) null, (String) null, (String) null, filterName2, list, schedulable, minAndroidVersion, (List) null, (String) null, attributes7 != null ? attributes7.getBgImageUrl() : null, (String) null, (String) null, 14187876, (g) null);
    }

    public final List<CJRAggsItem> a(List<? extends CJRUtilityVariantV2> list) {
        k.c(list, "variant");
        Iterable<CJRUtilityVariantV2> iterable = list;
        Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRUtilityVariantV2 a2 : iterable) {
            arrayList.add(a(a2));
        }
        return (List) arrayList;
    }
}
