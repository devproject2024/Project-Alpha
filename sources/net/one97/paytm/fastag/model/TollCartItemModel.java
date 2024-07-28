package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class TollCartItemModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "configuration")
    private TollConfigurationModel configuration;
    @b(a = "meta_data")
    private TollMetaDataModel meta_data;
    @b(a = "product_id")
    private Integer product_id;
    @b(a = "qty")
    private Integer qty;

    public Integer getProductId() {
        return this.product_id;
    }

    public void setProductId(Integer num) {
        this.product_id = num;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer num) {
        this.qty = num;
    }

    public TollConfigurationModel getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(TollConfigurationModel tollConfigurationModel) {
        this.configuration = tollConfigurationModel;
    }

    public TollMetaDataModel getMeta_data() {
        return this.meta_data;
    }

    public void setMeta_data(TollMetaDataModel tollMetaDataModel) {
        this.meta_data = tollMetaDataModel;
    }
}
