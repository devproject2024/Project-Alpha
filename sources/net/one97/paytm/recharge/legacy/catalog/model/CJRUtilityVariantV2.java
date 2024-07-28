package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;

public class CJRUtilityVariantV2 implements IJRDataModel {
    @b(a = "attributes")
    private CJRUtilityFilterAttributesV2 attributes;
    @b(a = "display_name")
    private String displayName;
    @b(a = "filter_name")
    private String filterName;
    @b(a = "products")
    private CJRUtilityProductV2 product;
    private CJRMetroQRFrequentOrderList recentsOrder;
    private boolean shouldExpand;
    @b(a = "variants")
    private List<CJRUtilityVariantV2> variants = new ArrayList();

    public String getFilterName() {
        return this.filterName;
    }

    public void setFilterName(String str) {
        this.filterName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public List<CJRUtilityVariantV2> getVariants() {
        return this.variants;
    }

    public void setVariants(List<CJRUtilityVariantV2> list) {
        this.variants = list;
    }

    public CJRUtilityProductV2 getProduct() {
        return this.product;
    }

    public void setProduct(CJRUtilityProductV2 cJRUtilityProductV2) {
        this.product = cJRUtilityProductV2;
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public void setShouldExpand(boolean z) {
        this.shouldExpand = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CJRUtilityVariantV2)) {
            return false;
        }
        return getFilterName().equalsIgnoreCase(((CJRUtilityVariantV2) obj).getFilterName());
    }

    public CJRUtilityFilterAttributesV2 getAttributes() {
        return this.attributes;
    }

    public void setAttributes(CJRUtilityFilterAttributesV2 cJRUtilityFilterAttributesV2) {
        this.attributes = cJRUtilityFilterAttributesV2;
    }

    public boolean isSchedulable() {
        CJRUtilityFilterAttributesV2 cJRUtilityFilterAttributesV2 = this.attributes;
        return cJRUtilityFilterAttributesV2 != null && cJRUtilityFilterAttributesV2.isSchedulable();
    }

    public CJRMetroQRFrequentOrderList getRecentsOrder() {
        return this.recentsOrder;
    }

    public void setRecentsOrder(CJRMetroQRFrequentOrderList cJRMetroQRFrequentOrderList) {
        this.recentsOrder = cJRMetroQRFrequentOrderList;
    }
}
