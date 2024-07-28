package net.one97.paytm.common.entity.prime.verifyprime.digitalcataloge;

import net.one97.paytm.common.entity.IJRDataModel;

public class Products implements IJRDataModel {
    private String catalogProductId;
    private String description;
    private String displayName;
    private String isFastForward;
    private String metaDescription;
    private String metaTitle;
    private String plan_id;
    private int price;
    private String productId;
    private String verticalId;
    private String warehouseId;

    public String getCatalogProductId() {
        return this.catalogProductId;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public String getPlan_id() {
        return this.plan_id;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIsFastForward() {
        return this.isFastForward;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getPrice() {
        return this.price;
    }
}
